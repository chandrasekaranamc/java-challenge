package jp.co.axa.employee.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import jp.co.axa.employee.entities.Employee;
import jp.co.axa.employee.repositories.EmployeeRepository;
import jp.co.axa.employee.services.EmployeeServiceImpl;

@SpringBootTest(classes= {EmployeeServiceTest.class})
public class EmployeeServiceTest {

  @InjectMocks
  EmployeeServiceImpl employeeService;
  @Mock
  EmployeeRepository employeeRepository;

  @Test
  public void retrieveEmployeesTest() {
    List<Employee> employeeList = new ArrayList<>();
    employeeList.add(new Employee(1l, "chandrasekaran",80000000,"Accounts"));
    employeeList.add(new Employee(2l, "Taniguchi",90000000,"Sales"));
    when(employeeRepository.findAll()).thenReturn(employeeList);
    assertEquals(2, employeeService.retrieveEmployees().size());
  }
  
  @Test
  public void getEmployeeTest() {
    Long employeeId = 1L;
    List<Employee> employeeList = new ArrayList<>();
    Optional<Employee> employee = Optional.ofNullable(new Employee(1l, "chandrasekaran",80000000,"Accounts"));
    employeeList.add(new Employee(1L, "Taniguchi",90000000,"Sales"));
    when(employeeRepository.findById(employeeId)).thenReturn(employee);
    assertEquals(employeeId, employeeService.getEmployee(employeeId).getId());
  }
  
  @Test
  public void saveEmployeeTest() {
    Employee employee = new Employee(1L, "chandrasekaran",80000000,"Accounts");
    when(employeeRepository.save(employee)).thenReturn(employee);
    employeeService.saveEmployee(employee);
    Mockito.verify(employeeRepository, times(1)).save(employee);
  }
  
  @Test
  public void deleteEmployeeTest() {
    Long employeeId = 1L;
    employeeService.deleteEmployee(employeeId);
    Mockito.verify(employeeRepository, times(1)).deleteById(employeeId);
  }
  
  @Test
  public void updateEmployeeTest() {
    Employee employee = new Employee(1L, "Taniguchi",80000000,"Accounts");
    when(employeeRepository.save(employee)).thenReturn(employee);
    employeeService.updateEmployee(employee);
    Mockito.verify(employeeRepository, times(1)).save(employee);
  }
  
}
