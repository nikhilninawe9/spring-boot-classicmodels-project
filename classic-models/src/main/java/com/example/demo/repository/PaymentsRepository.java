package com.example.demo.repository;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Payments;

@Repository
public interface PaymentsRepository extends JpaRepository<Payments, Integer> {

	@Transactional
	@Query(value = "select round(avg(amount),2) from payments", nativeQuery = true)
	public Double getAvgAmt();

	@Transactional
	@Query(value = "select payment_date from payments where customer_number=144", nativeQuery = true)
	public Date getDate();

	@Transactional
	@Query(value = "select round(sum(amount),1) from payments where payment_date between ? and ?;", nativeQuery = true)
	public Double getTotalAmountInDuration(Date time1, Date time2);

	@Transactional
	@Query(value = "select * from payments where payment_date = ?;", nativeQuery = true)
	public List<Payments> getPaymentDataDatewise(Date time1);

	@Transactional
	@Query(value = "select count(*) from payments where payment_date = ?;", nativeQuery = true)
	public Integer getNumberOfPaymentsAtTime(Date time1);

	@Transactional
	@Query(value = "select payment_date from payments where customer_number=?;", nativeQuery = true)
	public Date getDateByCustNum(Integer num);

	@Transactional
	@Query(value = "select * from payments where amount between ? and ?;", nativeQuery = true)
	public List<Integer> getCustomerNumbers(@PathVariable Integer from, @PathVariable Integer to);

	@Transactional
	@Query(value = "select customer_number from payments where payment_date between ? and ?;", nativeQuery = true)
	public List<Integer> getCustomerNumbersTxnInSelectedDates(Date time1, Date time2);

	@Transactional
	@Query(value = "SELECT payment_date FROM payments where check_number='HQ336336';", nativeQuery = true)
	public Date getDate1();

	@Transactional
	@Query(value = "select * from payments where year( payment_date ) = ?", nativeQuery = true)
	public List<Payments> getPaymentYearwise(String year);

	@Transactional
	@Query(value = "SELECT * FROM payments where payment_date = ?;", nativeQuery = true)
	public List<Payments> getPaymentsByEntirePaymentDates(Date date);

	@Transactional
	@Query(value = "select * from payments where month( payment_date ) = ?", nativeQuery = true)
	public List<Payments> getPaymentDataMonthwise(String month);

	@Transactional
	@Query(value = "select * from payments where day( payment_date ) = ?", nativeQuery = true)
	public List<Payments> getPaymentDataDaywise(String month);

	@Transactional
	@Query(value = "select customer_number, amount, check_number, payment_date from payments group by customer_number;", nativeQuery = true)
	public List<Payments> getPaymentDataCustomerWise();

	@Transactional
	@Query(value = "select customer_number, round(avg(amount),2), check_number, payment_date from payments group by customer_number;", nativeQuery = true)
	public List<Object[]> getPaymentDataCustomerWise1();
}
