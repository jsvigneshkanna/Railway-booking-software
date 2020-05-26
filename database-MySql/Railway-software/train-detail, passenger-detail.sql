#creating a new database with below given name
create database vkRailway;

#creating table named traindetail using above database
create table traindetail(
trainno int(11) not null,
train varchar(20) not null,
availability int(10) not null,
waitinglist int(10) not null,
primary key(trainno)   #primary key is made with trainno as its unique
);

#Inserting rows for the trainDetail table with below valuse
insert into traindetail(trainno, train, availability, waitinglist)
values(2012, 'vaigai', 57, 0);

insert into traindetail(trainno, train, availability, waitinglist)
values(2013, 'pandian', 3, 0);

insert into traindetail(trainno, train, availability, waitinglist)
values(2014, 'pearlcity', 1, 0);

insert into traindetail(trainno, train, availability, waitinglist)
values(2015, 'chennaiexpress', 0, 10);

insert into traindetail(trainno, train, availability, waitinglist)
values(2016, 'durunto', 0, 2);

#Veiwing the whole table
select *
from traindetail

#inserting row details for table passengerdetail
#its done using JAVA JDBC

select * 
from passengerdetail;