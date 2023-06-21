SELECT FIRST_NAME, SALARY,JOB_ID, JOB_TITLE FROM EMPLOYEES NATURAL JOIN JOBS

WHERE SALARY<4000;

SELECT employee_id, last_name,
location_id, department_id
FROM employees JOIN departments
USING (department_id);
--WHERE DEOARTMENT IS NULL;

SELECT e.employee_id, e.last_name,department_id,
        department_id, d.location_id
FROM employees e NATURAL JOIN departments d ;
--ON (e.department_id = d.department_id);

SELECT employee_id, department_name, city
FROM employees e
JOIN departments d
ON d.department_id = e.department_id
JOIN locations l
ON d.location_id = l.location_id;