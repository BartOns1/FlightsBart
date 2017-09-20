insert into passenger(id, first_name, Bonus_myles, last_name) values(1000, 'Natascha', 1577, 'Ons');
insert into passenger(id, first_name, Bonus_myles, last_name) values(1001, 'weide', 0, 'On');
insert into passenger(id, first_name, Bonus_myles, last_name) values(1002, 'cha', 15, 'ns');
insert into passenger(id, first_name, Bonus_myles, last_name) values(1003, 'ascha', 1400, 'dgOns');
insert into passenger(id, first_name, Bonus_myles, last_name) values(1004, 'Nat', 2000, 'hdfgjdtyjdyjOns');


insert into flight(id,  departure, destination, flight_name) values(2000, 'Brussel', 'Wenen', 'AAA111');
insert into flight(id, departure, destination, flight_name) values(2001, 'Brussel', 'Rome', 'BBB111');
insert into flight(id, departure, destination, flight_name) values(2002, 'Brussel', 'Herent', 'CCC111');

insert into ticket(id, price, flight_id, passenger_id) values(101, 500, 2000, 1001);
insert into ticket(id, price, flight_id, passenger_id) values(102, 50, 2002, 1002);
insert into ticket(id, price, flight_id, passenger_id) values(104, 5000, 2001, 1003);