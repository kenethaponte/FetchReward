# Fetch Rewards Coding Exercise – SDET

Given a balance scale and 9 gold bars of the same size and look. You don’t know the exact weight of each bar, but you know they are the same weight, except for only one fake bar. It weighs less than others. You need to find the fake gold bar by only bars and balance scales. You can only place gold bars on scale plates (bowls) and find which scale weighs more or less.

This code automates the game using Selenium Webdriver in Java. It takes from 1 to 3 weightings max to find the fake bar.

## Requirements

•	OS: Windows or Mac
•	Browser: Google Chrome or Microsoft Edge
•	[JDK 8https] (//www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
•	[Maven] (https://maven.apache.org/install.html)

## How to execute tests?

Run the following command in the projects’ root folder
For Chrome:
```
mvn –Dtest=ChromeTest test
```
For Edge:
```
mvn –Dtest=EdgeTest test
```
