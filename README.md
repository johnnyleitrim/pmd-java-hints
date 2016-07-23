# PMD Java Hints RuleSet

[![Build Status](https://api.travis-ci.org/johnnyleitrim/pmd-java-hints.svg?branch=master)](https://travis-ci.org/johnnyleitrim/pmd-java-hints/)

## About

This project provides a PMD rule set that gives hints for updating your code to use the newest syntax for the latest Java version.

## Using it in your project

Add this project as a dependency to the ```maven-pmd-plugin```, and configure the pmd plugin to use the ruleset ``java-hints``

```xml
        <build>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-pmd-plugin</artifactId>
                <version>${pmd.plugin.version}</version>
                <dependencies>
                    <dependency>
                        <groupId>io.johnnyleitrim</groupId>
                        <artifactId>pmd-java-hints</artifactId>
                        <version>0.1.0-SNAPSHOT</version>
                    </dependency>
                </dependencies>
                <configuration>
                    <rulesets>
                        <ruleset>java-hints</ruleset>
                    </rulesets>
                </configuration>
            </plugin>
        </build>
```
