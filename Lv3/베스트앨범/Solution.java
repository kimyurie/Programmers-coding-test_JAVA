// https://school.programmers.co.kr/learn/courses/30/lessons/42579
package Lv3.베스트앨범;
// review : 1

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();

        // 장르 : 재생횟수 형태로 저장
        HashMap<String, Integer> num = new HashMap<>();

        // 장르 : 고유번호 : 재생횟수 형태로 저장
        HashMap<String, HashMap<Integer, Integer>> music = new HashMap<>();

        // 1. 각 장르별로 재생 횟수 합산,
        // 각 고유번호 : 재생 횟수 저장
        for (int i = 0; i < plays.length; i++) {
            // 해당 장르가 처음 등장하는 경우
            if(!num.containsKey(genres[i])) {
                // 장르의 총 재생 횟수
                // {'classic' : 1450}
                num.put(genres[i], plays[i]);

                // 노래 고유 번호와 재생 횟수 저장
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                // {0: 500, 1:600, 2:150, 3: ...}

                // 장르별 노래 정보 저장
                //  'classic': {0: 500, 2: 150, 3: 800}
                music.put(genres[i], map);

                // num에 이미 있는 장르일 경우
            }else {
                // 이미 있는 곡은 원래 재생수에 더함
                num.put(genres[i], num.get(genres[i]) + plays[i]);
                music.get(genres[i]).put(i, plays[i]);
            }
        }

        // 2. 장르별 총 재생 횟수에 따라 내림차순으로 장르 정렬
        // .keySet() : Map에 저장되어있는 키(Key)들을 반환
        List<String> keySet = new ArrayList<>(num.keySet());
        // 총 재생 횟수(num의 값) 기준으로 정렬
        Collections.sort(keySet, (a, b) -> num.get(b) - num.get(a));
        // {'pop': 3100, 'classic' : 1450}

        // 3. 장르별 가장 많이 재생된 노래 2개까지 선택
        for (String key : keySet) {
            // 현재 장르에 속한 고유번호 : 재생수
            HashMap<Integer, Integer> map = music.get(key);
            // key가 "classic"인 경우, music.get("classic")은
            // "classic" 장르에 속한 노래들의 정보
            // ({0: 500, 2: 150, 3: 800})를 반환


            // 장르에 속한 노래들의 고유 번호 리스트
            List<Integer> genre_key = new ArrayList<>(map.keySet());
            //"classic" 장르의 경우, genre_key는 [0, 2, 3]


            // 노래들을 재생 횟수 기준으로 내림차순 정렬
            Collections.sort(genre_key, (a, b) -> map.get(b) - map.get(a));

            // 가장 많이 재생된 노래 1곡 추가
            answer.add(genre_key.get(0));

            // 장르에 2곡 이상이 있을 시 두번째로 많이 재생된 노래 추가
            if (genre_key.size() > 1){
                answer.add(genre_key.get(1));
            }
        }

        // 결과를 int 배열로 반환
        return answer.stream().mapToInt(i->i).toArray();

    }
}
