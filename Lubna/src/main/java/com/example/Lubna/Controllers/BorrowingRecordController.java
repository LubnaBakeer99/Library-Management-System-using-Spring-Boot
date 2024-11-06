package com.example.Lubna.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Lubna.Services.BorrowingRecordService;
import com.example.Lubna.untity.BorrowingRecord;

@RestController
public class BorrowingRecordController {
    @Autowired
    private BorrowingRecordService borrowingRecordService;

    @PostMapping("/api/borrow/{bookId}/patron/{patronId}")
    public BorrowingRecord borrowBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        return borrowingRecordService.borrowBook(bookId, patronId);
    }

    @PutMapping("/api/return/{bookId}/patron/{patronId}")
    public BorrowingRecord returnBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        return borrowingRecordService.returnBook(bookId, patronId);
    }
}
