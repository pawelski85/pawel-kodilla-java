package com.kodilla.testing.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BookLibrary {
    LibraryDatabase libraryDatabase;

    public BookLibrary(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }

    public List<Book> listBooksWithCondition(String titleFragment) {
        List<Book> bookList = new ArrayList<Book>();
        if (titleFragment.length() < 3) return bookList;
        List<Book> resultList = libraryDatabase.listBooksWithCondition(titleFragment);
        if (resultList.size() > 20) return bookList;
        bookList = resultList;
        return bookList;
    }

    public List<Book> listBooksInHandsOf2(LibraryUser libraryUser, Map<LibraryUser,Book> booksMap) {
        List<Book> resultBooks = new ArrayList<>();
        List<Book> resultBooks2 = libraryDatabase.listBooksInHandsOf(libraryUser);
        if(booksMap.containsKey(libraryUser)){
            for(Map.Entry<LibraryUser,Book> book:booksMap.entrySet()){
                resultBooks.add(book.getValue());
            }
            return resultBooks2;
        }
        return resultBooks;
    }

}





