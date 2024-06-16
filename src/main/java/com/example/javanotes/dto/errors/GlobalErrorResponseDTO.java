package com.example.javanotes.dto.errors;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GlobalErrorResponseDTO {
    private Date timestamp;
    private String message;
    private String details;
}
