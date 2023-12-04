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


class HandleOtherAuthMethods extends AuthenticationProcess{
	public HandleOtherAuthMethods() {
		this(false)
	}

	public HandleOtherAuthMethods(boolean isRequired) {
		super("Choose to use other ways and select password to sign in", isRequired)
	}

	private boolean ChoosePasswordAuthentication() {
		def useMyPassword = findTestObject(TestObjectId.USE_MY_PASSWORD_ID)
		if (WebUI.verifyElementPresent(useMyPassword, 10, FailureHandling.OPTIONAL))
			return ExecutionUtil.tryToClick(useMyPassword)
		return false
	}

	private boolean ChooseOtherWaysToSignIn() {
		def inputPasswordObject = findTestObject(TestObjectId.INPUT_PASSWORD_ID)
		if (WebUI.verifyElementPresent(inputPasswordObject, 10, FailureHandling.OPTIONAL))
			return true
		def otherWaysToSignIn = findTestObject(TestObjectId.OTHER_WAYS_TO_SIGN_IN_ID)
		if (WebUI.verifyElementPresent(otherWaysToSignIn, 5, FailureHandling.OPTIONAL))
			if (ExecutionUtil.tryToClick(otherWaysToSignIn))
				return this.ChoosePasswordAuthentication()
		return false
	}

	boolean stepProcess() {
		return this.ChooseOtherWaysToSignIn()
	}
}