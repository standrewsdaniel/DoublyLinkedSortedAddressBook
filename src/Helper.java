//@author Daniel St Andrews
//Created: 3/26/2022
//Purpose: Helper method to test all methods from address book that implements generic doubly linked sorted list.
//         *This files tests all methods in the program across all classes.*

import java.io.*;
import java.util.*;

public class Helper {

    //General start function for testing all functionality.
    public static void start(){

        try {
            File in = new File("input.txt");
            Scanner reader = new Scanner(in);
            String[] tokens;

            Contact temp;
            Contact searchTest = new Contact("James", "Butt", "504-621-8927");
            AddressBook book = new AddressBook();

            //METHOD TESTING
            //Some methods are tested twice to demonstrate functionality, or where it makes sense to call them again.
            //  All methods have been called or are used in this helper function.

            //Read the entire file into the doubly linked list
            while(reader.hasNextLine()){
                String input = reader.nextLine();
                tokens = input.split(" ");
                temp = new Contact(tokens[0], tokens[1], tokens[2]);

                //INSERT TEST
                book.insert(temp);
            }

            System.out.println("Finished populating list.");

            boolean isEmpty;

            // ISEMPTY TEST
            isEmpty = book.isEmpty();
            if(isEmpty == true) {
                System.out.println("Address book is empty.");
            }
            else System.out.println("Address book has members and is not empty.");

            // SEARCH TEST
            Node<Contact> contNode;
            contNode = book.search(searchTest);
            if(contNode != null){
                System.out.println("Node Found, Printing...\n" + contNode.getMember().toString() + "\n");
            }
            else System.out.println("Query not found.");

            // TOSTRING TEST
            System.out.println(book.toString());

            // DELETE TEST
            book.delete(searchTest);

            // TOSTRING TEST
            System.out.println(book.toString());

            // NUMBER OF CONTACTS TEST
            int len = book.getLen();
            System.out.println("There are " + len + " entries in the list.");

            AddressBook searchMethods = new AddressBook();
            // SAME AREA CODES TEST
            searchMethods = book.sameArea("815");
            System.out.println(searchMethods.toString());

            // SAME LAST NAMES TEST
            searchMethods = book.sameLast("LastNameTest");
            System.out.println(searchMethods.toString());

            // MAKE EMPTY / DELETE ALL TEST
            book.makeEmpty();

            // NUMBER OF CONTACTS TEST
            len = book.getLen();
            System.out.println("There are " + len + " entries in the list.");

            //EQUALS TEST
            AddressBook compare = new AddressBook();
            boolean isEquals = book.equals(compare);
            if(isEquals == true){
                System.out.println("Lists are equal!");
            }
            else System.out.println("Lists are not equal.");
        }
        catch(Exception e){
            System.out.println("File not found. Exiting...");
        }
    }

    //Used for structure specified in instructions
    public static void otherStart(){
        AddressBook book = new AddressBook();
        readIn(book);
        deletePrint(book);

    }

    //Reads and populates list created in otherStart
    public static void readIn(AddressBook book){

        try{
            File in = new File("input.txt");
            Scanner reader = new Scanner(in);
            String[] tokens;

            Contact temp;

            //Read the entire file into the doubly linked list
            while(reader.hasNextLine()){
                String input = reader.nextLine();
                tokens = input.split(" ");
                temp = new Contact(tokens[0], tokens[1], tokens[2]);

                //INSERT
                book.insert(temp);
            }
        }
        catch(Exception e){
            System.out.println("File not found. Exiting...");
        }
    }

    //Tests delete and makeEmpty on otherStart declared AddressBook as well as does length test to verify delete modifies len.
    public static void deletePrint(AddressBook book){

        int len;

        Contact delTest = new Contact("James", "Butt", "504-621-8927");

        System.out.println(book.toString());

        book.delete(delTest);

        System.out.println(book.toString());

        len = book.getLen();
        System.out.println("There are " + len + " entries in the list.");

        book.makeEmpty();

        System.out.println(book.toString());

        len = book.getLen();
        System.out.println("There are " + len + " entries in the list.");

    }


}
