package jp.co.axa.employee.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 従業員テーブルの情報を保持するクラス
 *
 */
@Entity
@Table(name="EMPLOYEE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

    /**
     * 従業員 ID
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    /**
     * 従業員名
     */
    @Column(name="EMPLOYEE_NAME")
    private String name;
    /**
     * 従業員の給与
     */
    @Column(name="EMPLOYEE_SALARY")
    private Integer salary;
    /**
     * 従業員部門
     */
    @Column(name="DEPARTMENT")
    private String department;

}
