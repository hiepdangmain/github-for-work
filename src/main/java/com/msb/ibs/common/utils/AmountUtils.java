package com.msb.ibs.common.utils;

import java.util.ArrayList;
import java.util.Arrays;

public class AmountUtils {

    public static String getStringAmount(String a, String currency) {
        String amountInword = "";
        String moneyCurency = getMoneyCurrency(currency);
        String newString = a.replace(".", ",");
        ArrayList<String> parts = new ArrayList<>(Arrays.asList(newString.split(",")));
        long poi1 = Long.parseLong(parts.get(0));
        long poi2;
        String phangNguyen = AmountVN.convertTtr(poi1, moneyCurency);
        if (parts.size() > 1) {
            poi2 = Long.parseLong(parts.get(1));
            String phanThapPhan = AmountVN.convertTtr(poi2, moneyCurency);
            phangNguyen = phangNguyen.replace(moneyCurency, "").trim();
            if (phanThapPhan.equalsIgnoreCase(moneyCurency)) {
                amountInword = phangNguyen + " "+ moneyCurency ;
            } else {
                amountInword = phangNguyen + " phẩy " + phanThapPhan;
            }
        } else {
            amountInword = phangNguyen;
        }
        return amountInword;
    }

    public static String getMoneyCurrency(String currency) {
        String currencyName = "";
        switch (currency) {
            case "USD":
                currencyName = "Đô la Mỹ";
                break;
            case "AUD":
                currencyName = "Đô la Úc";
                break;
            case "CAD":
                currencyName = "Đô la Canada";
                break;
            case "CHF":
                currencyName = "Frank Thụy Sĩ";
                break;
            case "CNY":
                currencyName = "Nhân dân tệ";
                break;
            case "DKK":
                currencyName = "Đồng Đan Mạch";
                break;
            case "EUR":
                currencyName = "Euro";
                break;
            case "GBP":
                currencyName = "Bảng Anh";
                break;
            case "HKD":
                currencyName = "Đôla Hồng Công";
                break;
            case "JPY":
                currencyName = "Yên Nhật";
                break;
            case "KRW":
                currencyName = "Won Hàn Quốc";
                break;
            case "MYR":
                currencyName = "Ringgit Mã Lai";
                break;
            case "NZD":
                currencyName = "Đô la New Zealand";
                break;
            case "SGD":
                currencyName = "Đô la Singapore";
                break;
            case "THB":
                currencyName = "Baht Thái";
                break;
            case "TWD":
                currencyName = "Đô la Đài Loan";
                break;
            case "VND":
                currencyName = "Việt Nam Đồng";
                break;
            default:
                break;
        }
        return currencyName;
    }

    public static String getStringAmountForeign(String amount, String currency) {
        String amountInword;
        String moneyCurency = getMoneyCurrency(currency);
        String newString = amount.replace(".", ",");
        ArrayList<String> parts = new ArrayList<>(Arrays.asList(newString.split(",")));
        long poi1 = Long.parseLong(parts.get(0));
        long poi2;
        String phangNguyen = AmountVN.convertTtr(poi1, moneyCurency);
        if (parts.size() > 1) {
            poi2 = Long.parseLong(parts.get(1));
            String readDecimal = getDecimal(currency);
            String phanThapPhan = AmountVN.convertTtr(poi2, readDecimal);
            if(phanThapPhan.equalsIgnoreCase(moneyCurency) || poi2 <= 0) {
                amountInword = phangNguyen;
            } else {
                amountInword = phangNguyen + " Và " + phanThapPhan;
            }
        } else {
            amountInword = phangNguyen;
        }
        return amountInword;
    }

    public static String getStringAmountForeign(String amount, String currency, String moneyCurency) {
        String amountInword;
        String newString = amount.replace(".", ",");
        ArrayList<String> parts = new ArrayList<>(Arrays.asList(newString.split(",")));
        long poi1 = Long.parseLong(parts.get(0));
        long poi2;
        String phangNguyen = AmountVN.convertTtr(poi1, moneyCurency);
        if (parts.size() > 1) {
            poi2 = Long.parseLong(parts.get(1));
            String readDecimal = getDecimal(currency);
            String phanThapPhan = AmountVN.convertTtr(poi2, readDecimal);
            if(phanThapPhan.equalsIgnoreCase(moneyCurency) || poi2 <= 0) {
                amountInword = phangNguyen;
            } else {
                amountInword = phangNguyen + " Và " + phanThapPhan;
            }
        } else {
            amountInword = phangNguyen;
        }
        return amountInword;
    }

    public static String getDecimal(String currency) {
        String currencyName = "";
        switch (currency) {
            case "USD":
                currencyName = "CENT";
                break;
            case "EUR":
                currencyName = "CENT";
                break;
            case "AUD":
                currencyName = "CENT";
                break;
            case "SGD":
                currencyName = "CENT";
                break;
            case "JPY":
                currencyName = "CENT";
                break;
            case "CAD":
                currencyName = "CENT";
                break;
            case "CHF":
                currencyName = "CENT";
                break;
            case "GBP":
                currencyName = "PENNY";
                break;
            case "VND":
                currencyName = "VIỆT NAM ĐỒNG";
                break;
            default:
                break;
        }
        return currencyName;
    }

//    public static void main(String[] args) {
//        System.out.println(getStringAmountForeign("5051.00", "CHF"));
//    }
}
