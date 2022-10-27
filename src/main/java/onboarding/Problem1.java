package onboarding;

import java.util.List;
import java.util.Map;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1){
            return -1;
        }

        // 예외
        /**
         * 페이지 차이가 1이 아닐 경우
         * 페이지가 음수 또는 400을 초과하여 입력될 경우
         */

        int pobiPlus = 0;
        int pobiMulti = 1;
        int pobiFinalPoint = 0;

        for (int i = 0; i < pobi.size(); i++) {
            String temp = pobi.get(i).toString();
            for (int j = 0; j < temp.length(); j++) {
                pobiPlus += (temp.charAt(j) - '0');
                pobiMulti *= (temp.charAt(j) - '0');

            }
            if (pobiPlus > pobiMulti) {
                pobiFinalPoint = pobiFinalPoint > pobiPlus? pobiFinalPoint : pobiPlus;
            } else {
                pobiFinalPoint = pobiFinalPoint > pobiMulti? pobiFinalPoint : pobiMulti;
            }
            pobiPlus = 0;
            pobiMulti = 1;
        }

        int crongPlus = 0;
        int crongMulti = 1;
        int crongFinalPoint = 0;

        for (int i = 0; i < crong.size(); i++) {
            String temp = crong.get(i).toString();
            for (int j = 0; j < temp.length(); j++) {
                crongPlus += (temp.charAt(j) - '0');
                crongMulti = crongMulti * (temp.charAt(j) - '0');
            }
            if (crongPlus > crongMulti) {
                crongFinalPoint = crongFinalPoint > crongPlus? crongFinalPoint : crongPlus;
            } else {
                crongFinalPoint = crongFinalPoint > crongMulti ? crongFinalPoint : crongMulti;
            }
            crongPlus = 0;
            crongMulti = 1;
        }

        if (crongFinalPoint > pobiFinalPoint) {
            answer = 2;
        } else if (crongFinalPoint < pobiFinalPoint) {
            answer = 1;
        } else {
            answer = 0;
        }

        return answer;
    }
}