package vip.epss.domain;

import java.util.ArrayList;

public class ArrayListConvertor {
    public static String convertArrayListToString(ArrayList<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String item : list) {
            sb.append(item);
            sb.append(",");
        }
        // 删除最后一个逗号
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public static ArrayList<String> convertStringToArrayList(String str) {
        String[] parts = str.split(",");
        ArrayList<String> list = new ArrayList<>();
        for (String part : parts) {
            list.add(part);
        }
        return list;
    }
}
