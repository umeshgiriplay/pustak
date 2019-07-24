package edu.sunway.pustak.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class BookCategory {

    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
