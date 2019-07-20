package edu.sunway.pustak.entity;

import javax.persistence.*;

@Entity
@Table(name = "ratings", schema = "pustak")
public class Rating {

    private Long ratingId;
    private User userId;
    private Book bookId;
    private int noOfStars;  // out of 10

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getRatingId() {
        return ratingId;
    }

    public void setRatingId(Long ratingId) {
        this.ratingId = ratingId;
    }

    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @OneToOne
    @JoinColumn(name = "bookId", referencedColumnName = "bookId", nullable = false)
    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "rating", nullable = false)
    public int getNoOfStars() {
        return noOfStars;
    }

    public void setNoOfStars(int noOfStars) {
        this.noOfStars = noOfStars;
    }
}
