// https://school.programmers.co.kr/learn/courses/30/lessons/42842
package Lv2.카펫;
// review : 1 / 2

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



// m2)
//class Solution {
//    public int[] solution(int brown, int yellow) {
//        int[] answer = new int[2];
//        int size = brown + yellow; // 전체 넓이 12
//
//        // 약수값 저장할 배열
//        List<Integer> as = new ArrayList<>();
//
//        for(int i = 1; i <= size; i++) {
//            if(size % i == 0) {
//                // as[1,2,3,4,6,12]
//                // as[1,3,9]
//                as.add(i);
//            }
//        }
//
//        // 약수 쌍 중에서 brown과 yellow 조건을 만족하는 지 확인
//        for (int i = 0; i < as.size(); i++) {
//            int height = as.get(i);
//            int width = size / height;
//
//            if(width >= height) {
//                // 테두리 = (4+3) * 2 - 4
//                int border = (width + height) * 2 - 4;
//                int inner = size - border;
//
//                if(border == brown && inner == yellow) {
//                    answer[0] = width;
//                    answer[1] = height;
//                    break;
//                }
//            }
//
//        }
//
//        return answer;
//    }
//}
