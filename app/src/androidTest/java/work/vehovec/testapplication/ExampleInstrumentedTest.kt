package work.vehovec.testapplication

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.android.material.button.MaterialButton
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.instanceOf

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
  @Test
  fun useAppContext() {
    // Context of the app under test.
    val appContext = InstrumentationRegistry.getInstrumentation().targetContext
    assertEquals("work.vehovec.testapplication", appContext.packageName)
  }

  @Rule
  @JvmField
  var activityTestRule = ActivityScenarioRule(MainActivity::class.java)

  @Test
  fun nextButtonClickTest() {
    onView(withId(R.id.button_first)).perform(click())

    Thread.sleep(100)

    onView(`is`(instanceOf(MaterialButton::class.java))).check(matches(withText("PREVIOUS")))

    onView(withId(R.id.button_second)).perform(click())

    Thread.sleep(100)

    onView(`is`(instanceOf(MaterialButton::class.java))).check(matches(withText("NEXT")))
  }
}