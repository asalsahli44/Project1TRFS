package com.project1.models;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "Department_head")
public class departmenthead {

    @Id
    @Column(name="dept_id")
    private int dept_id;

    @OneToOne
    @Column(name="dep_head")
    private Employee dep_head;



    public departmenthead() {
    }

    public departmenthead(Employee dep_head) {
        this.dep_head = dep_head;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public Employee getDep_head() {
        return dep_head;
    }

    public void setDep_head(Employee dep_head) {
        this.dep_head = dep_head;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        departmenthead that = (departmenthead) o;
        return getDept_id() == that.getDept_id() && getDep_head() == that.getDep_head();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDept_id(), getDep_head());
    }

    @Override
    public String toString() {
        return "department_head{" +
                "dept_id=" + dept_id +
                ", dep_head=" + dep_head +
                '}';
    }
}
