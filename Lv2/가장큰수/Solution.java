// https://school.programmers.co.kr/learn/courses/30/lessons/42746
package Lv2.가장큰수;
// review : 1

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // int 배열을 String 배열로 변환
        String[] arr = new String[numbers.length];

        for (int i = 0; i < arr.length; i++) {
            // String.valueOf : Object의 값을 String으로 변환
            arr[i] = String.valueOf(numbers[i]);
            // ["6", "10", "2"]
        }

        // 두 문자열을 이어 붙였을 때 더 큰값이 앞에 오도록 정렬
        // ex)
        // a = "6", b = "10"일 때:
        // b + a = "106"
        // a + b = "610"
        // compareTo 메서드는 "106"이 "610"보다 작으므로 음수를 반환
        // 따라서 "6"이 "10"보다 앞에 배치됩니다.
        Arrays.sort(arr, (a,b) -> (b + a).compareTo(a + b));
        // ["6", "2", "10"]

        // 배열의 첫번째 값이 "0"이면 0을 반환
        // ex) 입력이 [0, 0, 0]이면, "0"을 반환
        if (arr[0].equals("0")){
            return "0";
        }

        // 정렬된 문자열 하나로 이어붙임
        // String을 합치는 연산이 많을수록 StringBuilder가 유리
        StringBuilder answer = new StringBuilder();

        for(int i = 0; i < arr.length; i++) {
            answer.append(arr[i]); // ["6210"]
        }

        return answer.toString();

    }
}