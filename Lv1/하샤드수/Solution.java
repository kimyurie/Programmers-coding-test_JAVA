// https://school.programmers.co.kr/learn/courses/30/lessons/12947?language=java
package Lv1.하샤드수;

import java.util.*;

class Solution {
    public boolean solution(int x) {
        String[] str = Integer.toString(x).split("");

        int sum = 0;
        for(int i = 0; i < str.length; i++) {
            sum += Integer.parseInt(str[i]);
        }

        if(x % sum == 0) {
            return true;
        }else{
            return false;
        }
    }
}
