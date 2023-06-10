package com.kodilla.testing.shape;
import org.junit.jupiter.api.*;
@Nested
@DisplayName("Testy funkcji zawartych w ShapeCollector")
public class ShapeCollectorTest {
    private ShapeCollector shapeCollector;
    private Circle circle;
    private Rectangle rectangle;
    private Triangle triangle;

    @BeforeEach
    public void setUp() {
        shapeCollector = new ShapeCollector();
        circle = new Circle(5);
        rectangle = new Rectangle(3, 4);
        triangle = new Triangle(4,5);
        //System.out.println("Utworzono obiekty do testów");
    }


    @DisplayName(value = "Test addFigure()")
        @Test
        public void testAddFigure() {
            //Given
        shapeCollector.addFigure(circle);
        shapeCollector.addFigure(rectangle);
        shapeCollector.addFigure(triangle);
            //When ,Then
        Assertions.assertEquals(3, shapeCollector.getFiguresCount());
        System.out.println("Test addFigure() ok. ");
    }

    @DisplayName(value = "Test removeFigure()")
        @Test
        public void testRemoveFigure() {
            //Given
        shapeCollector.addFigure(circle);
        shapeCollector.addFigure(rectangle);
        shapeCollector.addFigure(triangle);
            //When
        boolean removed = shapeCollector.removeFigure(circle);
            //Then
        Assertions.assertTrue(removed);
        Assertions.assertEquals(2, shapeCollector.getFiguresCount());
        System.out.println("Test removeFigure() ok. ");
    }

    @DisplayName(value = "Test removeFigure()2")
        @Test
        public void testRemoveFigure_NotExistingFigure() {
            //Given
        shapeCollector.addFigure(circle);
            //When
        boolean removed = shapeCollector.removeFigure(rectangle);
            //Then
        Assertions.assertFalse(removed);
        Assertions.assertEquals(1, shapeCollector.getFiguresCount());
        System.out.println("Test removeFigure()2 ok.");
    }


    @DisplayName(value = "Test showFigures()")
        @Test
        public void testShowFigures() {
            //Given
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(rectangle);
            shapeCollector.addFigure(triangle);
            // When , Then
            // testuje jedynie wywołanie metody showFigures() bez porównywania wyników
            shapeCollector.showFigures();
        System.out.println("Test showFigures() ok.");
        }
    @DisplayName(value = "Test GetFigure()")
    @Test
    public void testGetFigure() {
        //Given
        shapeCollector.addFigure(circle);
        shapeCollector.addFigure(rectangle);
        shapeCollector.addFigure(triangle);
        //When
        Shape retrievedShape = shapeCollector.getFigure(1);
        //Then
        Assertions.assertEquals(rectangle, retrievedShape);
        System.out.println("Test GetFigure() ok.");
    }
    @AfterAll
    public static void afterAllTests() {
        System.out.println("Wszystkie testy zostały zakończone.");
    }
}


