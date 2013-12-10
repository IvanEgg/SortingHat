package com.wagnerandpei.incubate;

import com.googlecode.objectify.*;

public class OfyService {

	static {
		factory().register(ClassTimes.class);
	}
	
	public static Objectify ofy() {
		return ObjectifyService.ofy();
	}
	
	public static ObjectifyFactory factory() {
		return ObjectifyService.factory();
	}
	
}
