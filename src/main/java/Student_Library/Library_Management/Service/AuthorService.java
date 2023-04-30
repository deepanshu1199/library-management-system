package Student_Library.Library_Management.Service;

import Student_Library.Library_Management.DTOs.AuthorEntityDto;
import Student_Library.Library_Management.DTOs.AuthorResponseDto;
import Student_Library.Library_Management.DTOs.BookRequestDto;
import Student_Library.Library_Management.DTOs.BookResponseDto;
import Student_Library.Library_Management.Models.Author;
import Student_Library.Library_Management.Models.Book;
import Student_Library.Library_Management.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public String createAuthor(AuthorEntityDto authorEntityDto) {
        Author author=new Author();
        author.setAge(authorEntityDto.getAge());
        author.setCountry(authorEntityDto.getCountry());
        author.setName(authorEntityDto.getName());
        author.setRating(authorEntityDto.getRating());


        authorRepository.save(author);
        return"author created successfully";
    }

    public AuthorResponseDto getAuthorById(int authorId) {
        AuthorResponseDto authorResponseDto=new AuthorResponseDto();
        Author author=authorRepository.findById(authorId).get();
        
        authorResponseDto.setId(authorId);
        authorResponseDto.setName(author.getName());
        authorResponseDto.setAge(author.getAge());
        authorResponseDto.setRating(author.getRating());
        authorResponseDto.setCountry(author.getCountry());

        List<BookResponseDto> books = new ArrayList<>();
        
        List<Book> booklist=author.getBooksWritten();

        for(Book b:booklist){
            BookResponseDto bookResponseDto=new BookResponseDto(b.getName(),b.getPages(),b.getGenre());
            books.add(bookResponseDto);
        }
        
        authorResponseDto.setBooks(books);
        
        return authorResponseDto;
    }
}
