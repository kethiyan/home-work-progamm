class Olive extends PizzaDecorator {

    public Olive(Pizza pizza) {
        super(pizza);
    }

    public String getDescription() {
        return pizza.getDescription() + ", Olive";
    }

    public double getCost() {
        return pizza.getCost() + 20.0;
    }
}