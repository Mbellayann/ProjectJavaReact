package com.datamodel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Movie")
public class Movie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title" )
    private String title;
    @Column(name = "added" )
    private Date added;
    @Column(name = "external_id" )
    private String external_id;

    @OneToMany(mappedBy="movie")
    private Set<SeenMovie> seen_movies;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    public String getExternal_id() {
        return external_id;
    }

    public void setExternal_id(String external_id) {
        this.external_id = external_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<SeenMovie> getSeen_movies() {
        return seen_movies;
    }

    public void setSeen_movies(Set<SeenMovie> seen_movies) {
        this.seen_movies = seen_movies;
    }
}
