package com.tashi.patient_record_management;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class logout_validation {
    @Rule
    public ActivityTestRule<Dashboard> activity_loginActivityTestRule = new ActivityTestRule<>(Dashboard.class);
    //    public ActivityTestRule<Activity_login> activityTestRule = new ActivityTestRule<>(Activity_login.class);
//
    @Test
    public void logout_validation() {
        onView(withId(R.id.lout)).perform(click());
    }
}


