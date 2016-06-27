package com.skype.android.mobilesdk.testapp;

import android.support.test.uiautomator.By;
import android.test.InstrumentationTestCase;

import com.skype.android.mobilesdk.testapp.common.apps.ChromeApp;
import com.skype.android.mobilesdk.testapp.common.apps.SkypeApp;
import com.skype.android.mobilesdk.testapp.common.devices.TestDevice;

import org.junit.Test;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class CampaignReceiverTest extends InstrumentationTestCase {

    private SkypeApp skypeApp;
    private ChromeApp chromeApp;
    private TestDevice device;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        device = new TestDevice(getInstrumentation());
        skypeApp = new SkypeApp(device);
        chromeApp = new ChromeApp(device);
    }

    @Test
    public void testCampaignReceiver() throws Exception{
        String joinUri = "https://join.skype.com/ldWcBibXH7tU";// Mobile SDK group conversation id, for testing

        device.openApp("Chrome");

        chromeApp.navigateUrl(joinUri);

        //click "download skype"
        //TODO: find a way to link the download to beta app id
        chromeApp.findAndClickElement(By.desc("Download Skype"));

        device.installAndStartAppFromPlayStore();

        skypeApp.signInSkypeAs("c2c_test","c2c_test");

//        skypeApp.validateChatOpened("Mobile SDK test conversation (only for automation testing");
//        skypeApp.leaveChat();
        //TODO: enable this back once the campaign receiver for join is fixed.
    }

}
