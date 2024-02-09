package com.parkingApplication.greenStitch.service;

import com.parkingApplication.greenStitch.configuration.ParkingLotConfig;
import com.parkingApplication.greenStitch.models.Car;
import com.parkingApplication.greenStitch.models.ParkingSlot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotServiceImpl implements ParkingLotService {

    // storing data in-memory database
    private List<ParkingSlot> parkingSlots;

    public ParkingLotServiceImpl() {
        this.parkingSlots = new ArrayList<>();
    }

    @Override
    public void createParkingLot(int numSlots) {                    // method to set size of parking lot
        ParkingLotConfig parkingLotConfig = new ParkingLotConfig();
        if (numSlots > parkingLotConfig.MAX_SLOTS) {
            System.out.println("Error: Cannot create parking lot with more slots than the maximum allowed that is "+" "+parkingLotConfig.MAX_SLOTS);
            return;
        }
        for (int i = 0; i < numSlots; i++) {
            parkingSlots.add(new ParkingSlot(i + 1, null));
        }
        System.out.println("Created a parking lot with " + numSlots + " slots");
    }

    @Override
    public ParkingSlot parkCar(Car car) {                        // method to park car
        // Find the first available slot
        for (ParkingSlot slot : parkingSlots) {
            if (slot.getParkedCar() == null) {
                slot.setParkedCar(car);
                return slot;
            }
        }
        System.out.println("Sorry, parking lot is full");
        return null;
    }

    @Override
    public void leaveSlot(int slotNumber) {                    // method to empty slot
        if (isValidSlotNumber(slotNumber)) {
            ParkingSlot slot = parkingSlots.get(slotNumber - 1);
            if (slot.getParkedCar() != null) {
                slot.setParkedCar(null);
                System.out.println("Slot number " + slotNumber + " is free");
            } else {
                System.out.println("Slot number " + slotNumber + " is already empty");
            }
        } else {
            System.out.println("Invalid slot number");
        }
    }

    @Override
    public List<String> getRegistrationNumbersByColor(String color) {     // method to get all registration number by colour
        List<String> registrationNumbers = new ArrayList<>();
        for (ParkingSlot slot : parkingSlots) {
            if (slot.getParkedCar() != null && color.equalsIgnoreCase(slot.getParkedCar().getColor())) {
                registrationNumbers.add(slot.getParkedCar().getRegistrationNumber());
            }
        }
        return registrationNumbers;
    }

    @Override
    public int getSlotNumberByRegistrationNumber(String registrationNumber) {  // method to get slot no. by registration no.
        for (ParkingSlot slot : parkingSlots) {
            if (slot.getParkedCar() != null &&
                    registrationNumber.equalsIgnoreCase(slot.getParkedCar().getRegistrationNumber())) {
                return slot.getSlotNumber();
            }
        }
        return -1;
    }

    @Override
    public List<Integer> getSlotNumbersByColor(String color) {     // method to get all slot no. by a specific colour
        List<Integer> slotNumbers = new ArrayList<>();
        for (ParkingSlot slot : parkingSlots) {
            if (slot.getParkedCar() != null && color.equalsIgnoreCase(slot.getParkedCar().getColor())) {
                slotNumbers.add(slot.getSlotNumber());
            }
        }
        return slotNumbers;
    }

    @Override
    public String getStatus() {                           // method to get status of parking lot
        StringBuilder status = new StringBuilder("Slot No. Registration No Colour\n");
        int count=0;
        for (ParkingSlot slot : parkingSlots) {
            if (slot.getParkedCar() != null) {
                count++;
                status.append(slot.getSlotNumber()).append(" ")
                        .append(slot.getParkedCar().getRegistrationNumber()).append(" ")
                        .append(slot.getParkedCar().getColor()).append("\n");
            }
        }
        if(count==0){
            return "No car in Parking Lot.";
        }
        else{
            return status.toString().trim();
        }

    }

    private boolean isValidSlotNumber(int slotNumber) {           // method to check slot no. is valid or not
        return slotNumber >= 1 && slotNumber <= parkingSlots.size();
    }
}
