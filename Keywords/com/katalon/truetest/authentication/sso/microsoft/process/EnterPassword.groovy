package com.katalon.truetest.authentication.sso.microsoft.process

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import com.kms.katalon.core.util.KeywordUtil
import com.katalon.truetest.authentication.ExecutionUtil as ExecutionUtil
import com.katalon.truetest.authentication.sso.microsoft.TestObjectIds as TestObjectId
import com.katalon.truetest.authentication.AuthenticationProcess


class EnterPassword extends AuthenticationProcess{
	private String password;

	public EnterPassword(String password) {
		this(password, true)
	}

	public EnterPassword(String password, boolean isRequired) {
		super("Input password to sign in page and click sign-in", isRequired)
		this.password = password
	}

	private boolean enterUserPassword() {
		def inputPasswordObject = findTestObject(TestObjectId.INPUT_PASSWORD_ID)
		ExecutionUtil.tryToInput(inputPasswordObject, this.password)
	}

	private boolean clickSubmitPasswordButton() {
		def submitEmailButton = findTestObject(TestObjectId.BUTTON_SUBMIT_PASSWORD_ID)
		ExecutionUtil.tryToClick(submitEmailButton)
	}

	boolean stepProcess() {
		def boolean result = true;
		result = result && this.enterUserPassword()
		result = result && this.clickSubmitPasswordButton()
		return result;
	}
}