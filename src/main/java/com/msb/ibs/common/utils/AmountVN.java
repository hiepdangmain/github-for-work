package com.msb.ibs.common.utils;

/**
 * TODO: Class description here.
 *
 * @author QuangBD3
 */
public class AmountVN {
	boolean flag = true;
	final String[] arr1 = new String[] { "", " Nghìn", " Triệu", " Tỷ" };
	final String[] arr2 = new String[] { "Không", "Mười", "Hai Mươi", "Ba Mươi", "Bốn Mươi", "Năm Mươi", "Sáu Mười",
			"Bảy Mươi", "Tám Mươi", "Chín Mươi" };
	final String[] arr3 = new String[] { "Không", "Một", "Hai", "Ba", "Bốn", "Năm", "Sáu", "Bảy", "Tám", "Chín" };
	final String[] arr4 = new String[] { "Muời", "Mười Một", "Mười Hai", "Mười Ba", "Mười Bốn", "Mười Năm", "Mười Sáu",
			"Mười Bảy", "Mười Tám", "Mười Chín" };
	final String _point = new String("Phẩy");
	final static String[] mangso = new String[] { "Không", "Một", "Hai", "Ba", "Bốn", "Năm", "Sáu", "Bảy", "Tám",
			"Chín" };

	public static String dochangchuc(int so, boolean daydu) {
		String chuoi = "";
		int chuc = so / 10;
		int donvi = so % 10;
		if (chuc - 1 > 0) {
			chuoi = " " + mangso[chuc] + " Mươi";
			if (donvi == 1) {
				chuoi += " Mốt";
			}
		} else if (chuc == 1) {
			chuoi = " Mười";
			if (donvi == 1) {
				chuoi += " Một";
			}
		} else if (daydu && donvi > 0) {
			chuoi = " Lẻ";
		}
		if (donvi == 5 && chuc > 1) {
			chuoi += " Lăm";
		} else if (donvi > 1 || (donvi == 1 && chuc == 0)) {
			chuoi += " " + mangso[donvi];
		}
		return chuoi;
	}

	public static String docblock(int so, boolean daydu) {
		String chuoi = "";
		int tram = (int) so / 100;
		so = so % 100;
		if (daydu || tram > 0) {
			chuoi = " " + mangso[tram] + " Trăm";
			chuoi += dochangchuc(so, true);
		} else
			chuoi = dochangchuc(so, false);
		return chuoi;
	}

	public static String dochangtrieu(int so, boolean daydu) {
		String chuoi = "";
		int trieu = so / 1000000;
		so = so % 1000000;
		if (trieu > 0) {
			chuoi = docblock(trieu, daydu) + " Triệu";
			daydu = true;
		}
		int nghin = so / 1000;
		so = so % 1000;
		if (nghin > 0) {
			chuoi += docblock(nghin, daydu) + " Nghìn";
			daydu = true;
		}
		if (so > 0) {
			chuoi += docblock(so, daydu);
		}
		return chuoi;
	}

	public String docso(long so) {
		if (so == 0)
			return " Không Đồng";
		String chuoi = "", hauto = "";
		do {
			int ty = (int) (so % 1000000000);
			so = so / 1000000000;
			if (so > 0)
				chuoi = dochangtrieu(ty, true) + hauto + chuoi;
			else
				chuoi = dochangtrieu(ty, false) + hauto + chuoi;
			hauto = " Tỷ";
		} while (so > 0);
		return chuoi + " Đồng";
	}

	public static String convert(long so) {
		if (so == 0)
			return "Không Đồng";
		String chuoi = "", hauto = "";
		do {
			int ty = (int) (so % 1000000000);
			so = so / 1000000000;
			if (so > 0)
				chuoi = dochangtrieu(ty, true) + hauto + chuoi;
			else
				chuoi = dochangtrieu(ty, false) + hauto + chuoi;
			hauto = " Tỷ";
		} while (so > 0);
		return chuoi.trim() + " Đồng";
	}
	
	public static String convertTtr(long so, String money) {
		if (so == 0)
			return money;
		String chuoi = "", hauto = "";
		do {
			int ty = (int) (so % 1000000000);
			so = so / 1000000000;
			if (so > 0)
				chuoi = dochangtrieu(ty, true) + hauto + chuoi;
			else
				chuoi = dochangtrieu(ty, false) + hauto + chuoi;
			hauto = " Tỷ";
		} while (so > 0);
		return chuoi.trim() + " "+ money ;
	}
	
}
