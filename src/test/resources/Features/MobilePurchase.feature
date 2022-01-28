#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: AmazonProject
  I want to use this template for my feature file

Background:
  Given user Launches Amazon Application

  @tag1
  Scenario: MobilePurchase
    
    When user Search mobile
    And user click on MobileName
    Then user click on BuyNow option

  Scenario: MobilePurchase by one dim list
 
    When user Search mobile by one dim list
      | realme |
      | iphone |
    And user click on MobileName
    Then user click on BuyNow option
#    Examples: 
 #     | phName |
  #    | realme |
#      | iPhone |
