package com.project1.models;

import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "status")
public class status {

    @Id
    @Column(name = "status_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int status_id;


    @Column(name = "bencoApprove")
    private boolean bencoApprove;

    @Column(name = "depHeadApprove")
    private boolean depHeadApprove;

    @Column(name = "supApprove")
    private boolean supApprove;


    public status() {
    }



    @Override
    public int hashCode() {
        return Objects.hash(getStatus_id(), isBencoApprove(), isDepHeadApprove(), isSupApprove());
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public boolean isBencoApprove() {
        return bencoApprove;
    }

    public void setBencoApprove(boolean bencoApprove) {
        this.bencoApprove = bencoApprove;
    }

    public boolean isDepHeadApprove() {
        return depHeadApprove;
    }

    public void setDepHeadApprove(boolean depHeadApprove) {
        this.depHeadApprove = depHeadApprove;
    }

    public boolean isSupApprove() {
        return supApprove;
    }

    public void setSupApprove(boolean supApprove) {
        this.supApprove = supApprove;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        status status = (status) o;
        return getStatus_id() == status.getStatus_id() && isBencoApprove() == status.isBencoApprove() && isDepHeadApprove() == status.isDepHeadApprove() && isSupApprove() == status.isSupApprove();
    }

    @Override
    public String toString() {
        return "status{" +
                "status_id=" + status_id +
                ", bencoApprove=" + bencoApprove +
                ", depHeadApprove=" + depHeadApprove +
                ", supApprove=" + supApprove +
                '}';
    }
}
