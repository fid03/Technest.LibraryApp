package Entities;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    public int bookCount;

    public Library() {
        books = new ArrayList<>();
        this.bookCount = 0;
    }

    public void addBook(Book newBook) {
        for (Book existingBook : books) {
            if (existingBook.Name.equalsIgnoreCase(newBook.Name)) {
                updateBook(existingBook, newBook.Name, newBook.Language, newBook.Price);
                return;
            }
        }
        books.add(newBook);
        bookCount++;
        System.out.println("Book added successfully!");

    }



    public void updateBook(Book book, String newName, String newLanguage, double newPrice) {
        book.Name = newName;
        book.Language = newLanguage;
        book.Price = newPrice;
        System.out.println("Book information updated successfully!");
    }

    public void deleteBook(int Id){
        for (Book book : books) {
            if (book.getId() == Id) {
                books.remove(book);
                bookCount--;
            }
        }

        System.out.println("Book deleted successfully!");
    }

    public Book findBookByName(String Name) {
        for (Book book : books) {
            if (book.Name.equalsIgnoreCase(Name)) {
                return book;
            }
        }
        return null; // Book not found
    }
    public Book findBookById(int Id) {
        for (Book book : books) {
            if (book.getId() == Id) {
                return book;
            }
        }
        return null; // Book not found
    }
    public void showBooks() {
        for (Book book : books) {
            book.fullInfo();
        }
    }

}
