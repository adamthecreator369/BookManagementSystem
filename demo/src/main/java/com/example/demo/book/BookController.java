package com.example.demo.book;

// API Layer

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookService.getBooks());
        return  "books";
    }

    @GetMapping("/books/new")
    public String addNewBook(Model model) {
        model.addAttribute("book", new Book());
        return "create_book";
    }

    @PostMapping("/books")
    public String saveBook(@ModelAttribute("book") Book book) {
        bookService.addNewBook(book);
        return "redirect:/books";
    }

    @GetMapping("/books/edit/{bookId}")
    public String editBook(@PathVariable Long bookId, Model model) {
        model.addAttribute("book", bookService.getBookById(bookId).get());
        return "edit_book";
    }

    @PostMapping("/books/{bookId}")
    public String updateBook(@PathVariable Long bookId,
                                @ModelAttribute("book") Book book,
                                Model model) {

        bookService.updateBook(
                bookId,
                book.getIsbn(),
                book.getTitle(),
                book.getAuthor(),
                book.getStatus()
        );
        return "redirect:/books";
    }

    @GetMapping("/books/{bookId}")
    public String deleteStudent(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
        return "redirect:/books";
    }

    /*   Below Methods are for annotating and using this class as a RestController

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @RequestMapping(path = "{bookId}")
    public Optional<Book> getBookById(@PathVariable("bookId") Long bookId) {
        Optional<Book> studentOptional = bookService.getBookById(bookId);
        return studentOptional;
    }

    @PostMapping
    public void addNewBook(@RequestBody Book book) {
        bookService.addNewBook(book);
    }

    @PutMapping(path = "{bookId}")
    public void updateBook(
            @PathVariable("bookId") Long bookId,
            @RequestParam(required = false) String isbn,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String status) {
        bookService.updateBook(bookId, isbn, title, author, status);
    }

    @DeleteMapping(path = "{bookId}")
    public void deleteBook(@PathVariable("bookId") Long bookId) {
        bookService.deleteBook(bookId);
    }

    */
}
