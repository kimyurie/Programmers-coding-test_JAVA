// https://school.programmers.co.kr/learn/courses/30/lessons/12934?language=java
package Lv1.정수제곱근판별;

import java.util.*;

class Solution {
    public long solution(long n) {

        long s = (long)Math.sqrt(n);

        if(s * s == n) {
            return (s+1) * (s+1);
        }

        return -1;

    }
}
