package com.bridgelabz.greetingapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "greetings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Greeting {
    //Entity are Stored in this repository Class [BluePrint of Table itself]
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fname;
    private String lname;
    private String message;
}
