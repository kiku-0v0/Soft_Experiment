package Accessor;

import Composite.User;

public class ClockingVisitor implements Visitor{


    @Override
    public void visit(Development development) {
        System.out.println("执行弹性上班时间，不限上班时间和下班时间，每天上下班打卡，每天工作满 8 小时即可；");
    }

    @Override
    public void visit(System_office systemOffice) {
        System.out.println("执行 8:30-12:00，13:30-18:00，双休的 8 小时工作制；");
    }

    @Override
    public void visit(Operations operations) {
        System.out.println("执行 24 小时值班制度，上一天，休息两天；");
    }

    @Override
    public void visit(Market market) {
        System.out.println("：执行 8:30 打卡（在公司打卡，必要时可以远程打卡）后，在外跑业务，不再需要下班打卡。");
    }

    @Override
    public void visit(User user) {

    }

}
