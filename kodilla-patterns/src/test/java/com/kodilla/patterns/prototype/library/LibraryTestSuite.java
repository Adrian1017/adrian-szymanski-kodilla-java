package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

public class LibraryTestSuite {
    @Test
    public void testGetBooks() {
        //given
        Library library = new Library("MyLibrary");
        IntStream.iterate(1, n-> n+1)
                .limit(3)
                .forEach(n->library.getBooks().add(new Book("Title"+n,"Author"+n,
                        LocalDate.of(1999+n, 01+n,01+n))));

        Library shallowCopyLibrary = null;
        try {
            shallowCopyLibrary = library.shallowCopy();
            shallowCopyLibrary.setName("MyLibraryShallowCopy");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepCopyLibrary = null;
        try {
            deepCopyLibrary = library.deepCopy();
            deepCopyLibrary.setName("MyLibraryDeepCopy");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //then
        System.out.println(library);
        System.out.println(shallowCopyLibrary);
        System.out.println(deepCopyLibrary);
        Assert.assertEquals(3,library.getBooks().size());
        Assert.assertEquals(3, shallowCopyLibrary.getBooks().size());
        Assert.assertEquals(3, deepCopyLibrary.getBooks().size());
        Assert.assertEquals(shallowCopyLibrary.getBooks(), library.getBooks());
        Assert.assertNotEquals(deepCopyLibrary.getBooks(), library.getBooks());
    }

}