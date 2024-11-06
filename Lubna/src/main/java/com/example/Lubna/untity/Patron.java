package com.example.Lubna.untity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Patron {
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    
    @Size(min = 1, max = 255, message = "Name must be between 1 and 255 characters")
    private String name;
    @Size(min = 1, max = 255, message = "Contact information must be between 1 and 255 characters")
    private String contactInfo;
    @Size(min = 1, max = 255, message = "Address must be between 1 and 255 characters")
    private String address;
    private LocalDate membershipDate;

    @OneToMany(mappedBy = "patron")
    private List<BorrowingRecord> borrowedBooks;
}
