package mk.ukim.finki.emt.lab2.web.rest;

import mk.ukim.finki.emt.lab2.model.Book;
import mk.ukim.finki.emt.lab2.model.dto.BookDto;
import mk.ukim.finki.emt.lab2.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/books")
public class BookRestController {
    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> findAll(){
        return this.bookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id){
        return this.bookService.findBookById(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> editBook(@PathVariable Long id, @RequestBody BookDto bookDto){
        return this.bookService.editBook(id, bookDto.getName(), bookDto.getCategory(), bookDto.getAuthor(), bookDto.getAvailableCopies())
            .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody BookDto bookDto){
        return this.bookService.addNewBook(bookDto.getName(), bookDto.getCategory(), bookDto.getAuthor(), bookDto.getAvailableCopies())
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> deleteById(@PathVariable Long id){
        this.bookService.deleteBook(id);

        if(this.bookService.findBookById(id).isPresent()){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }
}
