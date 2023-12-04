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


class HandleOtherVerificationMethods extends AuthenticationProcess{
	public HandleOtherVerificationMethods() {
		this(false)
	}

	public HandleOtherVerificationMethods(boolean isRequired) {
		super("Choose to use TOTP to verify sign-in request", isRequired)
	}

	private boolean verifyStaySignedIn() {
		def textStaySignedIn = findTestObject(TestObjectId.STAY_SIGNED_IN_TEXT_ID)
		if (WebUI.verifyElementPresent(textStaySignedIn, 10, FailureHandling.OPTIONAL))
			return true
		return false
	}

	private boolean verifyTOTP() {
		def inputTOTP = findTestObject(TestObjectId.INPUT_TOTP_ID)
		if (WebUI.verifyElementPresent(inputTOTP, 10, FailureHandling.OPTIONAL))
			return true
		return false
	}

	private boolean chooseEnterSecurityCode() {
		def enterSecurityCode = findTestObject(TestObjectId.ENTER_A_SECURITY_CODE)
		if (WebUI.verifyElementPresent(enterSecurityCode, 5, FailureHandling.OPTIONAL))
			ExecutionUtil.tryToClick(enterSecurityCode)
	}

	private boolean chooseEnterTOTP() {
		def enterTOTP = findTestObject(TestObjectId.USE_VERIFICATION_CODE)
		if (WebUI.verifyElementPresent(enterTOTP, 10, FailureHandling.OPTIONAL))
			ExecutionUtil.tryToClick(enterTOTP)
	}

	private boolean chooseEnterTOTPToVerify() {
		def iCantUseAuthenticatorApp = findTestObject(TestObjectId.I_CANT_ACCESS_AUTHENTICATOR_APP)
		if (WebUI.verifyElementPresent(iCantUseAuthenticatorApp, 5, FailureHandling.OPTIONAL))
			ExecutionUtil.tryToClick(iCantUseAuthenticatorApp)
		return chooseEnterTOTP()
		return false
	}

	private boolean handleOtherVerificationMethods() {
		if (this.verifyStaySignedIn())
			return true
		if (this.verifyTOTP())
			return true
		if (this.chooseEnterSecurityCode())
			return true
		return this.chooseEnterTOTPToVerify()
	}

	boolean stepProcess() {
		return this.handleOtherVerificationMethods()
	}
}