package net.gouline.kotlindemo;

import android.test.InstrumentationTestRunner;

import junit.framework.TestSuite;

/**
 * Custom test runner.
 *
 * @author Mike Gouline
 */
public class TestRunner extends InstrumentationTestRunner {

    @Override
    public TestSuite getAllTests() {
        TestSuite suite = new TestSuite();
        suite.addTest(new DummyKotlinTest());
        return suite;
    }
}
