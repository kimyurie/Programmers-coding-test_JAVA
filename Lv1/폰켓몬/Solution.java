// https://school.programmers.co.kr/learn/courses/30/lessons/1845
package Lv1.폰켓몬;

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);

        }
        // 3 1 2   ---> 4 / 2 = 2
        if(nums.length / 2 < set.size()){
            return nums.length / 2;
        }
        // 3 2 4 ---> 6 / 2 = 3
        // 3 2
        else {
            return set.size();
        }
    }
}
