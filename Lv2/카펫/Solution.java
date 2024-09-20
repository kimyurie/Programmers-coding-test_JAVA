// https://school.programmers.co.kr/learn/courses/30/lessons/42842
package Lv2.카펫;
// review : 1

import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        // 가로와 세로는 둘 다 해당 수의 약수
        for (int height = 1; height <= sum; height++) {
            // height가 sum의 약수인 경우
            if (sum % height == 0) {

                int width = sum / height; // 가로 길이

                if(width >= height) {
                    // 갈색 테두리의 타일 수 계산
                    // (카펫의 테두리 길이에서 중복되는 네 귀퉁이 4개를 뺌)
                    int border = (width + height) * 2 - 4;

                    // 노란색 중앙 부분의 타일 수 계산
                    int center = sum - border;

                    if (border == brown && center == yellow) {
                        return new int[]{width, height};
                    }
                }
            }
        }
        return new int[0];
    }
}
