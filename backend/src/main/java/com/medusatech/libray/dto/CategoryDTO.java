package com.medusatech.libray.dto;

import com.medusatech.libray.entities.Book;
import com.medusatech.libray.entities.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class CategoryDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotNull
    private Long id;

    @NotBlank
    private String name;

    @Setter(AccessLevel.NONE)
    private Set<BookDTO> books = new HashSet<>();

    public CategoryDTO(Category entity) {
        this.name = entity.getName();
        this.books = entity.getBooks().stream().map(BookDTO::new).collect(Collectors.toSet());
        this.id = entity.getId();
    }
}

