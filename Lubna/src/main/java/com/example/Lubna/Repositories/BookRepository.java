package com.example.Lubna.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Lubna.untity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
