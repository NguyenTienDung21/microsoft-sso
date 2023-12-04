package com.katalon.truetest.authentication.sso.microsoft.process

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.SimpleDateFormat

import com.katalon.truetest.authentication.AuthenticationProcess
import com.katalon.truetest.authentication.ExecutionUtil
import com.katalon.truetest.authentication.sso.microsoft.TestObjectIds as TestObjectId
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


class EnterTOTP extends AuthenticationProcess{
	private static int LIMIT = 10;
	private String secretKey;

	public EnterTOTP(String secretKey) {
		this(secretKey, false)
	}

	private boolean verifyStaySignedIn() {
		def inputTOTPObject = findTestObject(TestObjectId.INPUT_TOTP_ID)
		def textStaySignedIn = findTestObject(TestObjectId.STAY_SIGNED_IN_TEXT_ID)
		def int count = 0
		while (count < LIMIT) {
			if (WebUI.verifyElementPresent(textStaySignedIn, 2, FailureHandling.OPTIONAL))
				return true
			if (WebUI.verifyElementPresent(inputTOTPObject, 2, FailureHandling.OPTIONAL))
				return false
			count++
		}
		return WebUI.verifyElementPresent(textStaySignedIn, 1, FailureHandling.OPTIONAL)
	}

	public EnterTOTP(String secretKey, boolean isRequired) {
		super("Enter TOTP then click verify", isRequired)
		this.secretKey = secretKey
	}

	private boolean inputTOTP() {
		def inputTOTPObject = findTestObject(TestObjectId.INPUT_TOTP_ID)
		return ExecutionUtil.tryToInput(inputTOTPObject, ExecutionUtil.getTwoFactorCode(this.secretKey))
	}

	private boolean clickVerifyButton() {
		def verifyTOTPButton = findTestObject(TestObjectId.VERIFY_TOTP_BUTTON_ID)
		return ExecutionUtil.tryToClick(verifyTOTPButton)
	}

	boolean stepProcess() {
		if (this.verifyStaySignedIn())
			return true
		def boolean result = true;
		result = result && this.inputTOTP()
		result = result && this.clickVerifyButton()
		return result;
	}
}