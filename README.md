# Book Management System
SpringBoot, Maven, PostgreSQL, Thymeleaf, and BootStrap

<img width="1680" alt="home" src="https://user-images.githubusercontent.com/78386606/132923253-5fdc8747-d935-423a-9e37-90acab52f01c.png">

<img width="1680" alt="create" src="https://user-images.githubusercontent.com/78386606/132923228-1140b2b3-9989-4561-a891-89dd319a5917.png">

<img width="1680" alt="update" src="https://user-images.githubusercontent.com/78386606/132923307-28dbd6c2-ebff-4f9c-b1b5-fa4a3bd24a4e.png">

<img width="1680" alt="error page" src="https://user-images.githubusercontent.com/78386606/132931515-bcedf931-1fd6-46d9-8055-ed8b04b4a90a.png">

<b>Creating the Postgres database</b>
<br>
<i>Terminal commands (in order):</i>
<br>
<br>
psql
<br>
CREATE DATABASE books;
<br>
\c books
<br>
CREATE TABLE book (
<br>
  id bigint NOT NULL,
  <br>
  isbn varchar(30) NOT NULL,
  <br>
  title varchar(100) NOT NULL,
  <br>
  author varchar(100) NOT NULL,
  <br>
  status varchar(15) NOT NULL,
  <br>
  PRIMARY KEY (id)
  <br>
);
<br>
\d book
<br>
GRANT ALL PRIVILEGES ON DATABASE books to yourusername;
<br>
GRANT ALL PRIVILEGES ON DATABASE books to postgres;
<br>
\q
<br>





  







