package com.tts.addressBook;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressBook {

    // how to insert the data in the address book,
    // how to connect the two tables
    // how to create arraylist
    // file...try to delete from file
    // error handling
    // validation
    // insert in to file


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
        System.out.println("Phone Number (###-###-####/###.###.####/ ### ### ####)");
        String phoneNumber = scanner.nextLine();

        Pattern pat = Pattern.compile("^(\\d{3}[- . \\ ]?){2}\\d{4}$");
        Matcher match = pat.matcher(phoneNumber);

        while(match.matches() != true) {
            System.out.println("Wrong format, please try again.");
            phoneNumber = scanner.next();
            match = pat.matcher(phoneNumber);
        }



        System.out.println("Email Address");
        String emailAddress = scanner.nextLine();
// to validate the email address
        // used for to perform all types of text search and text replace operations
        // Pattern.compile()method: create the pattern
        // mather() method used to search for the pattern, it returns
        // a Matcher object which contains information about the search that was performed
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,3}$");// the last 3 indicate 3 letter after . like .com
        Matcher matcher= pattern.matcher(emailAddress);

       while (matcher.matches() != true){
            System.out.println("wrong format, try again.");
            emailAddress = scanner.nextLine();// for the second try
       matcher = pattern.matcher(emailAddress);
       }


        Entry entry = new Entry(firstName, lastName, phoneNumber, emailAddress);
        this.addressBook.add(entry);
        System.out.println("Added new entry");

        // create file, save file in text format
//        System.out.println("saving contact " + firstName + " " + lastName + ": " + emailAddress + " : " + phoneNumber);
        try (PrintWriter pw = new PrintWriter(new FileWriter("file.txt", true))) {
            pw.println("First and Last name: "
                    + firstName + " " + lastName + ", " +
                    "Phone Number:  "
                    + phoneNumber + ", " +
                    "Email Address: " + emailAddress );
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }





    // remove entry by emailAddress
         // look the email address and if it exist delete the address
         // if not return not found

    public void removeEntry() {
        System.out.println("please enter the email address to remove entry: ");
        String emailAddress = scanner.nextLine();
//        boolean removeEntry = false;
        int i = 0;
        for (Entry entry : this.addressBook) {

            if (entry.getEmailAddress().equalsIgnoreCase(emailAddress)) {
                System.out.println("Delete the following entry: \n");
                entry.printAddressBook();/// method in Entry
                this.addressBook.remove(i);
//                removeEntry = true;
                return;
            }
            i++;

        }
//        if (!removeEntry) {
//            System.out.println("No Address found ");
//           }

        System.out.println("No contact with Email Address " + emailAddress + " was found.\n");
    }


    public void searchEntry() {
       System.out.println("how do you like to search your entry? ");
       // first name, last name, phone number, email address,

        boolean found= false;
        if(!this.addressBook.isEmpty()){
            System.out.println("1) First Name \n" +
                    "2) Last Name \n" +
                    "3) Phone Number \n" +
                    "4) Email Address \n");

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





}