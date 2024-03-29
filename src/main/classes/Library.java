package main.classes;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Student> students;

    public Library() {
        books = new ArrayList<>();
        students = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * Lends a book to a student. Removes the book from the library and adds it to the student's list.
     * This operation fails if the library doesn't have the student or the book or the student already has the book.
     *
     * @param book    The book to be lent.
     * @param student The student who is going to borrow the book.
     * @return        Returns true if the operation is successful and false otherwise.
     */
    public boolean lendBook(Book book, Student student) {
        if (!this.students.contains(student)) {
            System.out.println("!! Student " + student.getName() + " not registered.");
            return false;
        }        
        if (!this.books.contains(book)) {
            System.out.println("!! Book " + book.getTitle() + " not registered.");
            return false;
        }
        if (student.hasBook(book)) {
            System.out.println("!! Student already has the book.");
            return false;
        }

        this.books.remove(book);
        student.addBook(book);
        System.out.println(book.getTitle() + " lent to " + student.getName() + ".");
        return true;
    }

    /**
     * The student returns the book to the library. Removes the book from the student's list and adds it to the library.
     * This operation fails if the library doesn't have the student or the student doesn't have the book.
     *
     * @param book    The book to be returned.
     * @param student The student who is going to return the book.
     * @return Returns true if the operation is successful and false otherwise.
     */
    public boolean returnBook(Book book, Student student) {
        if (!this.students.contains(student)) {
            System.out.println("!! Student " + student.getName() + " not registered.");
            return false;
        }
        if (student.hasBook(book)) {
            this.books.add(book);
            student.removeBook(book);
            System.out.println(student.getName() + " returned " + book.getTitle() + ".");
            return true;
        }

        System.out.println("!! " + student.getName() + " doesn't have the book.");
        return false;
    }

    /**
     * Returns a list of students where the specified field matches any of the keys provided.
     * The specified field is determined by the searchByType argument, which can be id or name (but not title or author).
     *
     * @param searchByType Specifies the field used for searching (id, name).
     * @param keys         The list of keys to search for.
     * @return             The list of students that match the search criteria. Returns null if search type is title or author.
     */
    public ArrayList<Student> searchStudents(SearchByType searchByType, ArrayList<Object> keys) {
        ArrayList<Student> matchingStudents = new ArrayList<>();
        switch (searchByType) {
            case ID:
                for (Student student : students) {
                    for (Object key : keys) {
                        if (key instanceof Integer && student.getId() == (int) key) {
                            matchingStudents.add(student);
                            break; 
                        }
                    }
                }
                break;
            case NAME:
                for (Student student : students) {
                    for (Object key : keys) {
                        if (key instanceof String && student.getName().equalsIgnoreCase((String) key)) {
                            matchingStudents.add(student);
                            break; 
                        }
                    }
                }
                break;
            default:
                System.out.println("Invalid search type for students!");
                return null;
        }
    
        return matchingStudents;
    }

    /**
     * Returns a list of books where the specified field matches any of the keys provided.
     * The specified field is determined by the searchByType argument, which can be id, title, or author (but not name).
     *
     * @param searchByType Specifies the field used for searching (id, title, or author).
     * @param keys         The list of keys to search for.
     * @return             The list of books that match the search criteria. Returns null if search type is name.
     */
    public ArrayList<Book> searchBooks(SearchByType searchByType, ArrayList<Object> keys) {
        return null;
        ArrayList<Book> matchingBooks = new ArrayList<>();
        switch (searchByType) {
            case ID:
                for (Book book : books) {
                    for (Object key : keys) {
                        if (key instanceof Integer && book.getId() == (int) key) {
                            matchingBooks.add(book);
                            break; 
                        }
                    }
                }
                break;
            case TITLE:
                for (Book book : books) {
                    for (Object key : keys) {
                        if (key instanceof String && book.getTitle().equalsIgnoreCase((String) key)) {
                            matchingBooks.add(book);
                            break; 
                        }
                    }
                }
                break;
            case AUTHOR:
                for (Book book : books) {
                    for (Object key : keys) {
                        if (key instanceof String && book.getAuthor().equalsIgnoreCase((String) key)) {
                            matchingBooks.add(book);
                            break;
                        }
                    }
                }
                break;
            default:
                System.out.println("Invalid search type!");
                return null;
        }    
        return matchingBooks;
    }

    /**
     * Displays the books of library.
     */
    public void displayBooks() {
        System.out.println("Available books in library:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    /**
     * Displays the students registered in the library.
     */
    public void displayStudents() {
        System.out.println("Registered students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}