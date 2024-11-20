package Command;


import Composite.User;
import Dao.OrganizationDao;
import Dao.Util;
import Iterator.UserIterator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/*
用于接收从Web API返回的JSON数据
 */
public class CommandResponse {
    public String executeCommand(String jsonCommand) {
        final ObjectMapper objectMapper = new ObjectMapper();

        try {
            // 解析 JSON 字符串
            JsonNode rootNode = objectMapper.readTree(jsonCommand);
            String command = rootNode.get("command").asText();
            JsonNode parameters = rootNode.get("parameters");


            CommandRequest commandRequest = new CommandRequest(objectMapper);
            List<User> userList = OrganizationDao.getAllUser();
            UserIterator userIterator = new UserIterator(userList);

            String resultJson;

            switch (command) {
                case "getAllUsersByOrg":
                    String orgID = parameters.get("OrgID").asText();
                    resultJson = commandRequest.formatGetAllUsersResult(Util.getAllUserByOrg(orgID,orgID));
                    break;

                case "getUserPermissionsForOrg":
                    String UserfName = parameters.get("UserfName").asText();
                    resultJson = commandRequest.formatGetUserPermissionsResult(userIterator.getUserPermission(OrganizationDao.getAllOrganization(),UserfName));
                    break;

                default:
                    throw new IllegalArgumentException("Unknown command");
            }

            return resultJson;
        } catch (Exception ex) {
            return "{\"error\": \"" + ex.getMessage() + "\"}";
        }
    }
}
