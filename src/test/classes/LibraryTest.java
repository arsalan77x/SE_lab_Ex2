package test.classes;
import main.classes.Book;
import main.classes.Library;
import main.classes.Student;
import org.junit.jupiter.api.BeforeEach;


public class LibraryTest {
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
}
