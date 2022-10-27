package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<Set<String>> duplicateNameList = new ArrayList<>();
        Map<String, Integer> countMap = new HashMap<>();

        for (int i = 0; i < forms.size(); i++) {
            String nickname = forms.get(i).get(1);
            Set<String> tokenCheck = tokenSetting(nickname);

            duplicateNameList.add(tokenCheck);
            tokenCheck.forEach(token ->
                    countMap.put(token, countMap.getOrDefault(token, 0) + 1));
        }

        for (int i = 0; i < duplicateNameList.size(); i++) {
            if (duplicateNameList.get(i).stream().anyMatch(token -> countMap.get(token) > 1)) {
                answer.add(forms.get(i).get(0));
            }
        }

        Collections.sort(answer);
        return answer;

    }

    private static Set<String> tokenSetting(String nickname) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < nickname.length() - 1; i++) {
            set.add(nickname.substring(i, i + 2));
        }
        return set;
    }
}
