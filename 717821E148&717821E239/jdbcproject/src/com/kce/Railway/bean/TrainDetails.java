package com.kce.Railway.bean;

public class TrainDetails {
	public int trainId;
	public String Source;
	public String Destination;
	public int seatsAvailable;
	public String date;
	public double priceOfSeat;
	public TrainDetails(int trainId, String source, String destination, int seatsAvailable, String date,
			double priceOfSeat) {
		super();
		this.trainId = trainId;
		Source = source;
		Destination = destination;
		this.seatsAvailable = seatsAvailable;
		this.date = date;
		this.priceOfSeat = priceOfSeat;
	}
	public int getTrainId() {
		return trainId;
	}
	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}
	public String getSource() {
		return Source;
	}
	public void setSource(String source) {
		Source = source;
	}
	public String getDestination() {
		return Destination;
	}
	public void setDestination(String destination) {
		Destination = destination;
	}
	public int getSeatsAvailable() {
		return seatsAvailable;
	}
	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}
	public  String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getPriceOfSeat() {
		return priceOfSeat;
	}
	public void setPriceOfSeat(double priceOfSeat) {
		this.priceOfSeat = priceOfSeat;
	}
	
}
