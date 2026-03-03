
package systembuilder;

public class SystemBuilder 
{


    public static void main(String[] args)
    {
      
      Computer cm = new Computer.Builder().setCpu("Intel i7").setRAM("16GB").setHDD("1TB").setGraphics("NVIDIA RTX").build();
      Computer cm1 = new Computer.Builder().setCpu("Intel i3").setRAM("8GB").setHDD("512GB").setGraphics("INBuild").build();
      
      
        System.out.println(cm);
        System.out.println(cm1);
      
         
     
    
}
}
