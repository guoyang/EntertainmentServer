/**
 * $Id: ReturnObject.java 834 2012-10-12 08:26:31Z yang.guo $
 * Copyright(C) 2011-2016 dreamingame.com All rights reserved.
 */
package parser;

import java.util.Date;

import com.google.gson.JsonElement;

public class ReturnObject {

	private long time;
	
	private JsonElement object;

	public ReturnObject() {
		this.time = new Date().getTime();
	}
	
	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public JsonElement getObject() {
		return object;
	}

	public void setObject(JsonElement object) {
		this.object = object;
	}
}
