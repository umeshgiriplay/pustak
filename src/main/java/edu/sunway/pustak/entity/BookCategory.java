package edu.sunway.pustak.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category", schema = "pustak")
public class BookCategory {

    private Long categoryId;
    private String categoryName;

    private List<Book> booksByCategory;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "category", unique = true, nullable = false)
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @OneToMany(mappedBy = "categoryId")
    public List<Book> getBooksByCategory() {
        return booksByCategory;
    }

    public void setBooksByCategory(List<Book> booksByCategory) {
        this.booksByCategory = booksByCategory;
    }
}
