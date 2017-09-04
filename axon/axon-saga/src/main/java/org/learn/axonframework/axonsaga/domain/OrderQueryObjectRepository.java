package org.learn.axonframework.axonsaga.domain;

import org.learn.axonframework.axonsaga.domain.query.OrderQueryObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderQueryObjectRepository extends JpaRepository<OrderQueryObject, String> {
}
