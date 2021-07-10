package com.exe.team.service;

import com.exe.team.domain.Architect;
import com.exe.team.domain.Designer;
import com.exe.team.domain.Employee;
import com.exe.team.domain.Programmer;

/**
 * @Description 关于开发团队的CRUD
 */
public class TeamService {

    private static int counter = 1; // 给memberId赋值
    private final int MAX_MEMBER = 5;
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total;


    /**
     * @Description 获取开发团队中的所有成员
     * @return
     */
    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < team.length; i++) {
            team[i] = this.team[i];
        }
        return team;
    }

    /**
     * @Description 将制定的员工添加到开发团队中
     * @return
     */
    public void addMember(Employee e) throws TeamException {
        // 成员已满
        if (total >= MAX_MEMBER) {
            throw new TeamException("成员已满");
        }
        // 改成员不是开发成员
        if (!(e instanceof Programmer)) {
            throw new TeamException("成员不是开发成员");
        }
        // 改员工已经在开发团队中，要遍历，代码要好几行，做个方法
        if (isExist(e)) {
            throw new TeamException("员工已经在开发团队中");
        }
        // 该员工正在休假
        Programmer p = (Programmer) e; // 一定不会出现ClassCastException
//        if (p.getStatus().getNAME().equals("BUSY")) { 不好的写法
        if ("BUSY".equals(p.getStatus().getNAME())) {
            throw new TeamException("该员工已经是某团队成员");
        } else if ("VOCATION".equals(p.getStatus().getNAME())) {
            throw new TeamException("该员工正在休假");
        }
        // 团队至多只能有一名构架师
        // 团队至多只能有2名设计师
        // 团队至多只能有3名程序员

        // 获取team中已有成员中架构师，设计师，程序员人数
        int numOfArch = 0, numOfDes = 0, numOfPro = 0;
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect) {
                numOfArch++;
            } else if (team[i] instanceof Designer) {
                numOfDes++;
            } else if (team[i] instanceof Programmer) {
                numOfPro++;
            }
        }

        if (p instanceof Architect) {
            if (numOfArch >= 1) {
                throw new TeamException("团队至多只能有一名构架师");
            }
        } else if (p instanceof Designer) {
            if (numOfDes >= 2) {
                throw new TeamException("团队至多只能有2名设计师");
            }
        } else if (p instanceof Programmer) {
            if (numOfPro >= 3) {
                throw new TeamException("团队至多只能有3名程序员");
            }
        }

        // 将p加到team中
        team[total++] = p;
        // 将p的属性赋值
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);
    }

    private boolean isExist(Employee e) {
        for (int i = 0; i < total; i++) {
            if (team[i].getId() == e.getId()) {
                return true;
            }
        }
        return false;
    }

    public void removeMember(int memberId) throws TeamException {
        int i = 0;
        for (; i < total; i++) {
            if (team[i].getMemberId() == memberId) {
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        // 未找到
        if (i == total) {
            throw new TeamException("找不到指定memberID");
        }

        for (int j = i + 1; j < total; j++) {
            team[j -1 ] = team[j];
        }
        team[--total ] = null;


    }
}
