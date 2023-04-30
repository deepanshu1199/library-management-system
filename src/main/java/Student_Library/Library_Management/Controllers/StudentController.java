package Student_Library.Library_Management.Controllers;

import Student_Library.Library_Management.DTOs.StudentUpdateMobDto;
import Student_Library.Library_Management.Models.Student;
import Student_Library.Library_Management.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public String createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }
    @GetMapping("/get_user")
    public String getNameByEmail(@RequestParam("email") String email){
        return studentService.findNameByEmail(email);
    }
    @GetMapping("get_ListOfStudent")
    public List<Student> findStudentsOfCountry(@RequestParam("country") String country){
        return studentService.findStudenntsOfCountry(country);
    }
    @PutMapping("/updateMobNo")
    public String updateMobNo(@RequestBody StudentUpdateMobDto studentUpdateMobDto){
        return studentService.updateMobNo(studentUpdateMobDto);
    }
}
