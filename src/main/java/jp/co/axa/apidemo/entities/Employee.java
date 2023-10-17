package jp.co.axa.apidemo.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name="EMPLOYEE")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="EMPLOYEE_NAME")
    private String name;

    @Column(name="EMPLOYEE_SALARY")
    private Integer salary;

    @Column(name="DEPARTMENT")
    private String department;

    @Column(name="STATUS")
    private Integer status;

    @Column(name="STATUS_TIME")
    private LocalDateTime statusTime; // To know when the status is updated

    @Column(name="CREATE_TIME")
    private LocalDateTime createTime; // Always a good practice to know when the record was inserted

    public enum Status{
        CURRENT,
        ARCHIVED,
        DELETED
    }

}
