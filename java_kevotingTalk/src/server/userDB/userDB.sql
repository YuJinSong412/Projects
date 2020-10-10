/*테이블 생성*/

CREATE TABLE member_table (
 uname       VARCHAR(30),
 uemail     VARCHAR(30) not null,
 password    VARCHAR(30), 
  PRIMARY KEY(uemail)
) ENGINE=MYISAM CHARSET=utf8;

show tables;

drop table member_table;

INSERT INTO MEMBER_TABLE VALUES('송유진','s','s');
insert into MEMBER_TABLE values('김호수','g','g');
insert into MEMBER_TABLE values('노수일','n','n');
insert into MEMBER_TABLE values('정혜라','j','j');

select * from MEMBER_TABLE;


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

insert into friendList values(1,'s','g');
insert into friendList values(2,'s','n');
insert into friendList values(3,'s','j');

insert into friendList values(4,'g','s');
insert into friendList values(5,'g','n');
insert into friendList values(6,'g','j');

insert into friendList values(7,'n','g');
insert into friendList values(8,'n','s');
insert into friendList values(9,'n','j');

insert into friendList values(10,'j','g');
insert into friendList values(11,'j','n');
insert into friendList values(12,'j','s');

select * from friendList;

