package Student_Library.Library_Management.Controllers;

import Student_Library.Library_Management.DTOs.GetTransactionRequestDto;
import Student_Library.Library_Management.DTOs.IssueBookRequestDto;
import Student_Library.Library_Management.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @PostMapping("/issueBook")
    public String issueBook(@RequestBody IssueBookRequestDto issueBookRequestDto) {
       try{
           return transactionService.issueBook(issueBookRequestDto);
       }catch(Exception e){
           return e.getMessage();
       }
    }

    @GetMapping("/getTxnInfo")
    public String getTransaction(@RequestBody GetTransactionRequestDto getTransactionRequestDto){
        return transactionService.getTransaction(getTransactionRequestDto.getBookID(),getTransactionRequestDto.getCardId());
    }
}
