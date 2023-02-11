--number 1. Recapitulation of number of accounts owned by every customer.

select 
	concat(a.cust_firstname,' ', a.cust_lastname) as "customer name",
	a.cust_id as "customer id",
	count(b.acc_number) as "number of accounts" 
from customer a join account b on a.cust_id = b.acc_owner
group by a.cust_firstname, a.cust_lastname, a.cust_id 
order by a.cust_firstname;

--number 2. All transactions created by John Michael sorted by account number and transaction date

select 
	concat(c.cust_firstname,' ', c.cust_lastname) as "customer name", 
	c.cust_id as "customer id",
	b.acc_number as "account number", 
	a.*
from transaction a 
	join account b on a.trs_from_account = b.acc_number
	join customer c on b.acc_owner = c.cust_id 
where c.cust_id = 1
order by b.acc_number, a.trs_date desc;