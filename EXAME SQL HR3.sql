CREATE SEQUENCE kmsayfullah_PK START WITH 101 ;
CREATE TABLE kmsayfullah (
e_id number default kmsayfullah_PK.nextval not null ,
e_name varchar2(30),
e_dob date,
e_hier_date date,
e_salary number(8,2)
);




Insert into kmsayfullah(e_name, e_dob, e_hier_date, e_salary)
values('Fatema','10-Jan-1999','01-Jun-2022',2500.36);

Insert into kmsayfullah(e_name, e_dob, e_hier_date, e_salary)
values('Fahima','20-Jun-1995','05-Jan-2022',52525);

Insert into kmsayfullah(e_name, e_dob, e_hier_date, e_salary)
values('Foride','10-Mar-1989','01-Apr-2023',6539);

Insert into kmsayfullah(e_name, e_dob, e_hier_date, e_salary) 
values('Foysal','11-Jul-1996','01-Jan-2021',63663);

Insert into kmsayfullah(e_name, e_dob, e_hier_date, e_salary)
values('Fooade','10-Jan-1999','01-Jun-2019',56589);



select * from kmsayfullah;
order by desc
fetch first 1 row only; 


select * from kmsayfullah
   where e_name like '%a%';
   
   
 select first_name, last_name, salary from employees
 where salary >(select salary from employees
                    where employee_id=182);
                    
                    
select d.department_name,  Avg(e.salary),count(e.employee_id)
from employees e
join departments d on e.department_id = d.department_id
where e.commission_pct is not null
group by d.department_name;     


commit;

