/*
 * Copyright (c) 2010 Zhihua (Dennis) Jiang
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.touchonmobile.gwtmobile.phonegap.client;


public class Notification {

    public static native void alert(String message, Callback callback, String title, String buttonLabel) /*-{
	    $wnd.navigator.notification.alert(message, function() {
	    	callback.@com.touchonmobile.gwtmobile.phonegap.client.Notification.Callback::onComplete()();
	    },
	    title, buttonLabel);
	}-*/;

    public static native void confirm(String message, ConfirmCallback callback, String title, String buttonLabels) /*-{
	    $wnd.navigator.notification.confirm(message, function(result) {
	    	callback.@com.touchonmobile.gwtmobile.phonegap.client.Notification.ConfirmCallback::onComplete(I)(result);
	    },
	    title, buttonLabels);
	}-*/;
	
    public static native void activityStart() /*-{
	    $wnd.navigator.notification.activityStart();
	}-*/;

    public static native void activityStop() /*-{
	    $wnd.navigator.notification.activityStop();
	}-*/;

    public static native void progressStart(String title, String message) /*-{
	    $wnd.navigator.notification.progressStart(title, message);
	}-*/;

    public static native void progressValue(int value) /*-{
	    $wnd.navigator.notification.progressValue(value);
	}-*/;

    public static native void progressStop() /*-{
	    $wnd.navigator.notification.progressStop();
	}-*/;
    
    public static native void blink(int count, String color) /*-{
	    $wnd.navigator.notification.blink(count, color);
	}-*/;

    public static native void vibrate(int mills) /*-{
	    $wnd.navigator.notification.vibrate(mills);
	}-*/;

    public static native void beep(int count) /*-{
	    $wnd.navigator.notification.beep(count);
	}-*/;

    public interface Callback {
    	void onComplete();
    }
    
    public interface ConfirmCallback {
    	void onComplete(int selection);
    }
}
