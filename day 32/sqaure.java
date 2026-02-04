
package area.of.different.shapes;



class Square extends Shape
{

    Square(double s) {
        super(s);
    }

    void calculateArea() {
        double area = value * value;
        System.out.println("Area of Square: " + area);
    }
}

