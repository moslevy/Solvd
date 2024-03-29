package com.solvd.townhall.models.people;

import com.solvd.townhall.enums.Taxes;
import com.solvd.townhall.interfaces.ITaxable;
import com.solvd.townhall.models.properties.Property;

import java.util.Date;

public class Employee extends Person {

    private int employeeId;
    private String position;

    public Employee(){

    }


    public Employee(int employeeId, String position) {
        this.employeeId = employeeId;
        this.position = position;
    }

    public Employee(String firstName, String lastName, int age, Date DOB, String SSN, int employeeId, String position) {
        super(firstName, lastName, age, DOB, SSN);
        this.employeeId = employeeId;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", position='" + position + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", DOB=" + DOB +
                ", SSN='" + SSN + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Employee employee = (Employee) o;

        if (employeeId != employee.employeeId) return false;
        return position != null ? position.equals(employee.position) : employee.position == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + employeeId;
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }

    @Override
    public float paymentDue(Property property) {
        float taxesOwed;
        switch (property.getPropertyType()) {

            case SINGLE_FAMILY, MULTI_FAMILY -> {
                taxesOwed = property.calculateTaxes(property, Taxes.RESIDENTIAL);
            }

            case COMMERCIAL, SHOPPING_MALL -> {
                taxesOwed = property.calculateTaxes(property, Taxes.COMMERCIAL);
            }

            case INDUSTRIAL -> {
                taxesOwed =  property.calculateTaxes(property, Taxes.INDUSTRIAL);
            }

            default -> throw new IllegalStateException("Unexpected value: " + property.getPropertyType());
        }
        return taxesOwed;
    }
}
