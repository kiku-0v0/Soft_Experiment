package Iterator;

import Composite.Component;
import Composite.Organization;
import Composite.User;

import java.util.List;
import java.util.Scanner;

public class OrganizationIterator implements Iterator {
    private List<Organization> organizations;
    private int Index = 0;

    public OrganizationIterator(List<Organization> organizations) {
        this.organizations = organizations;
    }

    @Override
    public Boolean hasNext() {
        return Index < organizations.size();
    }

    @Override
    public Organization next() {
        if(!hasNext()){
            throw new java.util.NoSuchElementException();
        }
        return organizations.get(Index++);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public void getAllOrganization(){
        System.out.print("输入你要查询的机构ID:");
        Scanner scanner = new Scanner(System.in);
        String orgID = scanner.next();
        System.out.println("该机构的所有下属机构如下:");
        while(hasNext()){
            Organization org = next();

            if(org.getfID().equals(orgID)){
                OrganizationIterator organizationIterator = new OrganizationIterator(org.getChildOrganizations());
                while(organizationIterator.hasNext()){
                    Organization org1 = organizationIterator.next();
                    System.out.println(org1.toString());
                }
            }
        }
    }

    public void getAllUser(){
        System.out.print("输入你要查询的机构ID:");
        Scanner scanner = new Scanner(System.in);
        String orgID = scanner.next();
        System.out.println("该机构的所有成员如下:");
        while(hasNext()){
            Organization org = next();

            if(org.getfID().equals(orgID)){
                UserIterator userIterator = new UserIterator(org.getChildUser_1());
                while(userIterator.hasNext()){
                    User user = userIterator.next();
                    System.out.println(user.toString());
                }
            }
        }
    }//查找某个ID下的所有用户

}
