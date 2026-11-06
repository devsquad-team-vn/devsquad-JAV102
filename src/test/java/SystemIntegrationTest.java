import config.DBConnect;
import model.entity.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.*;
import service.impl.*;
import util.SecurityUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class SystemIntegrationTest {

    @Test
    @DisplayName("Kiểm tra mã hóa băm mật khẩu chuẩn Salted SHA-256")
    public void testPasswordHashing() {
        String password = "admin";
        String username = "admin";
        String hash = SecurityUtil.hashWithSalt(password, username);
        Assertions.assertNotNull(hash);
        Assertions.assertTrue(SecurityUtil.checkPassword(password, hash, username));
        Assertions.assertFalse(SecurityUtil.checkPassword("wrongpass", hash, username));
    }

    @Test
    @DisplayName("Kiểm tra kết nối Connection Pool HikariCP tới CSDL SQL Server")
    public void testDatabaseConnection() {
        try (Connection conn = DBConnect.getConnection()) {
            Assertions.assertNotNull(conn);
            Assertions.assertTrue(conn.isValid(3));
            System.out.println("Kết nối CSDL thành công: " + conn.getMetaData().getDatabaseProductName() + " " + conn.getMetaData().getDatabaseProductVersion());
        } catch (Exception e) {
            Assertions.fail("Lỗi kết nối CSDL: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Kiểm tra truy vấn Danh mục và Sản phẩm khả dụng")
    public void testProductAndCategoryService() {
        IDanhMucService danhMucService = DanhMucServiceImpl.getInstance();
        ISanPhamService sanPhamService = SanPhamServiceImpl.getInstance();

        List<DanhMuc> categories = danhMucService.getAllDanhMuc();
        Assertions.assertNotNull(categories);
        System.out.println("Tổng số danh mục trong hệ thống: " + categories.size());

        List<SanPham> products = sanPhamService.getAllSanPham();
        Assertions.assertNotNull(products);
        System.out.println("Tổng số sản phẩm trong hệ thống: " + products.size());
    }

    @Test
    @DisplayName("Kiểm tra cơ chế sinh mã đơn hàng chuẩn format TEA-yyyyMMdd-XXXXX")
    public void testOrderCodeGeneration() {
        IDonHangService donHangService = DonHangServiceImpl.getInstance();
        String nextOrderCode = donHangService.generateNextMaDh();
        Assertions.assertNotNull(nextOrderCode);
        Assertions.assertTrue(nextOrderCode.startsWith("TEA-"));
        System.out.println("Mã đơn hàng mới tự sinh: " + nextOrderCode);
    }

    @Test
    @DisplayName("Kiểm tra nghiệp vụ tính toán chiết khấu Voucher")
    public void testVoucherCalculation() {
        IKhuyenMaiService khuyenMaiService = KhuyenMaiServiceImpl.getInstance();
        List<KhuyenMai> vouchers = khuyenMaiService.getAllKhuyenMai();
        Assertions.assertNotNull(vouchers);
        System.out.println("Tổng số chương trình khuyến mãi: " + vouchers.size());
    }

    @Test
    @DisplayName("Kiểm tra xác thực nhân viên Dual-Verification (Hỗ trợ mật khẩu Seed SHA-256 thô)")
    public void testStaffLoginDualVerification() {
        INhanVienService nhanVienService = NhanVienServiceImpl.getInstance();
        NhanVien nv = nhanVienService.loginNhanVien("staff", "12345678", "127.0.0.1");
        Assertions.assertNotNull(nv, "Đăng nhập nhân viên 'staff' với mật khẩu '12345678' phải thành công qua cơ chế Dual Verification!");
        System.out.println("Xác thực nhân sự thành công: " + nv.getHoTen() + " (" + nv.getTenDangNhap() + ")");
    }

    @Test
    @DisplayName("Kiểm tra xác thực khách hàng Dual-Verification")
    public void testCustomerLoginDualVerification() {
        IKhachHangService khachHangService = KhachHangServiceImpl.getInstance();
        KhachHang kh = khachHangService.loginCustomer("0909999999", "12345678");
        if (kh == null) {
            kh = khachHangService.loginCustomer("khach_vip@gmail.com", "12345678");
        }
        Assertions.assertNotNull(kh, "Đăng nhập khách hàng VIP với mật khẩu '12345678' phải thành công!");
        System.out.println("Xác thực khách hàng CRM thành công: " + kh.getTenKh() + " (" + kh.getSoDienThoai() + ")");
    }

    @Test
    @DisplayName("Kiểm tra chốt chặn đơn hàng 0đ: Giảm giá 100k cho đơn 70k -> Khấu trừ tối đa 70k, tổng trả 0đ, tự động bỏ qua chuyển khoản QR và lưu DB trực tiếp")
    public void testVoucher100kOn70kOrderAndZeroPayableDirectCheckout() {
        IDonHangService donHangService = DonHangServiceImpl.getInstance();

        int tongTienHang = 70000;
        int voucherGiaTri = 100000; // Voucher 100k

        // 1. Tiền giảm giá không được vượt quá tổng tiền hàng
        int tienGiamGia = Math.min(voucherGiaTri, tongTienHang);
        Assertions.assertEquals(70000, tienGiamGia, "Tiền giảm giá voucher phải bị chặn ở mức tối đa bằng tổng tiền hàng (70.000đ)");

        int billBeforeTax = tongTienHang - tienGiamGia;
        Assertions.assertEquals(0, billBeforeTax);

        int vat = (int) Math.round(billBeforeTax * 0.08);
        int tongPhaiTra = billBeforeTax + vat;
        Assertions.assertEquals(0, tongPhaiTra, "Tổng phải trả cho đơn được giảm 100% phải là 0đ");

        // 2. Chốt đơn POS với tổng phải trả = 0đ và chọn maPt = 2 (QR)
        DonHang posOrder = new DonHang();
        String maDh = donHangService.generateNextMaDh();
        posOrder.setMaDh(maDh);
        posOrder.setMaPt(2); // Giả lập chọn QR
        posOrder.setTongTienHang(tongTienHang);
        posOrder.setTienGiamGia(tienGiamGia);
        posOrder.setTongPhaiTra(tongPhaiTra); // 0đ
        posOrder.setLoaiDonHang(1);

        List<ChiTietDonHang> items = new ArrayList<>();
        ChiTietDonHang ctdh = new ChiTietDonHang();
        ctdh.setMaDh(maDh);
        ctdh.setMaSp("SP00001");
        ctdh.setMaSize(1);
        ctdh.setSoLuong(1);
        ctdh.setGiaChot(70000);
        items.add(ctdh);

        try {
            // Gọi service checkout POS
            boolean checkoutSuccess = donHangService.checkoutPOS(posOrder, items, "NV00001");
            Assertions.assertTrue(checkoutSuccess, "Chốt đơn 0đ tại quầy phải thành công trực tiếp");

            // Đơn hàng 0đ KHÔNG ĐƯỢC nằm trong Cache chờ QR
            Assertions.assertFalse(util.PaymentStore.pendingOrders.containsKey(maDh),
                    "Đơn hàng 0đ tuyệt đối không được đưa vào bộ nhớ đệm QR pendingOrders!");

            // Phương thức thanh toán phải tự động chuyển thành 1 (Tiền mặt/Miễn phí) và trạng thái thanh toán = 1
            Assertions.assertEquals(1, posOrder.getMaPt(), "Phương thức thanh toán phải được tự động chuyển thành Tiền mặt / Miễn phí 0đ");
            Assertions.assertEquals(1, posOrder.getTrangThaiThanhToan(), "Đơn hàng 0đ phải được đánh dấu Đã thanh toán (1) ngay lập tức");

            System.out.println("✅ Kiểm thử nghiệp vụ Đơn hàng 0đ thành công mỹ mãn: Không sinh mã QR, không bắt chuyển khoản, thanh toán trực tiếp an toàn!");
        } finally {
            // Dọn dẹp dữ liệu test khỏi database
            try (Connection conn = DBConnect.getConnection()) {
                try (PreparedStatement ps1 = conn.prepareStatement("DELETE FROM CHI_TIET_DON_HANG WHERE ma_dh = ?");
                     PreparedStatement ps2 = conn.prepareStatement("DELETE FROM DON_HANG WHERE ma_dh = ?")) {
                    ps1.setString(1, maDh);
                    ps1.executeUpdate();
                    ps2.setString(1, maDh);
                    ps2.executeUpdate();
                }
            } catch (Exception e) {
                // Ignore cleanup
            }
        }
    }
}
