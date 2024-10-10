// https://school.programmers.co.kr/learn/courses/30/lessons/87389?language=java
package Lv1.나머지가1이되는수찾기;

class Solution {
    public int solution(int n) {
        int x = 2;
        while(n % x != 1) {
            x += 1;
        }
        return x;
    }
}