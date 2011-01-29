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
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.gwtmobile.phonegap.client.Device;
import com.gwtmobile.ui.client.event.SelectionChangedEvent;
import com.gwtmobile.ui.client.page.Page;

public class DeviceUi extends Page {

	private static DeviceUiUiBinder uiBinder = GWT.create(DeviceUiUiBinder.class);
	
	@UiField HTML text;

	interface DeviceUiUiBinder extends UiBinder<Widget, DeviceUi> {
	}

	public DeviceUi() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
    @UiHandler("list")
	void onListSelectionChanged(SelectionChangedEvent e) {
    	switch (e.getSelection()) {
    	case 0:
    		getDeviceInfo();
    		break;
    	}
    }

	private void getDeviceInfo() {
		text.setHTML("Device Name: " + Device.getName());
		text.setHTML(text.getHTML() + "<br/>Device PhongGap: " + Device.getPhoneGap());
		text.setHTML(text.getHTML() + "<br/>Device Platform: " + Device.getPlatform());
		text.setHTML(text.getHTML() + "<br/>Device UUID: " + Device.getUUID());
		text.setHTML(text.getHTML() + "<br/>Device Version: " + Device.getVersion());
	}
}
