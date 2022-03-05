package com.example.demo.repository;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Customers;
import com.google.gson.JsonArray;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Integer> {

	@Modifying
	@Transactional
	@Query(value = "update customers c inner join payments p on c.customer_number=p.customer_number set p.check_number=?, c.address_line2=?\r\n"
			+ "where c.customer_number=?;", nativeQuery = true)
	public Integer updateCustomer(String cheaqueNumber, String address2, Integer customerNumber);

	@Transactional
	@Query(value = "select c.address_line1, c.address_line2, c.country, p.amount, p.check_number from customers c inner join payments p on c.customer_number=p.customer_number;", nativeQuery = true)
	public JsonArray getCustDetails();

	@Transactional
	@Query(value = "select c.address_line1, c.address_line2, c.country, p.amount, p.check_number from customers c inner join payments p on c.customer_number=p.customer_number where check_number=?;", nativeQuery = true)
	public List<Object> getCustDetails1();

	@Transactional
	@Query(value = "select c.address_line1, c.address_line2, c.country, p.amount, p.check_number from customers c inner join payments p on c.customer_number=p.customer_number;", nativeQuery = true)
	public List<String[]> getCustDetails2();

	@Transactional
	@Query(value = "select c.address_line1, c.address_line2, c.country, p.amount, p.check_number from customers c inner join payments p on c.customer_number=p.customer_number;", nativeQuery = true)
	public List<Object[]> getCustDetails3();

	@Transactional
	@Query(value = "select * from customers where country=?;", nativeQuery = true)
	public List<Customers> getCustwithCountry();

	@Transactional
	@Query(value = "select count(*) 'number of employees', o.city cities, concat(e.first_name,\" \",e.last_name) 'full name'\r\n"
			+ "	from offices o inner join employees e on o.office_code=e.office_code group by o.office_code where ;", nativeQuery = true)
	public List<Object[]> getDATA();

	@Transactional
	@Query(value = "	select count(*) 'number of employees', o.city cities, concat(e.first_name,\" \",e.last_name) 'full name'\r\n"
			+ "	from offices o inner join employees e on o.office_code=e.office_code where o.city='NYC';", nativeQuery = true)
	public List<Object[]> getSingleDATA();

	@Transactional
	@Query(value = "select c.customer_number cNo, concat(c.contact_first_name,' ',c.contact_last_name)cFName, p.payment_date pDate, o.order_date oDate, o.status oStatus\r\n"
			+ "	from customers c inner join payments p inner join orders o \r\n"
			+ "	on c.customer_number=p.customer_number and c.customer_number=o.customer_number\r\n"
			+ "	where c.address_line2 is not null;", nativeQuery = true)
	public List<Object[]> getCustomerDataAddressNotNull();

	@Transactional
	@Query(value = "select round(avg(c.credit_limit),2) avgCreditLimit, c.country country from customers c \r\n"
			+ "	group by c.country order by country;", nativeQuery = true)
	public List<Object[]> getCustomerCreditLimitData();

	@Modifying
	@Transactional
	@Query(value = "update customers c inner join payments p inner join orders o \r\n"
			+ "	on c.customer_number=p.customer_number and c.customer_number=o.customer_number set p.payment_date = ?,\r\n"
			+ "	c.contact_first_name = ?, o.status = ? where c.customer_number = 121;", nativeQuery = true)
	public Integer updateCustomerData(String date, String firstName, String status);

	@Transactional
	@Query(value = "select round(avg(amount),2) average, year ( payment_date ) date from payments group by year(payment_date);", nativeQuery = true)
	public List<Object[]> getAvgByYear();

	@Transactional
	@Query(value = "select round(sum(buy_price)) 'total price', product_line 'product line' from products where product_line = ?;", nativeQuery = true)
	public List<Object[]> getTotalByProductLine(String prodLine);

	@Transactional
	@Query(value = "select * from customers where address_line1 like ?%;", nativeQuery = true)
	public List<Customers> getAddressWithCustomerName(String name);

	@Transactional
	@Query(value = "SELECT amount FROM payments where payment_date = ?;", nativeQuery = true)
	public Integer getAmountByPaymentDates(Date date);

}
