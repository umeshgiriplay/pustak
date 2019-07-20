package edu.sunway.pustak.entity;

import javax.persistence.*;

@Entity
@Table(name = "category", schema = "pustak")
public class BookCategory {

    private Long categoryId;
    private String categoryName;

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
}
