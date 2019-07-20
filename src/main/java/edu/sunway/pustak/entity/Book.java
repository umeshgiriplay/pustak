package edu.sunway.pustak.entity;

import edu.sunway.pustak.enums.BookLicense;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book", schema = "pustak")
public class Book {

    private Long bookId;
    private BookTitle titleId;
    private String description;
    private int viewsCount;
    private double overallRating;           // use the list of rating to determine overall rating
    private boolean canBeViewed;            // for registered/guest users
    private boolean favorite;

    private Author authorId;
    private Publication publicationId;
    private BookCategory categoryId;
    private BookLicense license;
    private User userId;                    // book uploader

    private List<Rating> listOfRatings;
    private List<Comments> listOfComments;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    @OneToOne
    @JoinColumn(name = "book_title", nullable = false)
    public BookTitle getTitleId() {
        return titleId;
    }

    public void setTitleId(BookTitle titleId) {
        this.titleId = titleId;
    }

    @Basic
    @Column(name = "description", length = 1000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "views_count")
    public int getViewsCount() {
        return viewsCount;
    }

    public void setViewsCount(int viewsCount) {
        this.viewsCount = viewsCount;
    }

    @Basic
    @Column(name = "rating")
    public double getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(double overallRating) {
        this.overallRating = overallRating;
    }

    public boolean isCanBeViewed() {
        return canBeViewed;
    }

    public void setCanBeViewed(boolean canBeViewed) {
        this.canBeViewed = canBeViewed;
    }

    @Basic
    @Column(name = "favorite")
    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "authorId")
    public Author getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Author authorId) {
        this.authorId = authorId;
    }

    @ManyToOne
    @JoinColumn(name = "publication_id", referencedColumnName = "publicationId", nullable = false)
    public Publication getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(Publication publicationId) {
        this.publicationId = publicationId;
    }

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "categoryId", nullable = false)
    public BookCategory getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(BookCategory categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "license")
    public BookLicense getLicense() {
        return license;
    }

    public void setLicense(BookLicense license) {
        this.license = license;
    }

    @OneToOne
    @JoinColumn(name = "uploaded_by", referencedColumnName = "userId")
    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @OneToMany(mappedBy = "bookId")
    public List<Rating> getListOfRatings() {
        return listOfRatings;
    }

    public void setListOfRatings(List<Rating> listOfRatings) {
        this.listOfRatings = listOfRatings;
    }

    @OneToMany(mappedBy = "bookId")
    public List<Comments> getListOfComments() {
        return listOfComments;
    }

    public void setListOfComments(List<Comments> listOfComments) {
        this.listOfComments = listOfComments;
    }
}
