package com.kodilla.patterns2.decorator.pizza;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PizzaOrderTestSuite {

    @Test
    public void testBasicPizza() {
        Pizza basicPizza = new BasicPizza();

        assertEquals(15.0, basicPizza.getCost(), 0.01);
        assertEquals("Ciasto i sos pomidorowy z serem", basicPizza.getDescription());
    }

    @Test
    public void testMushroomsDecorator() {
        Pizza basicPizza = new BasicPizza();
        Pizza mushroomsPizza = new MushroomsDecorator(basicPizza);

        assertEquals(18.0, mushroomsPizza.getCost(), 0.01);
        assertEquals("Ciasto i sos pomidorowy z serem, pieczarki", mushroomsPizza.getDescription());
    }

    @Test
    public void testHamDecorator() {
        Pizza basicPizza = new BasicPizza();
        Pizza hamPizza = new HamDecorator(basicPizza);

        assertEquals(19.0, hamPizza.getCost(), 0.01);
        assertEquals("Ciasto i sos pomidorowy z serem, szynka", hamPizza.getDescription());
    }

    @Test
    public void testExtraCheeseDecorator() {
        Pizza basicPizza = new BasicPizza();
        Pizza extraCheesePizza = new ExtraCheeseDecorator(basicPizza);

        assertEquals(17.0, extraCheesePizza.getCost(), 0.01);
        assertEquals("Ciasto i sos pomidorowy z serem, dodatkowy ser", extraCheesePizza.getDescription());
    }

    @Test
    public void testDeluxePizza() {
        Pizza basicPizza = new BasicPizza();
        Pizza mushroomsPizza = new MushroomsDecorator(basicPizza);
        Pizza hamAndMushroomsPizza = new HamDecorator(mushroomsPizza);
        Pizza deluxePizza = new ExtraCheeseDecorator(hamAndMushroomsPizza);

        assertEquals(24.0, deluxePizza.getCost(), 0.01);
        assertEquals("Ciasto i sos pomidorowy z serem, pieczarki, szynka, dodatkowy ser", deluxePizza.getDescription());
    }
}
