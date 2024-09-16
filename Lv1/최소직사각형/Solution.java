// https://school.programmers.co.kr/learn/courses/30/lessons/86491
package Lv1.최소직사각형;

import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = 0; // 가장 큰 가로값 저장
        int maxHeight = 0; // 가장 큰 세로값 저장

        // 1. sizes 각 배열 요소 내림차순으로 정렬
        // [30,70] -> [70, 30]
        for(int i = 0; i < sizes.length; i++) {
            if(sizes[i][0] < sizes[i][1]){
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }

            // 2. size 각 배열 요소 첫번째 값(size[i][0]) 중에서 가장 큰 값 찾기
            // ==> 60 70 60 80  얘네 중에 젤 큰값 찾기
            maxWidth = Math.max(maxWidth, sizes[i][0]);
            maxHeight = Math.max(maxHeight, sizes[i][1]);
        }

        return maxWidth * maxHeight;

    }
}
