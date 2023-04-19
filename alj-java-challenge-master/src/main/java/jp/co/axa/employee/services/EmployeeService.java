package jp.co.axa.employee.services;

import java.util.List;
import jp.co.axa.employee.entities.Employee;

/**
 * 従業員のインタフェース
 */
public interface EmployeeService {

  /**
   * 従業員情報を取得.<br>
   * 
   * @return 従業員リスト オブジェクトを返します
   */
  List<Employee> retrieveEmployees();

  /**
   * 社員IDで社員情報を取得.<br>
   * 
   * @return 従業員オブジェクトを返します
   */
  Employee getEmployee(Long employeeId);

  /**
   * 社員IDで社員情報を保存.<br>
   * 
   */
  void saveEmployee(Employee employee);

  /**
   * 社員IDで社員情報削除.<br>
   * 
   */
  void deleteEmployee(Long employeeId);

  /**
   * 社員IDで社員情報を更新.<br>
   * 
   */
  void updateEmployee(Employee employee);
}
