package com.example.Student.Library.Management.System.Services;


import com.example.Student.Library.Management.System.DTOs.StudentUpdateMobRequestDto;
import com.example.Student.Library.Management.System.Enums.CardStatus;
import com.example.Student.Library.Management.System.Models.Card;
import com.example.Student.Library.Management.System.Models.Student;
import com.example.Student.Library.Management.System.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String createStudent(Student student){

        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setStudentVariableName(student); // Fk coloumn is comingg from here


        student.setCard(card);

        studentRepository.save(student);
        return "Student and Card added suceesfully";

    }

    public String updateMobNo(StudentUpdateMobRequestDto studentUpdateMobRequestDto){
        Student originalStudent = studentRepository.findById(studentUpdateMobRequestDto.getId()).get();

        originalStudent.setMobNo(studentUpdateMobRequestDto.getMobNo());
        studentRepository.save(originalStudent);

        return "Mobile number updated succesfully";
    }

    public String findNameByEmail(String email){

        Student ans = studentRepository.findByEmail(email);
        return  ans.getName();


    }


}
