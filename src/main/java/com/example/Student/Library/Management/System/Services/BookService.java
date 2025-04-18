package com.example.Student.Library.Management.System.Services;


import com.example.Student.Library.Management.System.DTOs.BookEntryDTO;
import com.example.Student.Library.Management.System.Models.Author;
import com.example.Student.Library.Management.System.Models.Book;
import com.example.Student.Library.Management.System.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    AuthorRepository authorRepository;

    public String addBook(BookEntryDTO bookEntryDTO){


        int authorId = bookEntryDTO.getAuthorId();


        Author author = authorRepository.findById(authorId).get();

        Book book = new Book();

        book.setGenre(bookEntryDTO.getGenre());
        book.setPages(bookEntryDTO.getPages());
        book.setIssued(false);
        book.setName(bookEntryDTO.getName());





        book.setAuthor(author);
        List<Book> currentBooks = author.getBooksWritten();
        currentBooks.add(book);

        //author.setBooksWritten(currentBooks);


        authorRepository.save(author);


        return "Book added succesfully";

    }
}
