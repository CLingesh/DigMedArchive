create database DigMedArchive;
use DigMedArchive;



create table PatientDetails(
p_RegId int primary key auto_increment,
p_Name varchar(20)  not null,
p_PhNo long  not null,
p_Gender varchar(10) not null,
p_BlGroup varchar(5) not null,
p_Dob date not null
);


create table MedicalConsultationDetails(
d_Name varchar(20) not null,
d_RegId int primary key auto_increment,
d_Degree varchar(40) not null,
d_consultationName varchar(20) not null,
d_consultantPhNo long not null 
);

create table ListOfAilments(
a_Id int primary key auto_increment,
a_Reason varchar(100) not null,
a_Name varchar(50) not null,
a_Description varchar(50) not null
);

create table TreatmentDetails(
t_Id int primary key auto_increment,
t_Date date not null,
p_Id int,
d_Id int,
a_Id int,
t_Duration varchar(20),
t_Result varchar(80),
foreign key(p_Id) references PatientDetails(p_RegId),
foreign key(d_Id) references MedicalConsultationDetails(d_RegId),
foreign key(a_Id) references ListOfAilments(a_Id)
);

insert into PatientDetails(p_Name,p_PhNo,p_Gender,p_BlGroup,p_Dob)
values
('Raj','8973659205','Male','A1+','1995-08-14'),
('Geetha','7010869293','Female','O+','1999-12-02'),
('Rani','8883344401','Female','A-','1998-05-13'),
('Gopi','9865252504','Male','B+','1997-08-14');

insert into MedicalConsultationDetails(d_Name,d_Degree,d_consultationName,d_consultantPhNo)
values
('vinoth','MBBS','AAA','9876543210'),
('Hariharan','MBBS,MD in General','BBB','9648921658'),
('Perumal','MBBS,MD in Neurology','CCC','9834672125'),
('Nirmala','MBBS,MD in General','DDD','7856492381'),
('Navaneethan','MBBS,MD in Paediatric Neurologist','EEE','8964751265'),
('Chithambaram','MBBS,MD in General','FFF','8654987397'),
('SanguMani','Pulmonologist','GGG','8593316597'),
('Indra','Endocrinologist','HHH','9764825975'),
('Lingam','BDS,Dentistry','III','6478592135'),
('RajaGopal','Rheumatologist','JJJ','9812634684'),
('Sudhagar','Nephrologist','KKK','7698548654'),
('Hariharan','MBBS,MS Gastroenterologist','LLL','8976589651'),
('Prabakaran','Orthopedics','MMM','7236544198'),
('DarmaRai','Dermatologist','NNN','9846215926'),
('Duari','OrthoPedics','OOO','7946852188'),
('Narayanan','MBBS,MS neurologist','PPP','98457868987');

insert into ListOfAilments(a_Reason,a_Name,a_Description)
values
('Sneezing and Running Nose','Common cold caused by Rhino Virus','Antibiotics-Cetrizine'),
('Diarrhea with Stomach Pain','Parasitic Infection','Antiparasitic-Loperamide'),
('Severe Cough and Vomiting after Cough','Whooping Cough-Pertussis','Antibiotics-Azithromycin'),
('Painful Sensation during Swallowing and feel dry','Allergies in upper Respiratory Tract,Hoarseness','Pain Relievers-Acetaminophen'),
('Stuffy nose and Disturbed Breathing','Sinusitis','Anti Sinusitis-Amoxcillin'),
('Severe Diarrhea with Stomach Cramping,Feel ver sick, Dehydrated','Shigella Infection','T.Pepto Bismal'),
('Fever & chill,Tired,Vomiting,Rapid Breathing','Meningococcal Disease','Antibiotics-CephaloSporins'),
('Fever,Headache,Tiredness,Rashes in Face & Chest','Chicken Pox','Antiviral-Acyclovin'),
('Inability in coummunication,Lack of Emotion','Autism Spectrum Disorder','Dietary Approaches'),
('Ear Pain, Fluid Secretion in Ear','Ear Infection','Antibiotics-Amoxcillin'),
('White patches around Mouth, Throat, Soreness, Difficulty in swallowing','Candidiasis','T-Clotrimazole'),
('Difficult in Breathing, Wheezing','Bronchiolitis','Bronchodilators-Salbutamol'),
('Frequent urination, Increased Thrist, Hunger','Type 1 Diabetes Mellitus','Intaking life long insulin Injection'),
('Dificulty in Eating, Tooth loss, Pain','Dental Caries','Paracetamol'),
('Pain in Joint, Inability to climb, run, Cant walk for 10 Min','Jurenile idiopathic Arthritis','Corticosteroids- Dexamethasone'),
('Dificult Breathing, cough, fever','Pneumonia','Antibiotic-Amoxicillin'),
('Fainting, Tired','Anemia','Iron tablets-Ferrous sulphate'),
('Sudden wait gain,tired,infection','Nephrotic Syndrome','Diuretics-Furosemide'),
('Vomiting, Stomach pain,Constipation','Volvulus','Antiemetics'),
('Fever, Sore Throat, Neck enlargement','Glandular Fever','Dring Enough Fluids, Paracetamol'),
('Pain in wrist & Numbness','Carpal tunnel Syndrome','Ibuprofen'),
('Darkening of skin, change in mole colour','Skin cancer','Acyclovir at starting stage'),
('Pain in shoulder, inability to move swelling','Shoulder Dislocation','T.Ibuprofen'),
('Pain in Elbow,arm and wrist','Tennis Elbow','T.Ibuprofen'),
('Redness inside mouth, Burning sensation','Stomatitis','Acyclovir'),
('Severe Headache, Vomiting sensation','migrane','T.Sumatriptan');

insert into TreatmentDetails(t_Date,p_Id,d_Id,a_Id,t_Duration,t_Result)
values
('2012-01-01','4','1','17','10D','Prolong cause black color skin'),
('2012-01-07','1','1','1','5D','cause Drowsiness'),
('2012-02-07','2','4','6','2D','Intake of more fluid to stay hydrated'),
('2012-03-01','3','7','12','2D','Prolong leads to lung disability'),
('2013-01-01','1','14','22','10D','change in skin texture'),
('2013-07-10','3','16','26','6D','prolonged cause increase heart rate'),
('2014-02-08','3','8','13','5D','not in peak'),
('2014-03-08','1','3','1','5D','prolonged duration cause increase in heart Rhythm leads to severe condition'),
('2014-04-30','2','3','7','5D','1-5 survies have disability such as deafness,nervous system'),
('2014-08-08','4','11','18','7W','Prolong cause Kidney failure'),
('2015-04-05','3','13','24','6D','prolonged cause increace pain'),
('2016-05-05','4','12','19','10D','prolonged cause stomach pains'),
('2016-06-05','3','9','14','3D','prolonged cause stomach pain'),
('2016-07-05','1','6','3','5D','prolonged duration leads to low amount of magnesium and patassium in the blood'),
('2016-11-05','2','6','8','3D','prolonged medicine intake leads to gastric collapse'),
('2017-05-08','2','13','23','1M','prolonged cause liver failure'),
('2018-01-09','1','4','4','2D','Prolonged medications can damage the liver'),
('2018-03-09','2','5','9','2M','maintain normal diet'),
('2018-05-30','3','10','15','1M','not much affected'),
('2018-06-30','4','6','20','1W','prolonged cause stomach pains'),
('2018-11-15','2','4','10','2M','prolonged duration leads to mental problem'),
('2019-09-19','4','15','25','4D','prolonged cause stomach ulcer'),
('2020-05-11','1','4','5','3D','prolonged duration leads to stomach pains'),
('2020-07-11','2','4','11','4D','prolonged cause stomach pains'),
('2020-09-21','3','7','16','4D','prolonged cause stomach pains'),
('2020-12-21','4','13','21','4D','prolonged cause liver failure');

select * from PatientDetails;
select * from MedicalConsultationDetails;
select * from ListOfAilments;
select * from TreatmentDetails;

select * from PatientDetails,MedicalConsultationDetails; 

select p_Name from PatientDetails
union
select d_Name from MedicalConsultationDetails;

select t.t_Id,t.t_Date,d.d_Name,d.d_Degree,d.d_consultationName,d.d_consultantPhNo,a.a_Reason,a.a_Name,a.a_Description,t.t_Duration,t.t_Result from TreatmentDetails t
join MedicalConsultationDetails d on t.d_Id = d.d_RegId
join ListOfAilments a on t.a_Id = a.a_Id
join PatientDetails p on t.p_Id = p.p_RegId
where p.p_RegId=2
order by t.t_Date;

select t.t_Id,t.t_Date,t.t_Duration,t.t_Result,p.p_Name,p.p_PhNo,p.p_Gender,p.p_BlGroup,p.p_Dob from TreatmentDetails t
join PatientDetails p on t.p_Id = p.p_RegId
order by t.t_Date;
