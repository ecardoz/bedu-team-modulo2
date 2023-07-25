package com.bedu.e2e.tests.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        features= {"src/test/java/com/bedu/e2e/tests/features"},
        glue= {"com/bedu/e2e/tests/steps"},
        plugin= {"pretty", "json:report/cucumber.json", "unused:report/unused-steps.txt"},
        tags = "not @skip",
        snippets = CAMELCASE)
public class Runner {
}
