// https://school.programmers.co.kr/learn/courses/30/lessons/12933?language=java
package Lv1.정수내림차순으로배치하;

import java.util.*;

class Solution {
    public long solution(long n) {
        // long -> 문자열 배열로
        String[] str = Long.toString(n).split("");
        // 역순 정렬
        Arrays.sort(str, Collections.reverseOrder());

        // 문자열 배열 -> long 으로
        String s = "";
        for(int i = 0; i < str.length; i++) {
            s += str[i];
        }

        return Long.parseLong(s);

    }
}