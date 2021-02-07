# cucumberjvm-selenium-data-driven-framework

A barebone example for creating a data-driven driven framework (in this case data is in an excel workbook)

## Get the code

Git:

    git clone https://github.com/machzqcq/cucumber-jvm-examples.git
    cd cucumberjvm-selenium-data-driven-framework

## Use Maven

Open a command window and run:

    `mvnw` allows to run project without having mvn installed, otherwise if you have `mvn`, replace mvnw with mvn in the below commands

`./mvnw test`  

### Different examples of execution

- `./mvnw clean compile test`
- `./mvnw clean test -Dcucumber.features="classpath:features/DataDrivenFramework.feature"`
- `./mvnw clean test -Dcucumber.features="classpath:features/DataDrivenFramework.feature:11"`
- `./mvnw clean test -Dcucumber.features="classpath:features/DataDrivenFramework.feature" -Dcucumber.plugin="html:target/cucumber-html-report.html, json:target/cucumber.json"`

This runs Cucumber features using Cucumber's JUnit runner. The `@RunWith(Cucumber.class)` annotation on the 
`RunCucumberTest` class tells JUnit to kick off Cucumber.

    For Windows use mvnw.cmd

## Use Gradle

    `gradlew` allows to run project without having gradle installed, otherwise if you have `gradle`, replace gradlew with gradle in the below commands

Open a command window and run:

`./gradlew test --rerun-tasks --info`

This runs Cucumber features using Cucumber's JUnit runner. The `@RunWith(Cucumber.class)` annotation on the
`RunCucumberTest` class tells JUnit to kick off Cucumber.


## Few options you can try on this project

The Cucumber runtime parses command line options to know what features to run, where the glue code lives, what plugins to use etc.
When you use the JUnit runner, these options are generated from the `@CucumberOptions` annotation on your test.

Sometimes it can be useful to override these options without changing or recompiling the JUnit class. This can be done with the
`cucumber.options` system property. The general form is:

Using Maven:

`./mvnw -Dcucumber.options="..." test`


## Overriding options

The Cucumber runtime parses command line options to know what features to run, where the glue code lives, what plugins to use etc.
When you use the JUnit runner, these options are generated from the `@CucumberOptions` annotation on your test.

Sometimes it can be useful to override these options without changing or recompiling the JUnit class. This can be done with the
`cucumber.options` system property. The general form is:

Using Maven:

    mvn -Dcucumber.features="..." -Dcucumber.glue="..." test

Using Gradle:

    gradlew -Dcucumber.features="..." -Dcucumber.glue="..." test

For available options and overriding rules, please consult the following Maven command:

    mvn exec:java \
      -Dexec.classpathScope=test \
      -Dexec.mainClass=io.cucumber.core.cli.Main \
      -Dexec.args="--help"

### Run a subset of Features or Scenarios

Specify a particular scenario by *line*

    -Dcucumber.features="classpath:features/addition.feature:4"

This works because Maven puts `./src/test/resources` on your `classpath`.
You can also specify files to run by filesystem path:

    -Dcucumber.features="src/test/resources/features/addition.feature"

In case you have many feature files or scenarios to run against, separate them with commas `,`

    -Dcucumber.features="src/test/resources/skeleton/belly.feature:4, src/test/resources/features/addition.feature"

You can also specify what to run by *tag*:

    -Dcucumber.filter.tags="@foo"

### Running only the scenarios that failed in the previous run

    -Dcucumber.features="@target/rerun.txt"

This works as long as you have the `rerun` formatter enabled.

### Specify a different formatter:

For example a JUnit formatter:

`-Dcucumber.plugin="junit:target/cucumber-junit-report.xml"`

## Prettier HTML report
Generally all reports are found under `target` folder, however if you want more prettier reports..

`java -jar cucumber-sandwich-5.4.1-SNAPSHOT-jar-with-dependencies.jar -f path/to/the/folder/containing/cucumber.json -o /path/to/generate/html/reports/into`. For e.g.  

`java -jar cucumber-sandwich-5.4.1-SNAPSHOT-jar-with-dependencies.jar -n -f cucumberjvm-selenium-class1/target/  -o cucumberjvm-selenium-class1/target/` from the root of this repo

## References
- https://github.com/cucumber/cucumber-jvm/issues  
- https://github.com/damianszczepanik/cucumber-sandwich

