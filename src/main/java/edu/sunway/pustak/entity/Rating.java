package edu.sunway.pustak.entity;

import javax.persistence.*;

@Entity
public class Rating {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private User user;
    private int rating;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
