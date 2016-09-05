create table a_employee (
  id number(10) primary key ,
  name varchar2(255) not null,
  password varchar2(255) not null ,
  email varchar2(255) ,
  role varchar2(255) ,
  manager_id number(10) 
);

create table a_leavebill (
  id number(10) primary key ,
  days number ,
  content varchar2(255) ,
  remark varchar2(255) ,
  leavedate timestamp(6) ,
  state number ,
  user_id number(10) 
);

create sequence seq_employee minvalue 1 nomaxvalue start with 1 increment by 1 nocycle nocache;
create sequence seq_leavebill minvalue 1 nomaxvalue start with 1 increment by 1 nocycle nocache;
INSERT  INTO a_employee(id,name,password,email,role,manager_id) VALUES (seq_employee.nextval,'王中军','123','ee@163.com','boss',NULL);
INSERT  INTO a_employee(id,name,password,email,role,manager_id) VALUES (seq_employee.nextval,'冯小刚经纪人','123','dd@163.com','manager',1);
INSERT  INTO a_employee(id,name,password,email,role,manager_id) VALUES (seq_employee.nextval,'范冰冰经纪人','123','cc@163.com','manager',1);
INSERT  INTO a_employee(id,name,password,email,role,manager_id) VALUES (seq_employee.nextval,'冯小刚','123','bb@163.com','user',2);
INSERT  INTO a_employee(id,name,password,email,role,manager_id) VALUES (seq_employee.nextval,'范冰冰','123','aa@163.com','user',3);


commit;

