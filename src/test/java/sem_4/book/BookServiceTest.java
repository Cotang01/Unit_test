package sem_4.book;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class BookServiceTest {
    
    List<Book> books;
    Book book1;
    Book book2;
    BookRepository bookRepository;
    BookService bookService;
    
    @BeforeEach
    void setup() {
        books = new ArrayList<>();
        book1 = new Book("1", "Book1", "Author1");
        book2 = new Book("2", "Book2", "Author2");
        books.add(book1);
        books.add(book2);
        bookRepository = mock(BookRepository.class, withSettings().lenient());
        bookService = new BookService(bookRepository);
    }
    
    @Test
    void testFindBookById() {
        when(bookService.findBookById("1")).thenReturn(book1);
        when(bookService.findBookById("2")).thenReturn(book2);
    }
    
    @Test
    void testFindAllBooks() {
        when(bookService.findAllBooks()).thenReturn(books);
    }

}