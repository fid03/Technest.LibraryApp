package Entities;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Welcome to  Library!\n PLease enter library name...");
        String libName = sc.nextLine();


        Book book1 = new Book("Anna Karenina", "Leo Tolstoy", "ru", 25.90, 6);
        Book book2 = new Book("Kozetta", "Victor Hugo", "en", 22.39, 8);
        Book book3 = new Book("Çalikusu", "Resat Nuri Güntekin", "tr", 15.40, 4);
        Book book4 = new Book("A Brief History of Black Holes", "Becky Smethurst", "en", 26.32, 12);
        Library library = new Library();

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        while (true) {
            System.out.println("Please enter operation:" +
                    "\n1.Add book" +
                    "\n2.Update book" +
                    "\n3.Delete book" +
                    "\n4.Find book" +
                    "\n5.Show books" +
                    "\n6.Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter book name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter author name: ");
                    String author = sc.nextLine();
                    System.out.print("Enter language: ");
                    String language = sc.nextLine();
                    System.out.print("Enter book price: ");
                    int price = sc.nextInt();
                    System.out.print("Enter book count: ");
                    int count = sc.nextInt();

                    Book newBook = new Book(name, author, language, price, count);
                    library.addBook(newBook);
                    break;

                case 2:
                    System.out.print("Enter book ID to update: ");
                    int id = sc.nextInt();
                    Book bookToUpdate = library.findBookById(id);
                    if (bookToUpdate != null) {
                        System.out.print("Enter new book name: ");
                        String newName = sc.nextLine();
                        System.out.print("Enter new language: ");
                        String newLanguage = sc.nextLine();
                        System.out.print("Enter new price: ");
                        double newPrice = sc.nextDouble();
                        library.updateBook(bookToUpdate, newName, newLanguage, newPrice);
                    } else {
                        System.out.println("Book not found. Update failed.");
                    }
                    break;
                case 3:
                    System.out.print("Enter book ID to delete: ");
                    int deleteId = sc.nextInt();
                    library.deleteBook(deleteId);
                    break;
                case 4:
                    System.out.print("Enter book ID to find ");
                    int findId = sc.nextInt();
                    library.findBookById(findId);
                    break;
                case 5:
                    library.showBooks();
                    break;
                case 6:
                    System.out.println("Exit program");
                    System.exit(0);
                    break;
                case 7:
                    System.out.println("Please choose correct operation!");
                    break;
            }
        }
    }
}
