package com.medusatech.libray.dto;

import com.medusatech.libray.entities.Author;
import com.medusatech.libray.entities.Book;
import com.medusatech.libray.entities.Category;
import com.medusatech.libray.entities.Loan;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Data
@NoArgsConstructor
public class BookDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private String description;
    private int yearPublication;
    private Long totalQuantity;
    private Long quantityAvailable;
    private Instant registrationDate;

    public BookDTO (Book entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.description = entity.getDescription();
        this.yearPublication = entity.getYearPublication();
        this.totalQuantity = entity.getTotalQuantity();
        this.registrationDate = entity.getRegistrationDate();
    }

}
