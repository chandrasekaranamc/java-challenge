package jp.co.axa.employee.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jp.co.axa.employee.entities.Employee;
import jp.co.axa.employee.services.EmployeeService;
import lombok.RequiredArgsConstructor;

/**
 * 従業員のControllerクラス.<br>
 */
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class EmployeeController {

  /**
   * 従業員情報取得、更新、削除、保存を行うオブジェクト.<br>
   */
  private final EmployeeService employeeService;

  /**
   * 従業員情報を取得.<br>
   * 
   * @return 従業員リスト オブジェクトを返します
   */
  @GetMapping("/employees")
  public List<Employee> getEmployees() {
    List<Employee> employees = employeeService.retrieveEmployees();
    return employees;
  }

  /**
   * 社員IDで社員情報を取得.<br>
   * 
   * @return 従業員オブジェクトを返します
   */
  @GetMapping("/employees/{employeeId}")
  public Employee getEmployee(@PathVariable(name = "employeeId") Long employeeId) {
    return employeeService.getEmployee(employeeId);
  }

  /**
   * 社員IDで社員情報を保存.<br>
   * 
   */
  @PostMapping("/employees")
  public void saveEmployee(Employee employee) {
    employeeService.saveEmployee(employee);
  }

  /**
   * 社員IDで社員情報削除.<br>
   * 
   */
  @DeleteMapping("/employees/{employeeId}")
  public void deleteEmployee(@PathVariable(name = "employeeId") Long employeeId) {
    employeeService.deleteEmployee(employeeId);
  }

  /**
   * 社員IDで社員情報を更新.<br>
   * 
   */
  @PutMapping("/employees/{employeeId}")
  public void updateEmployee(@RequestBody Employee employee, @PathVariable(name = "employeeId") Long employeeId) {
    Employee emp = employeeService.getEmployee(employeeId);
    if (emp != null) {
      employeeService.updateEmployee(employee);
    }

  }

}
