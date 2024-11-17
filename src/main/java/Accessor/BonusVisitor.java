package Accessor;

import Composite.Organization;
import Composite.User;

public class BonusVisitor implements Visitor{

    @Override
    public void visit(Development development) {
        System.out.println("按照提交的代码数量、质量计算；");
    }

    @Override
    public void visit(System_office systemOffice) {
        System.out.println("按照固定金额计算；");
    }

    @Override
    public void visit(Operations operations) {
        System.out.println("按照系统稳定运行评价计算；");
    }

    @Override
    public void visit(Market market) {
        System.out.println("按照业务量计算。");
    }

    @Override
    public void visit(User user) {

    }
}
