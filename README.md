# 🍵 TEA POS SYSTEM - O2O & CLICK & COLLECT ENTERPRISE
> **Hệ thống Quản lý Bán lẻ Trà Sữa & Cổng Đặt Nước Trực Tuyến O2O (Click & Collect)**  
> **Dự án Đồ Án Chuyên Nghiệp - Đội ngũ Phát triển: CodeDevSquad (2026)**

[![Java](https://img.shields.io/badge/Java-21%20LTS-orange.svg?logo=openjdk)](https://www.oracle.com/java/)
[![Jakarta EE](https://img.shields.io/badge/Jakarta%20EE-10%20(Servlet%2FJSP)-blue.svg?logo=eclipseide)](https://jakarta.ee/)
[![Database](https://img.shields.io/badge/MS%20SQL%20Server-2022-red.svg?logo=microsoftsqlserver)](https://www.microsoft.com/sql-server)
[![Connection Pool](https://img.shields.io/badge/HikariCP-5.1.0-brightgreen.svg)](https://github.com/brettwooldridge/HikariCP)
[![Server](https://img.shields.io/badge/Apache%20Tomcat-11.0.1-yellow.svg?logo=apachetomcat)](https://tomcat.apache.org/)
[![UI Design](https://img.shields.io/badge/Frontend-Bootstrap%205%20%7C%20Frosted%20Glass%202026-6f42c1.svg)](https://getbootstrap.com/)
[![Tests](https://img.shields.io/badge/JUnit%205-8%2F8%20Passing-success.svg)](https://junit.org/junit5/)

---

## 👥 I. ĐỘI NGŨ PHÁT TRIỂN & PHÂN CÔNG NHIỆM VỤ (CODEDEVSQUAD)

Hệ thống được phát triển và vận hành bởi tổ chức **[devsquad-team-vn](https://github.com/devsquad-team-vn)**:

| STT | Họ và Tên | Tài khoản GitHub | Email liên hệ | Vai trò đảm nhiệm | Phân hệ phụ trách chính |
| :---: | :--- | :--- | :--- | :--- | :--- |
| **1** | **Nguyễn Văn Quang** | [@quang642000-lang](https://github.com/quang642000-lang) | `quang642000@gmail.com` | **Project Leader & Architect** | Quản lý dự án, Kiến trúc HikariCP, Bộ lọc bảo mật & Phân quyền ACL |
| **2** | **Vòng Kiệt** | [@vongkiet114](https://github.com/vongkiet114) | `vongkiet114@gmail.com` | **Lead Frontend Engineer** | Cổng Portal Khách hàng 2026, Giỏ hàng Click & Collect, Responsive Mobile |
| **3** | **Nguyễn Thành Nam** | [@num00363](https://github.com/num00363) | `namntv00363@gmail.com` | **Backend Core Developer** | Phân hệ Quầy thu ngân POS, Quản lý Khách hàng tại quầy & VietQR |
| **4** | **Hà Anh Khoa** | [@khoahatv00362-hash](https://github.com/khoahatv00362-hash) | `khoahatv00362@gmail.com` | **Database Administrator (DBA)** | Thiết kế 19 bảng SQL Server, Chuỗi Sequences tự tăng, Băm mật khẩu SHA-256 |
| **5** | **Sơn Thái Phú Quý** | [@quystptv00383-commits](https://github.com/quystptv00383-commits) | `quystptv00383@gmail.com` | **Quality Assurance (QA) & Test** | Xây dựng bộ Integration Tests (8/8 Pass), Kiểm thử nghiệp vụ đơn 0đ & Voucher |

---

## 🌟 II. TỔNG QUAN TÍNH NĂNG NỔI BẬT

### 1. Quầy Thu Ngân Bán Lẻ Siêu Tốc (POS Cashier Pro)
- **Giao diện bán hàng trực quan:** Chọn món nước theo danh mục, tùy biến cấp độ Đá (0% - 100%), Đường (0% - 100%), Size (S/M/L) và Topping phong phú.
- **Tích hợp Hội viên CRM:** Tra cứu khách hàng theo SĐT bằng AJAX không giật lag trang; tạo nhanh tài khoản khách tại quầy.
- **Tiêu điểm & Kho Voucher:** Đổi điểm tích lũy trừ thẳng tiền đơn; Modal chọn nhanh toàn bộ voucher đang áp dụng chỉ với 1 click.
- **Thanh toán linh hoạt:** Tiền mặt (tự tính tiền thừa) hoặc **VietQR động** (tự động nhận diện đơn 0đ không sinh mã QR).
- **In hóa đơn bán lẻ:** Xuất phiếu thanh toán nhiệt chuẩn 80mm.

### 2. Cổng Đặt Nước Trực Tuyến 2026 (Customer Portal Click & Collect)
- **Thiết kế Frosted Glass 2026:** Header kính mờ cao cấp, Hero phân chia tỉ lệ vàng, dải Voucher Flash tương tác (sao chép mã 1-click).
- **Tìm kiếm Tiếng Việt không dấu:** Tích hợp `Vietnamese_CI_AI`, tìm "tra sua" hay "trà sữa" đều ra kết quả tức thì.
- **Tùy biến pha chế:** Tự do cá nhân hóa ly nước yêu thích trước khi cho vào giỏ.
- **Nút Thêm Nhanh (1-Click Quick Add):** Thêm nhanh vào giỏ hàng ngay trên thẻ sản phẩm mà không cần chuyển trang.
- **Hẹn giờ nhận nước 24H:** Đảm bảo quán chuẩn bị nước trước tối thiểu 15 phút, khách đến lấy ngay không phải chờ đợi.

### 3. Hệ Thống Khuyến Mãi & CRM Trung Thành (Loyalty System)
- **Hạng thành viên 4 cấp:** Đồng (0đ), Bạc (500đ), Vàng (1,500đ), Kim Cương (3,000đ).
- **Quy tắc Voucher doanh nghiệp:** Giảm theo tiền mặt hoặc giảm theo %, chặn giá trị giảm tối đa, yêu cầu đơn tối thiểu, kiểm soát số lượt dùng còn lại.

---

## 🛠️ III. CÔNG NGHỆ SỬ DỤNG (TECH STACK)

| Thành phần | Công nghệ / Thư viện | Phiên bản | Mô tả chi tiết |
| :--- | :--- | :--- | :--- |
| **Backend Core** | Java SE | **Java 21 LTS** | Ngôn ngữ lập trình hiện đại, hiệu năng cao |
| **Web Framework** | Jakarta EE (Servlet / JSP) | **Jakarta 10** | Mô hình kiến trúc MVC phân lớp rõ ràng |
| **Connection Pool** | HikariCP | **5.1.0** | Tối ưu hóa kết nối CSDL tốc độ mili-giây |
| **Database** | Microsoft SQL Server | **2022** | Ràng buộc khóa ngoại, Sequences `NO CACHE`, Collation tiếng Việt |
| **Web Server** | Apache Tomcat | **11.0.1** | Container triển khai ứng dụng web |
| **Frontend** | HTML5, CSS3, JS, Bootstrap 5 | **5.3.2** | Giao diện hiện đại, SweetAlert2, Bootstrap Icons |
| **Testing** | JUnit 5 Jupiter | **5.10.1** | Kiểm thử tích hợp tự động toàn bộ luồng nghiệp vụ |

---

## 🚀 IV. HƯỚNG DẪN CÀI ĐẶT & KHỞI CHẠY (QUICK START)

### 1. Chuẩn bị môi trường
- Cài đặt **JDK 21** và cấu hình biến môi trường `JAVA_HOME`.
- Cài đặt **Microsoft SQL Server 2022** (Port 1433).
- Cài đặt **Apache Tomcat 11** hoặc IntelliJ IDEA Ultimate.

### 2. Khởi tạo Cơ sở Dữ liệu
1. Mở **SQL Server Management Studio (SSMS)** hoặc công cụ `sqlcmd`.
2. Mở file [datahetcuu.sql](datahetcuu.sql) và thực thi (Execute).
3. Database `QuanLyQuanCafehetcuu1` (hoặc `QuanLyQuanCafehetcuu3`) sẽ được tự động khởi tạo với 19 bảng và dữ liệu mẫu đầy đủ.

### 3. Cấu hình kết nối CSDL
Mở tệp `src/main/resources/application.properties` và chỉnh sửa thông tin phù hợp với máy của bạn:
```properties
db.url=jdbc:sqlserver://localhost:1433;databaseName=QuanLyQuanCafehetcuu1;encrypt=true;trustServerCertificate=true
db.user=sa
db.password=MatKhauCuaBan!
db.hikari.maximumPoolSize=15
```

### 4. Đóng gói & Triển khai (Build & Run)
Mở Terminal tại thư mục gốc dự án và chạy lệnh Maven:
```bash
# Chạy bộ kiểm thử tự động
mvn test

# Đóng gói file WAR
mvn clean package -DskipTests
```
Sau đó nạp file `target/JAV102.war` vào Apache Tomcat 11 và truy cập:
- **Cổng Khách Hàng:** `http://localhost:8081/home`
- **Quầy Thu Ngân POS:** `http://localhost:8081/pos` (Tài khoản: `staff` / Mật khẩu: `12345678`)
- **Trang Quản Trị Admin:** `http://localhost:8081/admin/dashboard` (Tài khoản: `admin` / Mật khẩu: `12345678`)

---

## 📂 V. CẤU TRÚC THƯ MỤC MÃ NGUỒN

```text
JAV102/
├── .github/                       # GitHub Workflows & Issue Templates
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── config/            # Cấu hình DBConnect (HikariCP) & Hằng số
│   │   │   ├── controller/        # Servlets điều hướng (POS, Portal, Admin, Auth)
│   │   │   ├── filter/            # Bộ lọc bảo mật & phân quyền truy cập
│   │   │   ├── model/             # Entities & Data Transfer Objects (DTO)
│   │   │   ├── repository/        # Data Access Objects (DAO/JDBC)
│   │   │   ├── service/           # Tầng nghiệp vụ xử lý logic
│   │   │   └── util/              # Hỗ trợ băm mật khẩu, định dạng tiền, VietQR
│   │   ├── resources/             # application.properties
│   │   └── webapp/
│   │       ├── assets/            # CSS (2026 frosted glass), JavaScript, hình ảnh
│   │       ├── views/             # Toàn bộ giao diện JSP phân hệ
│   │       └── WEB-INF/           # web.xml
│   └── test/                      # Bộ kiểm thử tự động SystemIntegrationTest.java
├── datahetcuu.sql                 # Bản thiết kế 19 bảng CSDL & dữ liệu mẫu hoàn chỉnh
├── pom.xml                        # Cấu hình dependencies Maven
└── README.md                      # Hồ sơ tài liệu dự án
```

---

## 📜 VI. BẢN QUYỀN & GIẤY PHÉP
Dự án được xây dựng và bảo vệ bản quyền bởi **CodeDevSquad 2026** thuộc tổ chức **[devsquad-team-vn](https://github.com/devsquad-team-vn)**.
Mọi hành vi sao chép phục vụ mục đích thương mại cần có sự đồng ý của nhóm phát triển.
