Feature: DS Portal SignIn Feature

  Background: User is on DS Algo Sign in Page
    Given The user is on the DS Algo Sign in Page

  Scenario Outline: Verify that user receives error message for all empty fields during Login
    When The user clicks login button after leaving the Username textbox and Password textbox empty
