### 4.2 Department CRUD

****************************************************
Update configurations in the following file:
****************************************************

=> update Database connection details in /crud/src/main/resources/hibernate.properties

****************************************************
For Running the Application , do the following steps
****************************************************

=> Download the Apache Tomcat 9.0.27 Server
=> On terminal, run the command 'mvn clean install'
=> Add its configuration to your project
=> Add the exploded war artifact to the deployment and  remove '_exploded' in Application context(only 'iiitb_war' shoule be there)

****************************************************
                        Data
****************************************************
----Department table------------
        insert into Department (capacity, department_Id, departmentName, vacancy) values (30, 1, 'Admin', 30);
        insert into Department (capacity, department_Id, departmentName, vacancy) values (20, 2, 'Faculty', 20);
        insert into Department (capacity, department_Id, departmentName, vacancy) values (15, 4, 'HR',15);
        insert into Department (capacity, department_Id, departmentName, vacancy) values (15, 3, 'Accounts',15);

----Employee table------------
        insert into Employee (Name, department_id, emailId, empId, password, id) values ('Mayur', 2, 'mayur@gmail', '1541', '123', 1);
        insert into Employee (Name, department_id, emailId, empId, password,  id) values ('Nirmal', 4, 'Nirmal@gmail.com', '1010', '225',  2);
        insert into Employee (Name, department_id, emailId, empId, password,  id) values ('Prasanna', 3, 'Parth@gmail.com', '1352', '000',  3);
        insert into Employee (Name, department_id, emailId, empId, password, id) values ('Nirmla', 1, 'Nirmla@gmail.com', '1100','111' ,  5);
        insert into Employee (Name, department_id, emailId, empId, password, id) values ('Parth' ,2, 'Prasanna@gmail.com', '1544', '222',  6);
        insert into Employee (Name, department_id, emailId, empId, password,  id) values ('Manav', 3, 'Manav@gmail.com', '4521', '444',  7);


****************************************************
                Troubleshooting
****************************************************
If the changes made in your project don't reflect in your browser kindly: 
=>Clear Browser Cache & Cookies
=> Delete the ```/target``` directory
*=>Run on the IntelliJ Terminal ```$ mvn clean install```


* Note
    First page url that you see as URL: "<ip:PORT>/iiitb_war"
