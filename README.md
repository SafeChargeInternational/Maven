Nuvei Cashier Card Scanner SDK for Android
==========================================

SETUP
------------
Add the next lines in your main project build.gradle file:
```gradle
buildscript {
    repositories {
        google()
        jcenter()
    }
}
allprojects {
    repositories {
        google()
        jcenter()
    }
}
```

Add the next line in your app build.gradle file:
```gradle
implementation "com.nuvei:CashierCardScanner:1.0.0"
```

PERMISSIONS
------------
Add the next lines in your main project build.gradle file:
```xml
<!-- Permission to vibrate — recommended, allows vibration feedback on scan ->
<uses-permission android:name=”android.permission.VIBRATE” />

<!-- Permission to use camera — required ->
<uses-permission android:name=”android.permission.CAMERA” />

<!-- Camera features — recommended ->
<uses-feature android:name=”android.hardware.camera” android:required=”false” />
<uses-feature android:name=”android.hardware.camera.autofocus” android:required=”false” />
<uses-feature android:name=”android.hardware.camera.flash” android:required=”false” />
```

USAGE
------------
The SDK works with WebView, so add the next line before you load Nuvei cashier page in the web view:
```kotlin
NuveiCashierCardScanner.connect(webview, this) // “this” is the current activity
```

Implement the `onActivityResult` method in the activity that contains the web view as follows:
```kotlin
override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if (requestCode == NuveiCashierCardScanner.SCAN_CARD_REQUEST_CODE) {
        NuveiCashierCardScanner.didScan(data)
    }
}
```

HINTS & TIPS
------------
* See [card.io Javadocs](https://card-io.github.io/card.io-Android-SDK/) for a complete reference.
* Note: the correct proguard file is automatically imported into your gradle project from the aar package. Anyone not using gradle will need to extract the proguard file and add it to their proguard config.
* card.io errors and warnings will be logged to the "card.io" tag.
* If upgrading the card.io SDK, first remove all card.io libraries so that you don't accidentally ship obsolete or unnecessary libraries. The bundled libraries may change.
* Processing images can be memory intensive.
* [Memory Analysis for Android Applications](https://android-developers.blogspot.com/2011/03/memory-analysis-for-android.html) provides some useful information about how to track and reduce your app's memory useage.
* card.io recommends the use of [SSL pinning](https://blog.thoughtcrime.org/authenticity-is-broken-in-ssl-but-your-app-ha) when transmitting sensitive information to protect against man-in-the-middle attacks.

LICENSE
------------
See: [LICENSE](https://raw.githubusercontent.com/SafeChargeInternational/Nuvei-Cashier-Card-Scanner-SDK-for-Android/master/LICENSE.md)
