package com.pajato.argus.tmdb.demo

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Rule
    @JvmField
    val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.pajato.argus.tmdb.demo", appContext.packageName)
    }

    @Test
    fun testSnackbarTextWhenFabButtonIsClicked() {
        onView(withId(R.id.fab)).perform(click())
        onView(withId(com.google.android.material.R.id.snackbar_text))
            .check(matches(withText("Replace with your own action")))
    }

    @Test
    fun testOptionsMenuCases() {
        openActionBarOverflowOrOptionsMenu(ApplicationProvider.getApplicationContext<Context>())
        onView(withText("Settings")).perform(click())

        openActionBarOverflowOrOptionsMenu(ApplicationProvider.getApplicationContext<Context>())
        onView(withText("Tests")).perform(click())
    }
}
