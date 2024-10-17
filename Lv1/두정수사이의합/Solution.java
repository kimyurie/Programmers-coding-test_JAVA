// https://school.programmers.co.kr/learn/courses/30/lessons/12912?language=java
package Lv1.두정수사이의합;

class Solution {
    public long solution(int a, int b) {
        long answer = 0;

        if(a < b) {

            for(int i = a; i <= b; i++) {
                answer += i;
            }

        }else if(a > b) {

            for(int i = b; i <= a; i++) {
                answer += i;
            }

        }else{
            answer = a;
        }

        return answer;
    }
}
