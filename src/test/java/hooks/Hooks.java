// hooks/Hooks.java
package hooks;

import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.FilePaths;
import utilities.TestContextClass;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;

public class Hooks {

    TestContextClass context;

    public Hooks(TestContextClass context) {
        this.context = context;
    }

    @Before
    public void setUp(Scenario scenario) {
        Collection<String> tags = scenario.getSourceTagNames();
        if (tags.contains("@ui")) {
            context.initialize();
            System.out.println("Browser launched before scenario.");
        } else {
            System.out.println("Skipping browser launch (API scenario).");
        }
    }

    @After
    public void tearDown() {
        if (context.getDriver() != null) {
            context.getDriver().quit();
            System.out.println("Browser closed after scenario.");
            context.clear();
        }
    }


    @AfterAll
    public static void openExtentReport() {
        try {

            ExtentService.getInstance().flush();

            File reportFile = new File(FilePaths.EXTENT_REPORT_FILE);
            if (reportFile.exists()) {
                Desktop.getDesktop().browse(reportFile.toURI());
                System.out.println(" Extent Report opened in Chrome.");
            } else {
                System.out.println("⚠ Extent Report not found at expected location.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
