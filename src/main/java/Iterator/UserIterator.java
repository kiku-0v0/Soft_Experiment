package Iterator;

import Composite.Organization;
import Composite.User;
import java.util.*;

/*
用户迭代器
 */

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

    public String getUserPermission(List<Organization> organizationList,String UserfName) {
        StringBuilder permission = new StringBuilder();
        while(hasNext()){
            User user = next();
            if(user.getfName().equals(UserfName)){
                OrganizationIterator organizationIterator = new OrganizationIterator(organizationList);
                while(organizationIterator.hasNext()){
                    Organization organization = organizationIterator.next();
                    for(String str : user.getfOrgIDs()){
                        if(str.equals(organization.getfID())){
                                permission.append(organization.getfPermission());
                        }
                    }
                }
            }
        }
        String permission1 = permission.toString().replaceAll("[|]+",",");
        String[] numbers = permission1.split(",");

        numbers = Arrays.stream(numbers)
                .filter(str -> !str.isEmpty())  // 过滤掉空字符串
                .toArray(String[]::new);  // 转回数组

        Set<String> uniqueNumbers = new TreeSet<>(Arrays.asList(numbers));
        return String.join(",", uniqueNumbers);
    }//获取用户的权限，并去重

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
    }

}
