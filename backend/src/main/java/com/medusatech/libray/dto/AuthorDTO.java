package com.medusatech.libray.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class AuthorDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotBlank
    private Long id;

    @NotBlank
    private String name;

}
