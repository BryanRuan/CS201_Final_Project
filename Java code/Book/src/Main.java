import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Main {

    private static final String CSV_FILE = "book_collection.csv";

    public static void main(String[] args) {

        // Try to load books from the file first.
        List<Book> bookCollection = loadBooksFromCSV(CSV_FILE);

        if (bookCollection.isEmpty()) {
            System.out.println("No books found in the file. Creating initial collection.");
            // 1. Create instances (Initial collection if file is empty/missing)
            AudioBook duneAudio = new AudioBook("Dune", "Frank Herbert", "Sci-Fi", 5.0, 21.5);
            PrintedBook martianPrint = new PrintedBook("The Martian", "Andy Weir", "Sci-Fi", 15.0, 384);
            AudioBook hpAudio = new AudioBook("Harry Potter", "J.K. Rowling", "Fantasy", 12.0, 15.0);

            bookCollection.add(duneAudio);
            bookCollection.add(martianPrint);
            bookCollection.add(hpAudio);

            // Add the LOTR book only if it was not loaded from the file
            PrintedBook lotrPrint = new PrintedBook("Lord of the Rings", "J.R.R. Tolkien", "Fantasy", 20.0, 1178);
            bookCollection.add(lotrPrint);
        } else {
            System.out.println("Successfully loaded " + bookCollection.size() + " books from " + CSV_FILE);
        }

        System.out.println("\n--- Books in the Collection ---");
        double totalCost = 0.0;


        for (Book book : bookCollection) {
            // book.toString() calls the specific toString() method for AudioBook or PrintedBook
            System.out.println(book.toString());

            // book.getCost() calls the specific implementation of getCost() for each object type
            totalCost += book.getCost();
        }
        System.out.println("----------------------------\n");

        // 4. Print results (Total Cost Calculation)
        System.out.printf("Total Cost of all books: $%.2f%n", totalCost);

        // 5. Save the updated collection back to the file
        saveBooksToCSV(CSV_FILE, bookCollection);
    }

    // --- FILE READING METHOD (Implementing try/catch) ---

    /**
     * Reads book data from a CSV file and creates Book objects.
     * Uses try-with-resources for reliable resource management.
     */
    public static List<Book> loadBooksFromCSV(String filename) {
        List<Book> books = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Skip empty lines or header if one existed
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(",");
                // Expected format: Type,Title,Author,Genre,Cost,SpecificAttribute
                if (parts.length != 6) {
                    System.err.println("Skipping malformed line: " + line);
                    continue; // Skip lines that don't match the format
                }

                String type = parts[0];
                String title = parts[1];
                String author = parts[2];
                String genre = parts[3];
                double cost = Double.parseDouble(parts[4]);

                // Input Validation and Object Instantiation
                if (type.equalsIgnoreCase("Printed")) {
                    int pages = Integer.parseInt(parts[5]);
                    books.add(new PrintedBook(title, author, genre, cost, pages));
                } else if (type.equalsIgnoreCase("Audio")) {
                    double length = Double.parseDouble(parts[5]);
                    books.add(new AudioBook(title, author, genre, cost, length));
                }
            }
        } catch (java.io.FileNotFoundException e) {
            // This is acceptable, it means the file hasn't been created yet.
            System.out.println("Book data file not found: " + filename + ". Starting with an empty collection.");
        } catch (IOException e) {
            // General IO error (e.g., permission issues)
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            // Data validation error (e.g., cost or pages is not a number)
            System.err.println("Data error in CSV: Expected a number but found invalid data. " + e.getMessage());
        }

        return books;
    }

    // --- FILE WRITING METHOD (Implementing try/catch) ---

    /**
     * Writes the book collection to a CSV file.
     * Uses try-with-resources for reliable resource management.
     */
    public static void saveBooksToCSV(String filename, List<Book> books) {
        // Use true for the second argument of FileWriter to APPEND to the file
        // or false (default) to OVERWRITE the file. We will OVERWRITE here.
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {

            // Optional: Write a header line
            // pw.println("Type,Title,Author,Genre,Cost,SpecificAttribute");

            for (Book book : books) {
                String line = "";

                // Check the actual type of the book object
                if (book instanceof PrintedBook) {
                    PrintedBook pBook = (PrintedBook) book;
                    line = String.format("Printed,%s,%s,%s,%.2f,%d",
                            pBook.getTitle(), pBook.getAuthor(), pBook.getGenre(), pBook.getCost(), pBook.getPages());
                } else if (book instanceof AudioBook) {
                    AudioBook aBook = (AudioBook) book;
                    line = String.format("Audio,%s,%s,%s,%.2f,%.1f",
                            aBook.getTitle(), aBook.getAuthor(), aBook.getGenre(), aBook.getCost(), aBook.getLength());
                }

                pw.println(line);
            }
            System.out.println("Successfully saved " + books.size() + " books to " + filename);

        } catch (IOException e) {
            // Handle errors during writing, e.g., disk full, permission denied
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}