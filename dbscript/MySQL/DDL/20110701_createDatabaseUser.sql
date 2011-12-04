use cstore;
CREATE USER coral IDENTIFIED BY 'coralpw'; 
grant usage on *.* to coral@localhost identified by 'coralpw'; 
grant all privileges on cstore.* to coral@localhost;