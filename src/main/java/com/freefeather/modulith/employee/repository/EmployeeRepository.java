package com.freefeather.modulith.employee.repository;

import com.freefeather.modulith.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
}
