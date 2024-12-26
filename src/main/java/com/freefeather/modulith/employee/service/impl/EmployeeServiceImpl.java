package com.freefeather.modulith.employee.service.impl;

import com.freefeather.modulith.employee.EmployeeDto;
import com.freefeather.modulith.employee.GetAllEmployeesEvent;
import com.freefeather.modulith.employee.repository.EmployeeRepository;
import com.freefeather.modulith.employee.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @EventListener
    public void getAll(GetAllEmployeesEvent event) {

        event.setEmployees(employeeRepository.findAll().stream()
                .map(employee -> modelMapper.map(employee, EmployeeDto.class))
                .collect(Collectors.toList()));
    }
}
