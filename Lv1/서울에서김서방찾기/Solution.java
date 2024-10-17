// https://school.programmers.co.kr/learn/courses/30/lessons/12919?language=java
package Lv1.서울에서김서방찾기;

class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        int index = 0;

        for(int i = 0; i < seoul.length; i++) {
            if(seoul[i].equals("Kim")) {
                index = i;
            }
        }

        return "김서방은 " + index + "에 있다";
    }
}
