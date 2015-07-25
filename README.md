# HockeyAppSample
This is a sample app that demonstrates how to hook up HockeyApp into your application.

Note that the minimum Android SDK version for this sample app is [API Lvl 14 (Ice Cream Sandwich)](https://source.android.com/source/build-numbers.html).
This sample app uses the [ActivityLifecycleCallbacks](http://developer.android.com/reference/android/app/Application.ActivityLifecycleCallbacks.html) which are only available in API Lvl 14 and above. It depends on the [HockeyApp Android SDK](https://github.com/bitstadium/HockeySDK-Android) and the [Gradle HockeyApp Plugin](https://github.com/x2on/gradle-hockeyapp-plugin) to automatically upload your build to HockeyApp.


## Setup
* [Sign up](https://rink.hockeyapp.net/users/sign_up) for HockeyApp
* Create a "New App" from the HockeyApp dashboard
* Find the App ID and Secret on your HockeyApp app page 
* Create an API Token:  **Account Settings > API Tokens > Create**
