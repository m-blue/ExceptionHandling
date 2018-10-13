package com.company;
import java.text.NumberFormat;

/**
 * Inherits from the Customer class.
 * Calculates the cost by the amount of square footage.
 * Applies the discount if senior is set to true.
 * Formats and displays the information inputted.
 */

public class Residential extends Customer {

    public Residential(String customerName, String customerPhone, String customerAddress, double squareFootage) {
        super(customerName, customerPhone, customerAddress, squareFootage);
    }

    double rate =  6.00;
    boolean senior = false;
    double discount = 0.15; // percentage in decimal form

    public void ResidentialRate(double _squareFootage) {
        double total = _squareFootage / 1000 * rate;
        if (senior == true) {
            total -= total * discount;
        }
        Display(total);
    }

    public void isSenior(String input){
        if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y")){
            senior = true;
        }
        else {
            senior = false;
        }
    }

    private void Display(double total){
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        System.out.println("Customer Name: " + super.getCustomerName());
        System.out.println("Customer Address: " + super.getCustomerAddress());
        System.out.println("Customer Phone Number: " + super.getCustomerPhone());
        System.out.println("Amount of Square Footage: " + super.getSquareFootage());
        System.out.println("Is Senior: " + (senior ? "Yes" : "No"));

        System.out.println( "Weekly Charge: "+ nf.format(total));
    }
}
