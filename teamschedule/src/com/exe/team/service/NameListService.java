package com.exe.team.service;

import com.exe.team.domain.*;
import com.exe.team.domain.impl.*;

import static com.exe.team.service.Data.*;
/**
 * 要写文档注释
 * @Description 负责将Data数据封装到Employee[]数组中，同事提供相关操作Employee[]的方法
 * @Author riley riple.shen@gmail.com
 * @Version V1.0
 * @Date 2021
 *
 */
import static java.lang.Integer.bitCount;
import static java.lang.Integer.parseInt;

public class NameListService {

    private  Employee[] employees;

    public NameListService() {
//        根据项目提供的Data类构建相应大小的employees数组
//                构造不同数据，包括Employee，Programmer， Designer， Architect，将数组存入对象中


//        employees = new Employee[Data.EMPLOYEES.length]; 方法一，不导入Data
      // 方法2： import static com.exe.team.service.Data.*;导入 Data下的所有的静态结构，括号里面Data去掉 employees = new Employee[EMPLOYEES.length];
        employees = new Employee[EMPLOYEES.length];

        for (int i = 0; i < employees.length; i++) {
//            if ( Integer.parseInt(EMPLOYEES[i][0]) == 10 ) { 原来代码
            int type = Integer.parseInt(EMPLOYEES[i][0]);

//            下面重复代码，获取Employee4个基本信息
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);
            // 申明处
            Equipment equipment;
            double bonus;
            int stock;

            switch (type) {
//               case 10; 原代码，体验很差
//                public static final int EMPLOYEE = 10; Data类里面就有这个属性，所以直接用EMPLOYEE来代替
                case EMPLOYEE:
                    employees[i] = new Employee(id, name, age, salary); // 重复代码属性，所以在上面加了id，name这些，都是后面发现写到前面的
                    break;
                case PROGRAMMER:
//                    Equipment equipment = createEquipment(i); // 因为equipment下面还有三个属性，无法在一行中完成，所以需要另外创造一个类, 还需要知道i的员工的位置
                    equipment = createEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary, equipment);
                    break;
                case DESIGNER:
                    // 此时代码 equipment 报错，因为没有申明，如果再 复制一次Equipment equipment = createEquipment(i);
                    // 又太冗长，如果把代码提前到上面EMPLOYEE 4个基本信息处？？思考？？
                    // 会报错，因为不是所有的都有equipment，有空出现，所以上面只申请，不处理

//                    double bonus = Double.parseDouble(EMPLOYEES[i][5]);
//                    employees[i] = new Designer(id, name, age, salary, equipment, bonus);
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id, name, age, salary, equipment, bonus);
                    break;
                case ARCHITECT:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
                    break;
            }
        }
    }

    /**
     * @Description 获取指定index上的员工的设备
     * @param index
     * @return
     */
    private Equipment createEquipment(int index) {

        int key = Integer.parseInt(EQUIPMENTS[index][0]);
        switch (key) {
            case PC:
//          return new PC(model, display); 需要复制，这时候model和display是空的，所以用数组
                return new PC(EQUIPMENTS[index][1], EQUIPMENTS[index][2]);
//                break; 要去掉break，继续
            case NOTEBOOK:
                return new NoteBook(EQUIPMENTS[index][1], Double.parseDouble(EQUIPMENTS[index][2]));

            case PRINTER:
                return new Printer(EQUIPMENTS[index][1], EQUIPMENTS[index][2]);
    }
    return null;
}


    /**
     * 获取当前所有的员工
     * @Description
     * @return
     */
     public Employee[] getAllEmployees() {
        return employees;
    }

    /**
     * @Description
     * @param id
     * @return
     * @throws TeamException
     */
    public Employee getEmployee(int id) throws TeamException {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                return employees[i];
            }
        }
       throw new TeamException("cannot find");
    }
}
