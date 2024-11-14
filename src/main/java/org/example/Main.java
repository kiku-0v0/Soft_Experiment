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
                orgIterator.getAllUser();//查找某个机构下的所有用户
                break;
            case "2":
                userIterator.getUserPermission(organizationList);
                break;
            case "3":
                orgIterator.getAllOrganization();
                break;
            case "4":
                userIterator.getUserGUID();
                break;
        }
    }
}