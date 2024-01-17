package com.easy.learn.controller;

import com.easy.learn.dto.TestEditDTO.TestEditDTO;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileUploadController {
    @Autowired
    private TestEditDTO testEditDTO;

    //check file excel type or not
    public static boolean checkExcelFormat(MultipartFile file){
        String contentType = file.getContentType();
        if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")){
            return true;
        }
        return false;
    }

    //convert excel to list
    public static List<TestEditDTO> convertExcelToList(InputStream inputStream, Long id){
        List<TestEditDTO> list = new ArrayList<>();
        try{
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            //set sheet name
            XSSFSheet sheet = workbook.getSheet("data");

            int rowNumber = 0;

            Iterator<Row> iterator = sheet.iterator();

            while(iterator.hasNext()){
                Row row = iterator.next();
                if(rowNumber == 0){
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cells = row.iterator();
                int cid = 0;

                TestEditDTO testEditDTO = new TestEditDTO();

                while(cells.hasNext()){
                    Cell cell = cells.next();
                    switch (cid){
                        case 0 : testEditDTO.setQuestion(String.valueOf(cell)); break;
                        case 1 : testEditDTO.setOp1(String.valueOf(cell)); break;
                        case 2 : testEditDTO.setOp2(String.valueOf(cell)); break;
                        case 3 : testEditDTO.setOp3(String.valueOf(cell)); break;
                        case 4 : testEditDTO.setOp4(String.valueOf(cell)); break;
                        case 5 : testEditDTO.setRightAnswer(String.valueOf(cell)); break;
                        default: break;
                    }
                    cid++;
                }
                testEditDTO.setLessonEditId(id);
                list.add(testEditDTO);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
