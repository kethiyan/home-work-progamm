public class Main
{
    public static void main(String[] args)
    {
        DoublyLinkedList list = new DoublyLinkedList();

        list.insertEnd(10);
        list.insertEnd(20);
        list.insertEnd(40);
        list.insertEnd(50);

        list.insertAtPosition(30,3);

        list.display();
    }
}
