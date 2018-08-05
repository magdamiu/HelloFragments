package com.example.magdamiu.hellofragments.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class ViewUtils {

    public static void hideKeyboard(Activity activity, View view) {
        final InputMethodManager inputManager = (InputMethodManager)
                activity.getSystemService(Context.INPUT_METHOD_SERVICE);

        final View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            currentFocus.post(new Runnable() {
                @Override
                public void run() {
                    boolean result = inputManager.hideSoftInputFromWindow(
                            currentFocus.getApplicationWindowToken(),
                            InputMethodManager.HIDE_IMPLICIT_ONLY);

                    Logging.show(this, "First attempt to hide: " + String.valueOf(result));
                    if (!result) {
                        boolean secondResult = inputManager.hideSoftInputFromWindow(
                                currentFocus.getWindowToken(), 0);
                        Logging.show(this, "Second attempt to hide: " +
                                String.valueOf(secondResult));
                    }
                }
            });
        }
    }
}
