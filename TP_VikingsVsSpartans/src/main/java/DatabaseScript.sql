drop database if exists tp_vikings_vs_spartans;
create database if not exists tp_vikings_vs_spartans;
use tp_vikings_vs_spartans;
show tables;


drop table if exists FighterType;
create table if not exists FighterType (IdFighterType int auto_increment,Description varchar(100) not null,
constraint PK_FighterType_IdFighterType primary key(IdFighterType),
constraint UK_FighterType_Description unique(Description));

insert into FighterType (Description) values ('Viking'),('Spartan');

drop table if exists Human;
create table if not exists Human (IdHuman int auto_increment,Name varchar(100) not null,Age int not null, Weight int not null,
FighterType int not null, constraint PK_Human_IdHuman primary key(IdHuman),constraint UK_Human_Name unique(Name),
constraint FK_Human_FighterType foreign key(FighterType) references FighterType(IdFighterType) on update cascade on delete cascade);

drop table if exists Combat;
create table if not exists Combat (IdCombat int auto_increment,DateCombat datetime default(now()),FigherOne int not null,FigherTwo int not null,
Winner varchar(100) not null,constraint PK_Combat_IdCombat primary key(IdCombat),
constraint FK_Combat_FigherOne foreign key(FigherOne) references Human(IdHuman) on update cascade,
constraint FK_Combat_FigherTwo foreign key(FigherTwo) references Human(IdHuman) on update cascade);

drop procedure if exists Human_Create;
delimiter //
create procedure Human_Create (out pIdHuman int,in pName varchar(100),in pAge int,in pWeight int,pFighterType int)
begin
	insert into Human (Name,Age,Weight,FighterType) values (pName,pAge,pWeight,pFighterType);
	set pIdHuman=last_insert_id();
end //
delimiter ;

drop procedure if exists Combat_Create;
delimiter //
create procedure Combat_Create (out pIdCombat int,in pDateCombat varchar(100),in pFigherOne int,in pFigherTwo int,in pWinner varchar(100))
begin
	insert into Combat (DateCombat,FigherOne,FigherTwo,Winner) values (pDateCombat,pFigherOne,pFigherTwo,pWinner);
	set pIdCombat=last_insert_id();
end //
delimiter ;


drop procedure if exists Human_Read;
delimiter //
create procedure Human_Read ()
begin
	select * from Human;
end
delimiter ;

drop procedure if exists Combat_Read;
delimiter //
create procedure Combat_Read ()
begin
	select * from Combat;
end
delimiter ;