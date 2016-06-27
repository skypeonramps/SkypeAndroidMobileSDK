package com.skype.android.mobilesdk.testapp.common.apps;

import android.support.test.uiautomator.By;

import com.skype.android.mobilesdk.testapp.common.devices.TestDevice;

/**
 * Created by petro.kushchak on 03/06/2016.
 */
public class SkypeApp{

    public static final String COM_SKYPE_RAIDER = "com.skype.raider";

    private TestDevice device;

    public SkypeApp(TestDevice device) {
        this.device = device;
    }

    public void signInSkypeAs(String username, String password) {
        device.findInputAreaAndSetText(By.res(COM_SKYPE_RAIDER,"sign_in_userid"),username, 5000);
        device.findButtonAndClick(By.res(COM_SKYPE_RAIDER, "sign_in_next_btn"),500);
        device.findInputAreaAndSetText(By.res(COM_SKYPE_RAIDER,"signin_password"), password, 3000);
        device.findButtonAndClick(By.res(COM_SKYPE_RAIDER,"sign_in_btn"), 500);
    }

    public void leaveChat(){
//        UiObject2 typeMessageString = device.findObject(By.text("Type a message here"));
//        typeMessageString.click();
//        typeMessageString.setText("/leave");
        device.findInputAreaAndSetText(By.text("Type a message here"), "/leave", 500);
        device.findButtonAndClick(By.desc("Send message"), 500);
    }

    public void waitForChat(){
//        device.wait(Until.hasObject(By.res("com.skype.raider", "chat_notification_contents")), 10000);
//        UiObject2 joinText = device.findObject(By.text("c2c test joined"));
//        device.findObject(By.res("com.skype.raider", "chat_notification_contents"), 10000);
    }

    public String getAppId() {
        return "Skype";
    }

    public void validateChatOpened(String conversationTitle) {
        if (device.findObject(By.res(COM_SKYPE_RAIDER,"sign_in_text"), 3000) != null){
            signInSkypeAs("c2c_test","c2c_test");
        }
        device.validateElementsExist(By.text("Type a message here"), 5000);
        device.validateElementsExist(By.text(conversationTitle), 1000);

    }

    public void validateCallStarted(String skypeId) {
        if (device.findObject(By.res(COM_SKYPE_RAIDER,"sign_in_text"), 3000) != null){
            signInSkypeAs("c2c_test","c2c_test");
        }
        device.validateElementsExist(By.text(skypeId), 3000);
    }

    public void endCall() {
        device.findButtonAndClick(By.descContains("End call"), 1000);
    }
}
