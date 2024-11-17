package Accessor;

import java.util.List;
import Composite.User;
import Iterator.UserIterator;

public class Development {
     private List<User> development;

     public Development(List<User> development){
         this.development = development;
     }

     public void accept(Visitor visitor){
         visitor.visit(this);
     }


}
