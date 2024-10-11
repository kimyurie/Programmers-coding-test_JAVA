// https://school.programmers.co.kr/learn/courses/30/lessons/12937?language=java
package Lv1.짝수와홀수;

class Solution {
    public String solution(int num) {
        String answer = "";
        if(num % 2 == 0) {
            answer = "Even";
        }else{
            answer = "Odd";
        }
        return answer;
    }
}
