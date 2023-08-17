# WSECUDemo
Automation Demo

This explanation is related to the QA Engineer II/III role assignment.

For Automating the assignment/Scenario I have utilized BDD (Behavior-Driven Development) framework. This is a sample of the framework that I have been using with my current project. It has been built from scratch and is created just to automate the current scenario.

For executing the framework I have:

For writing scenarios, I am utilizing Cucumber using a feature file which gives me the option to write my scenario with Gherkin language (Given-When-and-Then).

For the Project Management tool, I am using Maven which gives me the possibility to manage my framework's dependencies and plug-in integration and also the option to integrate with CI/CD process if we have to.

For scenario step definitions, I am using JAVA to write my step definitions and Selenium to interact with UI elements.

For reporting, I have Cucumber built-in reporting and also log4j. At @AfterStep tags, I have also added takeScreenShot method to take a screenshot of each step. and is located in the target folder.

For TestRunner, again Cucumber gives me the option to run my test cases by providing tags, glue, and feature path.

This is just a brief and general explanation of how the process is when I execute a test scenario in the framework. But the framework itself is not the same with each project and are different based on each one.




Steps to execute the Scenario:

1. Clone the project in the local computer.
2. Open in the IDE of your choice.
3. Once Project is imported.
4. You can run Maven clean and Maven install.
5. The report and screenshot will be generated under target folder.
6. And log files will be generated under the output folder.
