# Projects from seleniumframework.com

You can find a much lucid explanation on [seleniumframework.com] (http://www.seleniumframework.com/cucumber-jvm-2/what-is-cucumber-jvm/)

# cucumber-jvm-selenium-class1 

Explains browser commands that selenium java api provides.  
http://www.seleniumframework.com/cucumber-jvm-3/browser-commands/  

## Get the code

Git:

    git clone https://github.com/machzqcq/CucumberJVMExamples
    cd cucumberjvm-selenium-class1

## Use Maven

Open a command window and run:

    mvn test

This runs Cucumber features using Cucumber's JUnit runner. The `@RunWith(Cucumber.class)` annotation on the `RunCukesTest`
class tells JUnit to kick off Cucumber.

Open a command window and run:

    mvn clean test -Dcucumber.options="--plugin junit:taget_junit/cucumber.xml"

This runs Cucumber features using Cucumber's JUnit runner of course. Specifies extra output
results format that CI servers generally interpret

Open a command window and run:

    mvn clean test -Dcucumber.options="classpath:features/BrowserCommands.feature:11"

This should result in no scenarios running because there are no scenarios at line:10
Moreover, if we want to override running entire features folder, we can do this



## Few options you can try on this project

The Cucumber runtime parses command line options to know what features to run, where the glue code lives, what plugins to use etc.
When you use the JUnit runner, these options are generated from the `@CucumberOptions` annotation on your test.

Sometimes it can be useful to override these options without changing or recompiling the JUnit class. This can be done with the
`cucumber.options` system property. The general form is:

Using Maven:

    mvn -Dcucumber.options="..." test


### Run a subset of Features or Scenarios

Specify a particular scenario by *line* (and use the pretty plugin, which prints the scenario back)

    -Dcucumber.options="classpath:features/BrowserCommands.feature:5 --plugin pretty"

You can also specify files to run by filesystem path:

    -Dcucumber.options="src/test/resources/features/seleniumframework.feature:4 --plugin pretty"

You can also specify what to run by *tag*:

    -Dcucumber.options="--tags @foo --plugin pretty"

## Known Issues so far

https://github.com/cucumber/cucumber-jvm/issues
