package com.skype.android.mobilesdk.testapp.common.apps;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;

import com.skype.android.mobilesdk.testapp.common.devices.TestDevice;

/**
 * Created by petro.kushchak on 03/06/2016.
 */
public class ChromeApp {

    public static final String COM_SKYPE_RAIDER = "com.skype.raider";

    private TestDevice device;

    public ChromeApp(TestDevice device) {
        this.device = device;
    }

    public void navigateUrl(String url) {
        device.findButtonAndClick(By.res("com.android.chrome", "url_bar"), 5000);
        device.findInputAreaAndSetText(By.res("com.android.chrome", "url_bar"), url, 3000);

        device.enter();
    }

    public void findAndClickElement(BySelector selector) {
        device.findButtonAndClick(selector, 10000);
    }
}
