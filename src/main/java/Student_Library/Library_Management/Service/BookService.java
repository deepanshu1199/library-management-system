package Student_Library.Library_Management.Service;

import Student_Library.Library_Management.DTOs.BookRequestDto;
import Student_Library.Library_Management.Models.Author;
import Student_Library.Library_Management.Models.Book;
import Student_Library.Library_Management.Repositories.AuthorRepository;
import Student_Library.Library_Management.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    AuthorRepository authorRepository;

    public String addBook(BookRequestDto bookRequestDto){

        Book book=new Book();
        book.setName(bookRequestDto.getName());
        book.setPages(bookRequestDto.getPages());
        book.setGenre(bookRequestDto.getGenre());
        book.setIssued(bookRequestDto.isIssued());

        Author author=authorRepository.findById(bookRequestDto.getAuthorID()).get();
        book.setAuthor(author);

        List<Book> currBooks=author.getBooksWritten();
        currBooks.add(book);
        author.setBooksWritten(currBooks);

        authorRepository.save(author);

        return"book added successfully";
    }
}
