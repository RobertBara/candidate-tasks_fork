package fixtures;

import services.AuthenticationService;

import java.util.List;
import java.util.Map;


import org.yaml.snakeyaml.Yaml;

public class AuthenticationServiceMock extends AuthenticationService {

    private Map<String, List<Map<String, Object>>> dataset;

    public AuthenticationServiceMock(){
        dataset = (new Yaml()).load(
            getClass()
            .getClassLoader()
            .getResourceAsStream("dataset.yaml")
        );
    }

    @Override
    public boolean authenticate(String username, String password) {
        for (Map<String, Object> user: dataset.get("users")){
            if (username.equals(user.get("login")) && password.equals(user.get("password"))) {
                return true;
            }
        }
        return false;
    }
}
