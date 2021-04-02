package mk.ukim.finki.emt.lab2.service.impl;

import mk.ukim.finki.emt.lab2.model.Author;
import mk.ukim.finki.emt.lab2.model.Book;
import mk.ukim.finki.emt.lab2.model.enumerations.Category;
import mk.ukim.finki.emt.lab2.model.exceptions.BookNotFoundException;
import mk.ukim.finki.emt.lab2.repository.jpa.BookRepository;
import mk.ukim.finki.emt.lab2.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> addNewBook(String name, Category category, Author author, Integer availableCopies) {
        return Optional.of(this.bookRepository.save(new Book(name, category, author, availableCopies)));
    }

    @Override
    public void deleteBook(String name) {
        Book book = this.bookRepository.findByName(name).orElseThrow(() -> new BookNotFoundException(name));
        this.bookRepository.deleteById(book.getId());
    }

    @Override
    public Optional<Book> editBook(Long id, String name, Category category, Author author, Integer availableCopies) {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(name));

        book.setName(name);
        book.setCategory(category);
        book.setAuthor(author);
        book.setAvailableCopies(availableCopies);

        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public Optional<Book> markAsTaken(String name) {
        Book book = this.bookRepository.findByName(name).orElseThrow(() -> new BookNotFoundException(name));
        Integer copies = book.getAvailableCopies()-1;
        book.setAvailableCopies(copies);

        return Optional.of(this.bookRepository.save(book));
    }
}
