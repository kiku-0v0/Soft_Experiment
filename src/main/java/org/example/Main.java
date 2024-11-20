package org.example;

import Composite.Organization;
import Composite.User;
import Dao.OrganizationDao;
import Iterator.OrganizationIterator;
import Iterator.UserIterator;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        List<Organization> organizationList = OrganizationDao.getAllOrganization();
        List<User>  userList = OrganizationDao.getAllUser();
        OrganizationIterator orgIterator = new OrganizationIterator(organizationList);
        UserIterator userIterator = new UserIterator(userList);
        System.out.println("1,获取某个机构下全部用户");
        System.out.println("2,获取某个用户全部权限");
        System.out.println("3,获取某个机构下属机构");
        System.out.println("4,查找某个用户的GUID");
        System.out.print("请输入:");
        Scanner scan = new Scanner(System.in);
        switch (scan.next()){
            case "1":
                System.out.print("输入你要查询的机构ID:");
                Scanner scanner1 = new Scanner(System.in);
                String orgID1 = scanner1.next();
                System.out.println("该机构的所有成员如下:");
                for(User user :  orgIterator.getAllUserByOrg(orgID1)){//查找某个机构下的所有用户
                    System.out.println(user.toString());
                }
                break;
            case "2":
                userIterator.getUserPermission(organizationList,"010102");
                break;
            case "3":
                System.out.print("输入你要查询的机构ID:");
                Scanner scanner = new Scanner(System.in);
                String orgID = scanner.next();
                System.out.println("该机构的所有下属机构如下:");
                for(Organization org : orgIterator.getAllOrganization(orgID)){
                    System.out.println(org.toString());
                }
                //orgIterator.getAllOrganization(orgID);
                break;
            case "4":
                userIterator.getUserGUID();
                break;
            default:
                System.out.println("输入有误");
        }
    }
}