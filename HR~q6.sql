insert into kms1274116(eid,ename,salary,hire_date,department_id)
    select employee_id,last_name,salary,hire_date,department_id
    from employees
    where department_id=60;