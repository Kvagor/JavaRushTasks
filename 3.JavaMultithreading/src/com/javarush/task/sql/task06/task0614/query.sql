update employee,(select * from task where exp_date > '2022-10-01') as abc
set salary=salary + 1000
where employee.id = abc.employee_id;

