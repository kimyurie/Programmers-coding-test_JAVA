// https://school.programmers.co.kr/learn/courses/30/lessons/12916?language=java
package Lv1.문자열내p와y의개수;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int a = 0; int b = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'p' || s.charAt(i) == 'P'){
                a++;
            }else if(s.charAt(i) == 'y' || s.charAt(i) == 'Y'){
                b++;
            }
        }

        if(a == b){
            answer = true;
        }else{
            answer = false;
        }

        return answer;
    }
}