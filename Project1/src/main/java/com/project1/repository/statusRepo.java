package com.project1.repository;

import com.project1.models.status;

import java.util.List;

public interface statusRepo {
    public status getStatus(int id);
    public status deleteStatus(int id);
    public status addStatus(status s);
    public status updateStatus(status change);
    public List<status> getAllStatus();

}
