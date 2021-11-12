package com.ayush.service;

import com.ayush.helper.*;
import com.ayush.model.*;
import com.ayush.repo.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.multipart.*;

import java.io.*;
import java.util.*;

@Service
public class StudentService {
    private StudentRepo studentRepo;
    @Autowired
    public void setStudentRepo(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public void upload(MultipartFile file){
        List<Student> studentList = null;
        try {
            studentList = ExcelHelper.convertExcelToList(file.getInputStream());
            studentRepo.saveAll(studentList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Student> allStudents(){
        return  studentRepo.findAll();
    }
}
