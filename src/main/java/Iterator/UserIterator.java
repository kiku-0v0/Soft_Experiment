package Iterator;

import Composite.Organization;
import Composite.User;


import java.util.List;
import java.util.Scanner;

public class UserIterator implements Iterator{
    private List<User> Users;

    private int Index;

    public UserIterator(List<User> users){
        this.Users = users;
    }

    @Override
    public Boolean hasNext() {
        return Index < Users.size();
    }

    @Override
    public User next() {
        if(!hasNext()){
            throw new java.util.NoSuchElementException();
        }
        return Users.get(Index++);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public void getUserPermission(List<Organization> organizationList) {
        System.out.print("请输入你要查询的用户学号:");
        Scanner scanner = new Scanner(System.in);
        String UserfName = scanner.next();
        while(hasNext()){
            User user = next();
            if(user.getfName().equals(UserfName)){
                System.out.println(user.getUserPermission(organizationList));
            }
        }
        /*for(User user : Users){
            if(user.getfName().equals(UserfName)){
                System.out.println(user.getUserPermission(organizationList));
            }
        }*/
    }

    public void getUserGUID() {
        System.out.print("请输入你要查询的用户学号:");
        Scanner scanner = new Scanner(System.in);
        String Userid = scanner.next();
        while(hasNext()){
            User user = next();
            if(user.getfName().equals(Userid)){
                System.out.println("该用户的GUID为:" + user.getfUserGUID());
            }
        }
        /*for(User user : Users){
            if(user.getfName().equals(Userid)){
                System.out.println("该用户的GUID为:" + user.getfUserGUID());
            }
        }*/
    }

}
