package com.ayush.controller;

import com.ayush.helper.*;
import com.ayush.model.*;
import com.ayush.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;

import java.util.*;

@RestController
@CrossOrigin("*")
public class StudentController {
    private StudentService studentService;
    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/student/upload")
    public ResponseEntity upload(@RequestParam("file") MultipartFile file){
        if (ExcelHelper.checkExcelFormat(file)){
            studentService.upload(file);
            return  ResponseEntity.ok(Map.of("message","Data imported Sucessfully"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel format");
    }

    @GetMapping("/student")
    public  ResponseEntity allStudents(){
        List<Student> studentList = studentService.allStudents();
        return ResponseEntity.ok(studentList);
    }
}
