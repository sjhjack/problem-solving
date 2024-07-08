-- 코드를 입력하세요
SELECT outs.ANIMAL_ID, outs.NAME
FROM ANIMAL_INS ins
JOIN ANIMAL_OUTS outs
USING (ANIMAL_ID)
ORDER BY DATEDIFF(outs.DATETIME, ins.DATETIME + 1) DESC
LIMIT 2;