package com.example.Student.Library.Management.System.Controllers;


import com.example.Student.Library.Management.System.DTOs.addAuthorDTO;
import com.example.Student.Library.Management.System.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {


    @Autowired
    AuthorService authorService;


    @PostMapping("/add")
    public String addAuthor(@RequestBody addAuthorDTO addAuthorDTO){


        return authorService.createAuthor(addAuthorDTO);
    }

    @DeleteMapping("/delete")
    public String deleteAuthor(@RequestParam("id") int id){

        return authorService.DeleteAuthor(id);
    }

}