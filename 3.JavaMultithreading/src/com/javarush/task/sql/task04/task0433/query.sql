select year(date),month(date),day(date) from event where user_id = 3 and
type='SOLVE_TASK' and status='OK' group by 1,2,3

