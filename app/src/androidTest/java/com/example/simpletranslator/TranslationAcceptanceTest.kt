package com.example.simpletranslator

import android.support.test.runner.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TranslationAcceptanceTest {

    @Test
    fun verifyTranslation() {
        // given
        onView(withId(R.id.translationInput)).perform(ViewActions.typeText("word"), ViewActions.closeSoftKeyboard())

        // when
        onView(withId(R.id.translateButton)).perform(click())

        // then
        onView(withId(R.id.translateResult)).check(ViewAssertions.matches(ViewMatchers.withText("słowo")))
    }
}
