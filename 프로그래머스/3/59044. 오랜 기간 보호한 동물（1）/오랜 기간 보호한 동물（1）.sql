-- 코드를 입력하세요
SELECT ins.NAME, ins.DATETIME
FROM ANIMAL_INS ins
LEFT JOIN ANIMAL_OUTS outs
USING (ANIMAL_ID)
WHERE outs.DATETIME IS NULL
ORDER BY ins.DATETIME
LIMIT 3;