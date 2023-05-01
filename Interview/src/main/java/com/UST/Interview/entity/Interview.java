package com.UST.Interview.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Interview {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String emailid;
    private String phno;
    private String skills;
    private String experience;
    private String intdate;
    private String time;
    private String link;
    private String poc;

}
