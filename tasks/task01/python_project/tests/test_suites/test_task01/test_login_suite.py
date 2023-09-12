import unittest

from parameterized import parameterized

from task01.task01 import LoginPage
from tests.mocks.login_service.login_service_mock import LoginServiceMock

class TestStringMethods(unittest.TestCase):

    def setUp(self):
        self.login_page = LoginPage()
        self.login_service = LoginServiceMock()

    def test_positive(self):
        self.assertTrue(self.login_page.login('John', 'pAssw0rd!234', self.login_service))

    @parameterized.expand([
        ["Jonn", "pAssw0rd!234"], #Typo in user name
        ["Johny", "pAssw0rd!234"], # expanded correct name to
        ["john", "pAssw0rd!234"], # check case sensitivity in user name
        ["john", "passw0rd!234"], # check case sensitivity in user name and password
        ["John", "passw0rd!234"], # check case sensitivity in password
    ])
    def test_negative(self, user, password):
        self.assertFalse(self.login_page.login(user, password, self.login_service))

if __name__ == '__main__':
    unittest.main()