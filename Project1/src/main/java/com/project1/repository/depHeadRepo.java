package com.project1.repository;

import com.project1.models.departmenthead;

import java.util.List;

public interface depHeadRepo {
    public departmenthead getDepartmentHead(int id);

   // public departmenthead addDepartmentHead(departmenthead dh);

    public departmenthead deleteDepartmentHead(int id);

    public departmenthead updateDepartmentHead(departmenthead change);

    public List<departmenthead> getAllDepartmentHeads();
}
