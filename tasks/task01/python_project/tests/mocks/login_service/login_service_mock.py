import yaml
import os
import pathlib

class LoginServiceMock:

    def __init__(self) -> None:
        self.users = []
        with open(os.path.join(pathlib.Path(os.getcwd(), 'tests', 'resources', 'login_service', 'dataset.yaml')), 'r') as dataset_file:
            self.users = yaml.safe_load(dataset_file)['users']

    def authenticate(self, username, password):
        for user in self.users:
            if user['login'] == username and user['password'] == password:
                return True
        return False