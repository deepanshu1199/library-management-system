package Student_Library.Library_Management.Repositories;

import Student_Library.Library_Management.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findByEmail(String email);

    List<Student> findByCountry(String country);
}
