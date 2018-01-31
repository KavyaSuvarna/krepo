# krepo
To do project
Build a ToDo application with option to 
add/delete 
and mark it as completed. Also you should be to show pending and completed tasks.

Front End : Angularjs / Javascript / Html / Css3
Middleware : Spring boot / Spring
Back end : any in memory DB ex. H2 , MongoDB etc.
“
Pre requisites 
STS / VSCode , Nodejs , any in memory 

Used:
1.Angular JS
2. Spring boot
3.H2

mvn clean install
java -jar todo-0.0.1-SNAPSHOT.jar

H2 database
CREATE TABLE TASK(ID INT PRIMARY KEY, NAME VARCHAR(255), ISCOMPLETE BOOLEAN );

Pending ToDo:
1. Validation
2. CSS
