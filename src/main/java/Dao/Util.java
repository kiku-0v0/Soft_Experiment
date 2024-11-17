package Dao;

import Composite.Organization;
import Composite.User;
import Iterator.OrganizationIterator;
import Iterator.UserIterator;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/*
Util类用于获取各个部门的用户
由于之前获取的操作只能查询自己的子机构，不能查询自己，也无法查询下属机构的用户，因此重写一个专用的Util类
 */
public class Util {


    public static List<Organization> getALLOrganization(String organizationID,String orgID) throws SQLException {
        List<Organization> organizationList = OrganizationDao.getAllOrganization();
        OrganizationIterator orgIterator = new OrganizationIterator(organizationList);
        List<Organization> organizations = orgIterator.getAllOrganization(organizationID);
        for(Organization org : organizationList){
            if(org.getfID().equals(orgID)){
                organizations.add(org);
            }
        }
        return organizations;
    }

    /*
    根据机构的ID找到他下属所有部门的所有成员
     */
    public static List<User> getAllUser(String organizationID,String orgID) throws SQLException {
        List<User> userList = new ArrayList<>();
        List<Organization> organizationList = getALLOrganization(organizationID,orgID);
        UserIterator userIterator = new UserIterator(OrganizationDao.getAllUser());

        while(userIterator.hasNext()){
            User user = userIterator.next();
            for(Organization org:organizationList){
                for(String str:user.getfOrgIDs()) {
                    if(str.equals(org.getfID())){
                        userList.add(user);
                    }
                }
            }
        }
        return userList;
    }
}
