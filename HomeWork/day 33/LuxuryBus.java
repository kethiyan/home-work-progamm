
package transport.management;
public class LuxuryBus extends Transport
{
    void calculateFare()
    {
        fare = (distance * 10) + 200;
    }
}
