package com.estudo.Project.dto;

import com.estudo.Project.domain.User;

import java.io.Serial;
import java.io.Serializable;

public class AutorDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;

    public AutorDTO(){}

    public AutorDTO(User obj) {
        id = obj.getId();
        name = obj.getName();
    }
}
