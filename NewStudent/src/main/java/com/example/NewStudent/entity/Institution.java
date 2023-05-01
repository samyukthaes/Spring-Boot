package com.example.NewStudent.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.HashMap;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Institution {
    private int name;
    private String location;

}
