package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.ExecuteSaySomething;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.person.People;
import com.kodilla.stream.reference.FunctionalCalculator;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {

        Processor processor = new Processor();
        ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();
        processor.execute(executeSaySomething);
        processor.execute( ()-> System.out.println("Hello world!"));

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);


        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("hello world", text -> text.toUpperCase());
        poemBeautifier.beautify("hello world", text -> text.toUpperCase() + " of Lambda".toUpperCase());
        poemBeautifier.beautify("hello world", text -> text.replaceAll("world","lambda").toUpperCase());
        poemBeautifier.beautify("hello world", text -> "***" + text.toUpperCase()+ "***");


        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);

        People.getList().stream()
                .map(String::toUpperCase)
                .filter(s -> s.length() > 11)
                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
                .filter(s -> s.substring(0, 1).equals("M"))
                .forEach(System.out::println);


            BookDirectory theBookDirectory = new BookDirectory();
            theBookDirectory.getList().stream()
                    .filter(book -> book.getYearOfPublication() > 2005)
                    .forEach(System.out::println);

        BookDirectory theBookDirectory2 = new BookDirectory();
        List<Book> theResultListOfBooks = theBookDirectory2.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toList());

        System.out.println("# elements: " + theResultListOfBooks.size());
        theResultListOfBooks.stream()
                .forEach(System.out::println);

        BookDirectory theBookDirectory3 = new BookDirectory();

        Map<String, Book> theResultMapOfBooks = theBookDirectory3.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toMap(Book::getSignature, book -> book));

        System.out.println("# elements: " + theResultMapOfBooks.size());
        theResultMapOfBooks.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

        BookDirectory theBookDirectory4 = new BookDirectory();
        String theResultStringOfBooks = theBookDirectory4.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));

        System.out.println(theResultStringOfBooks);

        //****Zadanie: funkcyjny spacer po liście użytkowników forum****//
        /* odfiltruje tylko tych użytkowników, którzy są mężczyznami
        odfiltruje tylko tych użytkowników, którzy mają co najmniej 20 lat
        odfiltruje tylko tych użytkowników, którzy mają co najmniej jeden opublikowany post*/

        System.out.println("\nZadanie: funkcyjny spacer po liście użytkowników forum");
        Forum forum = new Forum();
        Map<Integer, ForumUser> theResultMapOfForumUser = forum.getUserList().stream()
                .filter( user -> user.getSex() == 'M')
                .filter( user -> user.getUserBirthday().isBefore(LocalDate.now().minusYears(20)))
                .filter( user -> user.getNumberOfPosts() > 0)
                .collect(Collectors.toMap((ForumUser::getUserId), ForumUser -> ForumUser));

          theResultMapOfForumUser.entrySet().stream()
                  .map(entry -> entry.getValue())
                  .forEach(System.out::println);

    }
}