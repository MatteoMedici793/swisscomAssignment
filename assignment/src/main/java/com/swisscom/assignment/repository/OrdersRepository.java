package com.swisscom.assignment.repository;

import com.swisscom.assignment.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    
    Optional<Orders> findById(Long orderId);

    @Query(value = "insert into Orders o set (o.state, o.product_id, o.quantity, o.order_creation) " +
            "values (:state, :productId, :quantity, :orderCreation)",
            nativeQuery = true)
    Long insertOrder(@Param("state") String state,
                     @Param("productId") Long product_id,
                     @Param("quantity") int quantity,
                     @Param("orderCreation") Date order_creation);

    void deleteById(Long id);

    @Modifying
    @Query("UPDATE Orders o set o.state = :state, o.order_deletion = :orderDeletion, o.order_delivery = :orderDelivery" +
            " WHERE o.id = :id")
    void updateOrder(@Param("state") String state,
                     @Param("id") Long id,
                     @Param("orderDeletion") Date order_deletion,
                     @Param("orderDelivery") Date order_delivery);
}
