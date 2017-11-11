package com.kodilla.testing.forum.statistics;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsTestSuite {

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
    public void testcalculateAdvStatisticsPost0User0() {
        //Given
        double postNumber = 0;
        List<String> namesList = new ArrayList<>();
        double userPostsAverageExpected = postNumber / namesList.size();
        Statistics statistics = mock(Statistics.class);
        when(statistics.postsCount()).thenReturn((int)postNumber);
        when(statistics.usersNames()).thenReturn(namesList);
        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(statistics);
        //When
        double userPostsAverageActual = forumStatistics.getUserPostsAverage();
        //Then
        Assert.assertEquals(userPostsAverageExpected, userPostsAverageActual, 0);
    }

    @Test
    public void testcalculateAdvStatisticsPost1000User100() {
        //Given
        double postNumber = 1000;
        List<String> namesList = new ArrayList<>();
        for( int i = 0; i <100; i++)
        {
          namesList.add("Testman");
        }
        double userPostsAverageExpected = postNumber / namesList.size();
        Statistics statistics = mock(Statistics.class);
        when(statistics.postsCount()).thenReturn((int)postNumber);
        when(statistics.usersNames()).thenReturn(namesList);
        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(statistics);
        //When
        double userPostsAverageActual = forumStatistics.getUserPostsAverage();
        //Then
        Assert.assertEquals(userPostsAverageExpected, userPostsAverageActual, 0);
    }

    @Test
    public void testcalculateAdvStatisticsPost0User100() {
        //Given
        double postNumber = 0;
        List<String> namesList = new ArrayList<>();
        for( int i = 0; i <100; i++)
        {
            namesList.add("Testman");
        }
        double userPostsAverageExpected = postNumber / namesList.size();
        Statistics statistics = mock(Statistics.class);
        when(statistics.postsCount()).thenReturn((int)postNumber);
        when(statistics.usersNames()).thenReturn(namesList);
        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(statistics);
        //When
        double userPostsAverageActual = forumStatistics.getUserPostsAverage();
        //Then
        Assert.assertEquals(userPostsAverageExpected, userPostsAverageActual, 0);
    }
    @Test
    public void testcalculateAdvStatisticsUser100Comments0() {
        //Given
        double commentsNumber = 0;
        List<String> namesList = new ArrayList<>();
        for( int i = 0; i <100; i++)
        {
            namesList.add("Testman");
        }
        double userCommentsAverageExpected = commentsNumber / namesList.size();
        Statistics statistics = mock(Statistics.class);
        when(statistics.commentsCount()).thenReturn((int)commentsNumber);
        when(statistics.usersNames()).thenReturn(namesList);
        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(statistics);
        //When
        double userCommentsAverageActual = forumStatistics.getUserCommentsAverage();
        //Then
        Assert.assertEquals(userCommentsAverageExpected, userCommentsAverageActual, 0);
    }
    @Test
    public void testcalculateAdvStatisticsUser100Comments500() {
        //Given
        double commentsNumber = 500;
        List<String> namesList = new ArrayList<>();
        for( int i = 0; i <100; i++)
        {
            namesList.add("Testman");
        }
        double userCommentsAverageExpected = commentsNumber / namesList.size();
        Statistics statistics = mock(Statistics.class);
        when(statistics.commentsCount()).thenReturn((int)commentsNumber);
        when(statistics.usersNames()).thenReturn(namesList);
        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(statistics);
        //When
        double userCommentsAverageActual = forumStatistics.getUserCommentsAverage();
        //Then
        Assert.assertEquals(userCommentsAverageExpected, userCommentsAverageActual, 0);
    }
    @Test
    public void testcalculateAdvStatisticsPost1000Comments2000() {
        //Given
        double postNumber = 1000;
        double commentsNumber = 2000;
        double postCommentsAverageExpected = commentsNumber / postNumber;
        Statistics statistics = mock(Statistics.class);
        when(statistics.commentsCount()).thenReturn((int)commentsNumber);
        when(statistics.postsCount()).thenReturn((int)postNumber);
        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(statistics);
        //When
        double postCommentsAverageActual = forumStatistics.getPostCommentsAverage();
        //Then
        Assert.assertEquals(postCommentsAverageExpected, postCommentsAverageActual, 0);
    }
    @Test
    public void testcalculateAdvStatisticsPost1000Comments500() {
        //Given
        double postNumber = 1000;
        double commentsNumber = 500;
        double postCommentsAverageExpected = commentsNumber / postNumber;
        Statistics statistics = mock(Statistics.class);
        when(statistics.commentsCount()).thenReturn((int)commentsNumber);
        when(statistics.postsCount()).thenReturn((int)postNumber);
        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(statistics);
        //When
        double postCommentsAverageActual = forumStatistics.getPostCommentsAverage();
        //Then
        Assert.assertEquals(postCommentsAverageExpected, postCommentsAverageActual, 0);
    }
}
