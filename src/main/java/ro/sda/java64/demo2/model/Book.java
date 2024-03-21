package ro.sda.java64.demo2.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class Book {
    @Length(min=3,max = 25, message = "Titlu trebuie sa fie intre 3 si 25 caractere!")
    private String title;
    private int pages;
    private String author;
    private String publisher;

    private String isbn;
}
