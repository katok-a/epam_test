package katok.tests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/katok/features/",
        glue = "katok.steps",
        tags = "@All_Tests"
)
public class AllTest {

}
