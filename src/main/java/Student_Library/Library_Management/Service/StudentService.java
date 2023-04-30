package Student_Library.Library_Management.Service;

import Student_Library.Library_Management.DTOs.StudentUpdateMobDto;
import Student_Library.Library_Management.Enums.CardStatus;
import Student_Library.Library_Management.Models.Card;
import Student_Library.Library_Management.Models.Student;
import Student_Library.Library_Management.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public String createStudent(Student student){

        // first we have to set the attributes then save them to the table

        //here we are setting card attributes
        Card card=new Card();
        card.setCardStatus(CardStatus.ACTIVATED);

        //here we are setting student attribute present in card entity
        card.setStudentVariable(student);

        //here we are setting card attribute present in student entity
        student.setCard(card);

        //here we are saving to the parent table and child table automatically saved
        studentRepository.save(student);
        return"student created successfully";
    }

    public String findNameByEmail(String email) {
        return studentRepository.findByEmail(email).getName();
    }
    public List<Student> findStudenntsOfCountry(String country){
        return studentRepository.findByCountry(country);
    }
    public String updateMobNo(StudentUpdateMobDto studentUpdateMobDto){
        Student student=studentRepository.findById(studentUpdateMobDto.getId()).get();
        student.setMobNo(studentUpdateMobDto.getMobNo());


        studentRepository.save(student);
        return "mobile number updated successfully";
    }
}
