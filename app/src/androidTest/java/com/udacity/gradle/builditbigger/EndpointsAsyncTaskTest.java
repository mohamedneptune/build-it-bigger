package com.udacity.gradle.builditbigger;

import android.support.annotation.Nullable;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.fail;

/**
 * Created by Mohamed Ben Abdelkader.
 */


@RunWith(AndroidJUnit4.class)

public class EndpointsAsyncTaskTest implements OnFindJokeListener {

    private String mJoke = null;
    private CountDownLatch mCountDownLatch;

    @Test
    public void AsyncTest() {
        try {
            mCountDownLatch = new CountDownLatch(1);
            EndpointsAsyncTask.getInstance(this);
            mCountDownLatch.await(10, TimeUnit.SECONDS);

            assertNotNull("Joke is null", mJoke);
            assertFalse("Joke is empty", mJoke.isEmpty());
        } catch (Exception e) {
            fail("Exception: " + e.getMessage());
        }
    }

    @Override
    public void onFindJokeFinish(@Nullable String result) {
        mJoke = result;
        mCountDownLatch.countDown();
    }

    @Override
    public void onFindJokeStart() {
    }
}