package com.skype.android.mobilesdk.testapp.common.devices;

/**
 * Created by petro.kushchak on 03/06/2016.
 */

import android.app.Instrumentation;
import android.os.Build;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;

import junit.framework.Assert;

import java.util.List;

//Device for testing needs to be set with language auto-correction turned off, and all the google word intelligence turned off eg: word complete uppercase correction,etc
public class TestDevice {

    private static String APPS_HUB_BUTTON = "Apps";

    private UiDevice device;
    private boolean isTablet;

    public TestDevice(Instrumentation instrumentation){
        device = UiDevice.getInstance(instrumentation);
        this.isTablet = Build.MODEL.equals("Nexus 9");
        //TODO: to find the appropriate way to determine device type for all models. Currently since we have only nexus 9 and 5 so it's enough for that
    }

    public void goHome(){
        device.pressHome();
    }

    public void enter(){
        device.pressEnter();
    }

    public void openApps(){
        goHome();
        findButtonAndClick(By.desc(APPS_HUB_BUTTON), 3000);
    }

    public void openApp(String appText){
        openApps();
        findButtonAndClick(By.text(appText), 500);
    }

    public UiObject2 findObject(BySelector selector, int timeOut){
        device.wait(Until.hasObject(selector), timeOut);
        return device.findObject(selector);
    }

    public void findButtonAndClick(BySelector selector, int timeOut){
        device.wait(Until.hasObject(selector), timeOut);
        device.findObject(selector).click();
    }

    public void findInputAreaAndSetText(BySelector selector, String text, int timeOut){
        device.wait(Until.hasObject(selector),timeOut);
        device.findObject(selector).setText(text);
    }

    public void validateElementsExist(BySelector selector, int timeOut) {
        device.wait(Until.hasObject(selector), timeOut);
        Assert.assertNotNull("no expected element found: " + selector.toString(), device.findObject(selector));
    }

    public void installAndStartAppFromPlayStore(){
        findButtonAndClick(By.text("INSTALL"), 8000);

        // Enable this part of code when running on nexus tablet as it will prompt to ask to accept the installing action.
        if(isTablet){
            findButtonAndClick(By.res("com.android.vending","continue_button"), 3000);
        }

        findButtonAndClick(By.res("com.android.vending", "launch_button"), 300000);

    }

    public void verifyAppSelectionMenuAndSelectApp(BySelector selector) {
        // In nexus, the first time clicking button, android will prompt up asking for application to open,
        // if skype is already selected to open the client once before, then the prompt up will become a panel
        // with "Open with Skype", without selecting skype needed. by that only "Just once" needs to be selected.

        device.wait(Until.hasObject(selector), 3000);
        UiObject2 appButton = device.findObject(selector);
        if(appButton  != null) {
            appButton.click();
        }
        findButtonAndClick(By.res("android","button_once"), 3000);
    }
}
