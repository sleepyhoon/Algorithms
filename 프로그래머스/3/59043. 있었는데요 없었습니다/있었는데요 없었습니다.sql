-- 코드를 입력하세요
SELECT I.ANIMAL_ID, I.NAME
from ANIMAL_INS as I
    left join ANIMAL_OUTS as O
    on I.ANIMAL_ID = O.ANIMAL_ID 
where I.DATETIME > O.DATETIME
order by I.DATETIME;