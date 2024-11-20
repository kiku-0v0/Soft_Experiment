package Iterator;

import Composite.Component;
import Composite.Organization;
import Composite.User;

import java.util.ArrayList;
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

    //得到该机构下的所有机构，不包括自己
    public List<Organization> getAllOrganization(String orgID) {
        List<Organization> resultList = new ArrayList<>();
        while (hasNext()) {
            Organization org = next();

            if (org.getfID().equals(orgID)) {
                OrganizationIterator organizationIterator = new OrganizationIterator(org.getChildOrganizations());
                while (organizationIterator.hasNext()) {
                    Organization org1 = organizationIterator.next();
                    resultList.add(org1);
                    //System.out.println(org1.toString());
                }
            }
        }
        return resultList;
    }

    public List<User> getAllUserByOrg(String orgID){
        while(hasNext()){
            Organization org = next();

            if(org.getfID().equals(orgID)){
                return org.getChildUser_1();
            }
        }
        return null;
    }//查找某个ID下的所有用户

}
