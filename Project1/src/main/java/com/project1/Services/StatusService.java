package com.project1.Services;

import com.project1.models.status;

import java.util.List;

public interface StatusService {
    public status getStatus(int id);
    public status deleteStatus(int id);
    public status addStatus(status s);
    public status updateStatus(status change);
    public List<status> getAllStatus();
}
