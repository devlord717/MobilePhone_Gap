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

package com.touchonmobile.gwtmobile.phonegap.kitchensink.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.touchonmobile.gwtmobile.phonegap.client.Camera;
import com.touchonmobile.gwtmobile.phonegap.client.Camera.Callback;
import com.touchonmobile.gwtmobile.phonegap.client.Camera.DestinationType;
import com.touchonmobile.gwtmobile.phonegap.client.Camera.Options;
import com.touchonmobile.gwtmobile.phonegap.client.Camera.SourceType;

public class CameraUi extends Composite {

	private static CameraUiUiBinder uiBinder = GWT.create(CameraUiUiBinder.class);
	
	interface CameraUiUiBinder extends UiBinder<Widget, CameraUi> {
	}

	public CameraUi() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("get")
    public void handleGetPictureClick(ClickEvent e) {
		Camera.getPicture(new Callback() {			
			@Override
			public void onSuccess(String imageData) {
				Window.alert("Success: " + imageData);
			}			
			@Override
			public void onError(String message) {
				Window.alert("Error: " + message);
			}
		}, new Options()
			.quality(50)
			.sourceType(SourceType.CAMERA)
			.destinationType(DestinationType.FILE_URI)
			.allowEdit(false));
	}

}
