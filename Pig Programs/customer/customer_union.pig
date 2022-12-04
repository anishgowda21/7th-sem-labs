cust1 = LOAD 'customer1.txt' USING PigStorage(',') as (id:int, firstname:chararray,lastname:chararray, phone:chararray, city:chararray);
cust2 = LOAD 'customer2.txt' USING PigStorage(',') as (id:int, firstname:chararray,lastname:chararray, phone:chararray, city:chararray);
cust = UNION cust1, cust2;
Dump cust;
