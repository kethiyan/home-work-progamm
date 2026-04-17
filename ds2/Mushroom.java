class Mushroom extends PizzaDecorator {

    public Mushroom(Pizza pizza) {
        super(pizza);
    }

    public String getDescription() {
        return pizza.getDescription() + , Mushroom;
    }

    public double getCost() {
        return pizza.getCost() + 25.0;
    }
}