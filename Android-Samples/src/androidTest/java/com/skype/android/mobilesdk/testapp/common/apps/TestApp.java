package com.skype.android.mobilesdk.testapp.common.apps;

import android.support.test.uiautomator.By;

import com.skype.android.mobilesdk.testapp.common.devices.TestDevice;

/**
 * Created by petro.kushchak on 03/06/2016.
 */
public class TestApp {

    public static final String COM_SKYPE_RAIDER = "com.skype.raider";
    private static final String TEST_APP_NAME = "TestApp";

    private TestDevice device;

    public TestApp(TestDevice device) {
        this.device = device;
    }

    public void enterSkypeId(String skypeId) {
        device.findInputAreaAndSetText(By.clazz("android.widget.EditText"), skypeId, 3000);
    }

    public void clickChatButton() {
        device.findButtonAndClick(By.text("Chat"), 3000);
    }

    public void clickCallButton() {
        device.findButtonAndClick(By.text("Call"), 3000);
    }

    public void clickJoinButton() {
        device.findButtonAndClick(By.text("Join"), 3000);
    }

    public void open() {
        device.openApp(TEST_APP_NAME);
    }
}
