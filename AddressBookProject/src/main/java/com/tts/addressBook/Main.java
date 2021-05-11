package com.tts.addressBook;

import com.tts.addressBook.AddressBook;

import java.util.Scanner;

public class Main {

    // how to insert the data in the address book,
    // how to connect the two tables
    private static Scanner scanner = new Scanner(System.in);
    private static AddressBook myAddressBook = new AddressBook();


    public static void mainMenu() {

        System.out.println("What do you like to do?");
        System.out.println("\n Press");
        System.out.println("\t 1 - To Add an entry in the Address Book");
        System.out.println("\t 2 - To Remove an entry from the Address Book");
        System.out.println("\t 3 - To Search for a specific entry from the Address Book");
        System.out.println("\t 4 - To Print Address Book");
        System.out.println("\t 5 - To Delete Address Book");
        System.out.println("\t 6 = To Quit the program");
        int menuOption = scanner.nextInt();

        switch (menuOption){
            case 1:
                myAddressBook.addEntry();
                break;

            case 2:
                myAddressBook.removeEntry();
                break;

            case 3:
                myAddressBook.searchEntry();
                break;

            case 4:
                myAddressBook.printAddressBook();
                break;

            case 5:
                myAddressBook.deleteAddressBook();
                break;

            case 6:
                System.out.println(0);
            default:
                System.out.println("Invalid input. Please try again.");
                break;
        }
// to do the program again
//        mainMenu();

    }



        public static void main(String[] args) {

            mainMenu();


        }
    }

