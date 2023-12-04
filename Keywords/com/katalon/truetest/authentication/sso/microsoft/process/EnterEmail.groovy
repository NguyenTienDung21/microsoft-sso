package com.katalon.truetest.authentication.sso.microsoft.process

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import com.kms.katalon.core.util.KeywordUtil
import com.katalon.truetest.authentication.ExecutionUtil as ExecutionUtil
import com.katalon.truetest.authentication.sso.microsoft.TestObjectIds as TestObjectId
import com.katalon.truetest.authentication.AuthenticationProcess


class EnterEmail extends AuthenticationProcess{
	private String email;

	public EnterEmail(String email) {
		this(email, true)
	}

	public EnterEmail(String email, boolean isRequired) {
		super("Input email to sign in page and click next", isRequired)
		this.email = email;
	}

	private boolean enterUserEmail() {
		def inputEmailObject = findTestObject(TestObjectId.INPUT_EMAIL_ID)
		return ExecutionUtil.tryToInput(inputEmailObject, this.email)
	}

	private boolean clickSubmitEmailButton() {
		def submitEmailButton = findTestObject(TestObjectId.BUTTON_SUBMIT_EMAIL_ID)
		return ExecutionUtil.tryToClick(submitEmailButton)
	}

	boolean stepProcess() {
		def boolean result = true;
		result = result && this.enterUserEmail()
		result = result && this.clickSubmitEmailButton()
		return result;
	}
}