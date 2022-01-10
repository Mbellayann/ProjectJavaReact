package com.dto;

import com.datamodel.Movie;
import java.util.Date;

public class MovieDto {
    private String title;
    private Date added;
    private String external_id;

    public Movie MapUser(){
        Movie movie = new Movie();
        movie.setTitle(this.title);
        movie.setAdded(this.added);
        movie.setExternal_id(this.external_id);
        return movie;
    }

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
}
