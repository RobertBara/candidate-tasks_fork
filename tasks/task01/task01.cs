public class LoginPage
{
    public bool Login(string username, string password, AuthenticationService authService)
    {
        bool result = false;
        
        // Call the authentication service to check the credentials
        if (authService.Authenticate(username, password))
        {
            // If the authentication service returns true, set the result to true
            result = true;
        }
        
        return result;
    }
}