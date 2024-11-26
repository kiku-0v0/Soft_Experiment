package Composite;

import java.util.ArrayList;
import java.util.List;


/*
机构类，对应表t_organization中的一条记录，同时使用一个List存放子节点，以实现树结构
 */
public class Organization extends Component{
    private String fID;
    private String fName;
    private String fPermission;//权限字段
    private String fHigherUpfIDs;//上级机构
    private String fRemark;
    private String fOrgGUID;
    private List<Organization> childOrganizations;//存放子机构

    private List<User> childUsers = new ArrayList<>();//存放子用户
    public Organization(String fID, String fName, String fPermission, String fHigherUpfIDs, String fRemark, String fOrgGUID,List<Organization> organizations) {
        this.fID = fID;
        this.fName = fName;
        this.fPermission = fPermission;
        this.fHigherUpfIDs = fHigherUpfIDs;
        this.fRemark = fRemark;
        this.fOrgGUID = fOrgGUID;
        this.childOrganizations =  organizations;
    }

    public Organization(String fID, String fName, String fPermission, String fHigherUpfIDs, String fRemark, String fOrgGUID,List<Organization> organizations,List<User> users) {
        this.fID = fID;
        this.fName = fName;
        this.fPermission = fPermission;
        this.fHigherUpfIDs = fHigherUpfIDs;
        this.fRemark = fRemark;
        this.fOrgGUID = fOrgGUID;
        this.childOrganizations =  organizations;
        this.childUsers = users;
    }

    public String getfName(){
        return fName;
    }

    public String getfPermission(){
        return fPermission;
    }

    public void addOrg(Organization o){
        childOrganizations.add(o);
    }//添加子节点
    public void removeOrg(Organization o){
        childOrganizations.remove(o);
    }//删除子节点

    public List<Organization> getChildOrganizations(){
        return childOrganizations;
    }

    public void addUser(User u){
        childUsers.add(u);
    }//添加子节点
    public void removeUser(User u){
        childUsers.remove(u);
    }//删除子节点

    public List<User> getChildUser_1(){
        return childUsers;
    }



    public String toString(){
        return "Organization{" +
                "fID='" + fID + '\'' +
                ", fName='" + fName + '\'' +
                ", fPermission='" + fPermission + '\'' +
                ", fHigherUpfIDs='" + fHigherUpfIDs + '\'' +
                ", fOrgGUID='" + fOrgGUID + '\'' +
                ", fRemark='" + fRemark + '\'' +
                '}';
    }

    public void getChildUser(){
        for(User u : childUsers){
            System.out.println(u.toString());
        }
    }

    public String getfID() {
        return fID;
    }
}
