package com.demo.demoapp

import android.content.Intent
import android.widget.ImageView
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows


@RunWith(
    RobolectricTestRunner::class
)
class MainActivityTest {

    private lateinit var mainActivity: MainActivity

    @Before
    @Throws(Exception::class)
    fun setUp() {
        mainActivity = Robolectric.buildActivity(MainActivity::class.java!!)
            .create()
            .resume()
            .get()
    }

    @Test
    fun clickingLogin_shouldStartLoginActivity() {
        mainActivity.findViewById<ImageView>(R.id.imgSearch).performClick()

        val expectedIntent = Intent(mainActivity, SearchActivity::class.java)
        val actual = Shadows.shadowOf(mainActivity).nextStartedActivity
        assertEquals(expectedIntent.component, actual.component)


    }
}