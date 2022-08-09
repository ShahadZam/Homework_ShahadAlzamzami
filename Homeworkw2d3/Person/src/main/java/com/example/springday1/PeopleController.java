package com.example.springday1;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class PeopleController {
    public ArrayList<String> listName;

    public PeopleController() {
        listName =new ArrayList<String>();
    }

    @GetMapping("/name")
    public ArrayList<String> getListName(){
        return listName;
    }

    @PostMapping("/name")
    public String setNames(@RequestBody String name){
        listName.add(name);
        return "added";
    }

    @PutMapping("/name/{index}")
    public String updateName(@PathVariable int index,@RequestBody String name){
        listName.set(index,name);
        return "updated";
    }

    @DeleteMapping("/name/{index}")
    public String deleteName(@PathVariable int index){
        listName.remove(index);
        return "deleted";
    }




}
