package com.team3.order.repository;

import com.team3.order.model.OrderTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderTable, Long> {
    @Modifying
    @Query("DELETE FROM OrderTable a WHERE a.id = :id")
    Optional<OrderTable> deleteOrderById(@Param("id") Long id);
}