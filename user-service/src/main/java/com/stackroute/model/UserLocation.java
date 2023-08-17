package com.stackroute.model;

public class UserLocation {
    public int pin;
    public String address;

    public UserLocation() {
    }

    public UserLocation(int pin, String address) {
        this.pin = pin;
        this.address = address;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserLocation{" +
                "pin=" + pin +
                ", address='" + address + '\'' +
                '}';
    }
}
