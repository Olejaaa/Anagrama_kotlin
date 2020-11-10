package com.example.anagrama_kotlin

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.assertion.ViewAssertions.matches



@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    private lateinit var stringToBeTyped: String

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun initValidString() {
        stringToBeTyped = "Espresso"
    }

    @Test
    @Throws(Exception::class)
    fun changeText_sameActivity() {
        onView(withId(R.id.text_input)).perform(typeText(stringToBeTyped), closeSoftKeyboard())
        onView(withId(R.id.text_view_result)).check(matches(withText(stringToBeTyped.reversed())))
    }

}