package jp.co.axa.apidemo.controllers;

import io.swagger.annotations.ApiOperation;
import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

     @GetMapping("/employees")
     @ApiOperation("Returns all of the employees")
    public List<Employee> getEmployees() {
        return employeeService.retrieveEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    @ApiOperation("Return one employee by employeeId")
    public Employee getEmployee(@PathVariable(name="employeeId")Long employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @PostMapping("/employees/save")
    @ApiOperation("Save one employee")
    public void saveEmployee(Employee employee){
        employeeService.saveEmployee(employee);
        logger.info("Employee Saved Successfully, employee:{}", employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    @ApiOperation("Delete one employee by employeeId")
    public void deleteEmployee(@PathVariable(name="employeeId")Long employeeId){
        employeeService.deleteEmployee(employeeId);
        logger.info("Employee Deleted Successfully, employeeId:{}", employeeId);
    }

    @PutMapping("/employees/{employeeId}")
    @ApiOperation("Update one employee by employeeId")
    public void updateEmployee(@RequestBody Employee employee,
                               @PathVariable(name="employeeId")Long employeeId){
        Employee emp = employeeService.getEmployee(employeeId);
        if(emp != null){
            employeeService.updateEmployee(employee);
        }

    }

}
