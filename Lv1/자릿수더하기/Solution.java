// https://school.programmers.co.kr/learn/courses/30/lessons/12931?language=java
package Lv1.자릿수더하기;

import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        // 1. N을 문자열로 바꿈 (숫자 -> 문자로 변환 : Integer.toString())
        // 2. split으로 나누고 배열로 집어넣음
        String[] arr = Integer.toString(n).split("");

        for(int i = 0; i < arr.length; i++) {
            answer += Integer.parseInt(arr[i]);
        }

        return answer;
    }
}
