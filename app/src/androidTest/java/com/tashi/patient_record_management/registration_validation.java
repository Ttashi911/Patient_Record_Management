package com.tashi.patient_record_management;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class registration_validation {
    @Rule
    public ActivityTestRule<Activity_register> activity_loginActivityTestRule = new ActivityTestRule<>((Activity_register.class));

    @Test
    public void register_validation() {
        onView(withId(R.id.user)).perform (typeText("Tashi"));
        closeSoftKeyboard();
        onView(withId(R.id.mail)).perform (typeText("tashi@gmail.com"));
        closeSoftKeyboard();
        onView(withId(R.id.pswd)).perform (typeText("tashi1"));
        closeSoftKeyboard();
        onView(withId(R.id.mobphone)).perform (typeText("9808550404"));
        closeSoftKeyboard();
        onView(withId(R.id.tv_res)).perform(click());


    }
}
