use gotit;

select * from article;

create table ARTICLE (
	id VARCHAR (40) NOT NULL,
    userId VARCHAR (40) NOT NULL,
	title VARCHAR (200) NOT NULL,
    description VARCHAR (1024) NOT NULL,
    likes INTEGER NOT NULL,
    categories VARCHAR (1024) NOT NULL,
    modified LONG NOT NULL,
    created LONG NOT NULL,
    createdBy VARCHAR (40) NOT NULL,
    modifiedBy VARCHAR (40) NOT NULL,
    version INTEGER NOT NULL,
    deleted VARCHAR (40) NOT NULL
);

select * from USER;
select * from session;

delete from user;
delete from session;

create table USER (
	id VARCHAR (40) NOT NULL,
    username VARCHAR(40) NOT NULL,
    password VARCHAR(100) NOT NULL,
    interestedCategories VARCHAR(1024),
    roles VARCHAR(40) NOT NULL,
    created LONG NOT NULL,
    modified LONG NOT NULL,
    createdBy VARCHAR (40) NOT NULL,
    modifiedBy VARCHAR (40) NOT NULL,
    version INTEGER NOT NULL,
    deleted VARCHAR (40) NOT NULL
);
select * from user;


UPDATE USER SET interestedCategories = "dsds" WHERE id = "5765fc08-aee7-49c5-ad24-7e46ff57effc";

create table SESSION (
	id VARCHAR (40) NOT NULL,
    userId VARCHAR(40) NOT NULL,
    token VARCHAR(100) NOT NULL,
    created LONG NOT NULL,
    modified LONG NOT NULL,
    createdBy VARCHAR (40) NOT NULL,
    modifiedBy VARCHAR (40) NOT NULL,
    version INTEGER NOT NULL,
    deleted VARCHAR (40) NOT NULL
);






insert into article VALUES ("vbmc.,vbm", "dasdljkas", "Software", "Description", 10, "|Software Development|", 0, 0, "userId", "userId", 0, 0);
select * from article where categories like '%|Sport|%';


create table ARTICLE_CATEGORY (
	id VARCHAR(40) NOT NULL,
    name VARCHAR(200) NOT NULL);

delete from category;
insert into ARTICLE_CATEGORY VALUES ("dashdl", "Data Structures");
insert into ARTICLE_CATEGORY VALUES ("asdasdad", "UX");
insert into ARTICLE_CATEGORY VALUES ("dasda", "UI");
insert into ARTICLE_CATEGORY VALUES ("fdgdfg", "Software development");
insert into ARTICLE_CATEGORY VALUES ("fdgdasddfg", "Backend developmnet");
insert into ARTICLE_CATEGORY VALUES ("gfggf", "Frontend developmnet");
insert into ARTICLE_CATEGORY VALUES ("eqweqwe", "AI");
insert into ARTICLE_CATEGORY VALUES ("dasfs;k", "VR");
insert into ARTICLE_CATEGORY VALUES ("df,mgnd,f;k", "Sport");


select * from article;
select * from article_category;
delete from article_category;


select * from ARTICLE_CATEGORY;