create database hospital_management;
use hospital_management;

create table login(
	ID varchar(20),
    PW varchar(20)
);

insert into login value("Test", "Password");

create table patient_info(
	ID varchar(20),
    Number varchar(40),
    Name varchar(20),
    Gender varchar(20),
    Patient_Disease varchar(20),
    Room_Number varchar(20),
    Time varchar(100),
    Deposit varchar(20)
);

select * from patient_info;

create table Room(
	room_no varchar(20),
    Availability varchar(20),
    Price varchar(20),
    Room_type varchar(100)
);

select * from room;

insert into Room values("100", "Available", "500", "G Bed 1");
insert into Room values("101", "Available", "500", "G Bed 2");
insert into Room values("102", "Available", "500", "G Bed 3");
insert into Room values("103", "Available", "500", "G Bed 4");
insert into Room values("200", "Available", "1500", "Private Room");
insert into Room values("201", "Available", "1500", "Private Room");
insert into Room values("202", "Available", "1500", "Private Room");
insert into Room values("203", "Available", "1500", "Private Room");
insert into Room values("301", "Available", "3500", "ICU Bed 1");
insert into Room values("302", "Available", "3500", "ICU Bed 2");
insert into Room values("303", "Available", "3500", "ICU Bed 3");
insert into Room values("304", "Available", "3500", "ICU Bed 4");
insert into Room values("305", "Available", "3500", "ICU Bed 5");

create table department(
	Department varchar(100),
    Phone_no varchar(20)
);

insert into department values("Surgical department", "123456789");
insert into department values("Nursing department", "123456789");
insert into department values("Operation theater complex (OT)", "123456789");
insert into department values("Paramedical department", "123456789");

select * from department;

create table Emplyee_info(Name varchar(20), Age varchar(20), Phone_Number varchar(20), Salary varchar(20), Email varchar(20), ID_Number varchar(20));

select * from Emplyee_info;

insert into Emplyee_info values("Doctors1", "30", "123456789", "50000", "gr@gmail.com", "123456789101");
insert into Emplyee_info values("Doctors2", "30", "123456789", "50000", "gr@gmail.com", "123456789101");

CREATE TABLE Ambulance (
    Name VARCHAR(20),
    Gender VARCHAR(20),
    Car_name VARCHAR(20),
    Available VARCHAR(20),
    Location VARCHAR(20)
);

INSERT INTO Ambulance VALUES ("av", "Male", "ZEN", "Available", "area 16");

SELECT * FROM Ambulance;






