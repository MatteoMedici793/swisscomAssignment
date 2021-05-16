package com.swisscom.assignment.repository;

import com.swisscom.assignment.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

    @Query(value = "select o from Orders o where o.order_id = :orderId")
    List<Orders> findByOrderId(@Param("orderId") Long order_id);

    @Query(value = "insert into Orders o set (o.state, o.product_id, o.product_type, o.product_name, o.quantity, o.order_creation) " +
            "values (:state, :productId, :productType, :productName, :quantity, :orderCreation)",
            nativeQuery = true)
    void insertOrder(@Param("state") String state,
                     @Param("productId") Long product_id,
                     @Param("productType") String product_type,
                     @Param("productName") String product_name,
                     @Param("quantity") int quantity,
                     @Param("orderCreation") Date order_creation);

    @Modifying
    @Query("UPDATE Orders o set o.state = :state, o.order_deletion = :orderDeletion, o.order_delivery = :orderDelivery" +
            " WHERE o.order_id = :id")
    void updateOrder(@Param("state") String state,
                     @Param("id") Long id,
                     @Param("orderDeletion") Date order_deletion,
                     @Param("orderDelivery") Date order_delivery);
}
