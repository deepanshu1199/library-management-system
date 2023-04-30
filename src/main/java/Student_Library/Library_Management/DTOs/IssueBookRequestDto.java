package Student_Library.Library_Management.DTOs;

public class IssueBookRequestDto {
    private int bookID;
    private int cardID;

    public IssueBookRequestDto() {
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getCardID() {
        return cardID;
    }

    public void setCardID(int cardID) {
        this.cardID = cardID;
    }
}
