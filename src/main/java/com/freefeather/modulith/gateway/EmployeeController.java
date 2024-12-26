package com.freefeather.modulith.gateway;

import com.freefeather.modulith.employee.EmployeeDto;
import com.freefeather.modulith.employee.GetAllEmployeesEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> findAll() throws Exception {
        try {
            GetAllEmployeesEvent event = new GetAllEmployeesEvent();
            publisher.publishEvent(event);
            List<EmployeeDto> result = event.getEmployees();

            if (result.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            Arrays.stream(ExceptionUtils.getRootCauseStackTrace(e)).forEach(msg -> log.error(msg));
            return ResponseEntity.internalServerError().build();
        }
    }
}
