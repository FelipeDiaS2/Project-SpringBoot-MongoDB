package com.estudo.Project.dto;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class CommentDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String text;
    private Date date;
    private AutorDTO autor;
    public  CommentDTO(){}

    public CommentDTO(String text, Date date, AutorDTO autor) {
        this.text = text;
        this.date = date;
        this.autor = autor;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AutorDTO getAutor() {
        return autor;
    }

    public void setAutor(AutorDTO autor) {
        this.autor = autor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentDTO that = (CommentDTO) o;
        return Objects.equals(text, that.text) && Objects.equals(date, that.date) && Objects.equals(autor, that.autor) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, date, autor);
    }
}
