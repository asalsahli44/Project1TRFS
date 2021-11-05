package com.project1.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="Department")
public class department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="d_id")
    private int department_id;

    @Column(name ="department_name")
    private String department_name;




    public department() {
    }

    public department(int department_id, String department_name) {
        this.department_id = department_id;
        this.department_name = department_name;
    }

    public department(String department_name) {
        this.department_name = department_name;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        department that = (department) o;
        return getDepartment_id() == that.getDepartment_id() && Objects.equals(getDepartment_name(), that.getDepartment_name());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDepartment_id(), getDepartment_name());
    }

    @Override
    public String toString() {
        return "department{" +
                "department_id=" + department_id +
                ", department_name='" + department_name + '\'' +
                '}';
    }
}

