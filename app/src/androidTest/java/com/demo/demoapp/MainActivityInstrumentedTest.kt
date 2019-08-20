package com.demo.demoapp

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(
        MainActivity::class.java,
        true, // initialTouchMode
        true
    )

    @Test
    fun clickingSearch_shouldReturnValidResult() {

        onView(withId(R.id.imgSearch))
            .perform(ViewActions.click())

        onView(withId(R.id.edtSearch))
            .perform(ViewActions.typeText("Cat"))

        onView(withId(R.id.btnSearch))
            .perform(ViewActions.click())

        onView(withId(R.id.txtTag))
            .check(ViewAssertions.matches(ViewMatchers.withText("Cat")))

    }

    @Test
    fun clickingSearch_searchingTag_shouldShowValidResultOnList() {

        onView(withId(R.id.imgSearch))
            .perform(ViewActions.click())

        onView(withId(R.id.edtSearch))
            .perform(ViewActions.typeText("Cat"))

        onView(withId(R.id.btnSearch))
            .perform(ViewActions.click())

        onView(withId(R.id.txtTag))
            .check(ViewAssertions.matches(ViewMatchers.withText("Cat")))

        Thread.sleep(5000)

        onView(withId(R.id.photoList))
            .check(matches(hasDescendant(withText("The cat"))))
    }

    @Test
    fun clickingSearch_searchingTag_ClickPhoto_ShouldShowValidDetails() {

        onView(withId(R.id.imgSearch))
            .perform(ViewActions.click())

        onView(withId(R.id.edtSearch))
            .perform(ViewActions.typeText("Cat"))

        onView(withId(R.id.btnSearch))
            .perform(ViewActions.click())

        onView(withId(R.id.txtTag))
            .check(ViewAssertions.matches(ViewMatchers.withText("Cat")))

        Thread.sleep(5000)

        onView(withId(R.id.photoList))
            .check(matches(hasDescendant(withText("The cat"))))

        onView(allOf(withId(R.id.photoList), isDisplayed())).perform(
            RecyclerViewActions
                .actionOnItem<RecyclerView.ViewHolder>(hasDescendant(withText("The cat")), click())
        )

    }
}
