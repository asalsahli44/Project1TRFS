package com.project1.Services;

import com.project1.models.departmenthead;

import java.util.List;

public interface DepartmentHeadService {
    public departmenthead getDepartmentHead(int id);

    public departmenthead addDepartmentHead(departmenthead dh);

    public departmenthead deleteDepartmentHead(int id);

    public departmenthead updateDepartmentHead(departmenthead change);

    public List<departmenthead> getAllDepartmentHeads();
}
