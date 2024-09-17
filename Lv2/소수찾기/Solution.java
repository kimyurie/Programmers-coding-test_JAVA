//https://school.programmers.co.kr/learn/courses/30/lessons/42839
package Lv2.소수찾기;

import java.util.*;

class Solution {
    // 중복을 제거하며 숫자 저장
    HashSet<Integer> numbersSet = new HashSet<>();

    // 1. 숫자 조합 만드는 재귀함수 작성
    public void recursive(String comb, String others) {
        // comb가 비어있지 않으면 현재 조합된 숫자를 numbersSet에 추가
        // 예시: comb = "12"일 때 numbersSet에 12 추가
        if (!comb.equals("")) {
            numbersSet.add(Integer.valueOf(comb));
        }
        // others 문자열에서 하나씩 문자를 선택해서 comb에 추가하고
        // 남은 문자들로 새로운 조합을 재귀적으로 생성
        // 예시: others = "123"일 때
        // 첫 번째 반복: i = 0, comb = "1", others = "23"
        // 두 번째 재귀 호출: recursive("1", "23")
        for (int i = 0; i < others.length(); i++) {
            // comb에 others의 i번째 문자를 추가
            // others의 i번째 문자를 제외한 나머지 문자로 재귀 호출
            // 예시 1: i = 0, comb = "1", others = "23"
            // 예시 2: i = 1, comb = "2", others = "13"
            // 예시 3: i = 2, comb = "3", others = "12"
            recursive(
                    comb + others.charAt(i), // comb에 others의 i번째 문자를 추가
                    // i번째 문자를 제외한 나머지 문자열로 재귀 호출
                    // 예시: others = "123", i = 1일 때 others.substring(0, 1) + others.substring(2) => "13"
                    others.substring(0, i) + others.substring(i + 1)
            );
        }
    }

    // 2. 소수 판별 함수 정의
    // num = 29라면
    // lim = (int)Math.sqrt(29)는 약 5
    // i = 2: 29 % 2 ≠ 0
    // i = 3: 29 % 3 ≠ 0
    // i = 4: 29 % 4 ≠ 0
    // i = 5: 29 % 5 ≠ 0
    // 2부터 5까지의 숫자로 나누어 떨어지지 않았으므로, 29는 소수
    public boolean isPrime(int num) {
        // 1) 0과 1은 소수가 아님
        if (num == 0 || num == 1) return false;

        // 2) 제곱근까지만 확인하여 소수 여부 판단
        // Math.sqrt(16) = 4
        int lim = (int)Math.sqrt(num);
        for (int i = 2; i <= lim; i++) {
            // 나누어 떨어지면 소수가 아님
            if (num % i == 0) return false;
        }

        return true; // 소수임
    }


    // 최종 소수 개수 반환
    public int solution(String numbers) {

        // 숫자 조합 만듬
        recursive("", numbers);

        // 소수 개수셈
        int count = 0;
        for (int number : numbersSet) {
            if (isPrime(number)) {
                count++;
            }
        }

        return count;

    }
}
