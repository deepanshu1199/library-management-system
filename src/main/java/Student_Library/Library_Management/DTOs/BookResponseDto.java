package Student_Library.Library_Management.DTOs;

import Student_Library.Library_Management.Enums.Genre;

public class BookResponseDto {
    private String name;
    private int pages;
    private Genre genre;

    public BookResponseDto() {
    }

    public BookResponseDto(String name, int pages, Genre genre) {
        this.name = name;
        this.pages = pages;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
