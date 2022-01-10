+------------------+-------------+------+-----+---------+-------+
| Field            | Type        | Null | Key | Default | Extra |
+------------------+-------------+------+-----+---------+-------+
| account_num      | varchar(20) | NO   | PRI | NULL    |       |
| amount           | varchar(10) | YES  |     | NULL    |       |
| account_hld_name | varchar(20) | NO   |     | NULL    |       |
| account_cre_date | date        | YES  |     | NULL    |       |
| status           | tinyint(1)  | YES  |     | NULL    |       |
+------------------+-------------+------+-----+---------+-------+

create table bank_account(account_num varchar(20) primary key,amount varchar(10),account_hld_name varchar(20) not null,account_cre_name date,status boolean);