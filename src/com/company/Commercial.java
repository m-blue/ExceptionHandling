package com.company;

import java.text.NumberFormat;

/**
 * Inherits from the Customer class.
 * Calculates the cost by the amount of square footage.
 * Applies the discount if multiField is set to true.
 * Formats and displays the information inputted.
 */

public class Commercial extends Customer {

    private String commercialName;
    private boolean multiField = false;
    private double rate = 5.00;
    private double discount = 0.10; //percentage in decimal form

    public String getCommercialName() {
        return commercialName;
    }

    public void setCommercialName(String commercialName) {
        this.commercialName = commercialName;
    }

    public Commercial(String customerName, String customerPhone, String customerAddress, double squareFootage) {
        super(customerName, customerPhone, customerAddress, squareFootage);
    }


    public void CommercialRate(double _squareFootage){
        double total = _squareFootage / 1000 * rate;
        if(multiField == true){
            total -= total * discount;
        }
        Display(total);
    }
    public void isMultiField(String input){
        if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y")){
            multiField = true;
        }
        else if(input.equalsIgnoreCase("no") ||input.equalsIgnoreCase("n")){
            multiField = false;
        }
    }

    private void Display(double total){
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        System.out.println("Customer Name: " + super.getCustomerName());
        System.out.println("Customer Address: " + super.getCustomerAddress());
        System.out.println("Customer Phone Number: " + super.getCustomerPhone());
        System.out.println("Commercial Name: " + commercialName);
        System.out.println("Amount of Square Footage: " + super.getSquareFootage());
        System.out.println("Is Multi-property: " + (multiField ? "Yes" : "No"));
        System.out.println( "Weekly Charge: "+ nf.format(total));
    }
}
