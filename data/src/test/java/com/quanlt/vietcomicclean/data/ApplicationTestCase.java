package com.quanlt.vietcomicclean.data;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, application = ApplicationSub.class, sdk = 21)
public abstract class ApplicationTestCase {
}
