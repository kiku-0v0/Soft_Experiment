package Accessor;

import Composite.User;

import java.util.List;

public class Operations {
    List<User> operations;

    public Operations(List<User> operations){
        this.operations = operations;
    }
    public void accept(Visitor visitor){
        visitor.visit(this);
    }

    public void print(){
        for(User user: operations){
            System.out.println(user.toString());
        }
    }
}
