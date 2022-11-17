package model;

import java.util.Map;

public class AuthenticatedUserAdaptater implements AuthenticatedUser {

    private String sciper;
    private String userName;

    public AuthenticatedUserAdaptater(Map<String, Object> data) {
        if(!data.containsKey("userName") || !data.containsKey("sciper")) {
            throw new IllegalArgumentException("Invalid data");
        }
        this.userName = (String)data.get("userName");
        this.sciper = String.valueOf(data.get("sciper"));
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public String getSciper() {
        return sciper;
    }
}
