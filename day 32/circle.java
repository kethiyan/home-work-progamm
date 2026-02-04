
package area.of.different.shapes;


public class circle extends Shape
{
     circle(double r) 
     {
        super(r);
    }

    void calculateArea() 
    {
        double area = 3.14 *value  * value;
        System.out.println("Area of Circle: " + area);
    }
}


