package com.exe.team.view;
/**
 * @Description
 */

import com.exe.team.service.NameListService;
import com.exe.team.service.TeamService;

public class TeamView {

    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    public void enterMainMenu() {

        boolean isFlag = true;

        while (isFlag) {
            listAllEmployees();

            System.out.println("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择（1-4）， ");


            char menu = TSUtility.readMenuSelection();
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
                    System.out.println("退出");
                    isFlag = false;
            }
        }

    }


    private void listAllEmployees() {

        System.out.println("公司所有员工");
    }

    private void getTeam() {

        System.out.println("1 团队列表");
    }

    private void getMember() {

        System.out.println("2 添加成员");
    }

    private void deleteMember() {

        System.out.println("3 删除成员");
    }

    public static void main(String[] args) {
        TeamView view = new TeamView();
        view.enterMainMenu();
    }

}


