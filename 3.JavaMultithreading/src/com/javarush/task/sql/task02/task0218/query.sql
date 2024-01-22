select case
           when (if(euro is null,6,euro))>5 then 'best'
           when (if(euro is null,6,euro))=5 then 'good'
           else 'bad'
end
from cars;

