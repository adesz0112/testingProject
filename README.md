# Webshop testing (Playwright Project)

This project is currently in development

# The System Under Test(SUT)
<img src="automationsite.png" alt="sut.png" width="700"/>;


## 📘 Project Overview

This project is an automated test suite developed using Playwright with Java and Cucumber, 
aimed at testing the core functionalities of (https://automationexercise.com). 
The test suite simulates real user interactions such as registration, login, form submissions, product searches, cart operations, and account management.

## Members
- [Ádám Mészáros](https://github.com/adesz0112)

## 🔧 Tech Stack
Playwright Java – Modern automation tool for reliable browser testing

Cucumber – BDD framework for writing human-readable test scenarios

JUnit/TestNG – Test runner integration

Edge/Chrome/Chromium – Cross-browser execution support

## ✅ Key Features Tested
User Registration & Login

Form validations (including HTML5 native messages)

Product Search and Navigation

Add to Cart and Checkout Flow

Modal handling and cart validation

Account Deletion

Error handling for invalid input cases

## 🚀 How to Run Tests
All tests are executed through the AllTestRunner class using JUnit:

Write in the command line: 
 mvn test

This runner collects and executes all feature files found under the features/ directory and uses step definitions from the stepdefinitions package.

## Test Details
* For detailed information on each test scenario, refer to the feature files under `src/test/resources/features`.