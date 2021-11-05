package com.project1.models;


import javax.persistence.*;

@Entity
@Table(name="Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name_")
    private String name_;

    @Column(name="supervisor_id")
    private int supervisor_id;

    @Column(name="email")
    private String email;

    @Column(name="benco")
    private boolean benco; // are they a benefit coodinator

    @ManyToOne
    @JoinColumn(name="department_id")
    private department department_id;

    @Column(name="username")
    private String username;

    @Column(name="e_password")
    private String password;

    public Employee() {
    }

    public Employee(String name_, int supervisor_id, String email, boolean benco, department department_id, String username, String password) {
        this.name_ = name_;
        this.supervisor_id = supervisor_id;
        this.email = email;
        this.benco = benco;
        this.department_id = department_id;
        this.username = username;
        this.password = password;
    }

    public Employee(int id, String name_, int supervisor_id, String email, boolean benco, department department_id,String username, String password) {
        this.id = id;
        this.name_ = name_;
        this.supervisor_id = supervisor_id;
        this.email = email;
        this.benco = benco;
        this.department_id = department_id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name_;
    }

    public void setName(String name) {
        this.name_ = name;
    }

    public int getSupervisor_id() {
        return supervisor_id;
    }

    public void setSupervisor_id(int supervisor_id) {
        this.supervisor_id = supervisor_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isBenco() {
        return benco;
    }

    public void setBenco(boolean benco) {
        this.benco = benco;
    }

    public department getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(department department_id) {
        this.department_id = department_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name_ + '\'' +
                ", supervisor_id=" + supervisor_id +
                ", email='" + email + '\'' +
                ", benco=" + benco +
                ", department_id=" + department_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

