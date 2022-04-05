//@author Daniel St Andrews
//Created: 3/26/2022
//Purpose: Sorted doubly linked class for to be implemented by addressbook.

public class AGenericADTSortedList<E extends Comparable<E>> {

    //Empty head and tail of list
    Node<E> head;
    Node<E> tail;

    //Tracks the length / index of list
    int len;

    //DC
    public AGenericADTSortedList()
    {
        head = null;
        tail = null;
        this.len = 0;
    }

    //Adds a member to the list depending on the length and comparing the members.
    public void add(E member) {

        //No Members exist in the list, make head
        if(len == 0) {
            head = new Node(member, null, null);
            head.setPos(0);
            tail = head;
            len++;
            return;
        }
        else {
            Node temp;

            if(member.compareTo((E)head.getMember()) < 0) {

                //Make new head, set next to head, prev to null.
                temp = new Node(member, head, null);
                head.setPrev(temp);
                head = temp;
            }
            else {

                temp = head.getNext();
                while(temp != null) {

                    if(member.compareTo((E)temp.getMember()) <= 0) {

                        Node temp2 = new Node(member, temp, temp.getPrev());
                        temp.getPrev().setNext(temp2);
                        temp.setPrev(temp2);
                        len++;
                        return;
                    }
                    temp = temp.getNext();
                }

                //Add onto tail
                Node newNode = new Node(member, null, tail);
                tail.setNext(newNode);
                tail = newNode;

            }
            len++;
            return;
        }

    }

    // Delete a single element from the list
    public void delete(E member){

        if(len == 0 || member == null)
        {
            System.out.println("List is Empty, Item cannot be deleted.");
            return;
        }
        else
        {
            Node<E> temp = search(member);
            if(temp == null){
                System.out.println("Member is not in list. ");
                return;
            }
            else{
                if(member.compareTo(head.member) == 0){
                    head = temp.next;
                } //Makes sure not last node
                else if(temp.getNext() != null){
                    temp.next.previous = temp.previous;
                }
                else if(temp.getPrev() != null){
                    temp.previous.next = temp.next;
                }
            }
        }
        fixIndex(this.head);
        System.out.println("Deleted.");
        len--;
        return;
    }

    //Delete all entries from the list.
    public void makeEmpty() {
        Node<E> temp = new Node<E>();

        while(this.head != null){
            temp = this.head;
            this.head = this.head.next;
            temp = null;
        }
        len = 0;
    }

    //Searches the list in order and returns a node if it exists, and null if it doesnt.
    public Node<E> search(E member){

        Node<E> temp = head;
        //Checks to see if the head is the node being searched.
        if(member.compareTo(temp.getMember()) == 0){
            return temp;
        }
        //Node being searched isnt head, continue
        while(member.compareTo(temp.getMember()) != 0){

            if(member.compareTo(temp.getMember()) == 0)
            {
                return temp;
            }
            else{
                temp.setNext(temp.getNext());
            }
        }
        return null;
    }

    //Simply returns whether or not the head of the list has been initialized.
    public boolean isEmpty(){

        if(head == null)
        {
            return true;
        }
        else{
            return false;
        }
    }

    //Returns whether or not two objects are equal.
    public boolean equals(Node<E> head){
        Node<E> temp = this.head;
        Node<E> comp = head;

        while(temp != null) {
            if(temp.getMember() == comp.getMember())
            {
                temp.setNext(temp.getNext());
                comp.setNext(comp.getNext());
            }
            else if(temp.getMember() != comp.getMember())
            {
                return false;
            }
        }
        return true;
    }

    //Returns the numbers of members in the list
    public int numMembers(){
        return len;
    }

    //Traverses the list in order and converts everything to a string and prints it to the screen.
    public String toString(){

        //Makes sure index is correct for list before printing to screen.
        fixIndex(this.head);

        //Empty string var
        String temp = "";
        //Node for iterating
        Node curr = head;

        //Move through list adding members to temp
        while(curr != null)
        {
            temp += "Index " + curr.getPos() + "; " + curr.getMember().toString() + "\n";
            curr = curr.getNext();
        }

        //Returns built temp string
        return temp;
    }

    //Adjusts and sets the index for the list for continuity.
    public void fixIndex(Node<E> head){
        int temp = 0;
        Node<E> node = head;

        while(node != null){
            node.setPos(temp);
            node = node.next;
            temp++;
        }

    }
}
