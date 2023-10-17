package jp.co.axa.apidemo.repositories;

import jp.co.axa.apidemo.entities.Employee;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Override
    @CacheEvict(cacheNames = "employees", key = "#result.id")
    <S extends Employee> S save(S s);

    @Override
    @Cacheable("employees")
    Optional<Employee> findById(Long aLong);
}
