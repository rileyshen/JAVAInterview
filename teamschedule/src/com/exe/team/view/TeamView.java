package com.exe.team.view;
/**
 * @Description
 */

import com.exe.team.service.NameListService;

import javax.swing.text.html.parser.Parser;

public class TeamView {
    public static void main(String[] args) {

        NameListService listSvc = new NameListService;
        TeamView teamView = new TeamView();

        public void enterMainMenu () {
            boolean isFlag = true;
            while (isFlag) {
                System.out.println("1 list all employees");
                System.out.println("2 get Team");
                System.out.println("3 add Member");
                System.out.println("4 delete Member");

                char c = TSUtility.readMenuSelection();
                switch (c) {
                    case '1':
                        teamView.listAllEmployees();
                        break;
                    case '2':
                        teamView.getTeam();
                        break;
                    case '3':
                        teamView.addMember();
                        break;
                    case '4':
                        teamView.deleteMember();
                }
            }

        }
    }

}


        public void listAllEmployees() {
            return NameListService.getAllEmployees();
        }

    public void getTeam() {
        return NameListService.getEmployee();
    }

    public void getMember() {
        return NameListService.getEmployee();
    }

    public void deleteMember() {
        return NameListService.getEmployee();
    }
    }

}
