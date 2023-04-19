package jp.co.axa.employee.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import jp.co.axa.employee.entities.Employee;
import jp.co.axa.employee.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;


/**
 * 従業員 ユースケースクラス
 */
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    /**
     * 従業員情報を取得.<br>
     * 
     * @return 従業員リスト オブジェクトを返します
     */
    public List<Employee> retrieveEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }
    
    /**
     * 社員IDで社員情報を取得.<br>
     * 
     * @return 従業員オブジェクトを返します
     */
    public Employee getEmployee(Long employeeId) {
        Optional<Employee> optEmp = employeeRepository.findById(employeeId);
        if (optEmp.isPresent()) {
          return optEmp.get();
        } else {
          return new Employee();
        }
    }

    /**
     * 社員IDで社員情報を保存.<br>
     * 
     */
    public void saveEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    /**
     * 社員IDで社員情報削除.<br>
     * 
     */
    public void deleteEmployee(Long employeeId){
        employeeRepository.deleteById(employeeId);
    }

    /**
     * 社員IDで社員情報を更新.<br>
     * 
     */
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}