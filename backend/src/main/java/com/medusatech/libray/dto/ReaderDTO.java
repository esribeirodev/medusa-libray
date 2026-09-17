package com.medusatech.libray.dto;

import com.medusatech.libray.entities.Loan;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ReaderDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotNull
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotNull
    private LocalDate birthDate;

    @NotNull
    @Setter(AccessLevel.NONE)
    private Instant creationDate;

    @Setter(AccessLevel.NONE)
    private List<LoanDTO> loans = new ArrayList<>();

}
