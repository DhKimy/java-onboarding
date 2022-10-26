package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return calc(word);
    }

    public static String calc(String wo) {
        String result = "";

        String[] arr = wo.split("");

        // 배열을 리스트로 만든다. remove() 사용 목적
        List<String> list = Arrays.asList(arr);
        for (int i = 0 ; i < list.size() ; i++){
            char c = list.get(i).charAt(0);
            if (c >= 'A' && c <= 'Z') {
                if (c <= 'M') {
                    list.set(i, String.valueOf((char)('M' + ( 'M' - c + 1))));
                }else {
                    list.set(i, String.valueOf((char)('N' - (c - 'N' + 1))));
                }

            }else if (c >= 'a' && c <= 'z' ) {
                if (c <= 'm') {
                    list.set(i, String.valueOf((char)('m' + ( 'm' - c + 1))));
                }else {
                    list.set(i, String.valueOf((char)('n' - (c - 'n' + 1))));
                }
            } else {
                continue;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(String s : list) {
            sb.append(s);
        }
        result = sb.toString();

        return result;
    }
}
