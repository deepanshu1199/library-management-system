package Student_Library.Library_Management.Models;

import Student_Library.Library_Management.Enums.CardStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "card_table")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp // auto stamp time when an enrty is created
    private Date createdOn;

    @UpdateTimestamp // update time when entry is updated
    private Date updatedOn;

    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;

    @OneToOne
    @JoinColumn
    private Student studentVariable;


    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    private List<Book> booksIssue;

    @OneToMany(mappedBy = "TransactionCard",cascade = CascadeType.ALL)
    private List<Transactions> cardTransactions;

    public Card() {
        booksIssue=new ArrayList<>();
        cardTransactions=new ArrayList<>();
    }

    public List<Book> getBooksIssue() {
        return booksIssue;
    }

    public void setBooksIssue(List<Book> booksIssue) {
        this.booksIssue = booksIssue;
    }

    public List<Transactions> getCardTransactions() {
        return cardTransactions;
    }

    public void setCardTransactions(List<Transactions> cardTransactions) {
        this.cardTransactions = cardTransactions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public Student getStudentVariable() {
        return studentVariable;
    }

    public void setStudentVariable(Student studentVariable) {
        this.studentVariable = studentVariable;
    }
}
