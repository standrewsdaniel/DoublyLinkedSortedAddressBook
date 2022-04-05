//@author Daniel St Andrews
//Created: 3/26/2022
//Purpose: Create an address book backed by a generic sorted doubly linked list. Addressbook consists of
//          contact objects which then contain first name, last name, and phone number for correspondents.

public class AddressBook {

    Contact contact;
    AGenericADTSortedList<Contact> list;

    public AddressBook() {
        contact = new Contact();
        list = new AGenericADTSortedList<Contact>();
    }

    public AddressBook(Contact temp) {
        contact = temp;
        list = new AGenericADTSortedList<Contact>();
    }

    //Inserts a specified contact into the list. If list hasnt been built, uses contact passed from constructor
    public void insert(Contact temp) {
        if (list.head == null) {
            list.add(temp);
        } else {
            list.add(temp);
        }
    }

    //Returns the node of an item in the list, returns null if it does not exist.
    public Node<Contact> search(Contact temp) {
        return this.list.search(temp);
    }

    //Returns whether or not the AddressBook is empty
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public void makeEmpty() {
        this.list.makeEmpty();
    }

    public void delete(Contact temp) {
        this.list.delete(temp);
    }

    public int getLen() {
        return this.list.len;
    }

    //Returns all of the contacts in a doubly linked list that share the same area code.
    public AddressBook sameArea(String number) {
        Node<Contact> temp = this.list.head;
        AddressBook result = new AddressBook();
        String areaCode;

        while(temp!= null) {
            areaCode = temp.member.phoneNumber.substring(0,3);
            if (areaCode.equals(number)) {
                result.insert(temp.member);
            }
            temp = temp.next;
        }
        return result;
    }

    //Return list of all members who have the same last name.
    public AddressBook sameLast(String last){
        Node<Contact> temp = this.list.head;
        AddressBook result = new AddressBook();
        while(temp != null){
            if(temp.member.lastName.equals(last))
            {
                result.insert(temp.member);
            }
            temp = temp.next;
        }
        return result;
    }

    //Checks if two address books are equal to one another.
    public boolean equals(AddressBook temp) {
        if (temp.list.equals(this.list.head) == true) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return list.toString();
    }


}
