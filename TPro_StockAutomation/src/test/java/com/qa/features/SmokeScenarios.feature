#----------------------------Feature Description---------------------------------------------
#--- This Feature file contains smoke test cases to check the basic functionality after a minor change-----
Feature: TPro Application Test
Background:
Given user open browser
Then user is on login page
Then user logs into app
Then click on KPIMenu

## --- Scenario for Login success and Basic check on logon ---
@Smoke
Scenario: Validate home page open a KPI and report do a DD and add Dimension

Given user is on home page
Then validate home page DashboardSettings Icon
Then open a KPI
Then verify KPi is open without error
Then Open Radial Menu and DD by any option
Then open the report view
Then full view and add dimension
Then close the browser

## ---- Scenario to validate all the KPI's are opening without any error ---
@Smoke
Scenario: Open All KPI's

Given user is on home page again
Then user open all KPI's 
And Close the browser

## ---- Scenario to validate all the dashboards are opening without any error ---
@Smoke
Scenario: Open All the dashboards

Given Dashboard Tab is open in KPI menu
Then open all the dashboards
And Close the browser

## --- Scenario to validate DD by all options on selected KPI's ---
@Smoke
Scenario: DD by all the options on KPI

Given User is logged in and KPI menu is open
Then open the KPI
Then DD by all the options
And quit the browser

## --- Scenario to validate add dimension on report ---
@Smoke
Scenario: Add all dimension on report

Given KPI is open
Then Open report view and full view
Then Add all the dimensions

## --- Scenario to add all the dimensions on all KPI's report ---
@Smoke
Scenario: Add all dimensions on all the reports one by one

Given KPI is already Open
Then Open report view from KPI and full view
Then Add all the dimensions and close the report

## --- Scenario to add measure on KPI --

@Smoke
Scenario: Add measure to the KPI

Given User is logged in and KPI Menu is Open
Then Open a KPI
Then Click the Show Measures Icon on KPI Menu
Then Pick a measure from measure list and add to KPI


## -- Scenario to add columns to super Header and set measure column as under header
@Smoke
Scenario: Add columns to super header and set measure columns as Set Under Header

Given User is logged in and Report is open
Then Add Dimension One
Then Add Dimension Two
Then Set Dimension One as super header
Then Set Dimension Two as super header
Then Set measure column as set under header


## Scenario to apply parameter Search
@Smoke
Scenario: Apply parameter search

Given Report view is open
Then click on Parameter search Icon
Then select an option
Then Enter a value and click search
Then verify report data gets filtered as per search criteria


## Scenario to apply formulae on report
@Smoke @Regression @Sample
Scenario: Apply formulae

Given KPI is open already
Then Add measure
Then Open report view
Then apply formulae




