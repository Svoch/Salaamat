create database if not exists healthsystem;
use healthsystem;
Create Table User ( ID int, Firstname nvarchar(50), Surname nvarchar(50), Username nvarchar(50), Password nvarchar(50), Address nvarchar(50), Primary Key (ID) );
Create Table Patient ( ID int, Firstname nvarchar(50), Surname nvarchar(50), Username nvarchar(50), Password nvarchar(50), Address nvarchar(50), SupervisorID int , RequestedSupervisorID int , Primary Key (ID) , Unique (Username) );
Create Table Doctor ( ID int, Firstname nvarchar(50), Surname nvarchar(50), Username nvarchar(50), Password nvarchar(50), Address nvarchar(50), Specialty nvarchar(50), Primary Key (ID) , Unique (Username) );


Create Table Illness ( ID int, Title nvarchar(50) , Description nvarchar(100) , Primary Key (ID) , Unique (Title) );

Create Table Illness_Patient ( PatientID int, IllnessID int, Primary Key (PatientID , IllnessID) , FOREIGN KEY (IllnessID) REFERENCES Illness (ID) , FOREIGN KEY (PatientID) REFERENCES Patient (ID) );

Create Table Medicine ( ID int, Name nvarchar(50) , Description nvarchar(100) , Primary Key (ID) , Unique (Name) );

Create Table Medicine_Illness_Patient ( PatientID int, IllnessID int, MedicineID int , Primary Key (PatientID , IllnessID , MedicineID) , FOREIGN KEY (MedicineID) REFERENCES Medicine (ID)  , FOREIGN KEY (PatientID , IllnessID)  REFERENCES Illness_Patient (PatientID , IllnessID)  );

alter table Patient add column Confirmed boolean;




