package com.reactnativetaxdownintercom

import android.nfc.Tag
import android.util.Log
import com.facebook.react.bridge.*
import io.intercom.android.sdk.Intercom
import io.intercom.android.sdk.identity.Registration
import java.lang.Error
import java.lang.Exception

class TaxdownIntercomModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    companion object {
      const val TAG = "Intercom";
      const val MODULE_NAME = "TaxdownIntercom";
    }

    override fun getName(): String {
        return MODULE_NAME;
    }

    override fun canOverrideExistingModule(): Boolean {
      return true;
    }

    @ReactMethod
    fun identifier(options: ReadableMap, promise: Promise) {
      try {
        val userId = options.getString("userId");
        val registration: Registration = Registration.create().withUserId(userId!!);
        Intercom.client().registerIdentifiedUser(registration);
        promise.resolve(null);
      } catch (e: Exception) {
        Log.e(TAG, "Failed initialize");
        promise.resolve(null);
      }
    }

    @ReactMethod
    fun displayMessenger(promise: Promise) {
      try {
        Intercom.client().displayMessenger();
        promise.resolve(null);
      } catch (e: Exception) {
        Log.e(TAG, "Failed initialize messenger");
      }
    }

    @ReactMethod
    fun displayHelpCenterArticle(articleId: String, promise: Promise) {
      try {
        Intercom.client().displayArticle(articleId);
        promise.resolve(null);
      } catch (e: Exception) {
        promise.reject(e.message);
        Log.e(TAG, "Failed display article");
      }
    }

}
