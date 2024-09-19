// https://school.programmers.co.kr/learn/courses/30/lessons/1845
// reveiw : 1(sol)
package Lv1.폰켓몬;

// m1)
//import java.util.*;
//
//class Solution {
//    public int solution(int[] nums) {
//        HashSet<Integer> set = new HashSet<>();
//
//        for(int i = 0; i < nums.length; i++) {
//            set.add(nums[i]);
//
//        }
//        // 3 1 2   ---> 4 / 2 = 2
//        if(nums.length / 2 < set.size()){
//            return nums.length / 2;
//        }
//        // 3 2 4 ---> 6 / 2 = 3
//        // 3 2
//        else {
//            return set.size();
//        }
//    }
//}

// review m2)
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);

            if (nums.length / 2 >= set.size()) {
                answer = set.size();
            }
        }

        return answer;
    }
}


