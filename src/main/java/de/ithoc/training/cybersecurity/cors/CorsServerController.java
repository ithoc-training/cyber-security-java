package de.ithoc.training.cybersecurity.cors;

import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CorsServerController {

    private static final int EMPLOYEE_COUNT = 2;
    private final List<Employee> employees = new ArrayList<>(EMPLOYEE_COUNT);

    @PostConstruct
    private void init() {
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            Employee employee = new Employee();
            employee.setId(String.valueOf(i));
            employee.setEmail("employee." + i + "@example.com");
            employee.setFirstname("Firstname " + i);
            employee.setSurname("Surname " + i);
            employee.setDepartment("Department " + i);
            employee.setPosition("Position " + i);
            employees.add(employee);
        }
    }

    @GetMapping("/employees")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<Employee>> get() {

        return ResponseEntity.ok(this.employees);
    }

}
