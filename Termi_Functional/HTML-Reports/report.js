$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("login.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Automation Team"
    },
    {
      "line": 2,
      "value": "#Keywords Summary :"
    },
    {
      "line": 3,
      "value": "#Feature: List of scenarios."
    },
    {
      "line": 4,
      "value": "#Scenario: Business rule through list of steps with arguments."
    },
    {
      "line": 5,
      "value": "#Given: Some precondition step"
    },
    {
      "line": 6,
      "value": "#When: Some key actions"
    },
    {
      "line": 7,
      "value": "#Then: To observe outcomes or validation"
    },
    {
      "line": 8,
      "value": "#And,But: To enumerate more Given,When,Then steps"
    },
    {
      "line": 9,
      "value": "#Scenario Outline: List of steps for data-driven as an Examples and \u003cplaceholder\u003e"
    },
    {
      "line": 10,
      "value": "#Examples: Container for s table"
    },
    {
      "line": 11,
      "value": "#Background: List of steps run before each of the scenarios"
    },
    {
      "line": 12,
      "value": "#\"\"\" (Doc Strings)"
    },
    {
      "line": 13,
      "value": "#| (Data Tables)"
    },
    {
      "line": 14,
      "value": "#@ (Tags/Labels):To group Scenarios"
    },
    {
      "line": 15,
      "value": "#\u003c\u003e (placeholder)"
    },
    {
      "line": 16,
      "value": "#\"\""
    },
    {
      "line": 17,
      "value": "## (Comments)"
    },
    {
      "line": 18,
      "value": "#Sample Feature Definition Template"
    }
  ],
  "line": 19,
  "name": "Termi Chat",
  "description": "",
  "id": "termi-chat",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 21,
  "name": "Termi launch and Authentication",
  "description": "",
  "id": "termi-chat;termi-launch-and-authentication",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 20,
      "name": "@Login"
    }
  ]
});
formatter.step({
  "line": 22,
  "name": "Launch Termi in Google Chrome",
  "keyword": "Given "
});
formatter.step({
  "line": 23,
  "name": "Enter Username as \"akhanduri@helm360.com\" and Password as \"Akhanduri@1\"",
  "keyword": "When "
});
formatter.step({
  "line": 24,
  "name": "Click on Login Button",
  "keyword": "And "
});
formatter.step({
  "line": 25,
  "name": "Click on Chat icon",
  "keyword": "When "
});
formatter.step({
  "line": 26,
  "name": "Verify that we are on chat page with page title \"Termi - Helm 360\"",
  "keyword": "Then "
});
formatter.match({
  "location": "Test_Step_Definition.launch_termi_in_google_chrome()"
});
formatter.result({
  "duration": 11495038200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "akhanduri@helm360.com",
      "offset": 19
    },
    {
      "val": "Akhanduri@1",
      "offset": 59
    }
  ],
  "location": "Test_Step_Definition.enter_username_and_password(String,String)"
});
formatter.result({
  "duration": 391564100,
  "status": "passed"
});
formatter.match({
  "location": "Test_Step_Definition.click_on_login_button()"
});
formatter.result({
  "duration": 3372973700,
  "status": "passed"
});
formatter.match({
  "location": "Test_Step_Definition.click_on_chat_icon()"
});
formatter.result({
  "duration": 238667100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Termi - Helm 360",
      "offset": 49
    }
  ],
  "location": "Test_Step_Definition.verify_that_we_are_on_chat_page(String)"
});
formatter.result({
  "duration": 5075602200,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 29,
  "name": "Termi Chat Bot",
  "description": "",
  "id": "termi-chat;termi-chat-bot",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 28,
      "name": "@ChatBot"
    }
  ]
});
formatter.step({
  "line": 30,
  "name": "User enters \"\u003cQuestion\u003e\" and gets \"\u003cAnswer\u003e\"",
  "keyword": "Then "
});
formatter.examples({
  "line": 31,
  "name": "",
  "description": "",
  "id": "termi-chat;termi-chat-bot;",
  "rows": [
    {
      "cells": [
        "Question",
        "Answer"
      ],
      "line": 32,
      "id": "termi-chat;termi-chat-bot;;1"
    },
    {
      "cells": [
        "Help",
        "To get help on what questions you can ask me, please select from the following categories:"
      ],
      "line": 33,
      "id": "termi-chat;termi-chat-bot;;2"
    },
    {
      "cells": [
        "My Schedule",
        "You have no appointments scheduled today"
      ],
      "line": 34,
      "id": "termi-chat;termi-chat-bot;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 33,
  "name": "Termi Chat Bot",
  "description": "",
  "id": "termi-chat;termi-chat-bot;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 28,
      "name": "@ChatBot"
    }
  ]
});
formatter.step({
  "line": 30,
  "name": "User enters \"Help\" and gets \"To get help on what questions you can ask me, please select from the following categories:\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Help",
      "offset": 13
    },
    {
      "val": "To get help on what questions you can ask me, please select from the following categories:",
      "offset": 29
    }
  ],
  "location": "Test_Step_Definition.user_enters_something_and_gets_something(String,String)"
});
formatter.result({
  "duration": 22019973800,
  "error_message": "org.openqa.selenium.TimeoutException: Expected condition failed: waiting for presence of element located by: By.xpath: (//div[@data-activity-id]//p)[90] (tried for 20 second(s) with 500 milliseconds interval)\r\n\tat org.openqa.selenium.support.ui.WebDriverWait.timeoutException(WebDriverWait.java:81)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:271)\r\n\tat com.qa.util.SeleniumLib.eWaitForPresent(SeleniumLib.java:156)\r\n\tat com.qa.util.SeleniumLib.latestResponseValidation(SeleniumLib.java:251)\r\n\tat com.qa.pageobject.ChatBotPage.getLatestResponse(ChatBotPage.java:37)\r\n\tat com.qa.step_definition.Test_Step_Definition.user_enters_something_and_gets_something(Test_Step_Definition.java:141)\r\n\tat ✽.Then User enters \"Help\" and gets \"To get help on what questions you can ask me, please select from the following categories:\"(login.feature:30)\r\nCaused by: org.openqa.selenium.NoSuchElementException: Cannot locate an element using By.xpath: (//div[@data-activity-id]//p)[90]\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.12.0\u0027, revision: \u00277c6e0b3\u0027, time: \u00272018-05-08T14:04:26.12Z\u0027\nSystem info: host: \u0027INNOPHLTXPQA086\u0027, ip: \u002710.1.50.20\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_211\u0027\nDriver info: driver.version: unknown\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.lambda$findElement$0(ExpectedConditions.java:896)\r\n\tat java.util.Optional.orElseThrow(Unknown Source)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.findElement(ExpectedConditions.java:895)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.access$000(ExpectedConditions.java:44)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$6.apply(ExpectedConditions.java:183)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$6.apply(ExpectedConditions.java:180)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:248)\r\n\tat com.qa.util.SeleniumLib.eWaitForPresent(SeleniumLib.java:156)\r\n\tat com.qa.util.SeleniumLib.latestResponseValidation(SeleniumLib.java:251)\r\n\tat com.qa.pageobject.ChatBotPage.getLatestResponse(ChatBotPage.java:37)\r\n\tat com.qa.step_definition.Test_Step_Definition.user_enters_something_and_gets_something(Test_Step_Definition.java:141)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)\r\n\tat java.lang.reflect.Method.invoke(Unknown Source)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:40)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:34)\r\n\tat cucumber.runtime.java.JavaStepDefinition.execute(JavaStepDefinition.java:38)\r\n\tat cucumber.runtime.StepDefinitionMatch.runStep(StepDefinitionMatch.java:37)\r\n\tat cucumber.runtime.Runtime.runStep(Runtime.java:300)\r\n\tat cucumber.runtime.model.StepContainer.runStep(StepContainer.java:44)\r\n\tat cucumber.runtime.model.StepContainer.runSteps(StepContainer.java:39)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:44)\r\n\tat cucumber.runtime.model.CucumberScenarioOutline.run(CucumberScenarioOutline.java:46)\r\n\tat cucumber.runtime.model.CucumberFeature.run(CucumberFeature.java:165)\r\n\tat cucumber.api.testng.TestNGCucumberRunner.runCukes(TestNGCucumberRunner.java:50)\r\n\tat com.qa.runner_class.TestRunner.runCukes(TestRunner.java:34)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)\r\n\tat java.lang.reflect.Method.invoke(Unknown Source)\r\n\tat org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:86)\r\n\tat org.testng.internal.Invoker.invokeMethod(Invoker.java:645)\r\n\tat org.testng.internal.Invoker.invokeTestMethod(Invoker.java:822)\r\n\tat org.testng.internal.Invoker.invokeTestMethods(Invoker.java:1130)\r\n\tat org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:129)\r\n\tat org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:112)\r\n\tat org.testng.TestRunner.privateRun(TestRunner.java:782)\r\n\tat org.testng.TestRunner.run(TestRunner.java:632)\r\n\tat org.testng.SuiteRunner.runTest(SuiteRunner.java:366)\r\n\tat org.testng.SuiteRunner.runSequentially(SuiteRunner.java:361)\r\n\tat org.testng.SuiteRunner.privateRun(SuiteRunner.java:319)\r\n\tat org.testng.SuiteRunner.run(SuiteRunner.java:268)\r\n\tat org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)\r\n\tat org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:86)\r\n\tat org.testng.TestNG.runSuitesSequentially(TestNG.java:1244)\r\n\tat org.testng.TestNG.runSuitesLocally(TestNG.java:1169)\r\n\tat org.testng.TestNG.run(TestNG.java:1064)\r\n\tat org.testng.remote.RemoteTestNG.run(RemoteTestNG.java:113)\r\n\tat org.testng.remote.RemoteTestNG.initAndRun(RemoteTestNG.java:206)\r\n\tat org.testng.remote.RemoteTestNG.main(RemoteTestNG.java:177)\r\n",
  "status": "failed"
});
formatter.scenario({
  "line": 34,
  "name": "Termi Chat Bot",
  "description": "",
  "id": "termi-chat;termi-chat-bot;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 28,
      "name": "@ChatBot"
    }
  ]
});
formatter.step({
  "line": 30,
  "name": "User enters \"My Schedule\" and gets \"You have no appointments scheduled today\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "My Schedule",
      "offset": 13
    },
    {
      "val": "You have no appointments scheduled today",
      "offset": 36
    }
  ],
  "location": "Test_Step_Definition.user_enters_something_and_gets_something(String,String)"
});
formatter.result({
  "duration": 5791252800,
  "error_message": "java.lang.AssertionError: expected [true] but found [false]\r\n\tat org.testng.Assert.fail(Assert.java:94)\r\n\tat org.testng.Assert.failNotEquals(Assert.java:513)\r\n\tat org.testng.Assert.assertTrue(Assert.java:42)\r\n\tat org.testng.Assert.assertTrue(Assert.java:52)\r\n\tat com.qa.util.SeleniumLib.latestResponseValidation(SeleniumLib.java:253)\r\n\tat com.qa.pageobject.ChatBotPage.getLatestResponse(ChatBotPage.java:37)\r\n\tat com.qa.step_definition.Test_Step_Definition.user_enters_something_and_gets_something(Test_Step_Definition.java:141)\r\n\tat ✽.Then User enters \"My Schedule\" and gets \"You have no appointments scheduled today\"(login.feature:30)\r\n",
  "status": "failed"
});
});