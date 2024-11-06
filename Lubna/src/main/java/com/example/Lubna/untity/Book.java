package com.example.Lubna.untity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 12, max = 255, message = "Title must be between 1 and 255 characters")
    private String title;
    @Size(min = 1, max = 255, message = "Author must be between 1 and 255 characters")
    private String author;
    @Min(value = 1450, message = "Publication year must be greater than 1450") 
    private int publicationYear;
    @Size(min = 10, max = 13, message = "ISBN must be between 10 and 13 characters")
    private String isbn;
 
   
}
