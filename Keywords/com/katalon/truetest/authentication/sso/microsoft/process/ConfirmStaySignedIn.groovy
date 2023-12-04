package com.katalon.truetest.authentication.sso.microsoft.process

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import com.kms.katalon.core.util.KeywordUtil
import com.katalon.truetest.authentication.ExecutionUtil as ExecutionUtil
import com.katalon.truetest.authentication.sso.microsoft.TestObjectIds as TestObjectId
import com.katalon.truetest.authentication.AuthenticationProcess


class ConfirmStaySignedIn extends AuthenticationProcess{
	private boolean staySignedIn = false

	public ConfirmStaySignedIn(String staySignedIn) {
		this(staySignedIn, false)
	}

	public ConfirmStaySignedIn(String staySignedIn, boolean isRequired) {
		super("Confirm stay signed in or not", isRequired)
		if (staySignedIn.toLowerCase() == "true")
			this.staySignedIn = true
	}

	private boolean clickStaySignedInOption() {
		def noButton = findTestObject(TestObjectId.SAVE_LOGIN_INFO_BUTTON_NO_ID)
		def yesButton = findTestObject(TestObjectId.SAVE_LOGIN_INFO_BUTTON_YES_ID)
		if (this.staySignedIn)
			return ExecutionUtil.tryToClick(yesButton)
		else
			return ExecutionUtil.tryToClick(noButton)
	}

	boolean stepProcess() {
		return clickStaySignedInOption()
	}
}