package com.kce.Railway.bean;

public class BookingDetails {
	public String name;
	public int phoNo;
	public int trainNo;
    public int noOfSeats;
	public BookingDetails(String name, int phoNo, int trainNo, int noOfSeats) {
		super();
		this.name = name;
		this.phoNo = phoNo;
		this.trainNo = trainNo;
		this.noOfSeats = noOfSeats;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhoNo() {
		return phoNo;
	}
	public void setPhoNo(int phoNo) {
		this.phoNo = phoNo;
	}
	public int getTrainNo() {
		return trainNo;
	}
	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	@Override
	public String toString() {
		return "BookingDetails [name=" + name + ", phoNo=" + phoNo + ", trainNo=" + trainNo + ", noOfSeats=" + noOfSeats
				+ "]";
	}
	
    


}
