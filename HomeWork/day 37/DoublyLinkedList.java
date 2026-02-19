public class DoublyLinkedList
{
    Node head;

   
    public void insertEnd(int data)
    {
        Node newNode = new Node(data);

        if(head == null)
        {
            head = newNode;
            return;
        }

        Node temp = head;
        while(temp.next != null)
        {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
    }

    
    public void insertAtPosition(int data,int pos)
    {
        Node newNode = new Node(data);

        if(pos == 1)
        {
            newNode.next = head;
            if(head != null)
                head.prev = newNode;
            head = newNode;
            return;
        }

        Node temp = head;
        for(int i=1;i<pos-1 && temp!=null;i++)
        {
            temp = temp.next;
        }

        if(temp == null)
            return;

        newNode.next = temp.next;

        if(temp.next != null)
            temp.next.prev = newNode;

        temp.next = newNode;
        newNode.prev = temp;
    }

    
    public void display()
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}
