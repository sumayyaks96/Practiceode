package com.synctric.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.synctric.SampleTest.Base;
import com.synctric.pages.InboxPage;

public class InboxTest extends Base {
	InboxPage obj;
	@Test
	public void checkCountOfUnreadMessage() throws IOException {
		obj=new InboxPage(driver);
		obj.unreadMessageCount();
	}

}
