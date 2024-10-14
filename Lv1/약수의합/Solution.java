// https://school.programmers.co.kr/learn/courses/30/lessons/12928?language=java
package Lv1.약수의합;

class Solution {
    public int solution(int n) {
        int count = 0;

        for(int i = 1; i <= n; i++) {
            if(n % i == 0) {
                count += i;
            }
        }

        return count;
    }
}
