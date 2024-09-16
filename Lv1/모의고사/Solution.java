// https://school.programmers.co.kr/learn/courses/30/lessons/42840
package Lv1.모의고사;

import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        // 각 수포자가 찍는 방식 배열에 넣기
        int[] one = {1, 2, 3, 4, 5};
        // [1, 3, 2, 4, 2]  --> 2문제 맞춤
        int[] two = {2, 1, 2, 3,  2, 4, 2, 5};
        // [1, 3, 2, 4, 2],[1, 3, 2, 4, 2]  --> 2문제 맞춤
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        // [1, 3, 2, 4, 2],[1, 3, 2, 4, 2]  --> 2문제 맞춤

        // 각 수포자가 맞춘 문제수 각각 저장
        int[] score = new int[3];

        // answer과 one, two, three 수포자 각각 비교해 맞춘 문제수 계산
        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == one[i % 5]) score[0]++;
            if(answers[i] == two[i % 8]) score[1]++;
            if(answers[i] == three[i % 10]) score[2]++;
        }

        // 맞춘 문제수중 가장 높은 수 찾기
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < 3; i++) {
            // add(i + 1) 해야지 1번, 2번, 3번 수포자 형태로 저장
            if (maxScore == score[i]) list.add(i + 1);
        }

        // List<Integer>을 int[]로 변환
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            //  .get(0) // 0 위치의 값 반환
            result[i] = list.get(i);
        }
        return result;  // int[]로 변환된 결과 반환
    }
}