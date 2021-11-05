package com.project1.models;

import javax.persistence.*;
import java.util.Objects;


//
@Entity
@Table(name="grading_format")
public class gradingFormat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id", updatable = false)
    private int grade_id;

    @Column(name = "presentation")
    private String presentation;


    public gradingFormat() {
    }

    public gradingFormat(int grade_id, String presentation) {
        this.grade_id = grade_id;
        this.presentation = presentation;

    }

    public gradingFormat(String presentation) {
        this.presentation = presentation;

    }

    public int getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(int grade_id) {
        this.grade_id = grade_id;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        gradingFormat that = (gradingFormat) o;
        return getGrade_id() == that.getGrade_id() && Objects.equals(getPresentation(), that.getPresentation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGrade_id(), getPresentation());
    }

    @Override
    public String toString() {
        return "gradingFormat{" +
                "grade_id=" + grade_id +
                ", presentation='" + presentation + '\'' +
                '}';
    }
}






