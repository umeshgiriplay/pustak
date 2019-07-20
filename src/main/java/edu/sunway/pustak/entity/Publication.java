package edu.sunway.pustak.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "publications", schema = "pustak")
public class Publication {

    private Long publicationId;
    private String publicationName;
    private Date publishedYear;

    private Collection<Book> publishedBooks;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(Long publicationId) {
        this.publicationId = publicationId;
    }

    @Basic
    @Column(name = "publication_name")
    public String getPublicationName() {
        return publicationName;
    }

    public void setPublicationName(String publicationName) {
        this.publicationName = publicationName;
    }

    @Basic
    @Column(name = "published_year")
    public Date getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(Date publishedYear) {
        this.publishedYear = publishedYear;
    }

    @OneToMany(mappedBy = "publicationId")
    public Collection<Book> getPublishedBooks() {
        return publishedBooks;
    }

    public void setPublishedBooks(Collection<Book> publishedBooks) {
        this.publishedBooks = publishedBooks;
    }
}
