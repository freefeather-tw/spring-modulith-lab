package com.freefeather.modulith.employee;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class GetAllEmployeesEvent {

    private final CompletableFuture<List<EmployeeDto>> future = new CompletableFuture<>();

    public void setEmployees(List<EmployeeDto> employees) {
        future.complete(employees);
    }

    public List<EmployeeDto> getEmployees() throws Exception {
        return future.get(30, TimeUnit.SECONDS);//等待三十秒，若超過會丟出Exception
    }
}
