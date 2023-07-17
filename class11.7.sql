select department_name, city from departments 
natural join (select l.location_id, l.city, l.country_id 
from locations l
join countries c
on(l.country_id= c.country_id)
join regions 
using(region_id)
where region_name = 'Europe'); 

INSERT INTO (SELECT L.LOCATION_ID, L.CITY, L.COUNTRY_ID FROM LOCATIONS L
JOIN COUNTRIES C
ON (L.COUNTRY_ID= C. COUNTRY_ID)
JOIN REGIONS USING (REGION_ID)
WHERE REGION_NAME = 'EUROPE')
VALUES (3300, 'CARDFF','UK');

SELECT * FROM LOCATIONS;