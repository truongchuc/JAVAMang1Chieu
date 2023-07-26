package DoAn;

import java.util.*;

public class SinhVien {
	// khởi tạo mảng a số lượng ban đầu 3
	public static int a1[], a2[], a3[], sl = 3;
	public static String ht[], mSV[];

	// biến tg lưu dữ liệu
	public static String nhapmSV() {
		Scanner sc = new Scanner(System.in);
		String tg = sc.nextLine();
		return tg;
	}

	public static int nhapdiemtoan() {
		int tg1;
		Scanner sc = new Scanner(System.in);
		tg1 = sc.nextInt();
		return tg1;
	}

	public static int nhapdiemvan() {
		int tg2;
		Scanner sc = new Scanner(System.in);
		tg2 = sc.nextInt();
		return tg2;
	}

	public static int nhapdiemanh() {
		int tg3;
		Scanner sc = new Scanner(System.in);
		tg3 = sc.nextInt();
		return tg3;
	}

	public static String nhapht() {
		Scanner sc = new Scanner(System.in);
		String tg = sc.nextLine();
		return tg;
	}

	public static void nhapmang() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập số lượng sinh viên: ");
		sl = sc.nextInt();
		a1 = new int[sl];
		a2 = new int[sl];
		a3 = new int[sl];
		ht = new String[sl];
		mSV = new String[sl];
		sc.nextLine();
		for (int i = 0; i < sl; i++) {
			System.out.print("Nhập mã sinh viên thứ  " + (i + 1) + ":");
			mSV[i] = nhapmSV();
			System.out.print("Nhập họ tên sinh viên thứ " + (i + 1) + ":");
			ht[i] = nhapht();
			System.out.print("Nhập điểm Toán sinh viên thứ " + (i + 1) + ":");
			a1[i] = nhapdiemtoan();
			System.out.print("Nhập điểm Văn sinh viên thứ " + (i + 1) + ":");
			a2[i] = nhapdiemvan();
			System.out.print("Nhập điểm Anh sinh viên thứ " + (i + 1) + ":");
			a3[i] = nhapdiemanh();
		}
	}

	// hiển thị danh sách vừa nhập
	public static void hthi() {
		System.out.println("--------------------------------------------------------------------------------------------------------");
		System.out.println("              THÔNG TIN SINH VIÊN                   ");
		System.out.println("--------------------------------------------------------------------------------------------------------");
		System.out.println("Mã SV     |   Họ Tên            |   Điểm Toán         |   Điểm Văn          |   Điểm Anh           |");
		System.out.println("--------------------------------------------------------------------------------------------------------");

		for (int i = 0; i < sl; i++) {
			System.out.printf("%-10s| %-20s| %-20s| %-20s| %d\n", mSV[i], ht[i], a1[i], a2[i], a3[i]);
		}

		System.out.println("--------------------------------------------------------------------------------------------------------");
	}

	// chèn sinh viên vào danh sách
	public static void chen() {

		int[] tempA1 = Arrays.copyOf(a1, sl);
		int[] tempA2 = Arrays.copyOf(a2, sl);
		int[] tempA3 = Arrays.copyOf(a3, sl);
		String[] tempHT = Arrays.copyOf(ht, sl);
		String[] tempMSV = Arrays.copyOf(mSV, sl);
		a1 = new int[sl + 1];
		a2 = new int[sl + 1];
		a3 = new int[sl + 1];
		ht = new String[sl + 1];
		mSV = new String[sl + 1];
		// vòng lặp for để chép các dữ liệu từ từ các mảng vừa sao chép vào các mảng
		// chính
		for (int i = 0; i < sl; i++) {
			a1[i] = tempA1[i];
			a2[i] = tempA2[i];
			a3[i] = tempA3[i];
			ht[i] = tempHT[i];
			mSV[i] = tempMSV[i];
		}
		System.out.println("Nhập mã SV của sinh viên mới:");
		mSV[sl] = nhapmSV();
		System.out.println("Nhập họ tên của sinh viên mới:");
		ht[sl] = nhapht();
		System.out.println("Nhập điểm Toán của sinh viên mới:");
		a1[sl] = nhapdiemtoan();
		System.out.println("Nhập điểm Văn của sinh viên mới:");
		a2[sl] = nhapdiemvan();
		System.out.println("Nhập điểm Anh của sinh viên mới:");
		a3[sl] = nhapdiemanh();
		sl++;
	}

	// xoá sinh viên
	public static void xoa() {
		System.out.println("Nhập mã SV cần xóa:");
		String msv = nhapmSV();
		int tempIndex = -1; // khởi tạo biến tempindex bằng -1
		boolean found = false; // kiểm tra sinh viên có trong mảng hay không
		for (int i = 0; i < sl; i++) {
			if (mSV[i].equals(msv)) { // nếu có trả về giá trị true và kết thúc vòng lặp
				tempIndex = i;
				found = true;
				break;
			}
		}
		if (found) {
			for (int i = tempIndex; i < sl - 1; i++) { //
				mSV[i] = mSV[i + 1];
				ht[i] = ht[i + 1];
				a1[i] = a1[i + 1];
				a2[i] = a2[i + 1];
				a3[i] = a3[i + 1];
			}
			sl--;
			mSV[sl] = null;
			ht[sl] = null;
			a1[sl] = 0;
			a2[sl] = 0;
			a3[sl] = 0;

			System.out.println("Đã xóa sinh viên có mã SV: " + msv);
		} else {
			System.out.println("Không tìm thấy sinh viên có mã SV: " + msv);
		}
	}

	public static void ktrD() {
		int max = a1[0];
		for (int i = 1; i < sl; i++) {
			if (a1[i] > max) {
				max = a1[i];
			}
		}
		System.out.println("--------------------------------------------------------------------------------------------------------");
		System.out.println("Sinh viên có điểm Toán cao nhất");
		System.out.println("--------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < sl; i++) {
			if (a1[i] == max) { // dùng vòng lặp for duyệt nếu phần tử nào bằng max thì in ra
				System.out.println("| Mã SV: " + mSV[i] + " | Họ tên: " + ht[i] + " | Điểm Toán: " + a1[i] + " | Điểm Văn:" + a2[i]
						+ "| Điểm Anh:" + a3[i] + "|");
			}
		}
		System.out.println("--------------------------------------------------------------------------------------------------------");
	}

	public static void Sx() {
		for (int i = 0; i < sl - 1; i++) {
			for (int j = 0; j < sl - i - 1; j++) {
				if (a1[j] > a1[j + 1]) {
					int tempA = a1[j];
					a1[j] = a1[j + 1];
					a1[j + 1] = tempA;
					int tempB = a2[j];
					a2[j] = a2[j + 1];
					a2[j + 1] = tempB;
					int tempC = a3[j];
					a3[j] = a3[j + 1];
					a3[j + 1] = tempB;
					String tempHT = ht[j];
					ht[j] = ht[j + 1];
					ht[j + 1] = tempHT;
					String tempMSV = mSV[j];
					mSV[j] = mSV[j + 1];
					mSV[j + 1] = tempMSV;
				}
			}
		}
		System.out.println("--------------------------------------------------------------------------------------------------------");
		System.out.println("Danh sách sinh viên theo điểm tăng dần:");
		System.out.println("--------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < sl; i++) {
			System.out.println("| Mã SV: " + mSV[i] + " | Họ tên: " + ht[i] + " | Điểm Toán: " + a1[i] + " | Điểm Văn:" + a2[i]
					+ "| Điểm Anh:" + a3[i] + "|");
		}
		System.out.println("--------------------------------------------------------------------------------------------------------");
	}

	public static void timKiem() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã SV cần tìm kiếm:");
		String msv = sc.nextLine();
		boolean found = false;
		// nếu tìm thấy mSV trong mảng trùng với msv thì in ra và gán giá trị found =
		// true
		for (int i = 0; i < sl; i++) {
			if (mSV[i].equals(msv)) {
				System.out.println("--------------------------------------------------------------------------------------------------------");
				System.out.println("Thông tin sinh viên có mã SV " + msv + ":");
				System.out.println("--------------------------------------------------------------------------------------------------------");
				System.out.println("|Họ tên:" + ht[i] + " --- Điểm: " + a1[i] + "|" + " --- Điểm Toán: " + a2[i]
						+ " --- Điểm Văn: " + "|" + " --- Điểm Anh: " + a3[i] + "|");
				System.out.println("--------------------------------------------------------------------------------------------------------");
				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("Không tìm thấy sinh viên có mã bạn vừa nhập " + msv);
		}
	}

	public static void suaThongTin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã SV cần sửa thông tin:");
		String msv = sc.nextLine();
		boolean found = false;

		for (int i = 0; i < sl; i++) {
			if (mSV[i].equals(msv)) {
				System.out.println("Nhập thông tin mới cho sinh viên có mã: " + msv + ":");

				System.out.println("Nhập họ tên mới:");
				ht[i] = sc.nextLine();

				System.out.println("Nhập điểm Toán mới:");
				a1[i] = sc.nextInt();
				sc.nextLine();

				System.out.println("Nhập điểm Văn mới:");
				a2[i] = sc.nextInt();
				sc.nextLine();

				System.out.println("Nhập điểm Anh mới:");
				a3[i] = sc.nextInt();
				sc.nextLine();

				System.out.println("Thông tin của sinh viên có mã SV " + msv + " đã được cập nhật.");
				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("Không tìm thấy sinh viên có mã SV " + msv);
		}
	}

}