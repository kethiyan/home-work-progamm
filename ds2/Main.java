public class Main {
    public static void main(String[] args) {

        // Plain Pizza
        Pizza pizza1 = new PlainPizza();
        System.out.println("Description : " + pizza1.getDescription());
        System.out.println("Cost        : " + pizza1.getCost());

        // Pizza with Cheese
        Pizza pizza2 = new Cheese(new PlainPizza());
        System.out.println("\nDescription : " + pizza2.getDescription());
        System.out.println("Cost        : " + pizza2.getCost());

        // Pizza with Cheese + Mushroom
        Pizza pizza3 = new Mushroom(new Cheese(new PlainPizza()));
        System.out.println("\nDescription : " + pizza3.getDescription());
        System.out.println("Cost        : " + pizza3.getCost());

        // Pizza with Cheese + Mushroom + Olive
        Pizza pizza4 = new Olive(new Mushroom(new Cheese(new PlainPizza())));
        System.out.println("\nDescription : " + pizza4.getDescription());
        System.out.println("Cost        : " + pizza4.getCost());
    }
}