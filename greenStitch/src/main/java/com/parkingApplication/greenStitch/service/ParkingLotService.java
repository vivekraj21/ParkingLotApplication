package com.parkingApplication.greenStitch.service;

import com.parkingApplication.greenStitch.models.Car;
import com.parkingApplication.greenStitch.models.ParkingSlot;

import java.util.List;

public interface ParkingLotService {

    void createParkingLot(int numSlots);                             // method to set size of parking lot
    ParkingSlot parkCar(Car car);                                    // method to park car
    void leaveSlot(int slotNumber);                                  // method to empty slot
    List<String> getRegistrationNumbersByColor(String color);        // method to get all registration number by colour
    int getSlotNumberByRegistrationNumber(String registrationNumber);// method to get slot no. by registration no.
    List<Integer> getSlotNumbersByColor(String color);               // method to get all slot no. by a specific colour
    String getStatus();                                              // method to get status of parking lot

}
