select gym.location,person.location from customers as person,gyms as gym
where person.location!='London' group by gym.location, person.location;
