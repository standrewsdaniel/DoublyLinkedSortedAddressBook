//@author Daniel St Andrews
//Created: 3/26/2022
//Purpose: Generic node class for use in sorted doubly linked list generic class.

public class Node<E> {

    //PDMS
    public E member;
    public Node<E> previous;
    public Node<E> next;
    public int index;

    //DC
    public Node(){
        this.next = null;
        this.previous = null;
        this.member = null;
        this.index = 0;
    }


    //NDC
    public Node(E temp, Node next, Node prev)
    {
        this.next = next;
        this.previous = prev;
        this.member = temp;
        this.index = 0;
    }

    //~~~~~~~~~~~Getters and setters~~~~~~~~~~~

    //Returns current member
    public E getMember()
    {
        return member;
    }

    //Sets current member
    public void setMember(E member)
    {
        this.member = member;
    }

    //Gets next node
    public Node getNext()
    {
        return next;
    }

    //Sets next node
    public void setNext(Node node)
    {
        this.next = node;
    }

    //Gets previous node
    public Node getPrev()
    {
        return previous;
    }

    //Sets previous node
    public void setPrev(Node node)
    {
        this.previous = node;
    }

    //Gets index
    public int getPos(){return this.index;};

    //Sets index
    public void setPos(int pos){this.index = pos;};

}
