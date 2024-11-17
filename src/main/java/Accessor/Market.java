package Accessor;

import Composite.User;

import java.util.List;

public class Market {
    private List<User> market;

    public Market(List<User> market){
        this.market = market;
    }

    public void accept(Visitor visitor){
        visitor.visit(this);
    }
}

