package com.udacity.gradle.builditbigger;

import android.support.annotation.Nullable;
import android.support.annotation.UiThread;

/**
 * Created by Mohamed Ben Abdelkader.
 */

    public interface OnFindJokeListener {
        @UiThread
        void onFindJokeStart();

        @UiThread
        void onFindJokeFinish(@Nullable String result);
    }

