package com.assignment.core;

import org.apache.commons.io.FileUtils;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
                DateTimeFormatter timeStampPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH-mm-ss");
                File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
                fileName = timeStampPattern.format(LocalDateTime.now()) + "_" + fileName + "_failureScreenshot";
                File targetFile = new File("screenShots/" + fileName + ".png");
                FileUtils.copyFile(scrFile, targetFile);
            }
        };
    }

}
