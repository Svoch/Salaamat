create database if not exists healthsystem;
use healthsystem;

Create Table User ( ID int, Firstname nvarchar(50), Surname nvarchar(50), Username nvarchar(50), Password nvarchar(50), Address nvarchar(50), Primary Key (ID) );

Create Table Patient ( ID int, Firstname nvarchar(50), Surname nvarchar(50), Username nvarchar(50), Password nvarchar(50), Address nvarchar(50), SupervisorID int , RequestedSupervisorID int , Primary Key (ID) , Unique (Username) );

Create Table Doctor ( ID int, Firstname nvarchar(50), Surname nvarchar(50), Username nvarchar(50), Password nvarchar(50), Address nvarchar(50), Specialty nvarchar(50), Primary Key (ID) , Unique (Username) );


Create Table Illness ( ID int, Title nvarchar(50) , Description nvarchar(100) , Primary Key (ID) , Unique (Title) );

Create Table Illness_Patient ( PatientID int, IllnessID int, Primary Key (PatientID , IllnessID) , FOREIGN KEY (IllnessID) REFERENCES Illness (ID) , FOREIGN KEY (PatientID) REFERENCES Patient (ID) );

Create Table Medicine ( ID int, Name nvarchar(50) , Description nvarchar(100) , Primary Key (ID) , Unique (Name) );

Create Table Medicine_Illness_Patient ( PatientID int, IllnessID int, MedicineID int , Primary Key (PatientID , IllnessID , MedicineID) , FOREIGN KEY (MedicineID) REFERENCES Medicine (ID)  , FOREIGN KEY (PatientID , IllnessID)  REFERENCES Illness_Patient (PatientID , IllnessID)  );

Alter Table Patient add column Confirmed boolean;

Create Table BodyState_Patient ( BodyStateType nvarchar(50) , PatientID int , date int , measurement int , Primary Key (BodyStateType , PatientID , date) );

Create Table Doctor_Patient ( DoctorID int , PatientID int , Question nvarchar(100) , Answer nvarchar(100) , Primary Key (DoctorID , PatientID) );

Create Table PhysicalActivity_Patient ( PatientID int , date int , measurement int , Primary Key (PatientID , date) );

Create Table Drugstore ( ID int, Name nvarchar(50) , Certificate nvarchar(50) , Username nvarchar(50), Password nvarchar(50), Address nvarchar(50), Primary Key (ID)  );

Alter Table PhysicalActivity_Patient add column Type int;

Insert Into Medicine Values (1, 'آسپیرین', 'داروی مسکن');
Insert Into Medicine Values (2, 'دوکساپرام', 'داروی تنفسی');
Insert Into Medicine Values (3, 'بروفن', 'داروی مسکن');

