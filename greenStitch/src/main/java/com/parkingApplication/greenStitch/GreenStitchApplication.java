package com.parkingApplication.greenStitch;

import com.parkingApplication.greenStitch.controller.ParkingLotController;
import com.parkingApplication.greenStitch.service.ParkingLotService;
import com.parkingApplication.greenStitch.service.ParkingLotServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class GreenStitchApplication {

	public static void main(String[] args) {

		ParkingLotService parkingLotService = new ParkingLotServiceImpl();
		ParkingLotController parkingLotController = new ParkingLotController(parkingLotService);

		Scanner scanner = new Scanner(System.in);
		String command;

		System.out.println("Welcome to the Parking Lot System!");

		do {
			System.out.print("Enter command: ");
			command = scanner.nextLine();
			parkingLotController.processCommand(command);
		} while (!command.equalsIgnoreCase("exit"));

		System.out.println("Program terminated.");
	}

}
