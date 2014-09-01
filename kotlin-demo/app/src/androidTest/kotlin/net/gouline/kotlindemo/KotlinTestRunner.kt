package net.gouline.kotlindemo

import android.test.InstrumentationTestRunner
import junit.framework.TestSuite

/**
 * Kotlin-based test runner.
 *
 * @author Mike Gouline
 */
open class KotlinTestRunner() : InstrumentationTestRunner() {

    override fun getAllTests(): TestSuite? {
        val suite = TestSuite()
        suite.addTest(KotlinDummyTest())
        return suite
    }
}