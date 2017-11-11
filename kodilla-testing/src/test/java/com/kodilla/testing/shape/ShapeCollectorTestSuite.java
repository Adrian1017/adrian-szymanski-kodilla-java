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
        Assert.assertEquals(resultExpected,resultActual,0);
    }

    @Test
    public void testCircleField(){
        //Given
        Circle circle = new Circle(10);
        double resultExpected = Math.PI * 10 * 10;
        //When
        double  resultActual = circle.getField();
        //Then
        Assert.assertEquals(resultExpected,resultActual, 0);
    }
    @Test
    public void testTriangleField(){
        //Given
        Triangle triangle = new Triangle(10,10);
        double resultExpected = (10 * 10 )/2;
        //When
        double  resultActual = triangle.getField();
        //Then
        Assert.assertEquals(resultExpected, resultActual, 0);
    }


    @Test
    public void testAddTriangle() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Triangle triangle = new Triangle(10,10);
        //When
        shapeCollector.addFigure(triangle);
        //Then
        Assert.assertEquals(shapeCollector.getFigure(0),triangle);
    }
    @Test
    public void testAddCircle() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Circle circle = new Circle(10);
        //When
        shapeCollector.addFigure(circle);
        //Then
        Assert.assertEquals(shapeCollector.getFigure(0),circle);
    }
    @Test
    public void testAddSquare() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Square square = new Square(10);
        //When
        shapeCollector.addFigure(square);
        //Then
        Assert.assertEquals(shapeCollector.getFigure(0),square);
    }
    @Test
    public void testRemoveTriangle() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Triangle triangle = new Triangle(10,10);
        shapeCollector.addFigure(triangle);
        //When
        boolean result1 = shapeCollector.removeFigure(triangle);
        //Then
        Assert.assertTrue(result1);
    }
    @Test
    public void testRemoveCircle() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Circle circle = new Circle(10);
        shapeCollector.addFigure(circle);
        //When
        boolean result2 = shapeCollector.removeFigure(circle);
        //Then
        Assert.assertTrue(result2);
    }
    @Test
    public void testRemoveSquare() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Square square = new Square(10);
        shapeCollector.addFigure(square);
        //When
        boolean result3 = shapeCollector.removeFigure(square);
        //Then
        Assert.assertTrue(result3);
    }
    @Test
    public void testGetTriangle() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Triangle triangleExpected = new Triangle(10,10);
        shapeCollector.addFigure(triangleExpected);
        //When
        Triangle triangleActual = (Triangle) shapeCollector.getFigure(0);
        //Then
        Assert.assertEquals(triangleExpected,triangleActual);
    }
    @Test
    public void testGetCircle() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Circle circleExpected = new Circle(10);
        shapeCollector.addFigure(circleExpected);
        //When
        Circle circleActual = (Circle) shapeCollector.getFigure(0);
        //Then
        Assert.assertEquals(circleExpected, circleActual);
    }
    @Test
    public void testGetSquare() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Square squareExpected = new Square(10);
        shapeCollector.addFigure(squareExpected);
        //When
        Square squareActual = (Square) shapeCollector.getFigure(0);
        //Then
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

        //When
        String shapesName = shapeCollector.showFigures();
        //Then
        Assert.assertTrue(shapesName.equals(triangle.getShapeName()+ "\n" +circle.getShapeName()+"\n" +
        square.getShapeName() + "\n"));
    }

}