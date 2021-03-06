package com.exe.team.view;
/**
 * @Description
 *
 *
 */
/**
 * @ author
 * @Create
 *
 */

import com.exe.team.domain.Employee;
import com.exe.team.domain.Programmer;
import com.exe.team.service.NameListService;
import com.exe.team.service.TeamException;
import com.exe.team.service.TeamService;

public class TeamView {

    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    public void enterMainMenu() {

        boolean isFlag = true;
        char menu = 0;
        while (isFlag) {

            if (menu != '1') {
                listAllEmployees();
            }

            System.out.print("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择（1-4): ");


            menu = TSUtility.readMenuSelection();
            switch (menu) {
                case '1':
                    getTeam();

                    break;
                case '2':
                    getMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
//                    System.out.println("退出"); version 1
//                    isFlag = false; v
                  System.out.println("确认是否退出");
                    char isExit = TSUtility.readConfirmSelection();
                    if(isExit == 'Y') {
                        isFlag = false;
                    }
                    break;
            }
        }

    }


    private void listAllEmployees() {

//        System.out.println("公司所有员工"); v1.0
        System.out.println("---------------------------------开发团队调度软件-------------------------\n");
        Employee[] employees = listSvc.getAllEmployees();
        if (employees == null || employees.length == 0) {
            System.out.println("公司里面没有任何员工信息 ");
        } else {
            System.out.println("ID\t姓名 \t年龄\t工资\t\t职位\t\t状态\t\t奖金\t\t\t股票\t\t领用设备");

            for (int i = 0; i < employees.length; i++) {
                System.out.println(employees[i]);
            }
        }
        System.out.println("---------------------------------开发团队调度软件-------------------------\n");
    }

    private void getTeam() {

//        System.out.println("1 团队列表"); v1.0
        System.out.println("---------------------------------团队成员列表-------------------------\n");

        Programmer[] team = teamSvc.getTeam();
        if (team == null || team.length == 0) {
            System.out.println("目前团队没有成员");
        } else {
            System.out.println("TID\t姓名\t年龄\t工资\t职位\t奖金\t股票");
            for (int i = 0; i < team.length; i++) {
                System.out.println(team[i].getDetailsForTeam());
            }
        }

        System.out.println("---------------------------------团队成员列表-------------------------\n");
    }

    private void getMember() {

//        System.out.println("2 添加成员"); v1.0
        System.out.println("---------------------------------添加成员-------------------------\n");
        System.out.print("请输入成员id： ");
        int id = TSUtility.readInt();

        Employee emp = null;
        try {
            emp = listSvc.getEmployee(id);
            teamSvc.addMember(emp);
            System.out.println("添加成功");
            // 回车键继续

        } catch (TeamException e) {
            System.out.println("添加失败，原因： " + e.getMessage());

        }
        TSUtility.readReturn();
    }

    private void deleteMember() {

//        System.out.println("3 删除成员");
        System.out.println("---------------------------------删除成员-------------------------\n");
        System.out.print("请输入成员TId： ");
        int memId = TSUtility.readInt();
        System.out.println("确认删除？(Y/N): ");
        char isDel = TSUtility.readConfirmSelection();
        if (isDel == 'N') {
            return;
        }
        try {
            teamSvc.removeMember(memId);
            System.out.println("删除成功");
        } catch (TeamException e) {
            System.out.println("失败，原因： " + e.getMessage());
        }
        TSUtility.readReturn();
    }

    public static void main(String[] args) {
        TeamView view = new TeamView();
        view.enterMainMenu();

    }

}

/**
 *
 *
 */
