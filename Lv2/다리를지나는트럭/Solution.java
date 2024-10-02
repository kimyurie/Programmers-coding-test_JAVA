// https://school.programmers.co.kr/learn/courses/30/lessons/42583
// https://minhamina.tistory.com/241
package Lv2.다리를지나는트럭;
// review : 1
import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();

        // 현재 다리 위에 있는 트럭들의 무게 합
        int sum = 0;
        // 경과 시간
        int time = 0;

        // 모든 트럭을 순차적으로 다리에 올리는 작업을 진행
        for(int i = 0; i < truck_weights.length; i++) {
            // 현재 트럭의 무게를 truck에 저장
            int truck = truck_weights[i];

            // 현재 트럭을 다리에 올리기 전에 가능한지 반복적으로 확인
            while(true) {
                // 1. 다리 위에 트럭이 없는 경우
                // ex) [] -> [7]
                if(queue.isEmpty()){
                    queue.add(truck); // [7]
                    sum += truck; // 7

                    // 트럭이 다리에 오를 때 시간을 1초 추가
                    time++; // 1
                    break; // 반복 종료 후 다음 트럭으로
                }
                // 2. 다리위에 트럭있지만 다리가 꽉 찬 경우
                // ex) [7,0] -> [0]
                // ex) [4,5] -> [5]
                else if(queue.size() == bridge_length) {
                    // 다리 위 가장 앞에 있는 트럭 다리 다 건너면 큐에서 제거
                    sum -= queue.poll(); // sum = 0 , queue[0]
                    // 다리에서 내릴 때는 시간이 들지 않음
                }
                // 3. 다리위에 트럭 있고, 다리 꽉 차지 않은 경우
                else{
                    // 3-1. 새로운 트럭 다리에 올려도 무게 한도 넘지 않는 경우
                    // ex) [4] -> [4,5]
                    if(sum + truck <= weight) {
                        // 트럭을 다리에 올리고, 다리위 트럭 무게합에 더함
                        queue.add(truck);
                        sum += truck; // 4
                        // 트럭 다리에 오를 때 시간 1초 추가
                        time++;
                        break; // 반복 종료하고 다음 트럭으로
                    }
                    // 3-2. 새로운 트럭 다리에 올리면 무게 한도 넘는 경우
                    // [7] -> [7,0]
                    else{
                        // 다리가 다 찰 때까지 0을 넣음
                        // 다리 위 트럭 움직이도록 시간만 증가
                        queue.add(0); // [7,0]
                        time++; // 2
                        // 다리 다 찰 때까지 0 넣는 행위 계속 반복되므로 break 생략
                    }
                }
            }
        }
        // 모든 트럭 다리 건넌 후에도 마지막 트럭 다리 건너야함
        // 마지막 트럭이 다리에서 빠져나가는 시간 더하기
        return time + bridge_length;
    }
}