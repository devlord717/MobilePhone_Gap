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

import com.google.gwt.core.client.JavaScriptObject;



public class Network {

	public static void isReachable(String reachableHostname, Callback callback) {
		isReachable(reachableHostname, callback, (JavaScriptObject)null);
	}

	public static void isReachable(String reachableHostname, Callback callback, Options options) {
		isReachable(reachableHostname, callback, options.getOptions());
	}

	private native static void isReachable(String reachableHostname, Callback callback, JavaScriptObject options) /*-{
		$wnd.navigator.network.isReachable(reachableHostname, 
		function(reachability) {
	    	callback.@com.touchonmobile.gwtmobile.phonegap.client.Network.Callback::onNetworkStatus(I)(reachability);
	    }, options);
	}-*/;
	
	public interface Callback {
		public void onNetworkStatus(int reachability);
	}
	
	public static class NetworkStatus {
		public static final int NOT_REACHABLE = 0;
		public static final int REACHABLE_VIA_CARRIER_DATA_NETWORK = 1;
		public static final int REACHABLE_VIA_WIFI_NETWORK = 2;
	}
	
    public static class Options {
    	Options self = this;
    	JavaScriptObject options = JavaScriptObject.createObject();
    	
    	public native Options isIpAddress(boolean b) /*-{
			this.@com.touchonmobile.gwtmobile.phonegap.client.Network.Options::options.isIpAddress = b;
			return this.@com.touchonmobile.gwtmobile.phonegap.client.Network.Options::self;
		}-*/;

		private JavaScriptObject getOptions() {
			return options;    		
    	}
    }
}
