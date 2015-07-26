# HockeyAppSample
This is a sample app that demonstrates how to hook up HockeyApp into your application.

Note that the minimum Android SDK version for this sample app is [API Lvl 14 (Ice Cream Sandwich)](https://source.android.com/source/build-numbers.html).
This sample app uses the [ActivityLifecycleCallbacks](http://developer.android.com/reference/android/app/Application.ActivityLifecycleCallbacks.html) which are only available in API Lvl 14 and above. It depends on the [HockeyApp Android SDK](https://github.com/bitstadium/HockeySDK-Android) and the [Gradle HockeyApp Plugin](https://github.com/x2on/gradle-hockeyapp-plugin) to automatically upload your build to HockeyApp.


## Setup
  * [Sign up](https://rink.hockeyapp.net/users/sign_up) for HockeyApp
  * Create a ["New App"](screenshots/Dashboard_NewApp.png) from the HockeyApp dashboard
  * Find the [App ID and Secret](screenshots/AppID_Secret.png) on your HockeyApp app page 
  * Create an API Token:  [Account Settings > API Tokens > Create](screenshots/AccountSetting_CreateApiToken.png)
  * edit [app/gradle.properties](app/gradle.properties) and replace `YOUR_API_TOKEN`, `YOUR_APP_ID` and `YOUR_APP_SECRET` with your valid API Token, App ID and App Secret values.
  
*NOTE:* You MUST have a valid API Token, App ID and App Secret for this sample application to work.

## Dependencies
  * [com.android.support:appcompat-v7:22.2.0](https://developer.android.com/tools/support-library/features.html#v7-appcompat)
  * [net.hockeyapp.android:HockeySDK:3.5.0](https://github.com/bitstadium/HockeySDK-Android)
  * [de.felixschulze.gradle:gradle-hockeyapp-plugin:3.2](https://github.com/x2on/gradle-hockeyapp-plugin)

## License

  * [Apache 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)
