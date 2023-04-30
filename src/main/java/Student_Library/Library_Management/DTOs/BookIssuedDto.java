package Student_Library.Library_Management.DTOs;

public class BookIssuedDto {
    private int BookID;
    private int cardID;

    public BookIssuedDto() {
    }

    public int getCardID() {

        return cardID;
    }

    public void setCardID(int cardID) {
        this.cardID = cardID;
    }

    public int getBookID() {
        return BookID;
    }

    public void setBookID(int bookID) {
        BookID = bookID;
    }
}
