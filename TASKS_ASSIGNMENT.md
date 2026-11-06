# 📋 BẢNG PHÂN CHIA NHIỆM VỤ DỰ ÁN TEA POS (WORK BREAKDOWN STRUCTURE)
> **Tổ chức:** [devsquad-team-vn](https://github.com/devsquad-team-vn) | **Dự án:** `devsquad-JAV102`  
> **Phiên bản:** 1.0 Enterprise | **Thời gian:** 2026

---

## 👥 I. PHÂN CÔNG THÀNH VIÊN & TEAMS

### 👑 1. Lead & System Architecture Team (`@devsquad-team-vn/lead`)
* **Phụ trách chính:** **Nguyễn Văn Quang** (`@quang642000-lang` - `quang642000@gmail.com`)
* **Trách nhiệm:**
  - Thiết kế kiến trúc tổng thể dự án theo chuẩn mô hình MVC phân lớp rõ ràng.
  - Cấu hình và tối ưu hóa Connection Pool HikariCP (`DBConnect.java`).
  - Thiết lập cơ chế bảo mật xác thực kép: Nhân viên (Staff/Admin) & Khách hàng Hội viên CRM.
  - Xây dựng các Filter chặn truy cập trái phép (`POSAuthFilter`, `AdminAuthFilter`, `CustomerAuthFilter`).
  - Quản lý kho mã nguồn GitHub, review Pull Request và xử lý xung đột (conflict).

---

### 🎨 2. Frontend & User Experience Team (`@devsquad-team-vn/frontend`)
* **Phụ trách chính:** **Vòng Kiệt** (`@vongkiet114` - `vongkiet114@gmail.com`)
* **Trách nhiệm:**
  - Thiết kế và nâng cấp giao diện Cổng Portal Khách hàng 2026 chuẩn hiệu ứng Kính mờ (Frosted Glass).
  - Tối ưu hóa trải nghiệm Responsive trên các thiết bị di động (Mobile, Tablet, Desktop).
  - Phát triển giao diện Giỏ hàng (`gio_hang.jsp`) và luồng đặt nước Click & Collect (`thanh_toan.jsp`).
  - Tích hợp hiệu ứng thông báo SweetAlert2 và hiệu ứng sao chép mã Voucher 1-Click.
  - Xây dựng tính năng Thêm nhanh ly nước tiêu chuẩn (`quickAddToCart`) trực tiếp từ danh mục.

---

### ⚙️ 3. Backend & Core POS Team (`@devsquad-team-vn/backend`)
* **Phụ trách chính:** **Nguyễn Thành Nam** (`@num00363` - `namntv00363@gmail.com`)
* **Trách nhiệm:**
  - Phát triển toàn bộ nghiệp vụ Quầy bán lẻ POS (`ban_hang.jsp`, `BanHangPOSController.java`).
  - Xử lý nghiệp vụ chọn đá, đường, size và topping cho từng cốc nước.
  - Tích hợp tra cứu khách hàng theo Số điện thoại ngầm bằng AJAX (`TraCuuKhachHangController.java`).
  - Xây dựng tính năng tạo nhanh khách hàng tại quầy thu ngân không cần mật khẩu.
  - Xử lý in phiếu hóa đơn bán lẻ chuẩn máy in nhiệt 80mm.
  - Tích hợp cổng thanh toán VietQR động và nghiệp vụ miễn trừ thanh toán cho đơn hàng 0đ.

---

### 🗄️ 4. Database & Data Integrity Team (`@devsquad-team-vn/dba`)
* **Phụ trách chính:** **Hà Anh Khoa** (`@khoahatv00362-hash` - `khoahatv00362@gmail.com`)
* **Trách nhiệm:**
  - Thiết kế mô hình quan hệ cơ sở dữ liệu vật lý gồm 19 bảng (`datahetcuu.sql`).
  - Cấu hình các chuỗi Sequences tự tăng (`seq_DonHang`, `seq_KhachHang`...) với `NO CACHE` chống nhảy vọt ID.
  - Thiết lập băm mật khẩu chuẩn bảo mật SHA-256 cho toàn bộ nhân sự và khách hàng.
  - Cấu hình Collation `Vietnamese_CI_AI` đảm bảo tìm kiếm tiếng Việt không dấu chuẩn xác 100%.
  - Quản lý ràng buộc toàn vẹn khóa ngoại (Foreign Keys) và quy tắc xóa Cascade.

---

### 🧪 5. Quality Assurance (QA) & Testing Team (`@devsquad-team-vn/qa`)
* **Phụ trách chính:** **Sơn Thái Phú Quý** (`@quystptv00383-commits` - `quystptv00383@gmail.com`)
* **Trách nhiệm:**
  - Xây dựng kịch bản kiểm thử tự động với JUnit 5 Jupiter (`SystemIntegrationTest.java`).
  - Kiểm thử nghiệp vụ áp dụng Voucher chiết khấu: Giảm theo tiền, giảm theo %, chặn trần tối đa.
  - Kiểm định trường hợp biên: Áp voucher 100k cho đơn 70k (đơn 0đ), đảm bảo hệ thống không bắt chuyển khoản.
  - Kiểm thử tải (Load Test) kết nối HikariCP khi nhiều ca bán hàng hoạt động cùng lúc.
  - Soát lỗi bảo mật và kiểm tra phân quyền truy cập chéo giữa các vai trò nhân viên.

---

## 📌 II. BẢNG PHÂN RÃ CHI TIẾT 40+ ĐẦU VIỆC (TASK MATRIX)

| Mã Task | Phân hệ nghiệp vụ | Tên nhiệm vụ cụ thể | Người phụ trách | Trạng thái |
| :---: | :--- | :--- | :--- | :---: |
| **ARCH-01** | Kiến trúc Core | Khởi tạo cấu trúc dự án Maven, Jakarta EE & Git Repo | **Nguyễn Văn Quang** | ✅ Hoàn thành |
| **ARCH-02** | Kết nối CSDL | Tích hợp Connection Pool HikariCP & nạp properties | **Nguyễn Văn Quang** | ✅ Hoàn thành |
| **ARCH-03** | Bảo mật | Viết bộ lọc xác thực `POSAuthFilter` & `AdminAuthFilter` | **Nguyễn Văn Quang** | ✅ Hoàn thành |
| **DB-01** | Database | Khởi tạo Schema 19 bảng vật lý SQL Server 2022 | **Hà Anh Khoa** | ✅ Hoàn thành |
| **DB-02** | Database | Tạo các Sequence tự tăng mã đơn, mã khách, mã món | **Hà Anh Khoa** | ✅ Hoàn thành |
| **DB-03** | Database | Cấu hình Collation tiếng Việt không dấu `Vietnamese_CI_AI` | **Hà Anh Khoa** | ✅ Hoàn thành |
| **DB-04** | Bảo mật | Viết hàm tiện ích băm mật khẩu một chiều SHA-256 | **Hà Anh Khoa** | ✅ Hoàn thành |
| **POS-01** | Quầy POS | Giao diện quầy thu ngân chia cột màn hình bán hàng | **Nguyễn Thành Nam** | ✅ Hoàn thành |
| **POS-02** | Quầy POS | Lựa chọn đá, đường, size, topping động vào giỏ quầy | **Nguyễn Thành Nam** | ✅ Hoàn thành |
| **POS-03** | Quầy POS | Tra cứu thành viên bằng SĐT qua AJAX không tải lại trang | **Nguyễn Thành Nam** | ✅ Hoàn thành |
| **POS-04** | Quầy POS | Tạo nhanh tài khoản khách tại quầy không cần mật khẩu | **Nguyễn Thành Nam** | ✅ Hoàn thành |
| **POS-05** | Quầy POS | Modal danh sách Voucher thực tế với 1-Click áp dụng | **Nguyễn Thành Nam** | ✅ Hoàn thành |
| **POS-06** | Quầy POS | Tính toán tiền thừa tiền mặt & xuất hóa đơn in nhiệt 80mm | **Nguyễn Thành Nam** | ✅ Hoàn thành |
| **POS-07** | Quầy POS | Sinh mã VietQR động theo đơn hàng kèm tự động chốt đơn | **Nguyễn Thành Nam** | ✅ Hoàn thành |
| **FE-01** | Portal UI | Thiết kế Header Frosted Glass chuẩn hiệu ứng kính mờ 2026 | **Vòng Kiệt** | ✅ Hoàn thành |
| **FE-02** | Portal UI | Xây dựng Hero Section tỉ lệ vàng & Thẻ món Signature | **Vòng Kiệt** | ✅ Hoàn thành |
| **FE-03** | Portal UI | Dải thẻ Flash Voucher tương tác kèm sao chép mã 1-Click | **Vòng Kiệt** | ✅ Hoàn thành |
| **FE-04** | Portal UI | Thẻ sản phẩm hành động kép: `+ Thêm nhanh` & `Tùy biến` | **Vòng Kiệt** | ✅ Hoàn thành |
| **FE-05** | Portal UI | Giỏ hàng trực tuyến Click & Collect & Hẹn giờ lấy nước 24H | **Vòng Kiệt** | ✅ Hoàn thành |
| **FE-06** | Portal UI | Trang tra cứu tiến độ làm nước thời gian thực cho khách | **Vòng Kiệt** | ✅ Hoàn thành |
| **QA-01** | Kiểm thử | Viết bộ kiểm thử kết nối CSDL và sinh mã đơn hàng tự động | **Sơn Thái Phú Quý** | ✅ Hoàn thành |
| **QA-02** | Kiểm thử | Kiểm thử tính toán giảm giá Voucher (tiền mặt & %) | **Sơn Thái Phú Quý** | ✅ Hoàn thành |
| **QA-03** | Kiểm thử | Kiểm thử trường hợp biên đơn hàng 0đ sau khi áp Voucher | **Sơn Thái Phú Quý** | ✅ Hoàn thành |
| **QA-04** | Kiểm thử | Kiểm thử Dual-Verification xác thực nhân sự hệ thống | **Sơn Thái Phú Quý** | ✅ Hoàn thành |
