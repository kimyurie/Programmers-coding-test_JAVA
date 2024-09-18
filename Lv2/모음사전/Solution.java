// https://school.programmers.co.kr/learn/courses/30/lessons/84512
package Lv2.모음사전;

import java.util.*;

class Solution {
    static List<String> list; // 모든 단어 저장할 리스트
    static String[] words = {"A", "E", "I", "O", "U"};

    // 재귀적으로 모든 단어를 생성하는 함수
    static void dfs(String str, int len) {
        list.add(str);
        if(len == 5) return;

        // 5개 모음 각각 붙여 재귀적으로 단어 생성
        for (int i = 0; i < 5; i++) {
            dfs(str + words[i], len + 1); // str에 모음 붙여 다음 단계로 재귀 호출
        }
    }

    // 주어진 단어가 사전에서 몇번째 위치인지 찾음
    public int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();
        dfs("", 0);

        // list에서 주어진 단어가 몇번째 위치에 있는지 찾음
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}
