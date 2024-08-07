-- 코드를 입력하세요
SELECT USER_ID, NICKNAME
    , CONCAT(CITY, ' ', STREET_ADDRESS1, ' ', STREET_ADDRESS2) 전체주소
    , CONCAT(LEFT(TLNO, 3), '-', SUBSTRING(TLNO, 4, 4), '-', RIGHT(TLNO, 4)) 전화번호
FROM USED_GOODS_BOARD b
JOIN USED_GOODS_USER u
ON b.WRITER_ID = u.USER_ID
GROUP BY USER_ID
HAVING COUNT(*) >= 3
ORDER BY USER_ID DESC;