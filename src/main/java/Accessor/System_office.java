package Accessor;

import Composite.User;

import java.sql.SQLOutput;
import java.util.List;

public class System_office {
    List<User> SystemUser;

    public System_office(List<User> systemUser){
        this.SystemUser = systemUser;
    }

    public void accept(Visitor visitor){
        visitor.visit(this);
    }

    public void print(){
        for(User user:SystemUser){
            System.out.println(user.toString());
        }
    }
}
