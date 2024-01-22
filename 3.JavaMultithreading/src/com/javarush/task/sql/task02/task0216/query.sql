select case position
when 'backend developer' then 'yes'
when 'frontend developer' then 'yes'
else 'no'
end
from employee where department = 'cool devs';

