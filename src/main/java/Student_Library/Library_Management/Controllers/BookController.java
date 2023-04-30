package Student_Library.Library_Management.Controllers;

import Student_Library.Library_Management.DTOs.BookRequestDto;
import Student_Library.Library_Management.Models.Book;
import Student_Library.Library_Management.Service.BookService;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public String addBook(@RequestBody BookRequestDto bookRequestDto){
        return bookService.addBook(bookRequestDto);
    }


}
