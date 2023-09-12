class LoginPage:
    def login(self, username, password, auth_service):
        result = False
        
        # Call the authentication service to check the credentials
        if auth_service.authenticate(username, password):
            # If the authentication service returns True, set the result to True
            result = True
        
        return result
