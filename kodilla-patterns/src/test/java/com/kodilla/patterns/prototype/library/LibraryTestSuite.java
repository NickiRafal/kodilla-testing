package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
public class LibraryTestSuite {

    private void displayBooksInfo(Library library) {
        System.out.println("Library: " + library.getName());
        library.getBooks().forEach(book -> {
            System.out.println("Author: " + book.getAuthor() + ", Title: " + book.getTitle() + ", Publication Date: " + book.getPublicationDate());
        });
    }

    @Test
    void testGetBooks() {
        // Given
        Library library = new Library("Powiesci 1");
        Book book1 = new Book("Duma i uprzedzenie", "Jane Austen", LocalDate.of(1813, 2, 11));
        Book book2 = new Book("Don Kichot", "Miguel de Cervantes", LocalDate.of(1605, 10, 3));
        Book book3 = new Book("Obcy", "Albert Camus", LocalDate.of(1942, 5, 22));

        // When
        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);

        Library shallowCopyLibrary = null;
        Library deepCopyLibrary = null;
        try {
            shallowCopyLibrary = library.shallowCopy();
            shallowCopyLibrary.setName("Powiesci Shallow Copy");

            deepCopyLibrary = library.deepCopy();
            deepCopyLibrary.setName("Powiesci Deep Copy");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        displayBooksInfo(library);
        if(shallowCopyLibrary != null) {
            displayBooksInfo(shallowCopyLibrary);
        }
        if (deepCopyLibrary != null) {
            displayBooksInfo(deepCopyLibrary);
        }
        // Then
        Assertions.assertEquals(3, library.getBooks().size());
        Assertions.assertEquals(3, shallowCopyLibrary.getBooks().size());
        Assertions.assertEquals(3, deepCopyLibrary.getBooks().size());
    }
}
