
package area.of.different.shapes;


abstract class Shape 
{
    double value;
    
    shape(double value)
    {
        this.value=value;
    }
    
    abstract void calculateArea();
}
