package com.tashi.patient_record_management;


        import androidx.test.rule.ActivityTestRule;

        import org.junit.Rule;
        import org.junit.Test;

        import static androidx.test.espresso.Espresso.closeSoftKeyboard;
        import static androidx.test.espresso.Espresso.onView;
        import static androidx.test.espresso.action.ViewActions.click;
        import static androidx.test.espresso.action.ViewActions.typeText;
        import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class login_validation {
    @Rule
    public ActivityTestRule<Activity_login> activity_loginActivityTestRule = new ActivityTestRule<>(Activity_login.class);
    //    public ActivityTestRule<Activity_login> activityTestRule = new ActivityTestRule<>(Activity_login.class);
//
    @Test
    public void login_validation() {
        onView(withId(R.id.user)).perform(typeText( "tashi@gmail.com" ));
        closeSoftKeyboard();
        onView(withId(R.id.pswd)).perform(typeText( "tashi1" ));
        closeSoftKeyboard();
        onView(withId(R.id.lin)).perform(click());
    }
}


