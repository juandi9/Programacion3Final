package com.example.demo.model;




import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table (name = "student")
public class Student {

    @Id

     Integer id;
    @Column(name = "first_name")
     String firstName;
    @Column (name = "last_name")
     String lastName;
     double prom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getProm() {
        return prom;
    }

    public void setProm(double prom) {
        this.prom = prom;
    }
}
