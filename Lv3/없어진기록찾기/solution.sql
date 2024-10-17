-- https://school.programmers.co.kr/learn/courses/30/lessons/59042
SELECT b.ANIMAL_ID, b.NAME
-- LEFT OUTER JOIN : 왼쪽에 있는 데이터는 무조건 가져오며, 오른쪽에 오는 테이블과 JOIN을 수행하여 조건에 맞는 데이터가 없을 시 null 로 표시
FROM ANIMAL_OUTS b LEFT JOIN
     ANIMAL_INS a ON b.ANIMAL_ID = a.ANIMAL_ID
-- ANIMAL_ID가 같은 값이 ANIMAL_INS 테이블에 존재하지 않는다면, NULL 값으로 연결
WHERE a.ANIMAL_ID is NULL
ORDER BY b.ANIMAL_ID ASC;