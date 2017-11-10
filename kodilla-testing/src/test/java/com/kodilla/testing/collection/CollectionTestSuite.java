package com.kodilla.testing.collection;

import com.kodilla.testing.collection.OddNumberExterminator;

import org.junit.*;


import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class CollectionTestSuite {
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suite: begin");
    }
    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite: end");
    }

    @ Before
    public void before(){
        System.out.println("Test case: begin");
    }
    @After
    public void after(){
        System.out.println("Test case: end");
    }
    @Test
    public void testOddNumbersExterminatorEmptyList(){
        //Given
        OddNumberExterminator oddNumberExterminator = new OddNumberExterminator();
        List<Integer> emptyList = new ArrayList<>();
        //When
        List<Integer> actual = oddNumberExterminator.exterminate(emptyList);
        System.out.println("Testing EmptyList");
        //Then
        Assert.assertTrue(actual == null);
    }
    @ Test
    public void testOddNumbersExterminatorNormalList(){
        //Given
        OddNumberExterminator oddNumberExterminator = new OddNumberExterminator();
        List<Integer> listToTest = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Integer> expected  = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10));
        //When
        List<Integer> actual = oddNumberExterminator.exterminate(listToTest);
        System.out.println("Testing normal List");
        //Then
        Assert.assertTrue(actual.equals(expected));
       // lub: Assert.assertArrayEquals(actual.toArray(), expected.toArray());
    }
    @ Test
    public void testOddNumbersExterminatorNormalListJ8(){
        //Given
        OddNumberExterminator oddNumberExterminator = new OddNumberExterminator();
        List<Integer> listToTest = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Integer> expected  = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10));
        //When
        List<Integer> actual = oddNumberExterminator.exterminateJ8(listToTest);
        System.out.println("Testing normal List(J8)");
        //Then
        Assert.assertTrue(actual.equals(expected));
        // lub: Assert.assertArrayEquals(actual.toArray(), expected.toArray());
    }
}
