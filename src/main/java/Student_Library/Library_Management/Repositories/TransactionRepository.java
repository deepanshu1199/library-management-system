package Student_Library.Library_Management.Repositories;

import Student_Library.Library_Management.Models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions,Integer> {

    @Query(value = "select * from transaction where transaction_book_id=:bookId and transaction_card_id=:cardId and is_issue_operation=true",nativeQuery = true)
    List<Transactions> getTransactionsForBookidandCardid(int bookId, int cardId);
}
