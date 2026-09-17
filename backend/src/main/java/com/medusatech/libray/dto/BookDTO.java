package com.medusatech.libray.dto;

import com.medusatech.libray.entities.Book;
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

    @NotBlank
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @Min(100)
    @Max(2030)
    @NotBlank
    private int yearPublication;

    @NotNull
    @PositiveOrZero
    private Long totalQuantity;

    @Setter(AccessLevel.NONE)
    private Long quantityAvailable;

    @NotNull
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
