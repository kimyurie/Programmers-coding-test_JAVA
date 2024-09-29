// https://school.programmers.co.kr/learn/courses/30/lessons/12909?language=java
package Lv2.올바른괄호;
// review : 1(o)
// char를 String으로 변환
// : Character.toString(char) 또는 String.valueOf(char)을 사용

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



//class Solution {
//    boolean solution(String s) {
//        boolean answer = true;
//
//        Stack<String> stack = new Stack<>();
//
//        for(int i = 0; i < s.length(); i++) {
//            if(stack.empty()) {
//                if(s.charAt(i) == ')') {
//                    return false;
//                }else{
//                    stack.push(String.valueOf(s.charAt(i)));
//                }
//            }else { // "("
//                if(s.charAt(i) == ')') {
//                    stack.pop();
//                }else{
//                    stack.push(String.valueOf(s.charAt(i)));
//                }
//            }
//        }
//
//        if(stack.empty()) answer = true;
//        else answer = false;
//
//        return answer;
//    }
//}
