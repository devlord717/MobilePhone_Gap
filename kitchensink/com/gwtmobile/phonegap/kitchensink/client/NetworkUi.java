/* Copyright (c) 2010 Zhihua (Dennis) Jiang
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

package com.gwtmobile.phonegap.kitchensink.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.gwtmobile.phonegap.client.Network;
import com.gwtmobile.phonegap.client.Network.Callback;
import com.gwtmobile.phonegap.client.Network.NetworkStatus;
import com.gwtmobile.phonegap.client.Network.Options;

public class NetworkUi extends Composite {

	private static NetworkUiUiBinder uiBinder = GWT.create(NetworkUiUiBinder.class);
	
	interface NetworkUiUiBinder extends UiBinder<Widget, NetworkUi> {
	}

	public NetworkUi() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("reachable")
    public void handleReachableClick(ClickEvent e) {
		Network.isReachable("google.com", new Callback() {			
			@Override
			public void onNetworkStatus(int reachability) {
				Window.alert("Network Status: " +
						(reachability == NetworkStatus.NOT_REACHABLE ? "NOT_REACHABLE" : 
						 reachability == NetworkStatus.REACHABLE_VIA_CARRIER_DATA_NETWORK ? "REACHABLE_VIA_CARRIER_DATA_NETWORK" : 
						 reachability == NetworkStatus.REACHABLE_VIA_WIFI_NETWORK ? "REACHABLE_VIA_WIFI_NETWORK" : 
						 "Unknown network status " + reachability));
			}
		}, new Options().isIpAddress(false));
	}

}
