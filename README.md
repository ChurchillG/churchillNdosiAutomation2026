
# Ndosi Automation Project

## Overview
This project is a Selenium-based test automation framework designed to test the Ndosi website. It uses Java, Maven, and TestNG for managing dependencies, test execution, and reporting. The framework is integrated with Extent Reports for detailed test reporting, including screenshots for failed test cases.

---

## Project Structure
---

## Class Descriptions

### **BaseTest**
- **Purpose**: Handles WebDriver setup and teardown.
- **Connections**: Parent class for all test classes.

### **LoginPage**
- **Purpose**: Encapsulates login page interactions.
- **Connections**: Used in `LoginTest`.

### **LearningPage**
- **Purpose**: Encapsulates learning page interactions.
- **Connections**: Used in test classes for learning flow.

### **LoginTest**
- **Purpose**: Contains test logic for login and learning flow.
- **Connections**: Uses `BaseTest`, `LoginPage`, `LearningPage`, `ExtentLogger`, and `Listener`.

### **Screenshots**
- **Purpose**: Captures screenshots during test execution.
- **Connections**: Used by `ExtentLogger` and `Listener`.

### **ExcelUtils**
- **Purpose**: Reads data from Excel files for data-driven testing.
- **Connections**: Used in test classes for fetching test data.

### **ExtentLogger**
- **Purpose**: Logs test steps and attaches screenshots to Extent Reports.
- **Connections**: Uses `Screenshots` and `Listener`.

### **Listener**
- **Purpose**: Implements `ITestListener` for Extent Reports logging.
- **Connections**: Uses `ExtentManager` and `Screenshots`.

### **ExtentManager**
- **Purpose**: Configures and initializes Extent Reports.
- **Connections**: Used by `Listener`.

### **testing.xml**
- **Purpose**: Defines the test suite and execution order.
- **Connections**: Registers `Listener` and includes test classes.

### **testdata.xlsx**
- **Purpose**: Provides test data for data-driven tests.
- **Connections**: Used by `ExcelUtils`.

---

## Features
- **Extent Reports Integration**: Generates detailed test reports with screenshots.
- **Data-Driven Testing**: Supports reading test data from Excel files.
- **Page Object Model (POM)**: Encapsulates page-specific logic for better maintainability.
- **Thread-Safe Execution**: Ensures thread safety for WebDriver and Extent Reports.

---

## Prerequisites
- Java 8 or higher
- Maven
- TestNG
- ChromeDriver (ensure it matches your Chrome version)

---

## How to Run
1. Clone the repository.
2. Navigate to the project root directory.
3. Execute the following Maven command:
   ```bash
   mvn clean test