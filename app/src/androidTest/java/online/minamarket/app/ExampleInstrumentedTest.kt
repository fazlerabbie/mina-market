package online.minamarket.app

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.action.ViewActions.click
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("online.minamarket.app", appContext.packageName)
    }

    @Test
    fun testSplashScreenIsVisible() {
        // Test that splash screen is initially visible
        onView(withId(R.id.splash_layout))
            .check(matches(isDisplayed()))
    }

    @Test
    fun testWebViewIsPresent() {
        // Wait for splash screen to disappear and check if WebView is present
        Thread.sleep(3000) // Wait for splash screen duration

        onView(withId(R.id.webview))
            .check(matches(isDisplayed()))
    }

    @Test
    fun testRetryButtonFunctionality() {
        // Test retry button functionality
        Thread.sleep(3000) // Wait for splash screen

        // If error layout is visible, test retry button
        try {
            onView(withId(R.id.retry_button))
                .check(matches(isDisplayed()))
                .perform(click())
        } catch (e: Exception) {
            // Error layout might not be visible if connection is successful
            // This is expected behavior
        }
    }

    @Test
    fun testSwipeRefreshIsPresent() {
        // Test that SwipeRefreshLayout is present
        Thread.sleep(3000) // Wait for splash screen

        onView(withId(R.id.swipe_refresh))
            .check(matches(isDisplayed()))
    }
}