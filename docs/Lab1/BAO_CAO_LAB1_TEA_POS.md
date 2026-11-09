**TRƯỜNG CAO ĐẲNG FPT POLYTECHNIC**

# BÁO CÁO THỰC HÀNH LAB 1 - DỰ ÁN JAVA 1 (JAV102)

## ĐỀ TÀI: HỆ THỐNG QUẢN LÝ BÁN TRÀ SỮA (TEA POS)
*Chuyên đề: Phân tích Yêu cầu Chức năng & Thiết kế Sơ đồ Use Case*

---

| Thông tin | Nội dung chi tiết |
| :--- | :--- |
| **Môn học / Lớp:** | Dự án Java 1 (JAV102) - Servlet, JSP & SQL Server |
| **Bài thực hành:** | Lab 1: Phân tích yêu cầu khách hàng & Thiết kế sơ đồ Use Case |
| **Sinh viên thực hiện:** | 1. Phạm Thiện Quang (Trưởng nhóm / Kiến trúc hệ thống)<br>2. Vòng Kiệt (Giao diện Frontend)<br>3. Nguyễn Nam (Xử lý Backend)<br>4. Hoàng Anh Khoa (Quản trị Cơ sở dữ liệu)<br>5. Sơn Trần Phú Quý (Kiểm thử hệ thống) |
| **Cơ sở dữ liệu:** | Microsoft SQL Server 2022 (Database: QuanLyQuanCafehetcuu1) |
| **Thời gian thực hiện:** | Tháng 11 / 2026 |

---

## MỤC TIÊU BÀI THỰC HÀNH LAB 1

Báo cáo này được thực hiện dựa trên dự án phần mềm TEA POS do nhóm tự xây dựng trong môn Dự án Java 1 (JAV102). Mục tiêu của bài thực hành:
- Phân tích rõ ràng phạm vi yêu cầu chức năng (Functional Requirements) và phi chức năng (Non-Functional Requirements) của dự án.
- Thiết kế và mô tả mô hình kiến trúc triển khai 3 tầng (Client, Web Server Servlet/JSP, Database Server SQL Server).
- Xác định đúng tác nhân (Actor), các ca sử dụng (Use Case) và quan hệ giữa chúng (Association, «include», «extend», Generalization).
- Vẽ sơ đồ Use Case cho Nhân viên thu ngân, Quản lý (Admin), Khách hàng và Sơ đồ Use Case tổng quan toàn hệ thống.

---

## BẢNG PHÂN CÔNG NHIỆM VỤ THỰC HIỆN LAB 1

| Các bước | Nội dung | Thảo luận | Người thực hiện |
| :--- | :--- | :---: | :--- |
| **1. SRS (MÔ TẢ YÊU CẦU)** | Mô tả ứng dụng làm gì, hoạt động như thế nào (quy trình bán lẻ tại quầy POS & đặt online Click & Collect) | Cả nhóm | Phạm Thiện Quang<br>Sơn Trần Phú Quý |
| **2. Danh sách chức năng** | Ứng dụng có các chức năng gì? Ai tham gia? Phân quyền (Bảng 19 chức năng, NFR, ma trận RBAC) | Cả nhóm | Nguyễn Nam<br>Hoàng Anh Khoa |
| **3. Mô hình Triển khai** | Vẽ mô hình kiến trúc 3 tầng: Client, Web Server Tomcat 11, Database SQL Server 2022 | Cả nhóm | Phạm Thiện Quang<br>Hoàng Anh Khoa |
| **4. Usecase** | a. Use case Tổng quan | Cả nhóm | Vòng Kiệt |
| | b. Use case Chi tiết (Nhân viên) | | Nguyễn Nam<br>Vòng Kiệt |
| | c. Use case Chi tiết (Admin) | | Hoàng Anh Khoa<br>Sơn Trần Phú Quý |


---

## BÀI 1 (2.0 ĐIỂM): GHI LẠI DANH SÁCH PHẠM VI CHỨC NĂNG CỦA DỰ ÁN (FUNCTIONAL REQUIREMENTS)

### 1.1. Bối cảnh dự án và quy trình bán hàng:
Hệ thống TEA POS phục vụ hoạt động bán lẻ đồ uống (trà sữa, cà phê, nước ép) cho cửa hàng với hai quy trình bán hàng chính:
- **Bán hàng trực tiếp tại quầy:** Khách gọi món -> Nhân viên chọn món trên màn hình POS, tùy chọn kích cỡ (Size), thêm topping, ghi chú đường/đá -> Nhập số điện thoại khách để tích điểm hoặc áp voucher -> Thu tiền (tiền mặt hoặc quét mã VietQR) -> Hệ thống in hóa đơn nhiệt và chuyển thông tin sang quầy pha chế.
- **Đặt nước trực tuyến hẹn giờ lấy tại quầy (Click & Collect):** Khách xem menu qua website -> Chọn món, tùy chọn ly nước -> Chọn thời gian hẹn đến lấy nước -> Thanh toán chuyển khoản VietQR -> Đơn hàng hiển thị trên máy POS quầy để nhân viên pha chế đúng giờ hẹn -> Khách ghé quầy nhận nước.

### 1.2. Bảng phạm vi chức năng chi tiết theo tác nhân:

| Phân hệ | Tác nhân (Actor) | Chi tiết yêu cầu chức năng | Mức độ ưu tiên |
| :--- | :--- | :--- | :---: |
| **Khách hàng<br>(Portal)** | Khách hàng | - Xem thực đơn đồ uống theo từng danh mục, tìm kiếm món theo tên.<br>- Tùy biến ly nước: chọn Size (S/M/L), thêm Topping, chỉnh mức đường/đá.<br>- Quản lý giỏ hàng: thêm món, sửa số lượng, xóa món.<br>- Đặt nước hẹn giờ lấy tại quầy (Click & Collect trước tối thiểu 15 phút).<br>- Thanh toán qua mã VietQR chuyển khoản ngân hàng.<br>- Xem lịch sử các đơn hàng đã đặt và theo dõi điểm thưởng tích lũy. | Bắt buộc |
| **Bán hàng tại quầy<br>(POS)** | Nhân viên<br>(Thu ngân) | - Đăng nhập tài khoản nhân viên, đổi mật khẩu cá nhân.<br>- Tra cứu menu món nước, thêm món vào hóa đơn bán tại quầy.<br>- Tùy chọn size, thêm topping và ghi chú khẩu vị theo yêu cầu khách.<br>- Tìm kiếm khách hàng theo SĐT (AJAX), tạo nhanh tài khoản khách tại quầy.<br>- Áp dụng mã voucher giảm giá và trừ điểm tích lũy của khách.<br>- Thanh toán tiền mặt (tự tính tiền thừa) hoặc quét mã VietQR.<br>- In hóa đơn bán lẻ nhiệt chuẩn 80mm.<br>- Tiếp nhận và chuyển trạng thái pha chế cho các đơn đặt online.<br>- Hủy hóa đơn bán hàng tại quầy khi có yêu cầu hợp lệ. | Bắt buộc |
| **Quản lý danh mục & Thực đơn** | Quản lý<br>(Admin) | - Quản lý danh mục đồ uống (Trà sữa, Cà phê, Nước ép): thêm, sửa, xóa.<br>- Quản lý thực đơn: thêm món mới, cập nhật giá theo size, tải ảnh, ẩn/hiện món.<br>- Quản lý danh sách Topping: cập nhật đơn giá, trạng thái còn/hết hàng. | Bắt buộc |
| **Quản lý kinh doanh & Nhân sự** | Quản lý<br>(Admin) | - Quản lý chương trình khuyến mãi: tạo mã voucher, định mức giảm, hạn dùng.<br>- Quản lý tài khoản nhân viên: tạo mới, phân quyền, khóa tài khoản.<br>- Quản lý khách hàng: xem danh sách hội viên, lịch sử mua và điểm thưởng.<br>- Tra cứu toàn bộ lịch sử hóa đơn hệ thống theo ngày và trạng thái. | Bắt buộc |
| **Báo cáo & Thống kê** | Quản lý<br>(Admin) | - Báo cáo doanh thu theo ngày, tháng và theo từng nhóm danh mục.<br>- Thống kê Top các sản phẩm đồ uống bán chạy nhất.<br>- Xem nhật ký hoạt động hệ thống (thao tác dữ liệu và đăng nhập). | Bắt buộc |

### 1.3. Yêu cầu phi chức năng (Non-Functional Requirements):
- **Giao diện (UI/UX):** Thiết kế web responsive, bố cục rõ ràng, thao tác tiện lợi trên máy POS cảm ứng tại quầy cũng như trên trình duyệt điện thoại của khách hàng.
- **Hiệu năng (Performance):** Quản lý kết nối CSDL bằng HikariCP để giảm độ trễ, thời gian tải trang nhanh, tra cứu khách hàng bằng AJAX không làm tải lại trang.
- **Bảo mật (Security):** Băm mật khẩu người dùng với SHA-256; sử dụng Servlet Filter để kiểm tra quyền truy cập (chặn truy cập trái phép vào trang quản trị); tự động khóa tài khoản tạm thời nếu đăng nhập sai liên tiếp nhiều lần.
- **Toàn vẹn dữ liệu (Data Integrity):** Thiết lập ràng buộc khóa ngoại trong SQL Server, không xóa cứng các sản phẩm/nhân viên đã có lịch sử hóa đơn để đảm bảo dữ liệu báo cáo kế toán luôn chính xác.

---

## BÀI 2 (2.0 ĐIỂM): VẼ MÔ HÌNH TRIỂN KHAI DỰ ÁN VỚI 3 THÀNH PHẦN (DEPLOYMENT ARCHITECTURE)

Hệ thống TEA POS được thiết kế theo mô hình kiến trúc triển khai 3 tầng (3-Tier Architecture) gồm: Tầng Client, Tầng Web Server chạy Servlet/JSP (Apache Tomcat) và Tầng Database Server (SQL Server).

[HINH_1_DEPLOYMENT]

*Hình 2.1: Sơ đồ mô hình kiến trúc triển khai 3 tầng của dự án TEA POS*

### 2.1. Thuyết minh chi tiết 3 thành phần triển khai:

**a) Thành phần 1: Tầng Client (Presentation Tier)**
- **Thiết bị:** Máy POS cảm ứng quầy thu ngân, máy tính/laptop của quản lý, điện thoại di động thông minh của khách hàng.
- **Phần mềm:** Các trình duyệt web phổ biến (Google Chrome, Microsoft Edge, Safari).
- **Công nghệ:** HTML5, CSS3, JavaScript, framework Bootstrap để hiển thị giao diện và gửi nhận dữ liệu với máy chủ.

**b) Thành phần 2: Tầng Web Server (Application Tier)**
- **Máy chủ ứng dụng:** Apache Tomcat 11 (Port 8081).
- **Nền tảng:** Java 21, Servlet và JSP theo kiến trúc MVC.
- **Các thành phần bên trong:**
  - *Controller (Java Servlets):* Tiếp nhận request từ client, điều hướng luồng xử lý và gọi tầng nghiệp vụ.
  - *View (JSP / JSTL):* Hiển thị giao diện dữ liệu trả về cho người dùng.
  - *Model / Service & DAO (JDBC):* Xử lý tính toán hóa đơn, kết nối cơ sở dữ liệu qua thư viện HikariCP.
  - *Filter:* Kiểm tra phiên đăng nhập và phân quyền truy cập.

**c) Thành phần 3: Tầng Database Server (Data Tier)**
- **Hệ quản trị CSDL:** Microsoft SQL Server 2022 (Port 1433).
- **Cơ sở dữ liệu:** Gồm 19 bảng quan hệ lưu trữ thông tin sản phẩm, danh mục, topping, hóa đơn, khách hàng, nhân viên, voucher và lịch sử hoạt động.

### 2.2. Giao thức kết nối giữa các tầng:
- **Client ⇄ Web Server:** Sử dụng giao thức HTTP/HTTPS. Client gửi HTTP Request (GET/POST) hoặc request AJAX ngầm và nhận phản hồi HTML/JSON từ Tomcat Server.
- **Web Server ⇄ Database Server:** Sử dụng giao thức mạng TCP/IP qua cổng 1433 thông qua thư viện kết nối Microsoft JDBC Driver (mssql-jdbc). Các câu lệnh SQL được thực thi an toàn bằng PreparedStatement.

---

## BÀI 3 (2.0 ĐIỂM): LIỆT KÊ CÁC USE CASE VÀ VẼ SƠ ĐỒ USE CASE CHO TÁC NHÂN NHÂN VIÊN

Tác nhân Nhân viên (Thu ngân) là người trực tiếp sử dụng phân hệ bán hàng tại quầy để phục vụ khách và quản lý đơn hàng trong ca trực.

| Mã UC | Tên Use Case | Mô tả nghiệp vụ | Quan hệ UML |
| :--- | :--- | :--- | :--- |
| **UC-NV01** | Đăng nhập | Nhập tài khoản và mật khẩu để đăng nhập vào ca làm việc trên hệ thống POS. | Association (Trực tiếp) |
| **UC-NV02** | Đổi mật khẩu | Nhân viên tự đổi mật khẩu cá nhân để bảo mật tài khoản. | «include» vào Đăng nhập |
| **UC-NV03** | Tra cứu menu & Thêm món | Xem thực đơn theo nhóm danh mục, tìm kiếm và thêm món vào hóa đơn bán hàng. | «include» vào Đăng nhập |
| **UC-NV04** | Tùy chọn Size & Topping | Chọn kích cỡ (S/M/L), chọn một hoặc nhiều topping, ghi chú % đường/đá cho từng ly nước. | «include» vào Đăng nhập |
| **UC-NV05** | Tra cứu khách hàng theo SĐT | Nhập số điện thoại khách hàng để kiểm tra thông tin và điểm tích lũy bằng AJAX. | «include» vào Đăng nhập |
| **UC-NV06** | Tạo tài khoản khách tại quầy | Tạo nhanh hồ sơ khách mới trực tiếp tại quầy khi số điện thoại chưa tồn tại. | «extend» từ Tra cứu KH |
| **UC-NV07** | Áp dụng Voucher & Điểm tích lũy | Nhập mã giảm giá và chọn số điểm tích lũy muốn trừ vào hóa đơn. | «include» vào Đăng nhập |
| **UC-NV08** | Thanh toán & Xuất hóa đơn | Chọn hình thức thanh toán (tiền mặt tính tiền thối hoặc quét mã VietQR), lưu hóa đơn. | «include» vào Đăng nhập |
| **UC-NV09** | In hóa đơn bán lẻ | Tự động in phiếu thanh toán nhiệt chuẩn 80mm giao cho khách sau khi thanh toán. | «include» vào Thanh toán |
| **UC-NV10** | Tiếp nhận đơn đặt online | Nhận đơn đặt trước từ website, chuyển trạng thái đơn sang pha chế. | «include» vào Đăng nhập |
| **UC-NV11** | Hủy hóa đơn tại quầy | Hủy hóa đơn chưa thanh toán khi khách đổi ý, nhập lý do hủy. | «include» vào Đăng nhập |

[HINH_2_UC_POS]

*Hình 3.1: Sơ đồ Use Case chi tiết tác nhân Nhân viên (Bán hàng POS)*

### 3.2. Phân tích các mối quan hệ nghiệp vụ trong sơ đồ:
- **Quan hệ trực tiếp (Association):** Nhân viên liên kết với chức năng Đăng nhập. Đây là điều kiện đầu tiên để được phép sử dụng các chức năng bán hàng.
- **Quan hệ «include»:** Các chức năng bán hàng tại quầy (Tạo đơn, Tùy chọn size/topping, Áp voucher, Thanh toán) đều có quan hệ «include» với Đăng nhập vì hệ thống bắt buộc phải kiểm tra phiên làm việc hợp lệ. Chức năng Thanh toán có quan hệ «include» với In hóa đơn vì khi đơn hàng thanh toán thành công, việc in bill là hành động tự động đi kèm.
- **Quan hệ «extend»:** Use Case "Tạo tài khoản khách tại quầy" là nhánh mở rộng («extend») từ "Tra cứu khách hàng theo SĐT". Khi nhân viên nhập số điện thoại mà hệ thống thông báo chưa có dữ liệu, chức năng tạo nhanh sẽ được gọi mà không làm mất thông tin đơn hàng đang chọn dở.

---

## BÀI 4 (2.0 ĐIỂM): LIỆT KÊ CÁC USE CASE VÀ VẼ SƠ ĐỒ USE CASE CHO TÁC NHÂN QUẢN LÝ

Tác nhân Quản lý (Admin) là người quản trị toàn bộ hoạt động của cửa hàng. Trong sơ đồ Use Case, Quản lý có quan hệ kế thừa (Generalization) từ Nhân viên, nghĩa là Quản lý có toàn quyền thực hiện các chức năng bán hàng của Nhân viên và có thêm các chức năng quản trị cấp cao.

| Mã UC | Tên Use Case | Mô tả nghiệp vụ | Quan hệ UML |
| :--- | :--- | :--- | :--- |
| **UC-QL00** | Kế thừa quyền bán hàng | Thực hiện toàn bộ các chức năng của Nhân viên (bán hàng, thu tiền, in bill). | Kế thừa (Generalization) |
| **UC-QL01** | Quản lý Thực đơn | Thêm món mới, cập nhật giá theo size (S/M/L), tải ảnh đại diện, bật/tắt trạng thái kinh doanh. | Chức năng quản trị |
| **UC-QL02** | Quản lý Topping | Thêm, sửa thông tin topping trà sữa, cập nhật đơn giá, trạng thái còn/hết. | Chức năng quản trị |
| **UC-QL03** | Quản lý Danh mục đồ uống | Thêm mới, chỉnh sửa thông tin các nhóm sản phẩm (Trà sữa, Cà phê, Đá xay). | Chức năng quản trị |
| **UC-QL04** | Quản lý Mã giảm giá (Voucher) | Tạo mới voucher theo % hoặc tiền mặt, thiết lập hạn sử dụng, số lượt dùng tối đa, đơn tối thiểu. | Chức năng quản trị |
| **UC-QL05** | Quản lý Tài khoản Nhân viên | Tạo tài khoản nhân viên mới, phân quyền (Thu ngân, Pha chế, Quản lý), khóa/kích hoạt tài khoản. | Chức năng quản trị |
| **UC-QL06** | Quản lý Khách hàng & CRM | Xem danh sách khách hàng, lịch sử mua hàng, điều chỉnh số điểm tích lũy và hạng thành viên. | Chức năng quản trị |
| **UC-QL07** | Tra cứu Hóa đơn toàn hệ thống | Xem danh sách và chi tiết toàn bộ hóa đơn của cửa hàng (tại quầy và online). | Chức năng quản trị |
| **UC-QL08** | Báo cáo Doanh thu | Xem báo cáo tổng hợp doanh thu theo ngày, tháng, năm và theo nhóm danh mục sản phẩm. | Chức năng quản trị |
| **UC-QL09** | Thống kê Top món bán chạy | Thống kê danh sách các món đồ uống có số lượng bán cao nhất trong khoảng thời gian đã chọn. | Chức năng quản trị |
| **UC-QL10** | Xem Nhật ký hoạt động | Xem lịch sử thay đổi dữ liệu (thêm, sửa, xóa) và lịch sử đăng nhập hệ thống. | Chức năng quản trị |

[HINH_3_UC_ADMIN]

*Hình 4.1: Sơ đồ Use Case chi tiết tác nhân Quản lý (Admin)*

### 4.2. Các quy tắc nghiệp vụ và ràng buộc cơ sở dữ liệu:
- **Ràng buộc khi xóa Thực đơn và Topping:** Đối với các món nước hoặc topping đã từng được bán (đã có trong bảng chi tiết hóa đơn), hệ thống không cho phép xóa vật lý (Hard Delete) mà chỉ cho phép chuyển sang trạng thái "Ngừng kinh doanh" (Soft Delete) để đảm bảo không làm sai lệch báo cáo doanh thu lịch sử.
- **Ràng buộc khi xóa Nhân viên:** Nhân viên đã từng lập hóa đơn bán hàng sẽ không được xóa khỏi CSDL để phục vụ kiểm tra đối soát. Quản lý chỉ được phép khóa tài khoản của nhân viên đó.
- **Ràng buộc áp dụng Voucher:** Khi thu ngân áp mã voucher, hệ thống tự động kiểm tra đồng thời: còn trong thời hạn sử dụng, số lượt dùng còn lại lớn hơn 0 và giá trị đơn hàng đạt mức tối thiểu quy định.

---

## BÀI 5 (2.0 ĐIỂM): NỘI DUNG MỞ RỘNG (GIẢNG VIÊN CHO THÊM)

Phần mở rộng hoàn thiện các nội dung bổ trợ quan trọng của dự án gồm: Sơ đồ Use Case tác nhân Khách hàng, Sơ đồ Use Case tổng quan toàn hệ thống, Ma trận phân quyền người dùng (RBAC Matrix) và Bảng đặc tả kịch bản Use Case trọng tâm.

### 5.1. Sơ đồ Use Case tác nhân Khách hàng (Customer Portal):
Khách hàng truy cập website đặt nước online với các Use Case chính:
- Xem danh mục đồ uống & tìm kiếm món theo tên.
- Tùy chọn ly nước: chọn Size (S/M/L), chọn Topping, điều chỉnh lượng đường và đá.
- Quản lý giỏ hàng: thêm món, sửa số lượng, xóa món.
- Đặt hẹn giờ nhận nước tại quầy (Click & Collect).
- Thanh toán trực tuyến qua mã chuyển khoản VietQR.
- Tra cứu lịch sử đơn hàng đã đặt và theo dõi điểm tích lũy thành viên.

[HINH_4_UC_CUSTOMER]

*Hình 5.1: Sơ đồ Use Case chi tiết tác nhân Khách hàng*

### 5.2. Sơ đồ Use Case tổng quan toàn bộ hệ thống:
Sơ đồ tổng quan thể hiện toàn bộ ranh giới hệ thống và mối quan hệ giữa 3 tác nhân chính: Khách hàng, Nhân viên thu ngân và Quản lý.

[HINH_5_UC_OVERVIEW]

*Hình 5.2: Sơ đồ Use Case tổng quan toàn bộ hệ thống TEA POS*

### 5.3. Bảng ma trận phân quyền người dùng (RBAC Matrix):

| STT | Nhóm chức năng nghiệp vụ | Khách vãng lai | Khách đã đăng nhập | Thu ngân / Quản lý |
| :---: | :--- | :---: | :---: | :---: |
| 1 | Xem thực đơn, tìm kiếm món nước | Có quyền | Có quyền | Có quyền |
| 2 | Tùy chọn ly nước, thêm vào giỏ hàng | Cần đăng nhập | Có quyền | Không dùng qua Web |
| 3 | Đặt nước hẹn giờ lấy tại quầy | Không | Có quyền | Không dùng qua Web |
| 4 | Thanh toán chuyển khoản VietQR | Không | Có quyền | Có quyền (tại quầy) |
| 5 | Xem lịch sử mua hàng và điểm tích lũy | Không | Có quyền | Có quyền (tra cứu KH) |
| 6 | Bán hàng tại quầy POS & Tạo tài khoản khách | Không | Không | Có quyền (Thu ngân & Admin) |
| 7 | Áp dụng voucher & trừ điểm tích lũy tại quầy | Không | Không | Có quyền (Thu ngân & Admin) |
| 8 | Thu tiền mặt, in hóa đơn bán lẻ tại quầy | Không | Không | Có quyền (Thu ngân & Admin) |
| 9 | Tiếp nhận đơn online và đổi trạng thái pha chế | Không | Không | Có quyền (Thu ngân & Admin) |
| 10 | Báo cáo doanh thu theo ngày, tháng | Không | Không | Chỉ Quản lý (Admin) |
| 11 | Thống kê Top sản phẩm bán chạy | Không | Không | Chỉ Quản lý (Admin) |
| 12 | Quản lý Thực đơn, Size và Topping | Không | Không | Chỉ Quản lý (Admin) |
| 13 | Quản lý Chương trình khuyến mãi (Voucher) | Không | Không | Chỉ Quản lý (Admin) |
| 14 | Quản lý Tài khoản Nhân viên và phân quyền | Không | Không | Chỉ Quản lý (Admin) |
| 15 | Quản lý Khách hàng và chính sách tích điểm | Không | Không | Chỉ Quản lý (Admin) |
| 16 | Tra cứu toàn bộ lịch sử hóa đơn hệ thống | Không | Không | Chỉ Quản lý (Admin) |
| 17 | Xem Nhật ký hoạt động hệ thống | Không | Không | Chỉ Quản lý (Admin) |

### 5.4. Bảng đặc tả kịch bản Use Case trọng tâm:

| Thuộc tính | Chi tiết đặc tả nghiệp vụ |
| :--- | :--- |
| **Mã & Tên Use Case** | **UC-NV08: Bán hàng tại quầy POS và Thanh toán** |
| **Tác nhân chính** | Nhân viên thu ngân / Quản lý |
| **Mục đích** | Tạo hóa đơn bán tại quầy, tùy chọn ly nước theo yêu cầu khách, áp dụng giảm giá và thanh toán. |
| **Tiền điều kiện** | Nhân viên đã đăng nhập thành công vào hệ thống POS. |
| **Hậu điều kiện** | Hóa đơn được lưu vào CSDL với trạng thái "Đã thanh toán", in hóa đơn cho khách và cộng điểm tích lũy. |
| **Luồng sự kiện chính<br>(Basic Flow)** | 1. Thu ngân chọn các món nước khách gọi trên màn hình danh mục POS.<br>2. Với mỗi món, thu ngân chọn kích cỡ (Size), chọn topping và ghi chú mức đường/đá.<br>3. Thu ngân nhập số điện thoại khách hàng để tra cứu thông tin và điểm tích lũy.<br>4. Thu ngân chọn áp dụng mã voucher hoặc nhập số điểm muốn đổi trừ tiền (nếu khách yêu cầu).<br>5. Hệ thống tính tổng tiền cần thanh toán sau khi trừ ưu đãi.<br>6. Thu ngân chọn phương thức thanh toán (Tiền mặt hoặc Quét mã VietQR):<br>&nbsp;&nbsp;&nbsp;- Nếu tiền mặt: Thu ngân nhập tiền khách đưa, hệ thống hiển thị tiền thối lại.<br>&nbsp;&nbsp;&nbsp;- Nếu VietQR: Khách quét mã QR trên màn hình phụ để chuyển khoản.<br>7. Thu ngân nhấn "Xác nhận thanh toán", hệ thống lưu hóa đơn vào CSDL và tự động in hóa đơn nhiệt 80mm giao cho khách. |
| **Luồng rẽ nhánh & Ngoại lệ** | - **3a. Số điện thoại chưa có trong hệ thống:** Thu ngân nhấn "Tạo nhanh khách", chỉ cần nhập họ tên khách để lưu hồ sơ mà không mất các món đang chọn.<br>- **6a. Khách đổi ý hủy đơn:** Thu ngân nhấn nút "Hủy đơn", nhập lý do hủy, hệ thống đóng đơn và hoàn trả điểm/voucher đã trừ.<br>- **6b. Tiền khách đưa không đủ:** Hệ thống cảnh báo và yêu cầu thu đủ tiền trước khi bấm xác nhận. |
