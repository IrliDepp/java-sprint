package com.desarrolladorslp.workshops.springbootjava.models;

import java.util.Objects;
import javax.persistence.*;
import javax.persistence.Column;

@Entity

@Table(name = "boards")

public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(length = 300)
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return id == board.id &&
                Objects.equals(name, board.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
