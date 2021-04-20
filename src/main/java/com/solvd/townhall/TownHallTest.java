package com.solvd.townhall;

import com.solvd.townhall.TownHallTest;
import com.solvd.townhall.enums.Taxes;
import com.solvd.townhall.exceptions.ExceptionExample;
import com.solvd.townhall.exceptions.InvalidUserException;
import com.solvd.townhall.exceptions.PropertyFoundNullException;
import com.solvd.townhall.generics.Report;
import com.solvd.townhall.models.City;
import com.solvd.townhall.models.people.Citizen;
import com.solvd.townhall.models.people.Employee;
import com.solvd.townhall.models.people.Person;
import com.solvd.townhall.models.properties.Address;
import com.solvd.townhall.models.properties.Commercial;
import com.solvd.townhall.models.properties.Property;
import com.solvd.townhall.models.properties.Residential;
import com.solvd.townhall.models.taxes.Tax;
import com.solvd.townhall.models.vehicles.Car;
import com.solvd.townhall.models.vehicles.Conventional;
import com.solvd.townhall.models.vehicles.Truck;
import com.solvd.townhall.models.vehicles.Vehicle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class TownHallTest {
    private static final Logger logger = LogManager.getLogger(TownHallTest.class);
    private static ArrayList<Person> citizens = new ArrayList<>();
    private static ArrayList<Property> properties = new ArrayList<>();
    private static float taxesOwed;

    private Taxes taxesEnum;

    public TownHallTest(Taxes taxesEnum) {
        this.taxesEnum = taxesEnum;
    }


    public static void main(String[] args) {

        City city = new City("Los Angeles");

        // Create addresses with method located in City Class
        logger.info("Set Addresses by calling method created in this class" + TownHallTest.class);
        city.setAddresses(createAddresses().toArray(new Address[0]));


        // Create taxes

        city.setTaxes(createTaxes());
        List<Tax> taxes = new ArrayList<>(createTaxes());

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

        Person owner1 = new Citizen("John", "Smith", 68, new Date("04/03/2003"), "555-22-3333", city.getAddresses()[2], new Date("20/02/2009"));
        Person owner2 = new Employee("Erik", "Royal", 58, new Date("01/02/1982"), "555-22-1111", 34, "Cousil");

        Property commercialProperty = new Commercial(city.getAddresses()[0], owner1, 33344.3f, 56, false, vehiclesList1);
        Property residentialProperty = new Residential(city.getAddresses()[1], owner2, 345.1f, 3, true);

        citizens.add(owner1);
        citizens.add(owner2);

        properties.add(commercialProperty);
        properties.add(residentialProperty);

        String lastName = null;

        while (lastName != "X") {
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter citizen's LAST NAME below to search for taxes owned: (TO EXIT INSERT X)");
            lastName = input.nextLine();

            Property foundProperty = null;
            // Invoke findProperty method based on last name input by user.
            try {
                foundProperty = findProperty(lastName, properties);

                if (foundProperty instanceof Residential) {
                    taxesOwed = foundProperty.calculateTaxes(foundProperty,
                            Taxes.RESIDENTIAL);
                } else {
                    if (foundProperty instanceof Commercial)
                        taxesOwed = foundProperty.calculateTaxes(foundProperty,
                                Taxes.COMMERCIAL);
                }
            } catch (PropertyFoundNullException propertyFoundNullException) {
                propertyFoundNullException.printStackTrace();
                logger.error("Because you entered an invalid LAST Name property is NULL.");
            }


            // Use try/catch in case user inputs a LastName that is not found and property comes back as null.
            try {
                System.out.println("Property Owner: "
                        + foundProperty.getOwner().getFirstName()
                        + " " + foundProperty.getOwner().getLastName()
                        + " owes: " + "$" + taxesOwed);
            } catch (Exception e) {
                System.out.println("Property owner not found, please run the program again to continue.");
                e.printStackTrace();
            }

            try {
                ExceptionExample exceptionExample = new ExceptionExample();
                logger.fatal("PROPERTY NOT FOUND!!! PLEASE TRY AGAIN");
                exceptionExample.testInvalidUserException(foundProperty.getOwner().getFirstName(), foundProperty);
            } catch (InvalidUserException invalidUserException) {
                invalidUserException.printStackTrace();
            }

            try {
                ExceptionExample exceptionExample = new ExceptionExample();
                logger.error("Passed an error on purpose to show exception in console");
                exceptionExample.testException(0);
            } catch (Exception e) {
                e.printStackTrace();
            }

            Report report = new Report(foundProperty.getOwner(), foundProperty.getAddress(), foundProperty.getYearlyTaxes());
            logger.info("Full taxes Report " + report.getClass().toString());
            System.out.println(report.toString());
        }
    }

    // Method to find property and calculate taxes based on type of property and taxes associated.
    public static Property findProperty(String lastName, ArrayList<Property> properties) throws PropertyFoundNullException {
        Property foundProperty = null;
        int i = 0;
        while (foundProperty == null && i < properties.size()) {
            if (properties.get(i).getOwner().getLastName().equals(lastName)) {
                foundProperty = properties.get(i);
            } else {
                i++;
            }
        }
        if (foundProperty != null){
            return foundProperty;
        }else{
            throw new PropertyFoundNullException("Property is NULL.");
        }

    }

    private static ArrayList<Address> createAddresses() {
        ArrayList<Address> addresses = new ArrayList<>();
        addresses.add(new Address(5104, "Nagle Ave", "Sherman Oaks", "CA", "91423"));
        addresses.add(new Address(5555, "Nazca", "Vicente Lopez", "Bs As", "ATY 223 ER"));
        addresses.add(new Address(4321, "Cuba", "CABA", "Bs As", "AEH1428"));
        return addresses;
    }


    private static LinkedHashSet<Tax> createTaxes() {
        LinkedHashSet<Tax> taxes = new LinkedHashSet<>();
        TownHallTest residentialTax = new TownHallTest(Taxes.RESIDENTIAL);
        TownHallTest commercialTax = new TownHallTest(Taxes.COMMERCIAL);
//        taxes.add(new ResidentialTax(2f, 1.4f, true, 0.78f, 0.1f));
//        taxes.add(new CommercialTax(2f, 1, false, 0.2f, 3.4f, 1.2f));
        return taxes;
    }
}


//// Printing out the creation of generics list.
//        logger.debug("Created debug list to show generics with Lists" + MyGenericClass.class);
//        System.out.println("Printing list of Strings and Integers of generic created class " + MyGenericClass.class);
//
//        // Added Strings to list
//        listsOfStrings.add("Moses");
//        listsOfStrings.add("Alan");
//        listsOfStrings.add("Jose");
//        listsOfStrings.add("Eric");
//        listsOfStrings.add("Pia");
//        // Printing list of Strings
//        System.out.println(listsOfStrings);
//
//        // Added Integers to list
//        listOfInts.add(101);
//        listOfInts.add(102);
//        listOfInts.add(103);
//        listOfInts.add(104);
//        listOfInts.add(105);
//        // Printing list of ints
//        System.out.println(listOfInts);
//
//        // Printing out the creation of generics with Key Value pairs.
//        logger.info("Printing Key/Value pairs with generics classes" + TownHallTest.class);
//        System.out.println(genericClass21.getK() + "\t" + genericClass21.getV());
//        System.out.println(genericClass22.getK() + "\t" + genericClass22.getV());
//
//        logger.debug("DEBUG from:  " + TownHallTest.class);
////        logger.trace("[TRACE] We've just greeted the user!");
////        logger.debug("[DEBUG] We've just greeted the user!");
////        logger.info("[INFO] We've just greeted the user!");
////        logger.warn("[WARN] We've just greeted the user!");
////        logger.error("[ERROR] We've just greeted the user!");
////        logger.fatal("[FATAL] We've just greeted the user!");