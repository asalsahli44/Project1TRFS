package com.project1.Services;

import com.project1.models.Employee;
import com.project1.models.ReinForm;

import java.util.List;

public interface ReinFormService {
    public ReinForm getReinForm(int id);
    public ReinForm addReinForm(ReinForm RF);
    public ReinForm deleteReinForm(int id);
    public ReinForm updateReinForm(ReinForm change);
    public List<ReinForm> getAllForms();
    public List<ReinForm> getAllFormsbyE(int id);
    public List<ReinForm> approveForms(int id);

}
