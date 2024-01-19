package com.msb.ibs.common.utils;

import java.text.Normalizer;

/**
 * @author cuongnd9 on 29/12/2021
 * @project IBS-Common
 */
public class CommonTranslateUtils {

    private static char uChars[][] = new char[][]
            {
                    {'À', 'Á', 'Ả', 'Ã', 'Ạ', 'Â', 'Ấ', 'Ầ', 'Ẩ', 'Ẫ', 'Ậ', 'Ắ', 'Ằ', 'Ă', 'Ặ'},//0
                    {'Đ'},//1
                    {'È', 'É', 'Ẻ', 'Ẽ', 'Ẹ', 'Ê', 'Ề', 'Ế', 'Ể', 'Ễ', 'Ệ'},//2
                    {'Ì', 'Í', 'Ỉ', 'Ĩ', 'Ị'},//3
                    {'Ò', 'Ó', 'Ỏ', 'Õ', 'Ọ', 'Ô', 'Ồ', 'Ố', 'Ổ', 'Ỗ', 'Ộ', 'Ơ', 'Ờ', 'Ớ', 'Ở', 'Ỡ', 'Ợ'},
                    {'Ù', 'Ú', 'Ủ', 'Ũ', 'Ụ', 'Ư', 'Ừ', 'Ứ', 'Ử', 'Ữ', 'Ự'},
                    {'Ỳ', 'Ý', 'Ỷ', 'Ỹ', 'Ỵ'},
                    {'à', 'á', 'ả', 'ã', 'ạ', 'â', 'ấ', 'ầ', 'ẩ', 'ẫ', 'ậ', 'ắ', 'ằ', 'ă', 'ặ'},
                    {'đ'},
                    {'è', 'é', 'ẻ', 'ẽ', 'ẹ', 'ê', 'ề', 'ế', 'ể', 'ễ', 'ệ'},
                    {'ì', 'í', 'ỉ', 'ĩ', 'ị'},
                    {'ò', 'ó', 'ỏ', 'õ', 'ọ', 'ô', 'ồ', 'ố', 'ổ', 'ỗ', 'ộ', 'ơ', 'ờ', 'ớ', 'ở', 'ỡ', 'ợ'},
                    {'ù', 'ú', 'ủ', 'ũ', 'ụ', 'ư', 'ừ', 'ứ', 'ử', 'ữ', 'ự'},
                    {'ỳ', 'ý', 'ỷ', 'ỹ', 'ỵ'},
                    {'\r', '\n'}

            };
    private static char[] uCharsR = new char[]{'A', 'D', 'E', 'I', 'O', 'U', 'Y', 'a', 'd', 'e', 'i', 'o', 'u', 'y', ' '};
    private static char[] uCharsTtr = new char[]{'A', 'D', 'E', 'I', 'O', 'U', 'Y', 'a', 'd', 'e', 'i', 'o', 'u', 'y', ' '};

    public static char search(char x) {
        for (int u = 0; u < uChars.length; u++)
            for (int v = 0; v < uChars[u].length; v++)
                if (x == uChars[u][v])
                    return uCharsR[u];
        return x;
    }

    public static char searchTtr(char x) {
        for (int u = 0; u < uChars.length; u++)
            for (int v = 0; v < uChars[u].length; v++)
                if (x == uChars[u][v])
                    return uCharsTtr[u];
                else if (x == '\n')
                    return '\n';
        return x;
    }

    public static String clearVNSql(String s) {
        if (CommonStringUtils.isNullOrEmpty(s)) {
            return "";
        }
        s = Normalizer.normalize(s, Normalizer.Form.NFC);
        String temp = "";
        for (int i = 0; i < s.length(); i++)
            temp += search(s.charAt(i));
        return temp.replaceAll("[^a-zA-Z0-9&@\\-/!$%\\’&()_+/?., ]+", "").trim();
        //~!@#$%^&*()_+:{}'
    }

    public static String clearVNBasic(String s) {
        if (CommonStringUtils.isNullOrEmpty(s)) {
            return "";
        }
        s = Normalizer.normalize(s, Normalizer.Form.NFC);
        String temp = "";
        for (int i = 0; i < s.length(); i++)
            temp += search(s.charAt(i));
        return temp.replaceAll("[^a-zA-Z0-9&@\\-/!$%\'\\’&()_+/?., ]+", "").trim();
        //~!@#$%^&*()_+:{}'
    }

    public static String clearVN(String s) {
        if (CommonStringUtils.isNullOrEmpty(s)) {
            return "";
        }
        s = Normalizer.normalize(s, Normalizer.Form.NFC);
        String temp = "";
        for (int i = 0; i < s.length(); i++)
            temp += search(s.charAt(i));

        return temp.replaceAll("[^a-zA-Z0-9&@\\-/!$%&()_+/?., ]+", "").trim();
        //~!@#$%^&*()_+:{}'
    }

    public static String clearTtrVN(String s) {
        if (CommonStringUtils.isNullOrEmpty(s)) {
            return "";
        }
        s = Normalizer.normalize(s, Normalizer.Form.NFC);
        String temp = "";
        for (int i = 0; i < s.length(); i++)
            temp += searchTtr(s.charAt(i));
        if (temp.contains("\n"))
            return temp.replaceAll("[^a-zA-Z0-9\n()+:/.,| ]+", "").trim();
        else
            return temp.replaceAll("[^a-zA-Z0-9()+:/.,| ]+", "").trim();
        //~!@#$%^&*()_+:{}'
    }

    public static String clearTtrRemarkVN(String s) {
        if (CommonStringUtils.isNullOrEmpty(s)) {
            return "";
        }
        s = Normalizer.normalize(s, Normalizer.Form.NFC);
        String temp = "";
        for (int i = 0; i < s.length(); i++)
            temp += searchTtr(s.charAt(i));

        return temp.replaceAll("[^a-zA-Z0-9()+:/., ]+", "").trim();

        //~!@#$%^&*()_+:{}'
    }

    public static String clearVNAdvance(String s) {
        if (CommonStringUtils.isNullOrEmpty(s)) {
            return "";
        }
        s = Normalizer.normalize(s, Normalizer.Form.NFC);
        String temp = "";
        for (int i = 0; i < s.length(); i++)
            temp += search(s.charAt(i));
        return temp.replaceAll("[^a-zA-Z0-9&@\\-/!$%&()_+/?., ]+", "");
        //~!@#$%^&*()_+:{}'
    }
}
