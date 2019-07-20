package edu.sunway.pustak.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "author", schema = "pustak")
public class Author {

    private Long authorId;
    private String name;
    private Long noOfBooks;

    private List<Book> booksWritten;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    @Basic
    @Column(name = "author_name", unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "no_of_books")
    public Long getNoOfBooks() {
        return noOfBooks;
    }

    public void setNoOfBooks(Long noOfBooks) {
        this.noOfBooks = noOfBooks;
    }

    @OneToMany(mappedBy = "authorId")
    public List<Book> getBooksWritten() {
        return booksWritten;
    }

    public void setBooksWritten(List<Book> booksWritten) {
        this.booksWritten = booksWritten;
    }
}
