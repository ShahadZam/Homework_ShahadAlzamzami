package com.example.springday1;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class GradeController {
    
     public ArrayList<Integer> listGrades;

    public GradeController() {
        listGrades =new ArrayList<Integer>();
    }

    @GetMapping("/grade")
    public ArrayList getListGrades(){
        return listGrades;
    }

    @PostMapping("/grade")
    public String setGrade(@RequestBody String grade){
        listGrades.add(Integer.parseInt(grade));
        return "grade added";
    }



    @PutMapping("/grade/{index}")
    public String updateGrade(@PathVariable int index,@RequestBody String grade){
        listGrades.set(index,Integer.parseInt(grade));
        return "grade updated";
    }

    @DeleteMapping("/grade/{index}")
    public String deleteGrade(@PathVariable int index){
        listGrades.remove(index);
        return "grade deleted";
    }





}
