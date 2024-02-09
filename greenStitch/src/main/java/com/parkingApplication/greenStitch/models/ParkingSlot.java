package com.parkingApplication.greenStitch.models;

public class ParkingSlot {
    // this class will store parking details
    private int slotNumber;
    private Car parkedCar;

    // constructor
    public ParkingSlot(int slotNumber, Car parkedCar) {
        this.slotNumber = slotNumber;
        this.parkedCar = parkedCar;
    }
    // getter & setter
    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public Car getParkedCar() {
        return parkedCar;
    }

    public void setParkedCar(Car parkedCar) {
        this.parkedCar = parkedCar;
    }
}
