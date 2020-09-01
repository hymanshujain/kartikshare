Feature: TPro Application Test
Background:
Given user open browser
Then user is on login page
Then user logs into app
Then click on KPIMenu

@Regression
Scenario: Validate home page open a KPI and report do a DD and add Dimension


Given user is on home page
Then validate home page DashboardSettings Icon
Then open a KPI
Then verify KPi is open without error
Then Open Radial Menu and DD by any option
Then open the report view
Then full view and add dimension
Then close the browser

@Regression
Scenario: Open New Dashboard

Given KPI menu is open
Then open a dashboard
Then close the browser1

@Regression
Scenario: Open All KPI's

Given user is on home page again
Then user open all KPI's 
And Close the browser

@Regression
Scenario: Open All the dashboards

Given Dashboard Tab is open in KPI menu
Then open all the dashboards
And Close the browser

@Regression
Scenario: DD by all the options on KPI

Given User is logged in and KPI menu is open
Then open the KPI
Then DD by all the options
And quit the browser

@Regression @Smoke
Scenario: Add all dimension on report

Given KPI is open
Then Open report view and full view
Then Add all the dimensions


#Scenario: Validate Terminus Home Page
#
#Given user is on home page
#Then validate home page NewDashboard Icon
#Then validate home page DashboardSettings Icon
#Then click on KPIMenu
#Then open a KPI
#Then verify KPi is open without error
#Then Open Radial Menu and DD by any option
#Then close the browser1


