package DoAn;

import java.util.*;

public class MeNu {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n;
		do {
			System.out.println("--------------- MENU -------------------------");
			System.out.println("|1. Nhập hồ sơ sinh viên---------------------|");
			System.out.println("|2. Hiển thị hồ sơ sinh viên-----------------|");
			System.out.println("|3. Hiển thị sinh viên có điểm Toán cao nhất-|");
			System.out.println("|4. Hiển thị danh sách điểm tăng dần---------|");
			System.out.println("|5. Tìm kiếm theo mã sinh viên---------------|");
			System.out.println("|6. Chèn Sinh Viên---------------------------|");
			System.out.println("|7. Xóa Sinh Viên----------------------------|");
			System.out.println("|8. Sửa thông tin sinh viên------------------|");
			System.out.println("|9. Thoát chương trình-----------------------|");
			System.out.println("----------------------------------------------");
			System.out.print("Chọn Mục Bạn Muốn: ");
			Scanner sc = new Scanner(System.in);
			System.out.print("Bạn Chọn:");
			n = sc.nextInt();
			switch (n) {
			case 1:
				SinhVien.nhapmang();
				break;
			case 2:
				SinhVien.hthi();
				break;
			case 3:
				SinhVien.ktrD();
				break;
			case 4:
				SinhVien.Sx();
				break;
			case 5:
				SinhVien.timKiem();
				break;
			case 6:
				SinhVien.chen();
				break;
			case 7:
				SinhVien.xoa();
				System.out.println("Danh sách sinh viên sau khi xoá");
				SinhVien.hthi();
				break;
			case 8:
				SinhVien.suaThongTin();
				break;
			case 9:
				System.out.println("Chương trình đã thoát.");
				break;
			default:
				System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
				break;
			}
		} while (n != 9);
		scanner.close();
	}
}
