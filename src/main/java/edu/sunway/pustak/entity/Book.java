package edu.sunway.pustak.entity;

import edu.sunway.pustak.enums.BookLicense;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private BookTitle title;
    private String description;
    @ManyToOne
    private Author author;
    @ManyToOne
    private Publication publication;
    @ManyToOne
    private BookCategory category;
    private BookLicense license;
    @ManyToOne
    private User user;
    @OneToMany
    private List<Rating> ratings;
    @OneToMany
    private List<Comments> comments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BookTitle getTitle() {
        return title;
    }

    public void setTitle(BookTitle title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public BookCategory getCategory() {
        return category;
    }

    public void setCategory(BookCategory category) {
        this.category = category;
    }

    public BookLicense getLicense() {
        return license;
    }

    public void setLicense(BookLicense license) {
        this.license = license;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }
}
