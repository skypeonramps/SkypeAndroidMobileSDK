Skype Consumer Android Mobile SDK (Preview)
===========================================

The Skype Consumer Android SDK enables a developer to easily add an IM or Call action (button) to your application to contact a specific user or join a specific conversation. Currently it wraps supported intents that enable deep linking into Skype.

### Prerequisites 
The SDK will only work with Skype Client 7.11 and higher. The Skype client currently supports a minimum version of Android 4.0.3. [See FAQ for more details](https://support.skype.com/en/faq/FA10328/what-are-the-system-requirements-for-skype).

### Using the Android SDK

1. Import the SDK Library via jCenter
2. Use SkypeAPI object to invoke actions in the Skype client

#### Importing SDK library

* Add this to project-level /app/build.gradle before dependencies*
```javascript
repositories {
	jcenter()
}
```

* Add the compile dependency with the latest version of the Skype Mobile SDK in the build.gradle file for your module that uses this sdk:
```javascript
dependencies {
compile 'com.skype.android.skype-android-sdk:MobileSdk:1.0.0.0'
}
```

#### Usage Example
```java
try {
	SkypeApi skypeApi = new SkypeApi(getApplicationContext());

    	skypeApi.startConversation(skypeIdValue.toString(), Modality.AudioCall);
} catch (SkypeSdkException e) {
 // Exception handling logic here
}
```



