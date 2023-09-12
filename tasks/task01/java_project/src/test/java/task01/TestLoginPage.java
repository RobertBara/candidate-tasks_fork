package task01;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import fixtures.AuthenticationServiceMock;


public class TestLoginPage
{
    private static LoginPage loginPage;
    private static AuthenticationServiceMock authenticationServiceMock;

    @BeforeEach
    public void setUp() throws Exception{
        loginPage = new LoginPage();
        authenticationServiceMock = new AuthenticationServiceMock();
    }

    @Test
    public void testPositive()
    {
        assertTrue( loginPage.login("John", "pAssw0rd!234", authenticationServiceMock) );
    }

    @ParameterizedTest
    @MethodSource("negativeTestCasesProvider")
    public void testNegative(String login, String password)
    {
        assertFalse( loginPage.login(login, password, authenticationServiceMock) );
    }

    private static Stream<Arguments> negativeTestCasesProvider() {
        return Stream.of(
            Arguments.of("Jonn", "pAssw0rd!234"), //Typo in user name
            Arguments.of("Johny", "pAssw0rd!234"), // expanded correct name to
            Arguments.of("john", "pAssw0rd!234"), // check case sensitivity in user name
            Arguments.of("john", "passw0rd!234"), // check case sensitivity in user name and password
            Arguments.of("John", "passw0rd!234") // check case sensitivity in password
        );
    }
}
