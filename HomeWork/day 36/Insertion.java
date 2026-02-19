
package singly.linked.list;


public class Insertion 
{
    Node head;
    void insert(int data)
    {
        Node n=new Node(data);
        
        if(head==null)
        {
            head=n;
        }
         else
        {
            Node temp=head;
            while(temp.next!=null)
            {
                temp=temp.next;
             }
            temp.next=n;
         }
    }
    
    void delete(int del)
    {
        if(head==null)
        {
            System.out.println("list empty");
            return;  
        }
        if(head.data==del)
        {
          head=head.next;
            return;
        }
        Node temp=head;
        
        while(temp.next!=null&&temp.next.data!=del)
        {
            temp=temp.next;
        
        }
        if(temp.next == null)
        {
            System.out.println("Value not found");
        }
        else
        {
            temp.next = temp.next.next;
        }
        
      }
    
     void display()
    {
        Node temp = head;

        while(temp != null)
        {
            System.out.print(temp.data + " >> ");
            temp = temp.next;
        }

       
    }

      
}
