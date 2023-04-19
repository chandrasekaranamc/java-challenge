package jp.co.axa.employee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import jp.co.axa.employee.entities.Employee;

/**
 * 
 * 従業員Repositoryのインタフェース
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
