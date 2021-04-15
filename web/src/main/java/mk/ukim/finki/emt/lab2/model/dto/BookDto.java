package mk.ukim.finki.emt.lab2.model.dto;

import lombok.Data;
import mk.ukim.finki.emt.lab2.model.Author;
import mk.ukim.finki.emt.lab2.model.enumerations.Category;

@Data
public class BookDto {
    private String name;
    private Category category;

    private Author author;

    private Integer availableCopies;

    public void Book(){

    }
    public void Book(String name, Category category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
