/*테이블 생성*/

CREATE TABLE member_table (
 uname       VARCHAR(30),
 uemail     VARCHAR(30) not null,
 password    VARCHAR(30), 
  PRIMARY KEY(uemail)
) ENGINE=MYISAM CHARSET=utf8;

show tables;

drop table member_table;

INSERT INTO MEMBER_TABLE VALUES('송유진','songij4@gmail.com','dbwls123@');
insert into MEMBER_TABLE values('김호수','ghtnfhfp4@gmail.com','1q2w3e4r!!');
insert into MEMBER_TABLE values('노수일','food8123@gmail.com','asdasd12');
insert into MEMBER_TABLE values('정혜라','hrjeong@gmail.com','1234*');

select * from MEMBER_TABLE;

delete from member_table where uemail='songsm4@gmail.com';

/*테이블 생성*/
create table friendList(
 id int not null AUTO_INCREMENT,
 userEmail varchar(30),
 friendEmail varchar(30),
   PRIMARY KEY(id),
   foreign key (userEmail)
   references member_table (uemail),
   foreign key (friendEmail)
   references member_table (uemail)
) ENGINE=MYISAM CHARSET=utf8;

drop table friendList;

insert into friendList values(1,'songij4@gmail.com','ghtnfhfp4@gmail.com');
insert into friendList values(2,'songij4@gmail.com','food8123@gmail.com');
insert into friendList values(3,'songij4@gmail.com','hrjeong@gmail.com');

insert into friendList values(4,'ghtnfhfp4@gmail.com','songij4@gmail.com');
insert into friendList values(5,'ghtnfhfp4@gmail.com','food8123@gmail.com');
insert into friendList values(6,'ghtnfhfp4@gmail.com','hrjeong@gmail.com');

insert into friendList values(7,'food8123@gmail.com','ghtnfhfp4@gmail.com');
insert into friendList values(8,'food8123@gmail.com','songij4@gmail.com');
insert into friendList values(9,'food8123@gmail.com','hrjeong@gmail.com');

insert into friendList values(10,'hrjeong@gmail.com','ghtnfhfp4@gmail.com');
insert into friendList values(11,'hrjeong@gmail.com','food8123@gmail.com');
insert into friendList values(12,'hrjeong@gmail.com','songij4@gmail.com');

select * from friendList;

