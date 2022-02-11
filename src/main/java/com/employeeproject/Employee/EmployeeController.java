package com.employeeproject.Employee;

import com.employeeproject.Employee.entities.Employee;
import com.employeeproject.Employee.util.GlobalResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    private static final List<Employee> employeesList;

    static {
        employeesList = new ArrayList<>();

        //1. adding hourly employees
        employeesList.add(new Employee("mohan", 1, 260, 0, 10));
        employeesList.add(new Employee("asdf", 2, 260, 0, 10));
        employeesList.add(new Employee("qwrtg", 3, 260, 0, 10));
        employeesList.add(new Employee("qwerr", 4, 260, 0, 10));
        employeesList.add(new Employee("czxdasd", 5, 260, 0, 10));
        employeesList.add(new Employee("pasd", 6, 260, 0, 10));
        employeesList.add(new Employee("lamsdwq", 7, 260, 0, 10));
        employeesList.add(new Employee("alweq", 8, 260, 0, 10));
        employeesList.add(new Employee("vzxds", 9, 260, 0, 10));
        employeesList.add(new Employee("werowq", 10, 260, 0, 10));

        //2. adding salaried employees

        employeesList.add(new Employee("dfdfwer", 11, 260, 1, 15));
        employeesList.add(new Employee("llopafd", 12, 260, 1, 15));
        employeesList.add(new Employee("wwwawe", 13, 260, 1, 15));
        employeesList.add(new Employee("asssia", 14, 260, 1, 15));
        employeesList.add(new Employee("ffaseqw", 15, 260, 1, 15));
        employeesList.add(new Employee("asdfqwereqw", 16, 260, 1, 15));
        employeesList.add(new Employee("asgscd", 17, 260, 1, 15));
        employeesList.add(new Employee("mmzxc", 18, 260, 1, 15));
        employeesList.add(new Employee("qweeeasd", 19, 260, 1, 15));
        employeesList.add(new Employee("asfqwe", 20, 260, 1, 15));

        //1. adding managers

        employeesList.add(new Employee("hhert", 21, 260, 2, 30));
        employeesList.add(new Employee("fffds", 22, 260, 2, 30));
        employeesList.add(new Employee("ZSDAS", 23, 260, 2, 30));
        employeesList.add(new Employee("weooif", 24, 260, 2, 30));
        employeesList.add(new Employee("kkksdf", 25, 260, 2, 30));
        employeesList.add(new Employee("uuisero", 26, 260, 2, 30));
        employeesList.add(new Employee("vvsdftt", 27, 260, 2, 30));
        employeesList.add(new Employee("llopsdf", 28, 260, 2, 30));
        employeesList.add(new Employee("saaawe", 29, 260, 2, 30));
        employeesList.add(new Employee("qweteq", 30, 260, 2, 30));


    }

    @GetMapping("/get/employees")
    public List<Employee> getEmployees() {
        return employeesList;
    }

    @GetMapping("/get/employee/{empid}")
    public Optional<Employee> getEmployee(@PathVariable("empid") Integer empid) {
        return employeesList.stream().filter(e -> e.getEmpId().equals(empid)).findFirst();
    }

    @GetMapping("/get/workday/{empid}/{workday}")
    public ResponseEntity<?> getEmployeesWorkDay(@PathVariable("empid") Integer empid, @PathVariable("workday") Integer workday) {
        Optional<Employee> employee = employeesList.stream().filter(e -> e.getEmpId().equals(empid)).findFirst();

        if (employee.isPresent()) {
            if (employee.get().getTotalWorkDays() > employee.get().getLeaveBalance()) {
                if (workday > 0 && workday <= employee.get().getTotalWorkDays()) {
                    Integer totalWorkDayBalance = employee.get().getTotalWorkDays() - workday;
                    employee.get().setTotalWorkDays(totalWorkDayBalance);
                    return GlobalResponseUtil.generateResponse(LocalDateTime.now(),
                            HttpStatus.OK,
                            "",
                            employee);
                } else {
                    return GlobalResponseUtil.generateResponse(LocalDateTime.now(),
                            HttpStatus.OK,
                            "Workday cannot be less than 0 and cannot be greater than 260",
                            employee);
                }
            } else {
                return GlobalResponseUtil.generateResponse(LocalDateTime.now(),
                        HttpStatus.OK,
                        "Workday cannot be less than 0 and cannot be greater than 260",
                        employee);
            }
        } else {
            return GlobalResponseUtil.generateResponse(LocalDateTime.now(),
                    HttpStatus.OK,
                    "No employee found",
                    employee);
        }
    }

    @GetMapping("/get/leave/{empid}/{leave}")
    public ResponseEntity<?> getEmployeesVacation(@PathVariable("empid") Integer empid, @PathVariable("leave") Integer leave) {
        Optional<Employee> employee = employeesList.stream().filter(e -> e.getEmpId().equals(empid)).findFirst();
        if (employee.isPresent()) {
            if (employee.get().getTotalWorkDays() > leave) {
                if (leave > 0 && leave <= employee.get().getLeaveBalance()) {
                    Integer leaveBalance = employee.get().getLeaveBalance() - leave;
                    employee.get().setLeaveBalance(leaveBalance);
                    Integer totalWorkDayBalance;
                    totalWorkDayBalance = employee.get().getTotalWorkDays() - employee.get().getLeaveBalance();
                    employee.get().setTotalWorkDays(totalWorkDayBalance);
                    return GlobalResponseUtil.generateResponse(LocalDateTime.now(),
                            HttpStatus.OK,
                            "",
                            employee);
                } else {
                    return GlobalResponseUtil.generateResponse(LocalDateTime.now(),
                            HttpStatus.OK,
                            "Leave cannot be less than 0 and cannot be greater than" + employee.get().getLeaveBalance() + " for the given employe type",
                            employee);
                }
            } else {
                return GlobalResponseUtil.generateResponse(LocalDateTime.now(),
                        HttpStatus.OK,
                        "Leave cannot be less than 0 and cannot be greater than" + employee.get().getLeaveBalance() + " for the given employe type",
                        employee);
            }
        } else {
            return GlobalResponseUtil.generateResponse(LocalDateTime.now(),
                    HttpStatus.OK,
                    "No employee found",
                    employee);
        }

    }

}

