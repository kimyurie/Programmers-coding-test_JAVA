// https://school.programmers.co.kr/learn/courses/30/lessons/12944?language=java
package Lv1.평균구하기;

class Solution {
    public double solution(int[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum / arr.length;
    }
}
