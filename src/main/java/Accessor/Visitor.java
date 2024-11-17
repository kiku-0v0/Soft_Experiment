package Accessor;

import Composite.Organization;
import Composite.User;

public interface Visitor {
    void visit(Development development);

    void visit(System_office systemOffice);

    void visit(Operations operations);

    void visit(Market market);

    void visit(User user);
}
