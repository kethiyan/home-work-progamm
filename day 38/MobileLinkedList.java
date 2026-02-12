public class MobileLinkedList
{
    Node head;

    // insert at head (Latest Launch)
    public void insertAtHead(int id, String brand, double price)
    {
        Node newNode = new Node(id, brand, price);
        newNode.next = head;
        head = newNode;
    }

    // insert at tail (Regular Stock)
    public void insertAtTail(int id, String brand, double price)
    {
        Node newNode = new Node(id, brand, price);

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
    }

    // display mobiles
    public void display()
    {
        if(head == null)
        {
            System.out.println("No mobiles available.");
            return;
        }

        Node temp = head;
        while(temp != null)
        {
            System.out.println("ID: " + temp.mobileId +
                               ", Brand: " + temp.brandName +
                               ", Price: " + temp.price);
            temp = temp.next;
        }
    }
}
