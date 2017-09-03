package org.learn.axonframework.axonsaga.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderQueryObjectRepository extends JpaRepository<OrderQueryObject, String> {
}
