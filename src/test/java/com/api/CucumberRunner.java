package com.api;

import org.junit.runner.RunWith;

import com.maveric.core.cucumber.CucumberBaseTest;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "./src/test/resources/features",
        glue = {"com.api.stepDefs"},
        tags = "@api"
)
public class CucumberRunner extends CucumberBaseTest {

}
