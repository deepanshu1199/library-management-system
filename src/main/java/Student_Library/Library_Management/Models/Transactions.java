package Student_Library.Library_Management.Models;

import Student_Library.Library_Management.Enums.TransactionStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "transaction")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;
    private int fine;
    private String TransactionID= UUID.randomUUID().toString();
    @CreationTimestamp
    private Date TransactionDate;
    private boolean isIssueOperation;

    @ManyToOne
    @JoinColumn
    private Card TransactionCard;

    @ManyToOne
    @JoinColumn
    private Book TransactionBook;

    public Transactions() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public String getTransactionID() {
        return TransactionID;
    }

    public void setTransactionID(String transactionID) {
        TransactionID = transactionID;
    }

    public Date getTransactionDate() {
        return TransactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        TransactionDate = transactionDate;
    }

    public boolean isIssueOperation() {
        return isIssueOperation;
    }

    public void setIssueOperation(boolean issueOperation) {
        isIssueOperation = issueOperation;
    }

    public Card getTransactionCard() {
        return TransactionCard;
    }

    public void setTransactionCard(Card transactionCard) {
        TransactionCard = transactionCard;
    }

    public Book getTransactionBook() {
        return TransactionBook;
    }

    public void setTransactionBook(Book transactionBook) {
        TransactionBook = transactionBook;
    }


}
