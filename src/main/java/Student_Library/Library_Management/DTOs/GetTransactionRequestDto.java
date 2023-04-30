package Student_Library.Library_Management.DTOs;

public class GetTransactionRequestDto {
    private int bookID;
    private int cardId;

    public GetTransactionRequestDto() {
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }
}
