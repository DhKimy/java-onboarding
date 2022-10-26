package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        return calc(number);
    }

    public static int calc(int num) {
        int result = 0;

        for (int i = 1; i <= num; i++){
            String temp = Integer.toString(i);
            result += temp.chars()
                    .filter(c -> c == '3' || c == '6' || c =='9')
                    .count();
        }
        return result;
    }
}
