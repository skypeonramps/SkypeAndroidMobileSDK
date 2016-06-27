package com.skype.android.mobilesdk.testapp;

import android.support.test.uiautomator.By;
import android.test.InstrumentationTestCase;

import com.skype.android.mobilesdk.testapp.common.apps.SkypeApp;
import com.skype.android.mobilesdk.testapp.common.apps.TestApp;
import com.skype.android.mobilesdk.testapp.common.devices.TestDevice;

import org.junit.Test;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class SkypeSdkActionsTest extends InstrumentationTestCase {

    private static String TEST_SKYPE_ID = "echo1234";

    private TestDevice device;
    private SkypeApp skypeApp;
    private TestApp testApp;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        device = new TestDevice(getInstrumentation());
        skypeApp = new SkypeApp(device);
        testApp = new TestApp(device);
        testApp.open();
    }

    @Test
    public void testChatButton() throws Exception {

        testApp.enterSkypeId(TEST_SKYPE_ID);
        testApp.clickChatButton();

        device.verifyAppSelectionMenuAndSelectApp(By.text(skypeApp.getAppId()));

        skypeApp.validateChatOpened(TEST_SKYPE_ID);
    }

    @Test
    public void testCallButton() throws Exception {

        testApp.enterSkypeId(TEST_SKYPE_ID);
        testApp.clickCallButton();

        device.verifyAppSelectionMenuAndSelectApp(By.text(skypeApp.getAppId()));

        skypeApp.validateCallStarted(TEST_SKYPE_ID);
        skypeApp.endCall();
    }

    @Test
    public void testJoinButton() throws Exception {

        testApp.enterSkypeId("ldWcBibXH7tU");
        testApp.clickJoinButton();

        device.verifyAppSelectionMenuAndSelectApp(By.text(skypeApp.getAppId()));

        skypeApp.validateChatOpened("Mobile SDK test conversation (only for automation testing)");
        skypeApp.leaveChat();

    }


}