package com.renren.breadtravel;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.renren.breadtravel.db.SearchDbHelper;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

   // SearchDbHelper mSearchDbHelper ;

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

     //   mSearchDbHelper = SearchDbHelper.getSearchDbHelper(appContext);

        assertEquals("com.renren.breadtravel", appContext.getPackageName());
    }

}
