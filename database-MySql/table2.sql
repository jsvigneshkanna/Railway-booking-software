use vk2db;

create table table1(
reg_num varchar(7) not null,
name varchar(15) not null,
cat1 int(10) not null,
city varchar(10) not null,
primary key(name)
);

insert into table1 (reg_num, name, cat1, city)
values('17d108', 'anu', 47, 'tenkasi');

select cat1
from demo2;

