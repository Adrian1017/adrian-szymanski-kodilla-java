package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {

    public List<ForumUser> getUserList(){
    List<ForumUser> forumUsers = new ArrayList<>();
        forumUsers.add(new ForumUser(1,"Ala",'F', LocalDate.of(1990, 12, 31),120) );
        forumUsers.add(new ForumUser(2,"Adam",'M', LocalDate.of(1991, 11, 11),10));
        forumUsers.add(new ForumUser(3,"Kasia",'F', LocalDate.of(1992, 10, 22),0) );
        forumUsers.add(new ForumUser(4,"Tomek",'M', LocalDate.of(1996, 12, 13),20) );
        forumUsers.add(new ForumUser(5,"Ela",'F', LocalDate.of(1994, 8, 30),20) );
        forumUsers.add(new ForumUser(6,"Bogdan",'M', LocalDate.of(1985, 7, 6),0) );
        forumUsers.add(new ForumUser(7,"Asia",'F', LocalDate.of(1986, 6, 3),270) );
        forumUsers.add(new ForumUser(8,"Adrian",'M', LocalDate.of(1987, 5, 8),20) );
        forumUsers.add(new ForumUser(9,"Bozena",'F', LocalDate.of(1988, 4, 5),20) );
        forumUsers.add(new ForumUser(10,"Lukasz",'M', LocalDate.of(1989, 3, 9),0) );

        return new ArrayList<>(forumUsers);
    }
}
