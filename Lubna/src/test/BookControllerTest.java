package com.example.Lubna;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.Lubna.Repositories.BookRepository;

@WebMvcTest(BookControllerTest.class)
public class BookControllerTest {
    
    @MockBean
    BookRecordRepository BookRepository;
    
    BookRecord RECORD_1 = new BookRecord(1, "Book 1",  "Author 1",2023, 10);
    BookRecord RECORD_2 = new BookRecord(2, "Book 2",  "Author 1",2002, 12);
    BookRecord RECORD_3 = new BookRecord(3, "Book 4",  "Author 1",2008, 13);


    @Test
    public void getAllRecords_success() throws Exception {
         List<BookRecord> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));
    
         Mockito.when(BookRecordRepository.getAllBooks()).thenReturn(records);
    
         mockMvc.perform(MockMvcRequestBuilders
            .get("/api/books")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk()) ;
    }

    @Test
   public void getBookById_success() throws Exception {
         Mockito.when(BookRecordRepository.findById(RECORD_1.getBookById())).thenReturn(java.util.Optional.of(RECORD_1));

         mockMvc.perform(MockMvcRequestBuilders
            .get("/api/books/1")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", notNullValue()))
            .andExpect(jsonPath("$.name", is("Book 1")));
      }


      @Test
    public void deletePatientById_success() throws Exception {
         Mockito.when(BookRecordRepository.findById(RECORD_2.getBookById())).thenReturn(Optional.of(RECORD_2));

         mockMvc.perform(MockMvcRequestBuilders
            .delete("/api/books/2")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
}

        @Test
        public void deletePatientById_notFound() throws Exception {
          Mockito.when(BookRecordRepository.getBookById(5)).thenReturn(null);

            mockMvc.perform(MockMvcRequestBuilders
            .delete("/api/books/5")
            .contentType(MediaType.APPLICATION_JSON))
              .andExpect(status().isBadRequest())
            .andExpect(result ->
                    assertTrue(result.getResolvedException() instanceof NotFoundException))
              .andExpect(result ->
            assertEquals("Book with ID 5 does not exist.", result.getResolvedException().getMessage()));
}
}