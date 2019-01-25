package com.udacity.gradle.builditbigger;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Mohamed Ben Abdelkader.
 */

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTestUnit {
    @Test
        public void iTest() throws Exception {
        int timeOut = 10;
        int expectedJokeSize = 6;
            EndpointsAsyncTaskTest endpointsAsyncTaskTest =  new EndpointsAsyncTaskTest();
            endpointsAsyncTaskTest.execute(InstrumentationRegistry.getContext());
            String jokeResult = endpointsAsyncTaskTest.get(timeOut, TimeUnit.SECONDS);
            Assert.assertEquals(expectedJokeSize,jokeResult.length());
        }
}