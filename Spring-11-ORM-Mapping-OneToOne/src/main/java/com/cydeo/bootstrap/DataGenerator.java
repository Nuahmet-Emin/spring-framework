package com.cydeo.bootstrap;

import com.cydeo.entity.Department;
import com.cydeo.entity.Employee;
import com.cydeo.enums.Gender;
import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataGenerator implements CommandLineRunner {

    EmployeeRepository employeeRepository;
    DepartmentRepository departmentRepository;

    public DataGenerator(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }


    List<Employee> employeeList  = new ArrayList<>();
    List<Department> departmentList = new ArrayList<>();



    @Override
    public void run(String... args) throws Exception {

        Employee e1 = new Employee("Nurahmet","A","nurahmet@abc.com", LocalDate.of(2023,07,01), Gender.MALE,250000);
        Employee e2 = new Employee("Mike","Santosh","mike@abc.com", LocalDate.of(2023,01,01), Gender.MALE,200000);
        Employee e3 = new Employee("Allen","Bush","allen@abc.com", LocalDate.of(2023,04,01), Gender.MALE,220000);
        Employee e4 = new Employee("Jeff","Besus","jeff@abc.com", LocalDate.of(2023,02,01), Gender.MALE,120000);
        Employee e5 = new Employee("Elon","Cock","elon@abc.com", LocalDate.of(2023,03,01), Gender.MALE,230000);

        Department d1 = new Department("Sports","Outdoors");
        Department d2 = new Department("Tools","Hardware");
        Department d3 = new Department("Clothing","Home");
        Department d4 = new Department("Phone & Tablets","Electronics");
        Department d5 = new Department("Computers","Electronics");

        employeeList.addAll(Arrays.asList(e1,e2,e3,e4,e5));
        departmentList.addAll(Arrays.asList(d1,d2,d3,d4,d5));

    }
}
