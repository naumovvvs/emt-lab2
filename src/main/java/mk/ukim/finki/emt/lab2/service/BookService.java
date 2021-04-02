package mk.ukim.finki.emt.lab2.service;

import mk.ukim.finki.emt.lab2.model.Author;
import mk.ukim.finki.emt.lab2.model.Book;
import mk.ukim.finki.emt.lab2.model.enumerations.Category;
import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Optional<Book> addNewBook(String name, Category category, Author author, Integer availableCopies);
    void deleteBook(String name);
    Optional<Book> editBook(Long id, String name, Category category, Author author, Integer availableCopies);
    Optional<Book> markAsTaken(String name);
}
