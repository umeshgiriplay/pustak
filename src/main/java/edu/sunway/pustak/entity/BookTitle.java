package edu.sunway.pustak.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class BookTitle {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String edition;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }
}
