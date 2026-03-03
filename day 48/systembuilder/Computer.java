
package systembuilder;


public class Computer 
{
    private String cpu;
    private String RAM;
    private String HDD;
    private String Graphics;

    public Computer(Builder builder)
    {
        this.cpu = builder.cpu;
        this.RAM = builder.RAM;
        this.HDD = builder.HDD;
        this.Graphics = builder.Graphics;
    }
    
    static class Builder
    {
      private String cpu;
      private String RAM;
      private String HDD;
      private String Graphics;

        Builder() 
        {
            
        }

        public Builder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder setRAM(String RAM) {
            this.RAM = RAM;
          return this;
        }

        public Builder setHDD(String HDD) {
            this.HDD = HDD;
          return this;
        }

        public Builder setGraphics(String Graphics) {
            this.Graphics = Graphics;
          return this;
        }
        public Computer build()
       {
          return new Computer(this); 
       }
       
    }
    @Override
    public String toString()
    {
         return "CPU: " + cpu +
                "\nRAM: " + RAM +
                "\nHDD: " + HDD +
                "\nGraphics: " + Graphics;
         
    }
   
    
    
}
