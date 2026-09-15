package com.medusatech.libray.entities;

import com.medusatech.libray.services.interfaces.Rentable;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter
@Getter
@Entity
@Table(name = "tb_book")
public class Book implements Serializable, Rentable {

    @Serial
    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String title;

    @NotBlank
    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Min(100)
    @Max(2030)
    @Column(nullable = false)
    private int yearPublication;

    @NotNull
    @PositiveOrZero
    @Column(nullable = false)
    private Long totalQuantity;

    @Setter(AccessLevel.NONE)
    @NotNull
    @PositiveOrZero
    @Column(nullable = false)
    private Long quantityAvailable;

    @Setter(AccessLevel.NONE)
    @NotNull
    @Column(nullable = false)
    private Instant registrationDate;

    @ManyToMany
    @JoinTable(name = "tb_book_author",
    joinColumns = @JoinColumn(name = "book_id"),
    inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "tb_book_category",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "book")
    private List<Loan> loans = new ArrayList<>();

    protected Book() {

    }
    public Book(String title, String description, int yearPublication, Long totalQuantity, Instant registrationDate) {
        this.title = title;
        this.description = description;
        this.yearPublication = yearPublication;
        this.totalQuantity = totalQuantity;
        this.registrationDate = registrationDate;
    }

    @Override
    public void rent(int quantity) {
        if(quantity > 0 && quantity < getTotalQuantity()){

        }
    }

    @Override
    public void refund(int quantity) {

    }
}
