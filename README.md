# README

An OO Java application developed for management and interaction of patients, physicians and pharmacies. Utilizes Hibernate to manage databases. 





Notes:

kill all sql processes command:
    mysqladmin processlist -u root -p  |  awk '$2 ~ /^[0-9]/ {print "KILL "$2";"}' |  mysql -u root -p 

Do not forbid TCP/IP connection for mysql. do not add `skip-networking` in my.cnf


Predefined Users:

doctor1:doc1 علی علوی
doctor2:doc2 مسعود حکیمی
patient1:pat1 محسن احمدی
patient2:pat2 احمد نعیمی
daru1:daru1

