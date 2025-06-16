// hooks/Hooks.java
package hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import utilities.FilePaths;
import utilities.TestContextClass;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Hooks {

    TestContextClass context;

    public Hooks(TestContextClass context) {
        this.context = context;
    }

    @Before
    public void setUp() {
        context.initialize();
        System.out.println("Browser launched before scenario.");
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
