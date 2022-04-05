//@author Daniel St Andrews
//Created: 3/26/2022
//Purpose: Contact class that contains the information to be stored in contact object. Collection of these objects
//          make up the addressbook object.

public class Contact implements Comparable<Contact> {

    //PDMS / Locals
    String firstName;
    String lastName;
    String phoneNumber;

    //DC
    public Contact()
    {
        this.firstName = "";
        this.lastName = "";
        this.phoneNumber = "";
    }

    //NDC
    public Contact(String first, String last, String phone)
    {
        this.firstName = first;
        this.lastName = last;
        this.phoneNumber = phone;
    }

    //Overridden toString
    public String toString() {

        String temp = "";
        temp = this.firstName + " " + this.lastName + " " + this.phoneNumber;
        return temp;
    }

    //Overridden compareTo
    public int compareTo(Contact temp){

        if(temp.phoneNumber == this.phoneNumber && temp.lastName == this.lastName && temp.firstName == this.firstName)
        {
            return 1;
        }
        return 0;
    }

}
