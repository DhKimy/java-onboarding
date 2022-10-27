package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        /**
         고려사항
         : 본인과 친구인지 아닌지 (친구리스트)
         : 친구의 친구인지를 판별 (친구의 친구리스트)
         : 타임라인에 방문한 적이 있는지 판별 (점수 HashMap)
         : 점수별로 라인업 하여 result를 보여주어야 한다. (점수 HashMap)
         */

        // 본인과 친구인 사람들 리스트 업
        List<String> usersFriendsList = new ArrayList<>();
        usersFriendsList = userWithFriendsListUp(friends, user);

        // 유저의 친구의 친구 리스트 업
        List<String> knowTogetherFriends = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < usersFriendsList.size(); j++) {
                if (friends.get(i).get(0) == usersFriendsList.get(j)) {
                    knowTogetherFriends.add(friends.get(i).get(1));
                    break;
                } else if (friends.get(i).get(1) == usersFriendsList.get(j)) {
                    knowTogetherFriends.add(friends.get(i).get(0));
                    break;
                }
            }
        }

        // HashMap을 이용하여 친구, 방문기록 점수 기록
        Map<String, Integer> scoreMap = new HashMap<>();

        // 친구 리스트에 있는 경우 + 10점을 value로 가지게 함.
        for (int i = 0; i < knowTogetherFriends.size(); i++) {
            // 기존에 있는 경우, 기존 값에 + 10
            if (scoreMap.containsKey(knowTogetherFriends.get(i))) {
                scoreMap.put(knowTogetherFriends.get(i), scoreMap.get(knowTogetherFriends.get(i)) + 10);
                continue;
            }

            // 기존 값이 없는 경우, <K, V> 새로 put
            scoreMap.put(knowTogetherFriends.get(i), 10);
        }

        // 방문 이력이 있을 경우 + 1점을 value로 가지게 함.
        for (int i = 0; i < visitors.size(); i++) {

            // scoreMap에 이름이 있을 경우
            if (scoreMap.containsKey(visitors.get(i))) {
                scoreMap.put(visitors.get(i), scoreMap.get(visitors.get(i)) + 1);
                continue;
            }

            // scoreMap에 이름이 없는 경우
            scoreMap.put(visitors.get(i), 1);
        }

        // ScoreMap 정렬 후 Answer List에 상위 5명 add

        List<String> topFriends = new ArrayList<>(scoreMap.keySet());

        Collections.sort(topFriends, (value1, value2) -> (scoreMap.get(value2).compareTo(scoreMap.get(value1))));

        for (int i = 0 ; i < topFriends.size(); i++) {
            if (i == 5) {
                break;
            }
            if (usersFriendsList.contains(topFriends.get(i)) || topFriends.get(i) == user) {
                continue;
            }
            answer.add(topFriends.get(i));
        }

        return answer;
    }

    public static List<String> userWithFriendsListUp(List<List<String>> friends, String user) {
        List<String> userFriends = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            if(friends.get(i).get(0) == user) {
                userFriends.add(friends.get(i).get(1));
            } else if (friends.get(i).get(1) == user){
                userFriends.add(friends.get(i).get(0));
            }
        }
        return userFriends;
    }
}
