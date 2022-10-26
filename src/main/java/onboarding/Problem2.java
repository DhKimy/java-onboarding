package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {

        return calc(cryptogram);
    }

    public static String calc(String str) {
        String result = "";

        boolean isCheck = true;
        String[] arr = str.split("");

        // 배열을 리스트로 만든다. remove() 사용 목적
        List<String> list = Arrays.asList(arr);

        while(isCheck) {
            isCheck = false;
            List<String> tempString = new ArrayList<>();
            tempString.addAll(list);

            for (int i = 0; i < list.size() - 1 ; i++){
                if(list.get(i).equals(list.get(i + 1))) {
                    /**
                     * 뒤의 인덱스에 위치한 소문자부터 삭제한다. 앞에것부터 삭제하면 인덱스가 섞여 삭제되지 않는다.
                     * asdpddkk 의 경우, i부터 삭제하면 인덱스 4에 있는 d가 삭제되고 나서 모든 값이 당겨지고,
                     * asdpdkk가 된 상태에서 i + 1 인 인덱스 5에 있는 것이 삭제되는데, 이러면 k가 삭제된다.
                     */
                    tempString.remove(i + 1);
                    tempString.remove(i);
                    list = tempString;
                    isCheck = true;
                    continue;
                }
            }
            // 중복된 소문자가 없을 경우, continue에 걸리지 않고 진행
            list = tempString;
        }

        System.out.println(result);
        StringBuilder sb = new StringBuilder();
        for(String s : list) {
            sb.append(s);
        }
        result = sb.toString();

        return result;
    }
}
