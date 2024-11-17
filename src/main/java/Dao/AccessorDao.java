package Dao;

import Accessor.Development;
import Accessor.Market;
import Accessor.Operations;
import Accessor.System_office;
import Composite.Organization;
import Composite.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import Iterator.OrganizationIterator;

public class AccessorDao {
    //研发部下属的开发部
    public static Development getDevelopment() throws SQLException {
        return new Development(Util.getAllUser("010102","010102"));
    }

   //研发部下属的系统部（除运维工程师外）、行政办公室
    public static System_office getSystem_office() throws SQLException {
        List<User> userList = Util.getAllUser("010103","010103");
        List<User> userList1 = Util.getAllUser("010401","010401");

        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            for (String str : user.getfOrgIDs()) {
                if (str.equals("01010304")) {
                    iterator.remove(); // 使用 Iterator 删除元素,将运维工程师剔除
                    break;
                }
            }
        }

        userList.addAll(userList1);

        return new System_office(userList);
    }

    //运维工程师
    public static Operations getOperations() throws SQLException{
        OrganizationIterator organizationIterator = new OrganizationIterator(OrganizationDao.getAllOrganization());
        List<User> users = organizationIterator.getAllUser("01010304");
        return new Operations(users);
    }

    public static Market getMarket() throws SQLException {
        return new Market(Util.getAllUser("0102","0102"));
    }

}
