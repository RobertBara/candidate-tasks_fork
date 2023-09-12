# Java Project
Root directory for Login Page designed in Java.

Structure:
```bash
java_project -> root directory
|-- task01 -> directory with implemented task
    |-- src -> directory with java source
        |-- main -> directory with business code implementation
        |-- test -> directory with tests suites, helpers, mocks, resources...
            |-- resources -> direcotry with all required resources like dataset, configs...
            |-- java -> directory witch test code implementation
                |-- fixtures -> directory with mock definitions used for testing
                |-- task01 -> directory with tests for task01 functionality
```

How To Execute tests:
- Go to: cd tasks/task01/java_project
- Execute command: mvn clean install
- Execute command: mvn test