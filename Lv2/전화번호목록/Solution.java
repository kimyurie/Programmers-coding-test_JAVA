// https://school.programmers.co.kr/learn/courses/30/lessons/42577
// review : 1
package Lv2.전화번호목록;

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> hm = new HashMap<>();

        // 모든 전화번호를 hashmap에 넣기
        for(int i = 0;i < phone_book.length; i++) {
            hm.put(phone_book[i], i);
            // {'119': 0, '97674223': 1, '1195524421': 2}
        }

        // 모든 전화번호의 접두어가 hashmap에 존재하는지 확인
        for (int i = 0; i < phone_book.length; i++) {
            // j는 접두사의 길이
            for (int j = 0; j < phone_book[i].length(); j++) {
                // .containsKey(1) // key 값 중 1이 있으면 true, 없으면 false
                // substring(0, j)는 인덱스가 0~j까지 접두어
                if(hm.containsKey(phone_book[i].substring(0, j))) {
                    return false;
                }
                // j = 0 --> 접두어 "" --> 접두어 존재 x
                // j = 1 --> 접두어 "1" --> 접두어 존재 x
                // j = 2 --> 접두어 "11" --> 접두어 존재 x
            }
        }
        return true;
    }
}