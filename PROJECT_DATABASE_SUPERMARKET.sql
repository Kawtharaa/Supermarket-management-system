
CREATE SCHEMA superMarket_pro2;
USE superMarket_pro2;
CREATE TABLE employee ( phone_no VARCHAR(10), age INT, first_name VARCHAR(45), last_name VARCHAR(45), ssn varchar(10) NOT NULL, salary INT,PRIMARY KEY (ssn));
CREATE TABLE product (code VARCHAR(10) NOT NULL, quantity INT ,section VARCHAR(10), name VARCHAR(45), PRIMARY KEY (code));
CREATE TABLE bills (price INT, date DATE, emp_id VARCHAR(10),product_code VARCHAR(10), bill_no VARCHAR(10) NOT NULL,tax double ,product_no int ,PRIMARY KEY (bill_no));
CREATE TABLE offers (product_code VARCHAR(10),validity VARCHAR(3), type VARCHAR(45),duration VARCHAR(45),date DATE, offer_code VARCHAR(10), PRIMARY KEY(offer_code));
CREATE TABLE payment (total_price INT,type VARCHAR(45),p_id VARCHAR(10) NOT NULL,bill_id VARCHAR(10), PRIMARY KEY (p_id));
CREATE TABLE sections (name VARCHAR(45), s_number VARCHAR(10) NOT NULL,emp_id VARCHAR(10), aisle INT ,PRIMARY KEY (s_number));
CREATE TABLE shifts (cashier_no INT NOT NULL,time VARCHAR(2),date DATE,emp_id VARCHAR(12));
ALTER TABLE bills ADD CONSTRAINT FOREIGN KEY (emp_id) REFERENCES employee (ssn);
ALTER TABLE bills ADD CONSTRAINT FOREIGN KEY (product_code) REFERENCES product (code);
ALTER TABLE offers ADD CONSTRAINT FOREIGN KEY (product_code) REFERENCES product (code);
ALTER TABLE payment ADD CONSTRAINT FOREIGN KEY (bill_id) REFERENCES bills (bill_no);
ALTER TABLE product ADD CONSTRAINT FOREIGN KEY (section) REFERENCES sections (s_number);
ALTER TABLE sections ADD CONSTRAINT FOREIGN KEY (emp_id) REFERENCES employee (ssn);
ALTER TABLE shifts ADD CONSTRAINT FOREIGN KEY (emp_id) REFERENCES employee (ssn);


INSERT INTO employee VALUES ('0563829461',30,'Fatima','aleid','1234567890',8400);
INSERT INTO employee VALUES ('0581345925',27,'Majed','alsedrah','2134567890',7000);
INSERT INTO employee VALUES ('0572297110',32,'Ahmed','alsaba','3124567890',4500);
INSERT INTO employee VALUES ('0528442018',25,'noor','alaliwat','4567890123',5000);
INSERT INTO employee VALUES ('0573456819',39,'saad','aldossary','5678901234',5000);
INSERT INTO employee VALUES ('0505383845', 25, 'Hoor', 'alhussain', '6284946199', 4500);
INSERT INTO employee VALUES ('0597341899', 28, 'Alaa', 'alkhaldi', '1268439823', 6000);
INSERT INTO employee VALUES ('0552186556', 31, 'Ali', 'alhelaili', '3547882319', 7100);
INSERT INTO employee VALUES ('0505383845', 25, 'Talal', 'alzaid', '5384718204', 5300);


INSERT INTO sections VALUES ('vegetables & fruits','1','5678901234',20);
INSERT INTO sections VALUES ('snacks','2','1234567890',40);
INSERT INTO sections VALUES ('drinks','3','2134567890',10);
INSERT INTO sections VALUES ('dairy','4','3124567890',30);
INSERT INTO sections VALUES ('bakery','5','4567890123',50);

INSERT INTO product VALUES ('101',130,'1','orange');
INSERT INTO product VALUES ('102',50,'2','Pringles');
INSERT INTO product VALUES ('103',77,'3','iced tea');
INSERT INTO product VALUES ('104',50,'4','cheese');
INSERT INTO product VALUES ('105',44,'5','muffin');
INSERT INTO product VALUES ('109', 60, '1', 'strawberry ');
INSERT INTO product VALUES ('110',3,'2','nasma');
INSERT INTO product VALUES ('106', 40, '5', 'pancake');
INSERT INTO product VALUES ('107', 23, '3', 'herbal tea');
insert into product values ('108',14,'1','mango');



INSERT INTO bills VALUES (70,'2023-1-12','1234567890','102',01,0.05,3);
INSERT INTO bills VALUES (15,'2023-1-14','2134567890','104',02,0.05,1);
INSERT INTO bills VALUES (30,'2023-1-15','3124567890','103',03,0.05,2);
INSERT INTO bills VALUES (122,'2023-1-16','4567890123','105',04,0.05,4);
INSERT INTO bills VALUES (25,'2023-1-18','5678901234','101',05,0.05,2);
INSERT INTO bills VALUES(60,'2023-1-16','5678901234','107',10,0.05,10 );
INSERT INTO bills VALUES(200,'2023-1-15','1234567890','107',06,0.05,6 );
INSERT INTO bills VALUES(205,'2023-2-17','2134567890','108',07,0.05,7 );
INSERT INTO bills VALUES(150,'2023-2-15','4567890123','108',08,0.05,8 );
INSERT INTO bills VALUES(20,'2023-2-15','1234567890','109',09,0.05,9);

INSERT INTO payment VALUES (70,'credit card','1','1' );
INSERT INTO payment VALUES (15,'cash','2','2');
INSERT INTO payment VALUES (30,'cash','3','3' );
INSERT INTO payment VALUES (122,'cash','4','4' );
INSERT INTO payment VALUES ( 25,'credit card','5','5');
INSERT INTO payment VALUES ( 70,'credit card','6','6');
INSERT INTO payment VALUES (15,'cash','7','7');
INSERT INTO payment VALUES (30,'cash','8', '8' );
INSERT INTO payment VALUES (122,'cash','9','9' );
INSERT INTO payment VALUES ( 25,'credit card','10','10');



INSERT INTO shifts VALUES (01,'am','2023-1-12','1234567890');
INSERT INTO shifts VALUES (02,'am','2023-1-14','2134567890');
INSERT INTO shifts VALUES (03,'pm','2023-1-15','3124567890');
INSERT INTO shifts VALUES (04,'pm','2023-1-16','4567890123');
INSERT INTO shifts VALUES (05,'am','2023-1-18','5678901234');
INSERT INTO shifts VALUES (01, 'pm', '2023-1-17', '6284946199');
INSERT INTO shifts VALUES (02, 'pm', '2023-1-20', '1268439823');
INSERT INTO shifts VALUES (03, 'am', '2023-1-17', '3547882319');
INSERT INTO shifts VALUES (04, 'am', '2023-1-29', '5384718204');

INSERT INTO offers VALUES ( '103', 'yes', 'discount', '5 days', '2023-1-22', '8');
INSERT INTO offers VALUES ( '104', 'yes', 'discount', '3 days', '2023-1-23', '3');
INSERT INTO offers VALUES ( '101', 'no', 'buy 1 get 1 ', '6 days', '2023-1-20', '6');
INSERT INTO offers VALUES ( '102', 'yes', 'discount', '5 days', '2023-1-27' , '4');
INSERT INTO offers VALUES ( '105', 'no', 'buy 1 get 1 ', '6 days', '2023-1-22','1');
INSERT INTO offers VALUES ('102','yes','discount','5 days','2023-1-18' ,'2');
INSERT INTO offers VALUES ('104','yes','discount','3 days','2023-1-19' ,'7');
INSERT INTO offers VALUES ('101','no','buy 1 get 1','6 days','2023-1-10','9' );
INSERT INTO offers VALUES ('105','no','buy 1 get 1','6 days','2023-1-10' ,'10');
INSERT INTO offers VALUES ('103','yes',' discount ','5 days','2023-1-18' ,'12');




