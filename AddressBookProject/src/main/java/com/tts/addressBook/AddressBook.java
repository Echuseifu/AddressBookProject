package com.tts.addressBook;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {

    // how to insert the data in the address book,
    // how to connect the two tables
    // how to create arrylist
    // file


    // creating Arraylist
    private static ArrayList<Entry> addressBook;
    public static Scanner scanner = new Scanner(System.in);


    public AddressBook(){
        this.addressBook = new ArrayList<Entry>();
    }

    public void addEntry () {
        System.out.print("Please enter the new entry: ");

        System.out.println("First Name");
        String firstName = scanner.nextLine();
        System.out.println("Last Name");
        String lastName = scanner.nextLine();
        System.out.println("Phone Number");
        String phoneNumber = scanner.nextLine();
        System.out.println("Email Address");
        String emailAddress = scanner.nextLine();

        Entry entry = new Entry(firstName,lastName,phoneNumber,emailAddress);
        this.addressBook.add(entry);
        System.out.println("Added new entry");


    }

         // remove entry by emailAddress
    // look the email address and if it exist delete the address
    // if not return not found

    public void removeEntry() {
        System.out.println("please enter the email address to remove entry: ");
        String emailAddress = scanner.nextLine();
        boolean removeEntry = false;
        int i = 0;
        for(Entry entry: this.addressBook){

            if (entry.getEmailAddress().equalsIgnoreCase(emailAddress)){
                System.out.println("Delete the following entry: \n");
                entry.printAddressBook();/// method in Entry
                this.addressBook.remove(i);
                removeEntry = true;
            }

            i++;

        }
         if(!removeEntry){
             System.out.println("No Address found ");

         }


  }


    public void searchEntry() {
       System.out.println("how do you like to search your entry? ");
       // first name, last name, phone number, email address,

        boolean found= false;
        if(!this.addressBook.isEmpty()){
            System.out.println("1) First Name \n" +
                    "2) Last Name \n " +
                    "3) Phone Number \n" +
            "4) Email Address");

            System.out.println("Chose a search type: ");
             int searchType = scanner.nextInt();
            System.out.println("Enter your search");
            String searchQuery = scanner.next();

            switch (searchType){
                case 1:
                    for (Entry entry: this.addressBook){
                        if(entry.getFirstName().equalsIgnoreCase(searchQuery)){
                            found = true;
                            entry.printAddressBook();
                        }
                    }
                break;

                case 2:
                    for (Entry entry: this.addressBook){
                        if(entry.getLastName().equalsIgnoreCase(searchQuery)){
                            found = true;
                            entry.printAddressBook();
                        }
                    }
                break;

                case 3:
                    for (Entry entry: this.addressBook){
                        if(entry.getPhoneNumber().equalsIgnoreCase(searchQuery)){
                            found = true;
                            entry.printAddressBook();
                        }
                    }
                    break;

                case 4:
                    for (Entry entry: this.addressBook){
                        if(entry.getEmailAddress().equalsIgnoreCase(searchQuery)){
                            found = true;
                            entry.printAddressBook();
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid input. Please try again");
                    searchEntry();
                    break;
            }


        } else {
            System.out.println("This Address Book is empty. ");
        }

        if(!found){
            System.out.println("Did not find record with that entry");
        }

    }

    public  void printAddressBook() {
        System.out.println("You have " + addressBook.size() + " entry in your AddressBook");

//        for (int i = 0; i < addressBook.size(); i++) {
//            System.out.println((i + 1) + ". " + addressBook.get(i));
//        }
        for (Entry entry: this.addressBook) {
           entry.printAddressBook();
        }

    }

    public void deleteAddressBook() {

               this.addressBook.clear();
        System.out.println("Address book cleared!");
    }


    public void quit() {
        System.out.println("stop running the program  ");

    }
}