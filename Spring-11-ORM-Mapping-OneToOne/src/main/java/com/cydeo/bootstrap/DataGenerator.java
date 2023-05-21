package com.cydeo.bootstrap;

import com.cydeo.entity.Department;
import com.cydeo.entity.Employee;
import com.cydeo.entity.Region;
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
    //DepartmentRepository departmentRepository;

    public DataGenerator(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;

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

        Region r1 = new Region("East","US");
        Region r2 = new Region("West","Turkey");
        Region r3 = new Region("Asia","East Turkistan");
        Region r4 = new Region("Europe","France");
        Region r5 = new Region("Africa","Congo");

        e1.setDepartment(d1);
        e2.setDepartment(d2);
        e3.setDepartment(d3);
        e4.setDepartment(d4);
        e5.setDepartment(d5);

        e1.setRegion(r1);
        e2.setRegion(r2);
        e3.setRegion(r3);
        e4.setRegion(r4);
        e5.setRegion(r5);


        employeeList.addAll(Arrays.asList(e1,e2,e3,e4,e5));
        departmentList.addAll(Arrays.asList(d1,d2,d3,d4,d5));

        employeeRepository.saveAll(employeeList);
        //departmentRepository.saveAll(departmentList);

    }
}
