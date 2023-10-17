package jp.co.axa.apidemo;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.services.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApiDemoApplicationTests {

    @Autowired
    EmployeeService employeeService;

    @Test
    public void contextLoads() {

    }

    @Autowired
    public MockMvc mvc;

    /**
     * Simple sample of mock test
     */
    @Test
    public void testLoadEmployee() throws Exception {

        employeeService.saveEmployee(Employee.builder().id(1L)
                .name("Jack").salary(500_000).department("Human Resource")
                .build());

        mvc.perform(get("/api/v1/employees/1")
//                        .with(user("admin").password("pass").roles("USER", "ADMIN"))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.salary").value(500_000))
                .andExpect(jsonPath("$.department").value("Human Resource"))
                .andExpect(jsonPath("$.name").value("Jack"));
    }

}
