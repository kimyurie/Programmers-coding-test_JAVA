// https://school.programmers.co.kr/learn/courses/30/lessons/12932?language=java
package Lv1.자연수뒤집어배열로만들기;

import java.util.*;

class Solution {
    public int[] solution(long n) {
        // 1. n을 문자열로 변환
        String s = String.valueOf(n);
        int[] answer = new int[s.length()];

        // 2. 역순정렬
        for(int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(s.substring(answer.length-1-i, answer.length - i));
        }

        return answer;
    }
}
