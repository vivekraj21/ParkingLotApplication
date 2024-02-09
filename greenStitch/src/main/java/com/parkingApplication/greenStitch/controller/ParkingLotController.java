package com.parkingApplication.greenStitch.controller;

import com.parkingApplication.greenStitch.models.Car;
import com.parkingApplication.greenStitch.models.ParkingSlot;
import com.parkingApplication.greenStitch.service.ParkingLotService;

import java.util.List;

public class ParkingLotController {

    private final ParkingLotService parkingLotService;

    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    public void processCommand(String command) {
        String[] tokens = command.split(" ");
        switch (tokens[0]) {
            case "create_parking_lot":
                int numSlots = Integer.parseInt(tokens[1]);
                parkingLotService.createParkingLot(numSlots);
                break;
            case "park":
                String registrationNumber = tokens[1];
                String color = tokens[2];
                Car car = new Car(registrationNumber, color);
                ParkingSlot parkedSlot = parkingLotService.parkCar(car);
                if (parkedSlot != null) {
                    System.out.println("Allocated slot number: " + parkedSlot.getSlotNumber());
                }
                break;
            case "leave":
                int slotNumber = Integer.parseInt(tokens[1]);
                parkingLotService.leaveSlot(slotNumber);
                break;
            case "status":
                System.out.println(parkingLotService.getStatus());
                break;
            case "registration_numbers_for_cars_with_colour":
                String targetColor = tokens[1];
                List<String> registrationNumbers = parkingLotService.getRegistrationNumbersByColor(targetColor);
                if(registrationNumbers.size()==0){
                    System.out.println("Car with this colour is not in parking lot.");
                }
                else {
                    System.out.println(String.join(", ", registrationNumbers));
                }
                break;
            case "slot_number_for_registration_number":
                String targetRegistrationNumber = tokens[1];
                int targetSlotNumber = parkingLotService.getSlotNumberByRegistrationNumber(targetRegistrationNumber);
                System.out.println(targetSlotNumber > 0 ? targetSlotNumber : "Not found");
                break;
            case "slot_numbers_for_cars_with_colour":
                String carsColor = tokens[1];
                List<Integer> slotNumbers = parkingLotService.getSlotNumbersByColor(carsColor);
                if(slotNumbers.size()==0){
                    System.out.println("Car with this colour is not in parking lot.");
                }
                else {
                    System.out.println(String.join(", ", slotNumbers.stream().map(Object::toString).toArray(String[]::new)));
                }
                break;
            case "exit":
                System.exit(0);
                break;
            default:
                System.out.println("Invalid command");
        }
    }
}
