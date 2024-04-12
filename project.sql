
create database project;
use project;


 create table doctor(
 did int primary key AUTO_INCREMENT ,
 dname varchar(50),
 fathersname varchar(50),
 bloodgroup varchar(50),
 address varchar(50),
 contectno varchar(50),
 department varchar(50),
 emailid varchar(50),
 schedule varchar(50),
 password varchar(50),
 dob varchar(50),
 gender varchar(50),
 maritialstatus varchar(50),
 joiningdate varchar(50),
 experience varchar(50),
  fee int
 
);

create table patient (
pid int  primary key AUTO_INCREMENT,
pname varchar(50),
fathersname varchar(50),
bloodgroup varchar(50),
address varchar(50),
phoneno varchar(10),
emailid varchar(50),
cghs_private varchar(50),
disease varchar(50),
age int,
gender varchar(50),
maritialstatus varchar(50)


);


create table admit(
 admitid int primary key AUTO_INCREMENT,
 pid int,
 pname varchar(50),
 surgery varchar(50),
 surgeryamount int,
 roomtype varchar(50),
 roomrent  int,
 date varchar(50),
 days int,
 dname varchar(50),
 foreign key(pid) references patient(pid)
 );
 
 create table appointment (
 apid int  primary key AUTO_INCREMENT ,
 pid int ,
 pname varchar(50),
 age int,
 bloodgroup varchar(50),
 department varchar(50),
 did int ,
 doctorname varchar(50),
 consultantfee int,
 date varchar(50),
 foreign key(pid) references patient(pid),
 foreign key(did) references doctor(did)
 );
 
 
	
create table RECEPTIONIST(
 rid int primary key AUTO_INCREMENT,
 rname varchar(50),
 fathersname varchar(50),
 address varchar(50),
 salary  int,
 contectno varchar(50),
 emailid varchar(50),
 joiningdate varchar(50),
 password varchar(50),
 dob varchar(50),
 bloodgroup varchar(50),
 maritialstatus varchar(50),
 gender varchar(50)

 );
 
 
 



 create table prescriptions(
	priid int  primary key AUTO_INCREMENT,
      did int,
	dname varchar(50),
	pid int ,
	pname varchar(50),
      age int,
      bloodgroup varchar(50),
      prescriptions varchar(50),
	pathology varchar(50),
	remark varchar(50),
	advice varchar(100),
	
	foreign key(pid) references patient(pid),
     foreign key(did) references   doctor(did)
	);
   

 create table  diagnosis(
	diagnosisId int  primary key AUTO_INCREMENT,
      pid int,
	pname varchar(50),
	did int ,
	dname varchar(50),
      age int,
      bloodgroup varchar(50),
      pathology varchar(50),
	description varchar(50),
      date date;
	bodypart varchar(50),
	notes varchar(100)
	
	);

