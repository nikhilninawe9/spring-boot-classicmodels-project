package com.example.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

	@Transactional
	@Query(value = "select * from orders where order_number=?;", nativeQuery = true)
	public Orders getOrderWithId(Integer id);

	@Transactional
	@Query(value = "select count(*) total_number, round(sum(p.buy_price),2) sum_price, p.product_description,  p1.product_line from \r\n"
			+ "products p inner join productlines p1 on p.product_line=p1.product_line group by p1.product_line;", nativeQuery = true)
	public List<Object[]> getAllOrderWithDetails();
}
