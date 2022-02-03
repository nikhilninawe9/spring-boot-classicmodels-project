package com.example.demo.repository;

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

//	@Transactional
//	@Query(value = "select count(*) 'number of employees', o.city cities, concat(e.first_name,\" \",e.last_name) 'full name'\r\n"
//			+ "	from offices o inner join employees e on o.office_code=e.office_code group by o.office_code;", nativeQuery = true)
//	public List<?> getDATA();

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
			+ "	group by c.country;", nativeQuery = true)
	public List<Object[]> getCustomerCreditLimitData();
}
