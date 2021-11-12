package com.ayush.helper;

import com.ayush.model.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.web.multipart.*;

import java.io.*;
import java.util.*;

public class ExcelHelper {

    public  static Boolean checkExcelFormat(MultipartFile file){
        String contentType = file.getContentType();
        String excelType="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
        if (contentType.equals(excelType)){
            return  true;
        }else{
            return  false;
        }
    }

    public  static List<Student> convertExcelToList(InputStream stream){
        List<Student> studentList=new ArrayList<>();
        try{
            XSSFWorkbook workBook = new XSSFWorkbook(stream);
            XSSFSheet sheet = workBook.getSheet("result");
            int rowNumber=0;
            Iterator<Row> iterator = sheet.iterator();
            while (iterator.hasNext()){
                Row row = iterator.next();
                if (rowNumber==0){
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellIterator = row.iterator();
                int cid=0;
                Student student=new Student();
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    switch (cid){
                        case 0:
                            student.setRollNo((int)cell.getNumericCellValue());
                            break;
                        case  1:
                            student.setName(cell.getStringCellValue());
                            break;
                        case 2:
                            student.setDotNet(cell.getNumericCellValue());
                            break;
                        case  3:
                            student.setComputerGraphics(cell.getNumericCellValue());
                            break;
                        case 4:
                            student.setComputerNetwork(cell.getNumericCellValue());
                            break;
                        case 5:
                            student.setMIS(cell.getNumericCellValue());
                            break;
                        case 6:
                            student.setManagement(cell.getNumericCellValue());
                        default:
                            break;
                    }
                    cid++;
                }
                studentList.add(student);

            }
            return studentList;

        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }
}
