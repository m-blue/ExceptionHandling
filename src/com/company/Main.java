package com.company;

import java.util.Scanner;

/**
 * Asks the user to input their customer information depending
 * on which option customer type they chose.
 * Displays the information.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Commercial\n2. Residential\n3. Done");
        System.out.println("Please select choices 1 - 3 ");
        boolean isValid = false;
        while (!isValid){
            try {
                int input = scanner.nextInt();
                switch (input){
                    case 1:
                        isValid = true;
                        Commercial();
                        break;
                    case 2:
                        isValid = true;
                        Residential();
                        break;
                    case 3:
                        isValid = true;
                        break;
                    default:
                        System.out.println("Invalid Selection");
                        System.out.println();
                }


            }catch (Exception e){
                System.out.println("Error! couldn't recognize selection");
                return;
            }
        }
    }

    /**
     * Asks the user for their customer and commercial information
     * Creates an instance of the Commercial class
     */
    static void Commercial(){
        String name;
        String phoneNumber;
        String address;
        String sqrFt;
        Scanner comm = new Scanner(System.in);
        try {
            System.out.println("Enter the customer's name");
            name = comm.nextLine();
            System.out.println("Enter customer's phone number");
            phoneNumber = comm.nextLine();
            System.out.println("Enter customer's address");
            address = comm.nextLine();
            System.out.println("Enter the amount of square footage");
            sqrFt = comm.nextLine();
        }catch (Exception e){
            System.out.println("Error! Unable to recognize input");
            return;
        }

        double squareFootage = 0;
        try {
            squareFootage = Double.parseDouble(sqrFt);
        }catch (Exception e){
            System.out.println("Error! Couldn't parse the squareFootage into a double");
            return;
        }

        Commercial commercial = new Commercial(name,phoneNumber,address,squareFootage);

        System.out.println("Enter the commercial name");
        commercial.setCommercialName(comm.nextLine());
        System.out.println("Is it a multi-property? (Enter (y)es or (n)o)");
        String answer = comm.nextLine();
        commercial.isMultiField(answer);
        commercial.CommercialRate(squareFootage);
    }

    /**
     * Asks the user for customer and Residential information
     * Creates an instance of the Residential class
     */
    static void Residential(){
        String name;
        String phoneNumber;
        String address;
        String sqrFt;
        Scanner res = new Scanner(System.in);
        try {
            System.out.println("Enter the customer's name");
            name = res.nextLine();
            System.out.println("Enter customer's phone number");
            phoneNumber = res.nextLine();
            System.out.println("Enter customer's address");
            address = res.nextLine();
            System.out.println("Enter the amount of square footage");
            sqrFt = res.nextLine();
        }catch (Exception e){
            System.out.println("Error! Unable to recognize input");
            return;
        }

        double squareFootage;
        try {
            squareFootage = Double.parseDouble(sqrFt);
        }catch (Exception e){
            System.out.println("Error! Couldn't parse squareFootage into a double");
            return;
        }
        Residential residential = new Residential(name,phoneNumber,address,squareFootage);

        System.out.println("Is this a senior field? (Enter (y)es or (n)o)");
        String resAnswer = res.nextLine();
        residential.isSenior(resAnswer);
        residential.ResidentialRate(squareFootage);
    }
}
