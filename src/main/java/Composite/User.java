package Composite;

import Accessor.Visitor;
import Iterator.OrganizationIterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
用户类，对应t_user表中的一条记录，但是使用List将所属机构划分
 */

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
        OrganizationIterator organizationIterator = new OrganizationIterator(org);
        List<String> perimissionList = new ArrayList<>();

        while(organizationIterator.hasNext()){
            Organization organization = organizationIterator.next();

            for(String str : fOrgIDs){
                if(str.equals(organization.getfID())){
                    perimissionList.add(organization.getfPermission());
                }
            }
        }
        return perimissionList;
    }


}
