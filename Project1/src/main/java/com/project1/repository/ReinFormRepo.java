package com.project1.repository;

import com.project1.models.Employee;
import com.project1.models.ReinForm;
import com.project1.models.status;

import java.util.List;

public interface ReinFormRepo {
    public ReinForm getReinForm(int id);
    public ReinForm addReinForm(ReinForm RF);
    public ReinForm deleteReinForm(int id);
    public ReinForm updateReinForm(ReinForm change);
    public List<ReinForm> getAllForms();


}
