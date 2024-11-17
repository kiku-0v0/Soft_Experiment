import Accessor.BonusVisitor;
import Accessor.Development;
import Accessor.Operations;
import Accessor.System_office;
import Composite.Organization;
import Composite.User;
import Dao.AccessorDao;
import Dao.OrganizationDao;
import Dao.Util;
import Iterator.OrganizationIterator;

import java.sql.*;
import java.util.List;


public class Text {
    public static void main(String[] arg) throws SQLException, ClassNotFoundException {
        Development development = AccessorDao.getDevelopment();
        BonusVisitor bonusVisitor = new BonusVisitor();
        development.accept(bonusVisitor);
    }
}
