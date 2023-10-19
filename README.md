# MarketsDotCom

Scope of this is to automate this task : https://docs.google.com/document/d/1h3G9HNNewd4GljCIk2sBJTpRV5iGJOu_4n2zLlVjM98/edit#heading=h.111zdfo6zxwk

Pre-requisite:

Java

Maven

Structure of the Test Framework
Main folder contains all the codes related to the framework and the object model, while the test folder should contain all related to the test subject (testcase) and the test configurations.

Main folder divided in three sections

Core

BasePage - custom common library for selenium, where we wrap selenium commands.

DriverManager - where we setup and initialize the behavior of the webdriver.

Pages - each page of the site will have an entity here called Page Object or like a blueprint for each page

Utilities - in real world scenario, these are custom scripts act as a helper like database reader, parsers, fetchers, generators and so on...


Test folder divides in two section, where Java folder holds the testcases and the testdatas.

And Resources folder contains the configuration on how we want the test framework to run.
