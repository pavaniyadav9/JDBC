package com.hallbooking.model;

public class Hall {
    private int id, capacity;
    private String hallName, location, status;
    private double price;

    public Hall(int id, String hallName, String location, int capacity, double price, String status) {
        this.id=id; this.hallName=hallName; this.location=location;
        this.capacity=capacity; this.price=price; this.status=status;
    }
    public int getId(){return id;}
    public String getHallName(){return hallName;}
    public String getLocation(){return location;}
    public int getCapacity(){return capacity;}
    public double getPrice(){return price;}
    public String getStatus(){return status;}
}
