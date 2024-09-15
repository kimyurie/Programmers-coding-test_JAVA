// https://school.programmers.co.kr/learn/courses/30/lessons/42578
package Lv2.의상;

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // 의상 종류별로 의상 개수 저장
        HashMap<String, Integer> hm = new HashMap<>();

        for(int i = 0; i < clothes.length; i++) {
            String type = clothes[i][1]; // 의상 종류
            hm.put(type, hm.getOrDefault(type,0) + 1);
            // {'headgear': 2, 'eyewear': 1}
        }

        int answer = 1;

        // .keySet()은 값 출력
        // ex) for (Integer i: map.keySet())
        //	    System.out.println(i + map.get(i));
        for (String key : hm.keySet()) {
            // ex) headgear: 3가지 선택지 (yellow_hat, green_turban, 입지 않음)
            // ex) eyewear: 2가지 선택지 (blue_sunglasses, 입지 않음)
            // → 이런 식으로 안 입는 경우도 생각해줘야 하기 때문에 개수에 +1
            answer *= (hm.get(key) + 1);

            // (yellow_hat, green_turban) + 아무 것도 입지 않음
            // answer *= (2 + 1); ----> 3

            // (blue_sunglasses) + 아무 것도 입지 않음
            // answer *= (1 + 1); ----> 6
        }
        // ex) (안 입음 + 안 입음 + 안 입음 + 안 입음)
        //  → 모두 안 입는 경우가 한 번 나오기 때문에 최종 결과에서 -1
        return answer - 1;  // 5
    }
}