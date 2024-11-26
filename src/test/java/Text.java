import Command.CommandRequest;
import Command.CommandResponse;
import Composite.Organization;
import Dao.OrganizationDao;
import Iterator.UserIterator;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.*;
import java.util.List;


public class Text {
    public static void main(String[] arg) throws SQLException, ClassNotFoundException {
        List<Organization> organizationList = OrganizationDao.getAllOrganization();
        UserIterator userIterator = new UserIterator(OrganizationDao.getAllUser());
        ObjectMapper objectMapper = new ObjectMapper();
        CommandRequest commandRequest = new CommandRequest(objectMapper);
        //从Web Api传入json格式到jsonCommand1中调用CommandRequest解析，用CommandResponse返回结果。
        String jsonCommand1 = "{\"command\": \"getAllUsersByOrg\", \"parameters\": {\"OrgID\": \"010102\"}}";
        //模拟Web Api接口返回json命令
        String jsonCommand2 = "{\"command\": \"getUserPermissionsForOrg\", \"parameters\": {\"UserfName\": \"202225220608\"}}";

        CommandResponse commandResponse = new CommandResponse();

        System.out.println(commandResponse.executeCommand(jsonCommand2));
    }
}
