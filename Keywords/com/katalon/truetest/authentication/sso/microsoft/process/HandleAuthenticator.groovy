package com.katalon.truetest.authentication.sso.microsoft.process

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import com.kms.katalon.core.util.KeywordUtil
import com.katalon.truetest.authentication.ExecutionUtil as ExecutionUtil
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.katalon.truetest.authentication.sso.microsoft.TestObjectIds as TestObjectId
import com.katalon.truetest.authentication.AuthenticationProcess


class HandleAuthenticator extends AuthenticationProcess{
	public HandleAuthenticator() {
		this(false)
	}

	public HandleAuthenticator(boolean isRequired) {
		super("Choose to use password instead of MS authenticator", isRequired)
	}

	private boolean handleMSAuthenticatorLogin() {
		def inputPasswordObject = findTestObject(TestObjectId.INPUT_PASSWORD_ID)
		if (WebUI.verifyElementPresent(inputPasswordObject, 10, FailureHandling.OPTIONAL))
			return true
		def useYourPasswordInstead = findTestObject(TestObjectId.USE_YOUR_PASSWORD_INSTEAD_ID)
		if (WebUI.verifyElementPresent(useYourPasswordInstead, 5, FailureHandling.OPTIONAL))
			return ExecutionUtil.tryToClick(useYourPasswordInstead)
		return false
	}

	boolean stepProcess() {
		return this.handleMSAuthenticatorLogin()
	}
}