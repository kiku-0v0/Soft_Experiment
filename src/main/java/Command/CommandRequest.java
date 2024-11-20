package Command;

import Composite.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
/*
将程序得到的数据转换为json格式返回
 */
public class CommandRequest {
    private final ObjectMapper objectMapper;

    public CommandRequest(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String formatGetAllUsersResult(List<User> users) {
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(new CommandResult("getAllUsersByOrg", users));//写成Json格式
        } catch (Exception ex) {
            return "{\"error\": \"" + ex.getMessage() + "\"}";
        }
    }

    public String formatGetUserPermissionsResult(String permissions) {
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(new CommandResult("getUserPermissionsForOrg", permissions));
        } catch (Exception ex) {
            return "{\"error\": \"" + ex.getMessage() + "\"}";
        }
    }

    
    private static class CommandResult {
        public String command;
        public Object result;

        public CommandResult(String command, Object result) {
            this.command = command;
            this.result = result;
        }
    }

}
