package com.example.Lubna.Services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Lubna.Repositories.BookRepository;
import com.example.Lubna.Repositories.BorrowingRecordRepository;
import com.example.Lubna.Repositories.PatronRepository;
import com.example.Lubna.exception.ResourceNotFoundException;
import com.example.Lubna.untity.Book;
import com.example.Lubna.untity.BorrowingRecord;
import com.example.Lubna.untity.Patron;

import jakarta.transaction.Transactional;

@Service
public class BorrowingRecordService {
    @Autowired
    private BorrowingRecordRepository borrowingRecordRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PatronRepository patronRepository;

    @Transactional
    public BorrowingRecord borrowBook(Long bookId, Long patronId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        Patron patron = patronRepository.findById(patronId).orElseThrow(() -> new ResourceNotFoundException("Patron not found"));

        BorrowingRecord borrowingRecord = new BorrowingRecord();
        borrowingRecord.setBook(book);
        borrowingRecord.setPatron(patron);
        borrowingRecord.setBorrowDate(LocalDate.now());
        return borrowingRecordRepository.save(borrowingRecord);
    }

    @Transactional
    public BorrowingRecord returnBook(Long bookId, Long patronId) {
        BorrowingRecord borrowingRecord = borrowingRecordRepository.findByBookIdAndPatronId(bookId, patronId)
                .orElseThrow(() -> new ResourceNotFoundException("Borrowing record not found"));

        borrowingRecord.setReturnDate(LocalDate.now());
        return borrowingRecordRepository.save(borrowingRecord);
    }
}
