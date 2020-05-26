use vk2db;
#below code used to create new table from above selected database
#create table demo(
#id int not null,
#name varchar(10) not null,
#primary key(id)
#);
#desc demo;

#below code used to insert various columns in above created table
#INSERT INTO DEMO (id, name)
#values(1, 'vk');

#INSERT INTO DEMO(id, name)
#values(2, 'sugu');

#INSERT INTO DEMO(id, name)
#values(3, 'geetha');

#INSERT INTO DEMO(id, name)
#values(4, 'sugi');

#INSERT INTO DEMO(id, name)
#values(5, 'sanjee');

#below code used to view/ select the columns from above finished code
#select name
#from demo
#where name='sugi';
#where id>2 and id < 4;

#below code is used to update new elements/ columns in above created code
update demo
set name = 'vignesh'
where id=1;

#select name
#from demo
#where name like 'su%';  #the right code is used to select the name that has fisrt  2 place 'su'

#below code is used to view top N(prescribed int value) of column
#select name
#from demo
#LIMIT 2;    #This limits the row viewable to only first 2 rows

#below code is used to display the above created table column in asc/ descending order
# ASC - asecnding / DESC - descending
#select name
#from demo
#ORDER BY id DESC;

# (GROUP BY) below code is used to group output display by comman thing
#select sum(id), name
#from demo
#group by name;

create table vk1(
reg_num varchar(7) not null,
name varchar(15) not null,
cat1 int(10) not null,
city varchar(10) not null,
primary key(name)
);

insert into vk1 (reg_num, name, cat1, city)
values('17d001', 'anu', 47, 'tenkasi');

insert into vk1 (reg_num, name, cat1, city)
values('17d002', 'vaishnav', 39, 'tirupur');

insert into vk1 (reg_num, name, cat1, city)
values('17d003', 'ebby', 36, 'madurai');

insert into vk1 (reg_num, name, cat1, city)
values('17d004', 'selva', 45, 'kovilpathi');

insert into vk1 (reg_num, name, cat1, city)
values('17d005', 'sriram', 49, 'karaikudi');

insert into vk1 (reg_num, name, cat1, city)
values('17d106', 'vignesh kanna', 50, 'madurai');

insert into vk1 (reg_num, name, cat1, city)
values('17d007', 'karthi', 49, 'dindugal');

select *
from vk1
where cat1<40;