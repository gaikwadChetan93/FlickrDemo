package com.demo.demoapp

import android.support.test.InstrumentationRegistry
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4

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
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(
        MainActivity::class.java,
        true, // initialTouchMode
        true
    )

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.demo.demoapp", appContext.packageName)
    }

    @Test
    fun clickingSearch_shouldReturnValidResult() {

        Espresso.onView(ViewMatchers.withId(R.id.imgSearch))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.edtSearch))
            .perform(ViewActions.typeText("Cat"))

        Espresso.onView(ViewMatchers.withId(R.id.btnSearch))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.txtTag))
            .check(ViewAssertions.matches(ViewMatchers.withText("Cat")))


    }
}
