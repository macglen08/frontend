package com.ticket.TicketOrderService;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TicketOrderRepository extends MongoRepository<BookingTicket, String>{

}
