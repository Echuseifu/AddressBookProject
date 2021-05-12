package com.tts.phoneBook;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PhoneBook {

    public static void main(String[] args) {
        displayMenu();
    }


    // call contact
    public static void callContact(String name) {

        String s[] = findNumber(name);
        if(s != null){
            System.out.println("calling " + name + " at " + s[1]);
        } else {
            System.out.println("No person found named " + name);
        }
    }



    // save contact
    public static void saveContact(String name, long number) {
        System.out.println("saving contact " + name + ": " + number);
//
//        File file = new File("file.text");

//        try {
//
//            if (!file.exists())
//                file.createNewFile();
////        // enable us to write on our file
//            // this one override what we inserted everytime
////             PrintWriter pw = new PrintWriter(file);
////            /// this does not override out input
//        PrintWriter pw = new PrintWriter(new FileWriter(file,true));
//            pw.println(name + ": " + number);
////            pw.close();
//        } catch (IOException e){
//            System.out.println(e.getMessage());
//        }

        try (PrintWriter pw = new PrintWriter(new FileWriter("file.txt", true))) {
            pw.println(name + ": " + number);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }


    // find phone number
    public static String[] findNumber(String name) {

        try (Scanner input = new Scanner(new File("file.txt"))) {
            String [] s = new String[0];

            boolean foundPerson = false;
            while (input.hasNextLine()) {
                // splitting the string character into before and after the colon
                s = input.nextLine().split(":");
                if (s[0].equals(name)) {
                    System.out.println("The number associated with " + name + " is " + s[1]);
                    foundPerson = true;
                    break;// help to break the while loop to break
                }
            }
            if (!foundPerson) {
                System.out.println("could not find " + name);
                s = null;
            }
            return s;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }



    public static void displayMenu() {

        try (Scanner input = new Scanner(System.in)){
            String name;

        do {
            System.out.println("What would like to do?(1, 2, 3...etc)");
            System.out.println("\t 1 - call Contact");
            System.out.println("\t 2 - save contact");
            System.out.println("\t 3 - Find Number");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n who would you like to call (Firstname Lastname)");
                    name = input.nextLine();
                    callContact(name);
                    break;

                case 2:
                    System.out.println("\n what is the name of the person you would like to save? (Firstname Lastname)");
                    name = input.nextLine();

                    System.out.println("\n what is the phone number of the person you are saving? (1111111111)");
                    long number = input.nextLong();
                    input.nextLine();
                    saveContact(name, number);
                    break;

                case 3:
                    System.out.println("\n what is the name of the person whose phone number are searching? (Firstname Lastname)");
                    findNumber(input.nextLine());

                    break;
                default:
                    break;
            }

//            input.close();

            System.out.println("Do you wish to perform another action? (Y/N)");
//            if(input.next().toLowerCase().charAt(0) == 'Y')
            if(input.next().toLowerCase().charAt(0) != 'y')
                break;
        } while(true);
        } catch (Exception e){
            System.out.println(e.getMessage());

        }

    }
}