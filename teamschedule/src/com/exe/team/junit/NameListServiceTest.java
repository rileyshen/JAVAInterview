package com.exe.team.junit;

import com.exe.team.domain.Employee;
import com.exe.team.service.NameListService;
import com.exe.team.service.TeamException;
import org.junit.Test;

/**
 * @Description 对NameListService类的测试
 */
public class NameListServiceTest {

    @Test
    public void testGetAllEmployees() {
        NameListService service = new NameListService();
        Employee[] allEmployees = service.getAllEmployees();

        for (int i = 0; i < allEmployees.length; i++) {
            System.out.println(allEmployees[i]);

        }
    }

    @Test
    public void testGetEmployee() {
        NameListService service = new NameListService();
        int id = 1;
        id = 10;
        id = 100;
        try {
            Employee employee = service.getEmployee(id);
            System.out.println(employee);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }


}
