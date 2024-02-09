# ParkingLotApplication
![p1](https://img.freepik.com/premium-vector/city-parking-lot-with-different-cars_165488-1693.jpg)

## Overview
- This is a simple parking lot application developed in Java. It provides an automated ticketing system for managing a parking lot.

## Installation and Setup

### Prerequisites

- Java Development Kit (JDK) installed (version 8 or above)
- Apache Maven installed (for building and managing dependencies)

### Build the Application

1. Clone the repository to your local machine.(git clone 'git repository link')
2. Build the application using maven.(maven clean install)
3. Run the application by running main class (i.e., GreenStitchApplication.java) in your IDE.

### How to use

1. In this application, data get's stored in in-memory database.
2. After running the application, it provides you an interactive command prompt based shell where commands can be typed in.
#### Below is list of command you can use :
1. create_parking_lot 6                                     (command to create parking lot of specific size.)
2. park KA-01-HH-1234 White                                 (command to park followed by registration number with colour of car.)
3. leave 4                                                  (command to empty slot followed by slot number.)
4. status                                                   (command to get complete status of parking lot.)
5. exit (command to terminate program.)
6. slot_number_for_registration_number regNum  (command to get slot no. for a specific registration no.)
7. slot_numbers_for_cars_with_colour col (command to get all slot for a specific colour of car)
8. registration_numbers_for_cars_with_colour col (command to get all registration no. for a specific colour of car)
