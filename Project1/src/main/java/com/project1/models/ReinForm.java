package com.project1.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "reinbursement_Form")
public class ReinForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "form_id")
    private int form_id;

    @Column(name = "dates")
    private long date;

    @Column(name="locations")
    private String location;

    @Column(name="description")
    private String description;

    @Column(name="costs")
    private int costs;

    @Column(name="grade")
    private String grade;

    @Column(name="event_id")
    private int event_type;

    @ManyToOne
    @JoinColumn(name="grade_format", nullable = false)
    private gradingFormat grade_format;

    @ManyToOne
    @JoinColumn(name="stat_id", nullable = false)
    private status stat_id;

    @ManyToOne
    @JoinColumn(name="e_id")
    private Employee employee_id;



    public ReinForm(){

    }

    public ReinForm(int form_id, long date, String location, String description, int costs, String grade, int event_type, gradingFormat grade_format, status stat_id, Employee employee_id) {
        this.form_id = form_id;
        this.date = date;
        this.location = location;
        this.description = description;
        this.costs = costs;
        this.grade = grade;
        this.event_type = event_type;
        this.grade_format = grade_format;
        this.stat_id = stat_id;
        this.employee_id = employee_id;
    }


    public ReinForm(long date, String location, String description, int costs, String grade, int event_type, gradingFormat grade_format, status stat_id, Employee employee_id) {
        this.date = date;
        this.location = location;
        this.description = description;
        this.costs = costs;
        this.grade = grade;
        this.event_type = event_type;
        this.grade_format = grade_format;
        this.stat_id = stat_id;
        this.employee_id = employee_id;
    }





    public int getForm_id() {
        return form_id;
    }

    public void setForm_id(int form_id) {
        this.form_id = form_id;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCosts() {
        return costs;
    }

    public void setCosts(int costs) {
        this.costs = costs;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getEvent_type() {
        return event_type;
    }

    public void setEvent_type(int event_type) {
        this.event_type = event_type;
    }



    public gradingFormat getGrade_format() {
        return grade_format;
    }

    public void setGrade_format(gradingFormat grade_format) {
        this.grade_format = grade_format;
    }

    public status getStat_id() {
        return stat_id;
    }

    public void setStat_id(status stat_id) {
        this.stat_id = stat_id;
    }

    public Employee getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Employee employee_id) {
        this.employee_id = employee_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReinForm that = (ReinForm) o;
        return getForm_id() == that.getForm_id() && getDate() == that.getDate() && getCosts() == that.getCosts() && getGrade() == that.getGrade() && getGrade_format() == that.getGrade_format() && getStat_id() == that.getStat_id() && getEmployee_id() == that.getEmployee_id() && Objects.equals(getLocation(), that.getLocation()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getEvent_type(), that.getEvent_type());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getForm_id(), getDate(), getLocation(), getDescription(), getCosts(), getGrade(), getEvent_type(),  getGrade_format(), getStat_id(), getEmployee_id());
    }

    @Override
    public String toString() {
        return "Reinbursement_form{" +
                "form_id=" + form_id +
                ", date=" + date +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", costs=" + costs +
                ", grade=" + grade +
                ", event_type='" + event_type + '\'' +
                ", grade_format=" + grade_format +
                ", stat_id=" + stat_id +
                ", employee_id=" + employee_id +
                '}';
    }
}
