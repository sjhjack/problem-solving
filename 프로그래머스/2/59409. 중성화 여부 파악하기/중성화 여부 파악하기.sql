-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME, IF(SEX_UPON_INTAKE REGEXP('Neutered|Spayed'), 'O', 'X') 중성화
FROM ANIMAL_INS;