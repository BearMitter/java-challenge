package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> retrieveEmployees() {
        List<Employee> employees = employeeRepository.findAll(Example.of(Employee.builder()
                .status(Employee.Status.CURRENT.ordinal()).build()));
        return employees;
    }

    public Employee getEmployee(Long employeeId) {
        Optional<Employee> optEmp = employeeRepository.findById(employeeId);
        return optEmp.orElse(null);
    }

    public void saveEmployee(Employee employee) {
        if (employee.getCreateTime() == null) {
            employee.setStatus(Employee.Status.CURRENT.ordinal());
            employee.setStatusTime(LocalDateTime.now());
            employee.setCreateTime(LocalDateTime.now());
        }
        employeeRepository.save(employee);
    }


    /**
     *  Update status rather than delete record in Database
     */
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(NoSuchElementException::new);
        employee.setStatus(Employee.Status.DELETED.ordinal());
        employee.setStatusTime(LocalDateTime.now());
        employeeRepository.save(employee);
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}