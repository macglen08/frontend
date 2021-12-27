package com.ticket.TicketOrderService;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Trains")
public class Train {
	
	@Id
	private String id;
	private String seats;
	private String startStation;
	private String endStation;
	
	public Train() {
		
	}

	public Train(String id, String seats, String startStation, String endStation) {
		this.id = id;
		this.seats = seats;
		this.startStation = startStation;
		this.endStation = endStation;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSeats() {
		return seats;
	}

	public void setSeats(String seats) {
		this.seats = seats;
	}

	public String getStartStation() {
		return startStation;
	}

	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}

	public String getEndStation() {
		return endStation;
	}

	public void setEndStation(String endStation) {
		this.endStation = endStation;
	}


}
