package com.project1.Services;

import com.project1.models.status;
import com.project1.repository.StatusRepoHBImpl;
import com.project1.repository.statusRepo;

import java.util.List;

public class StatusServiceImpl implements StatusService{

    statusRepo sr;

    public StatusServiceImpl(statusRepo sr) {
        this.sr = sr;
    }

    @Override
    public status getStatus(int id) {
        return sr.getStatus(id);
    }

    @Override
    public status deleteStatus(int id) {
        return sr.deleteStatus(id);
    }

    @Override
    public status addStatus(status s) {
        return sr.addStatus(s);
    }

    @Override
    public status updateStatus(status change) {
        return sr.updateStatus(change);
    }

    @Override
    public List<status> getAllStatus() {
        return sr.getAllStatus();
    }
}
