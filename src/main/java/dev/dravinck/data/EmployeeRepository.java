package dev.dravinck.data;

import dev.dravinck.domain.employee.CreateEmployeeDTO;
import dev.dravinck.domain.employee.Employee;

public interface EmployeeRepository {
  Employee findByEmail(String email);
  Employee create(CreateEmployeeDTO employee);
}
