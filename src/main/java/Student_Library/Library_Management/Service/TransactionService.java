package Student_Library.Library_Management.Service;

import Student_Library.Library_Management.DTOs.IssueBookRequestDto;
import Student_Library.Library_Management.Enums.CardStatus;
import Student_Library.Library_Management.Enums.TransactionStatus;
import Student_Library.Library_Management.Models.Book;
import Student_Library.Library_Management.Models.Card;
import Student_Library.Library_Management.Models.Transactions;
import Student_Library.Library_Management.Repositories.BookRepository;
import Student_Library.Library_Management.Repositories.CardRepository;
import Student_Library.Library_Management.Repositories.TransactionRepository;
import jakarta.transaction.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.xa.XAResource;

import java.util.ArrayList;
import java.util.List;

import static Student_Library.Library_Management.Enums.TransactionStatus.SUCCESS;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    CardRepository cardRepository;
    @Autowired
    BookRepository bookRepository;
    public String issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception {
        Transactions transactions=new Transactions();
        transactions.setFine(0);
        transactions.setIssueOperation(true);


        Card transactioncard=cardRepository.findById(issueBookRequestDto.getCardID()).get();
        transactions.setTransactionCard(transactioncard);

        Book transactionbook=bookRepository.findById(issueBookRequestDto.getBookID()).get();
        transactions.setTransactionBook(transactionbook);

        if(transactionbook==null || transactionbook.isIssued()==true){
            transactions.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transactions);
            throw new Exception("Book not available");
        }

        if(transactioncard==null || !transactioncard.getCardStatus().equals(CardStatus.ACTIVATED)){
            transactions.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transactions);
            throw new Exception("Card is not valid");
        }
        transactions.setTransactionStatus(TransactionStatus.SUCCESS);

        transactionbook.setIssued(true);
        // setting card

        List<Transactions> transactionsList=transactioncard.getCardTransactions();
        transactionsList.add(transactions);
        transactioncard.setCardTransactions(transactionsList);

        List<Book> issuedBooksForCard=transactioncard.getBooksIssue();
        issuedBooksForCard.add(transactionbook);
        transactioncard.setBooksIssue(issuedBooksForCard);


        List<Transactions> transactionsList1=transactionbook.getBookTransactions();
        transactionsList1.add(transactions);
        transactionbook.setBookTransactions(transactionsList1);

        cardRepository.save(transactioncard);


        // not saving in book and transaction repository because card is parent of book and transaction so by cascading it will automatically saved
       // bookRepository.save(transactionbook);
       // transactionRepository.save(transactions);

        return "book is issued successfully";
    }

    public String getTransaction(int bookId,int cardId){
        List<Transactions> transactionsList=transactionRepository.getTransactionsForBookidandCardid(bookId,cardId);

        String transactionId=transactionsList.get(0).getTransactionID();

        return transactionId;
    }
}
