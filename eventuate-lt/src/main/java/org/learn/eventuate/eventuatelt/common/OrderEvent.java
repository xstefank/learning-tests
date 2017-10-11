package org.learn.eventuate.eventuatelt.common;

import io.eventuate.Event;
import io.eventuate.EventEntity;

@EventEntity(entity = "org.learn.eventuate.eventuatelt.backend.domain.OrderAggregate")
public interface OrderEvent extends Event {
}
