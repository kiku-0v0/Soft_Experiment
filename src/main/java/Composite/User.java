package Composite;

import Accessor.Visitor;
import Iterator.OrganizationIterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User extends Component{
    private String fID;
    private List<String> fOrgIDs;
    private String fUserGUID;
    private String fName;
    private String fPassword;
    private String fRemark;

    public User(String fID, List<String> fOrgIDs, String fUserGUID, String fName, String fPassword, String fRemark) {
        this.fID = fID;
        this.fOrgIDs = fOrgIDs;
        this.fUserGUID = fUserGUID;
        this.fName = fName;
        this.fPassword = fPassword;
        this.fRemark = fRemark;
    }

    public List<String> getfOrgIDs(){
        return fOrgIDs;
    }

    public String getfName(){
        return fName;
    }

    public String getfID(){
        return fID;
    }

    public String getfUserGUID(){
        return fUserGUID;
    }

    public String toString(){
        return "User{" +
                "fID='" + fID + '\'' +
                ", fOrgIDs='" + fOrgIDs + '\'' +
                ", fUserGUID='" + fUserGUID + '\'' +
                ", fName='" + fName + '\'' +
                ", fPassword='" + fPassword + '\'' +
                ", fRemark='" + fRemark + '\'' +
                '}';
    }

    public List<String> getUserPermission(List<Organization> org){
        System.out.println("该用户的权限如下:");
        OrganizationIterator organizationIterator = new OrganizationIterator(org);
        List<String> perimissionList = new ArrayList<>();

        while(organizationIterator.hasNext()){
            Organization organization = organizationIterator.next();

            for(String str : fOrgIDs){
                if(str.equals(organization.getfID())){
                    perimissionList.add(organization.getfPermission());
                    //System.out.println(organization.getfPermission());
                }
            }
        }
        return perimissionList;
    }

    public void accept(Visitor visitor){
        visitor.visit(this);
    }

}
