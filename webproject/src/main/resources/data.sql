CREATE TABLE "USERS" 
   (	"USER_ID" NUMBER(19), 
	"ACTIVE" NUMBER(19), 
	"PASSWORD" VARCHAR(255), 
	"ROLE" VARCHAR(255), 
	"USER_NAME" VARCHAR(255)
   ) ;

  
create sequence user_id_generator_seq;