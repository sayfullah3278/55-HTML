

CREATE TABLE KMS_1274(
E_ID INT PRIMARY KEY, 
E_NAME VARCHAR2(30),
E_EMAIL VARCHAR2(30),
E_HIRE_DATE DATE,
SALARY NUMBER(6,2));

CREATE TABLE KMS_12741(
E_ID NUMBER DEFAULT KMS_1247_PK. NEXTVAL  NOT NULL, 
E_NAME VARCHAR2(30),
E_EMAIL VARCHAR2(30),
E_HIRE_DATE DATE,
SALARY NUMBER(6,2));





CREATE SEQUENCE KMS_1274_PK START WITH 1
INCREMENT BY 1 ;
NOCACHE
NOCICLE;
   
   
Insert into  KMS_12741(E_NAME,E_EMAIL,E_HIRE_DATE, SALARY)
values('FATAMA','FATAMA@GMAIL.COM','01-Jun-2022',2500.36);  

Insert into KMS_12741(E_NAME,E_EMAIL,E_HIRE_DATE, SALARY)
values('FAHIM','FAHIM@GMAIL.COM','20-Jun-2023',4500.36);

Insert into KMS_12741(E_NAME,E_EMAIL,E_HIRE_DATE, SALARY)
values('FARUK','FARUK@GMAIL.COM','30-Jun-2012',2350.36); 

Insert into KMS_12741(E_NAME,E_EMAIL,E_HIRE_DATE, SALARY)
values('FOYSAL','FOYSAL@GMAIL.COM','15-Jun-2012',9350.36); 

Insert into KMS_12741(E_NAME,E_EMAIL,E_HIRE_DATE, SALARY)
values('FABRICAN','FABRICAN@GMAIL.COM','30-Jun-2012',2350.36); 

SELECT * FROM  KMS_12741;



SELECT * FROM EMPLOYEES 
WHERE SALARY<(SELECT MAX(SALARY) FROM EMPLOYEES 
                WHERE LAST_NAME LIKE '%a%');

SELECT * FROM EMPLOYEES;

SELECT DEPARTMENT_NAME,ROUND( AVG(SALARY))"Average salary ",COUNT (COMMISSION_PCT) "NUMBER OF EMPLOYEES "
FROM DEPARTMENTS
JOIN  EMPLOYEES  USING (DEPARTMENT_ID)
WHERE COMMISSION_PCT IS NOT NULL
GROUP BY DEPARTMENT_NAME;




SELECT FIRST_NAME, LAST_NAME, EMPLOYEE_ID, JOB_ID FROM EMPLOYEES
 WHERE department_id IN (SELECT department_id FROM departments 
                        WHERE LOCATION_ID=(SELECT LOCATION_ID FROM LOCATIONS 
                        WHERE CITY='Toronto'));