package com.gmail.ddzhunenko.organizationdirectory.entity;

import javax.persistence.*;

@Entity
@Table(name = "positions", schema = "public")
public class Position {

    @Id
    @Column(name = "id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;

    public Position() {
    }

    public Position(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
