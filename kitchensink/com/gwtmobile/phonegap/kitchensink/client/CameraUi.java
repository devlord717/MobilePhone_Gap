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
import com.gwtmobile.phonegap.client.Camera;
import com.gwtmobile.phonegap.client.Camera.Callback;
import com.gwtmobile.phonegap.client.Camera.DestinationType;
import com.gwtmobile.phonegap.client.Camera.EncodingType;
import com.gwtmobile.phonegap.client.Camera.MediaType;
import com.gwtmobile.phonegap.client.Camera.Options;
import com.gwtmobile.phonegap.client.Camera.SourceType;
import com.gwtmobile.ui.client.event.SelectionChangedEvent;
import com.gwtmobile.ui.client.page.Page;

public class CameraUi extends Page {

	@UiField HTML text;
	private static CameraUiUiBinder uiBinder = GWT.create(CameraUiUiBinder.class);
	
	interface CameraUiUiBinder extends UiBinder<Widget, CameraUi> {
	}

	public CameraUi() {
		initWidget(uiBinder.createAndBindUi(this));
	}

    @UiHandler("list")
	void onListSelectionChanged(SelectionChangedEvent e) {
    	switch (e.getSelection()) {
    	case 0:
    		getPicture();
    		break;
    	}
    }

    void getPicture() {
		Camera.getPicture(new Callback() {			
			@Override
			public void onSuccess(String imageData) {
				text.setHTML("Success: " + imageData + "<br/>" + 
						"<img src='" + imageData + "'/>");
			}			
			@Override
			public void onError(String message) {
				text.setHTML("Error: " + message);
			}
		}, Options.newInstance()
			.quality(50)
			.sourceType(SourceType.CAMERA)
			.destinationType(DestinationType.FILE_URI)
			.allowEdit(false)
			.encodingType(EncodingType.PNG)
			.targetWidth(480)
			.targetHeight(720)
			.mediaType(MediaType.PICTURE));
	}

}
