package Lv2.올바른괄호;

// https://school.programmers.co.kr/learn/courses/30/lessons/12909?language=java

import java.util.*;

class Solution {
    boolean solution(String s) {
        // char형 스택 선언
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push('(');
            }else{ // s.charAt(i) == ')'
                if(stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
