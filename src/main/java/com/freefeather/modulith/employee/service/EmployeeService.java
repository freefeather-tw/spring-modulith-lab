package com.freefeather.modulith.employee.service;

import com.freefeather.modulith.employee.GetAllEmployeesEvent;

public interface EmployeeService {
    void getAll(GetAllEmployeesEvent event);
}
