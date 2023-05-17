package com.driver.models;

import javax.persistence.*;

@Entity
@Table(name = "Image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String description;
    private String dimensions;


    @ManyToOne
    @JoinColumn
    Blog blog;

    public Image() {
    }

    public Image(int id, String description, String dimensions) {
        this.id = id;
        this.description = description;
        this.dimensions = dimensions;
    }

    public Image(int id, String description, String dimension, Blog blog) {
        this.id = id;
        this.description = description;
        this.dimensions = dimension;
        this.blog = blog;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimensions() {
        return this.dimensions;
    }

    public void setDimensions(String dimension) {
        this.dimensions = dimension;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}