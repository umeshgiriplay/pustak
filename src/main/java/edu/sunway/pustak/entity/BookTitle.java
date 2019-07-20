package edu.sunway.pustak.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book_titles", schema = "pustak")
public class BookTitle {

    private Long titleId;
    private String title;
    private String edition;

    private List<Book> booksByTitle;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getTitleId() {
        return titleId;
    }

    public void setTitleId(Long titleId) {
        this.titleId = titleId;
    }

    @Basic
    @Column(name = "book_title", nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "edition")
    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    @OneToMany(mappedBy = "titleId")
    public List<Book> getBooksByTitle() {
        return booksByTitle;
    }

    public void setBooksByTitle(List<Book> booksByTitle) {
        this.booksByTitle = booksByTitle;
    }
}
