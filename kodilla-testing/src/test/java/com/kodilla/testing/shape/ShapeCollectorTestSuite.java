package com.kodilla.testing.shape;

import org.junit.*;

//Test suite for classes of Forum
public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }


    @Test
    public void testSquareField(){
        //Given
        Square square = new Square(10);
        double resultExpected = 10 * 10;
        //When
        double  resultActual = square.getField();
        //Then
        Assert.assertTrue(resultExpected ==resultActual);
    }

    @Test
    public void testCircleField(){
        //Given
        Circle circle = new Circle(10);
        double resultExpected = 3.14159 * 10 * 10;
        //When
        double  resultActual = circle.getField();
        //Then
        Assert.assertTrue(resultExpected ==resultActual);
    }
    @Test
    public void testTriangleField(){
        //Given
        Triangle triangle = new Triangle(10,10);
        double resultExpected = (10 * 10 )/2;
        //When
        double  resultActual = triangle.getField();
        //Then
        Assert.assertTrue(resultExpected ==resultActual);
    }

    @Test
    public void testAddShape() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Triangle triangle = new Triangle(10,10);
        Circle circle = new Circle(10);
        Square square = new Square(10);
        //When
        shapeCollector.addFigure(triangle);
        shapeCollector.addFigure(circle);
        shapeCollector.addFigure(square);

        //Then
        Assert.assertEquals(shapeCollector.getFigure(0),triangle);
        Assert.assertEquals(shapeCollector.getFigure(1),circle);
        Assert.assertEquals(shapeCollector.getFigure(2),square);
    }

    @Test
    public void testRemoveShape() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Triangle triangle = new Triangle(10,10);
        Circle circle = new Circle(10);
        Square square = new Square(10);
        shapeCollector.addFigure(triangle);
        shapeCollector.addFigure(circle);
        shapeCollector.addFigure(square);

        //Then
        boolean result1 = shapeCollector.removeFigure(triangle);
        boolean result2 = shapeCollector.removeFigure(circle);
        boolean result3 = shapeCollector.removeFigure(square);
        //Then
        Assert.assertTrue(result1);
        Assert.assertTrue(result2);
        Assert.assertTrue(result3);
    }
    @Test
    public void testGetShape() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Triangle triangleExpected = new Triangle(10,10);
        Circle circleExpected = new Circle(10);
        Square squareExpected = new Square(10);
        shapeCollector.addFigure(triangleExpected);
        shapeCollector.addFigure(circleExpected);
        shapeCollector.addFigure(squareExpected);

        //Then
        Triangle triangleActual = (Triangle) shapeCollector.getFigure(0);
        Circle circleActual = (Circle) shapeCollector.getFigure(1);
        Square squareActual = (Square) shapeCollector.getFigure(2);
        //Then
        Assert.assertEquals(triangleExpected,triangleActual);
        Assert.assertEquals(circleExpected, circleActual);
        Assert.assertEquals(squareExpected,squareActual);
    }
    @Test
    public void testShowShape() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Triangle triangle = new Triangle(10,10);
        Circle circle = new Circle(10);
        Square square = new Square(10);
        shapeCollector.addFigure(triangle);
        shapeCollector.addFigure(circle);
        shapeCollector.addFigure(square);

        //Then
        String shapesName = shapeCollector.showFigures();
        //Then
        Assert.assertTrue(shapesName.equals(triangle.getShapeName()+circle.getShapeName()+
        square.getShapeName()));
    }

}