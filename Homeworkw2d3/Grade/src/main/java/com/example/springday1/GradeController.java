package com.example.springday1;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class GradeController {
    public ArrayList listGrades;

    public GradeController() {
        listGrades =new ArrayList();
    }

    @GetMapping("/grade")
    public ArrayList getListGrades(){
        return listGrades;
    }

    @PostMapping("/grade")
    public String setGrade(@RequestBody String grade){
        listGrades.add(grade);
        return "grade added";
    }



    @PutMapping("/grade/{index}")
    public String updateGrade(@PathVariable int index,@RequestBody String grade){
        listGrades.set(index,grade);
        return "grade updated";
    }

    @DeleteMapping("/grade/{index}")
    public String deleteGrade(@PathVariable int index){
        listGrades.remove(index);
        return "grade deleted";
    }




}
