package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.OrderDetails;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {
	@Transactional
	@Query(value = "select * from orderdetails where order_number=?;", nativeQuery = true)
	public OrderDetails getOrderDetailsWithId(Integer id);
}
