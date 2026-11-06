# 🤝 QUY CHUẨN LÀM VIỆC NHÓM TRÊN GITHUB (CONTRIBUTING GUIDELINES)
> **Dự án:** TEA POS System | **Tổ chức:** [devsquad-team-vn](https://github.com/devsquad-team-vn)

Tài liệu này quy định quy chuẩn cộng tác và quản lý mã nguồn dành cho tất cả thành viên trong nhóm **CodeDevSquad 2026**.

---

## 🌳 I. MÔ HÌNH PHÂN NHÁNH (GIT BRANCHING STRATEGY)

Hệ thống sử dụng mô hình phân nhánh chuẩn **Git Flow giản lược**:

```text
  main (Bản nộp đồ án / Production ổn định)
   ▲
   │  (Merge via Pull Request sau khi review)
   │
  develop (Nhánh tích hợp tính năng chung của cả nhóm)
   ▲
   ├────── feature/FE-01-frosted-header (Nhánh của Vòng Kiệt)
   ├────── feature/POS-05-active-voucher (Nhánh của Nguyễn Thành Nam)
   ├────── feature/DB-03-collation-search (Nhánh của Hà Anh Khoa)
   └────── test/QA-03-zero-order-testing (Nhánh của Sơn Thái Phú Quý)
```

### 1. Quy tắc đặt tên nhánh:
- **Tính năng mới:** `feature/<mã-nhiệm-vụ>-<tên-ngắn-gọn>`  
  *Ví dụ:* `feature/FE-04-dual-action-card`, `feature/POS-07-vietqr-handling`
- **Sửa lỗi phát sinh:** `bugfix/<mã-lỗi>-<mô-tả>`  
  *Ví dụ:* `bugfix/search-accent-collation`, `bugfix/pos-duplicate-qr`
- **Kiểm thử:** `test/<mã-nhiệm-vụ>-<mô-tả>`  
  *Ví dụ:* `test/QA-02-voucher-discount-calc`

---

## 💬 II. QUY CHUẨN THÔNG ĐIỆP COMMIT (CONVENTIONAL COMMITS)

Mọi commit của thành viên phải tuân theo cú pháp:
```text
<type>(<scope>): <mô tả ngắn gọn bằng tiếng Việt hoặc tiếng Anh>
```

### Các tiền tố `<type>` được phép sử dụng:
* `feat`: Thêm tính năng mới (Feature)
* `fix`: Sửa lỗi (Bug fix)
* `refactor`: Tái cấu trúc code (không đổi tính năng bên ngoài)
* `style`: Chỉnh sửa giao diện, CSS, canh lề (không ảnh hưởng logic)
* `docs`: Chỉnh sửa hoặc thêm tài liệu (`README`, `TASKS_ASSIGNMENT`)
* `test`: Thêm hoặc cập nhật bài kiểm thử (JUnit test)

*Ví dụ:*
- `feat(pos): hoàn thiện modal chọn voucher thực tế với 1-click apply`
- `fix(search): bổ sung Vietnamese_CI_AI tìm kiếm tiếng Việt không dấu`
- `style(portal): áp dụng hiệu ứng kính mờ Frosted Glass 2026 cho Header`

---

## 🚀 III. QUY TRÌNH NỘP CODE (PULL REQUEST WORKFLOW)

1. **Trước khi bắt đầu:** Kéo code mới nhất từ nhánh `develop` về máy:
   ```bash
   git checkout develop
   git pull origin develop
   ```
2. **Tạo nhánh riêng để làm việc:**
   ```bash
   git checkout -b feature/FE-ten-tinh-nang
   ```
3. **Commit và đẩy lên GitHub:**
   ```bash
   git add .
   git commit -m "feat(portal): mô tả việc đã làm"
   git push -u origin feature/FE-ten-tinh-nang
   ```
4. **Mở Pull Request (PR):**
   - Vào GitHub repo, chọn `Compare & pull request`.
   - Chọn Base: `develop` <- Compare: `feature/FE-ten-tinh-nang`.
   - Điền đầy đủ thông tin theo mẫu PR Template.
   - Gắn tag Reviewer: **Nguyễn Văn Quang** (`@quang642000-lang`) để duyệt code trước khi merge vào nhánh chính.
