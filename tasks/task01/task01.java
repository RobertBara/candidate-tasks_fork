public class LoginPage {
    
    public boolean login(String username, String password, AuthenticationService authService) {
        boolean result = false;
        
        // Call the authentication service to check the credentials
        if (authService.authenticate(username, password)) {
            // If the authentication service returns true, set the result to true
            result = true;
        }
        
        return result;
    }
    
}