package org.learn.eventuate.eventuatelt.query;

import org.learn.eventuate.eventuatelt.backend.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
}
