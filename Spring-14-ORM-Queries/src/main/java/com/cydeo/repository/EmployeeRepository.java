package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    //Display all employees with email address

    List<Employee> findByEmail(String email);

    //Display all employes with first name '' and last name ' ', also show all employees with an email address
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastName, String email);

    //Display all employees that first name is not ' '
    List<Employee> findByFirstNameIsNot(String firstName);

    //Display all employees where last name starts with ' '
    List<Employee> findByLastNameStartsWith(String pattern);

    //Display all employees with salaries higher than ' '
    List<Employee> findBySalaryGreaterThan(Integer salary);

    //Display all employees with salaries less than ' '
    List<Employee> findBySalaryLessThanEqual(Integer salary);

    //Display all employees that has been hired between '' and ''
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    //Display all employees where salaries greater and equal to '' in order
    List<Employee> findBySalaryGreaterThanEqualOrderBySalaryDesc(Integer salary);

    //Display top unique 3 employees that is making less than
    List<Employee> findDistinctTopBySalaryLessThan(Integer salary);

    //Display all employees that do not have email address
    List<Employee> findByEmailIsNotNull();


    @Query("SELECT e FROM Employee e WHERE e.email = 'sdubber7@t-online.de'")
    Employee getEmployeeDetail();

    @Query("SELECT e.salary from Employee e where e.email = 'sdubber7@t-online.de'")
    Integer getEmployeeSalary();

    @Query("select e From Employee e where e.email =?1")
    Optional<Employee> getEmployeeDetail(String email);

    @Query("Select e From Employee e Where e.email =?1 and e.salary =?2 ")
    Employee getEmployeeDetail(String email, int salary);

    //Not Equal
    @Query("SELECT e FROM Employee e WHERE e.salary<>?1")
    List<Employee> getEmployeeSalaryNotEqual(int salary);

    //like/contains/startswith/endswith
    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE ?1")
    List<Employee> getEmployeeFirstNameLike(String pattern);

    //less than
    @Query("SELECT e FROM Employee e WHERE e.salary < ?1")
    List<Employee> getEmployeeSalaryLessThan(int salary);

    //greater than
    @Query("SELECT e FROM Employee e WHERE e.salary > ?1")
    List<Employee> getEmployeeSalaryGreaterThan(int salary);


    //between
    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN ?1 and ?2 ")
    List<Employee> getEmployeeSalaryBetween(int Salary1, int Salary2);

    //before dates
    @Query("SELECT e FROM Employee e WHERE e.hireDate < ?1")
    List<Employee> getEmployeeHireDateBefore(LocalDate date);

    //Null
    @Query("select e from Employee e where e.email IS null ")
    List<Employee> getEmployeeEmailIsNull();

    //NotNull
    @Query("select e from Employee e where e.email IS NOT null ")
    List<Employee> getEmployeeEmailIsNotNull();

    //Sorting in ascending order
    @Query("select e from Employee e ORDER BY e.salary")
    List<Employee> getEmployeeSalaryOrderAsc();

    //Sorting in descending order
    @Query("select e from Employee e ORDER BY e.salary desc ")
    List<Employee> getEmployeeSalaryOrderDesc();

    @Query(value = "SELECT * FROM employees WHERE salary ?1, nativeQuery= ture")
    List<Employee> readEmployeeDetailBySalary(int Salary);

    @Query("SELECT e from Employee e WHERE e.salary = :salary")
    List<Employee>  getEmployeeSalary(@Param("salary")int salary);

    @Modifying
    @Transactional
    @Query("UPDATE Employee e SET e.email = 'admin@email.com' where e.id=:id")
    void updateEmployeeJPQL(@Param("id") int id);


    @Modifying
    @Transactional
    @Query(value = "update employees Set email = 'admin@email.com' where id=:id", nativeQuery = true)
    void updateEmployeeNativeQuery(@Param("id") int id);



}

