package com.example.hw3.townhallinterfaces;

import com.example.hw3.townhallinterfaces.exceptions.ExceptionExample;
import com.example.hw3.townhallinterfaces.models.people.Citizen;
import com.example.hw3.townhallinterfaces.models.people.Employee;
import com.example.hw3.townhallinterfaces.models.people.Person;
import com.example.hw3.townhallinterfaces.models.properties.Address;
import com.example.hw3.townhallinterfaces.models.properties.Commercial;
import com.example.hw3.townhallinterfaces.models.properties.Property;
import com.example.hw3.townhallinterfaces.models.properties.Residential;
import com.example.hw3.townhallinterfaces.models.taxes.CommercialTax;
import com.example.hw3.townhallinterfaces.models.taxes.ResidentialTax;
import com.example.hw3.townhallinterfaces.models.taxes.Tax;
import com.example.hw3.townhallinterfaces.models.vehicles.Car;
import com.example.hw3.townhallinterfaces.models.vehicles.Conventional;
import com.example.hw3.townhallinterfaces.models.vehicles.Truck;
import com.example.hw3.townhallinterfaces.models.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TownHallTest {

    private static ArrayList<Person> citizens = new ArrayList<>();
    private static ArrayList<Property> properties = new ArrayList<>();
    private static float taxesOwed;

    public static void main(String[] args) {
        Tax residentialTax = new ResidentialTax(2f, 1.4f, true, 0.78f, 0.1f);
        Tax commercialTax = new CommercialTax(2f, 1, false, 0.2f, 3.4f, 1.2f);

        // Create a few addresses
        Address addressCitizen1 = new Address(1234, "Ventura Blvd", "Tarzana", "CA", "91356");
        Address addressProperty1 = new Address(5555, "Nazca", "Vicente Lopez", "Bs As", "ATY 223 ER");
        Address addressCitizen2 = new Address(9842, "Nagle Ave", "Sherman Oaks", "CA", "91423");
        Address addressProperty2 = new Address(4321, "Cuba", "CABA", "Bs As", "AEH1428");

        // Create 2 vehicle lists
        List<Vehicle> vehiclesList1 = new ArrayList<>();
        List<Vehicle> vehiclesList2 = new ArrayList<>();

        // Create cars to add to vehicle lists.
        Car car1 = new Car("Renault", "Duster", "OPQ4444", 4.4f, "Black", false);
        Car car2 = new Car("Tesla", "Model X", "AE 555 QR", 2f, "Grey", true);
        Truck truck1 = new Truck("Scania", "F1", "AA 454 QF", 16, false);
        Conventional heavyConventional = new Conventional("Volvo", "VL2020", "AE 456 OP", 3);

        // Add create vehicles to vehicle lists
        vehiclesList1.add(truck1);
        vehiclesList1.add(heavyConventional);
        vehiclesList2.add(car1);
        vehiclesList2.add(car2);

        Person owner1 = new Citizen("John", "Smith", new Date("04/03/2003"), "555-22-3333", addressCitizen1, new Date("20/02/2009"));
        Person owner2 = new Employee("Erik", "Royal", new Date("01/02/1982"), "555-22-1111", 34, "Cousil");

        Property commercialProperty = new Commercial(addressProperty1, owner1, 33344.3f, 56, false, vehiclesList1);
        Property residentialProperty = new Residential(addressProperty2, owner2, 345.1f, 3, true);

        citizens.add(owner1);
        citizens.add(owner2);

        properties.add(commercialProperty);
        properties.add(residentialProperty);

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter citizen's LAST NAME below to search for taxes owned:");
        String lastName = input.nextLine();

        // Invoke findProperty method based on last name input by user.
        Property foundProperty = findProperty(lastName, properties);
        if (foundProperty instanceof Residential) {
            taxesOwed = foundProperty.calculateTaxes(foundProperty, residentialTax);
        } else {
            if (foundProperty instanceof Commercial)
                taxesOwed = foundProperty.calculateTaxes(foundProperty, commercialTax);
        }
        // Use try/catch in case last has no property and comes back as null.
        try {
            System.out.println("Property Owner: "
                    + foundProperty.getOwner().getFirstName()
                    + " " + foundProperty.getOwner().getLastName()
                    + " owes: " + "$" + taxesOwed);
        } catch (Exception e) {
            System.out.println("Property owner not found, please run the program again to continue.");
        }

        try{
            ExceptionExample exceptionExample = new ExceptionExample();
            exceptionExample.testException(0);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    // Method to find property and calculate taxes based on type of property and taxes associated.
    public static Property findProperty(String lastName, ArrayList<Property> properties) {
        Property foundProperty = null;
        int i = 0;
        while (foundProperty == null && i < properties.size()) {
            if (properties.get(i).getOwner().getLastName().equals(lastName)) {
                foundProperty = properties.get(i);

            } else {
                i++;
            }
        }
        return foundProperty;
    }

}
