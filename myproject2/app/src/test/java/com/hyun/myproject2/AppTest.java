/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.hyun.myproject2;

import org.junit.Test;
import com.hyun.app2.App;
import static org.junit.Assert.*;

public class AppTest {
    @Test public void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    }
}
