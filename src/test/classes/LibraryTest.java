package test.classes;
import main.classes.Book;
import main.classes.Library;
import main.classes.SearchByType;
import main.classes.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;


class LibraryTest {
    private Library library;
    private Book book1, book2, book3;
    private Student student1, student2, student3;

    @BeforeEach
    void setUp() {
        library = new Library();

        book1 = new Book("Book-1", "Author-1", 1);
        book2 = new Book("Book-2", "Author-2", 2);
        book3 = new Book("Book-3", "Author-1", 3);

        student1 = new Student("s1", 1);
        student2 = new Student("s2", 2);
        student3 = new Student("s3", 3);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.addStudent(student1);
        library.addStudent(student2);
        library.addStudent(student3);
    }

    @Test
    void testLendBook_toUnregisteredStudent() {
        Student unregisteredStudent = new Student(("s4"), 4);
        boolean lendResult = library.lendBook(book1, unregisteredStudent);
        assertFalse(lendResult);
        assertFalse(unregisteredStudent.hasBook(book1));
    }

    @Test
    void testReturnBook() {
        library.lendBook(book1, student1);
        library.returnBook(book1, student1);
        assertFalse(student1.hasBook(book1));
    }

    @Test
    void testSearchBooks_byId() {
        ArrayList<Object> keys = new ArrayList<>(Arrays.asList(1, 3));
        ArrayList<Book> expectedBooks = new ArrayList<>(Arrays.asList(book1, book3));
        ArrayList<Book> searchResult = library.searchBooks(SearchByType.ID, keys);
        assertEquals(expectedBooks, searchResult);
    }

    @Test
    void testSearchBooks_byTitle() {
        ArrayList<Object> keys = new ArrayList<>(Arrays.asList("Book-2", "Book-3"));
        ArrayList<Book> expectedBooks = new ArrayList<>(Arrays.asList(book2, book3));
        ArrayList<Book> searchResult = library.searchBooks(SearchByType.TITLE, keys);
        assertEquals(expectedBooks, searchResult);
    }

    @Test
    void testSearchBooks_byAuthor() {
        ArrayList<Object> keys = new ArrayList<>(Arrays.asList("Author-1"));
        ArrayList<Book> expectedBooks = new ArrayList<>(Arrays.asList(book1, book3));
        ArrayList<Book> searchResult = library.searchBooks(SearchByType.AUTHOR, keys);
        assertEquals(expectedBooks, searchResult);
    }

    @Test
    void testSearchBooks_invalidSearchType() {
        ArrayList<Object> keys = new ArrayList<>(Arrays.asList("Book-1", "Book-2"));
        assertNull(library.searchBooks(SearchByType.NAME, keys));
    }

    @Test
    void testSearchStudents_byId() {
        ArrayList<Object> keys = new ArrayList<>(Arrays.asList(1, 3));
        ArrayList<Student> expectedStudents = new ArrayList<>(Arrays.asList(student1, student3));
        ArrayList<Student> searchResult = library.searchStudents(SearchByType.ID, keys);
        assertEquals(expectedStudents, searchResult);
    }

    @Test
    void testSearchStudents_byName() {
        ArrayList<Object> keys = new ArrayList<>(Arrays.asList("s1", "s3"));
        ArrayList<Student> expectedStudents = new ArrayList<>(Arrays.asList(student1, student3));
        ArrayList<Student> searchResult = library.searchStudents(SearchByType.NAME, keys);
        assertEquals(expectedStudents, searchResult);
    }

    @Test
    void testSearchStudents_invalidSearchType() {
        ArrayList<Object> keys = new ArrayList<>(Arrays.asList("Book-1", "Book-2"));
        assertNull(library.searchStudents(SearchByType.TITLE, keys));
    }
}

