package com.assignment.core;

import org.apache.commons.io.FileUtils;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static com.assignment.core.WebDriverInitializer.getDriver;

public class ScreenShotOnFailure implements MethodRule {

    public Statement apply(final Statement statement, final FrameworkMethod frameworkMethod, final Object o) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {
                    statement.evaluate();
                } catch (Throwable t) {
                    captureScreenShot(frameworkMethod.getName());
                    throw t;
                }
            }

            public void captureScreenShot(String fileName) throws IOException {
                File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
                fileName += "_failureScreenshot";
                File targetFile = new File("./" + fileName + ".png");
                FileUtils.copyFile(scrFile, targetFile);
            }
        };
    }
}
