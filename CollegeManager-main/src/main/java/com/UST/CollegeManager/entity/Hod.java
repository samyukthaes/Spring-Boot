package com.UST.CollegeManager.entity;

 import lombok.AllArgsConstructor;
 import lombok.Data;
 import lombok.NoArgsConstructor;

 import javax.persistence.*;

@Entity
@Table(name = "hod")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

}
