public class Car {

    @Inject
    public Engine engine;

    public void drive() {
        engine.start();
        System.out.println("Car is Running");
    }
}