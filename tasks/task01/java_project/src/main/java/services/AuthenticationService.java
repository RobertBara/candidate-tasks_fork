package services;

public abstract class AuthenticationService {
    public abstract boolean authenticate(String username, String password);
}
