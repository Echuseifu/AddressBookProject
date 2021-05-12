package com.tts.addressBook;

import com.tts.addressBook.AddressBook;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {



    private static Scanner scanner = new Scanner(System.in);
    private static AddressBook myAddressBook = new AddressBook();


    public static void mainMenu() {
    boolean quite = false;

        do {
            System.out.println("What do you like to do?");
            System.out.println("\n Press");
            System.out.println("\t 1 - To Add an entry in the Address Book");
            System.out.println("\t 2 - To Remove an entry from the Address Book");
            System.out.println("\t 3 - To Search for a specific entry from the Address Book");
            System.out.println("\t 4 - To Print Address Book");
            System.out.println("\t 5 - To Delete Address Book");
            System.out.println("\t 6 = To Quit the program");
            int menuOption = scanner.nextInt();


            switch (menuOption) {
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
                    System.out.println("Exit program");
                    quite = true;

                    break;

                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }


        } while(!quite);

        // should be closed after the loop
        scanner.close();
    }


        public static void main(String[] args) {

            mainMenu();


        }
    }

