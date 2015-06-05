create database if not exists healthsystem;
use healthsystem;
Create Table User ( ID int, Firstname nvarchar(50), Surname nvarchar(50), Username nvarchar(50), Password nvarchar(50), Address nvarchar(50), Primary Key (ID) );
Create Table Patient ( ID int, Firstname nvarchar(50), Surname nvarchar(50), Username nvarchar(50), Password nvarchar(50), Address nvarchar(50), Supervisor nvarchar(50), Primary Key (ID) );

