
drop table Reinbursement_Form;
drop table status;
drop table grading_format;
drop table Department_head ;
drop table Employee;
drop table Department;

create table if not exists Department(
	d_id serial primary key,
	department_name varchar(50)
);


insert into department values 
(default, 'chem'),
(default, 'geology'),
(default, 'math'),
(default, 'seasonal');

create table if not exists Employee(
	id serial primary key,
	name_ varchar(50),
	supervisor_id int default null references Employee(id) on delete set null,
	email varchar(50),
	benco bool,  
	department_id int references Department(d_id) on delete set null,
	username varchar(50),
	e_password varchar(50)
);


insert into Employee values 
(default, 'john Benco', 1, 'john@gmail.com', true, 1, 'john', 'password'),
(default, 'hector Department head', 1, 'hector@gmail.com', false, 1, 'hector', 'password'),
(default, 'ahmed Supervisor', 2, 'ahmed@gmail.com', false, 1, 'ahmed', 'password'),
(default, 'rick Employee', 3, 'rick@gmail.com', false, 1, 'rick', 'password'),
(default, 'ryan Employee', 3, 'ryan@gmail.com', false, 1, 'ryan', 'password'),
(default, 'jackie Employee', 3, 'jackie@gmail.com', false, 1, 'jackie', 'password');



create table if not exists Department_head(
	department_id int primary key, 
	dep_head int references Employee(id) on delete set null
);

insert into Department_head values
(1,1),
(2,2);





create table if not exists grading_format(
	grade_id serial primary key, 
	presentation varchar(50)
);

create table if not exists status(
	status_id serial primary key,
	bencoApprove bool,
	depHeadApprove bool,
	supApprove bool
);







create table if not exists Reinbursement_Form(
	form_id serial primary key, 
	dates Bigint,
	locations varchar(50),
	description varchar(500),
	costs int,
	grade varchar(50),
	event_id int,
	grade_format int references grading_format(grade_id) on delete set null,
	stat_id int references status(status_id) on delete set null,
	e_id int references Employee(id) on delete set null
);



insert into status values
(default, false, false, false);

--(default, 'grade updated'),
--(default, 'presentation updated'),
--(default, 'supervisor approval'),
--(default, 'benco final'),
--(default, 'denied'),
--(default, 'supervisor request more info'),
--(default, 'department header request employee to add more documents'),
--(default, 'department header request supervisor to add more documents'),
--(default, 'benco request dep head to add more documents'),
--(default, 'benco request supervisor to add more documents'),
--(default, 'benco request dep head to provide more'),
--(default, 'benco change amount'),
--(default, 'auto deny');
		
--insert into status values 
--		requestFK int,
--		Direct_Supervisor  bool default false,
--		Department_Head bool default false,
--		Benefits_Coordinator bool default false
		
insert into grading_format values
(default,'presentation'),
(default,'lettergrade'),
(default,'passfail');

insert into Reinbursement_Form values
(default, 1212, 'sana 12 drive', 'do what now', 600,'80', 1, 1,1,1),
(default, 1313, '13 harden alley', 'king three',800,'90', 3, 2,1,2),
(default, 777, 'kd avenue', 'swish pull up', 900,'60', 2, 3,1,3);



		













