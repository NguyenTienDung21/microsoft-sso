package com.katalon.truetest.authentication.sso.microsoft.process

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import com.kms.katalon.core.util.KeywordUtil
import com.katalon.truetest.authentication.ExecutionUtil as ExecutionUtil
import com.katalon.truetest.authentication.sso.microsoft.TestObjectIds as TestObjectId
import com.katalon.truetest.authentication.AuthenticationProcess
import com.kms.katalon.core.model.FailureHandling as FailureHandling

class FocusToLoginWindow extends AuthenticationProcess{
	private int windowIndex = 0
	private static int LIMIT = 5

	public FocusToLoginWindow(String name, int windowIndex) {
		this(name, windowIndex, false)
	}

	public FocusToLoginWindow(String name, int windowIndex, boolean isRequired) {
		super(name, isRequired)
		this.windowIndex = windowIndex
	}

	private int getNumberOfOpenedWindow() {
		return DriverFactory.localWebServerStorage.get().getWindowHandles().size()
	}

	private boolean verifyPopUpWindow() {
		def int count = 0
		def inputEmailObject = findTestObject(TestObjectId.INPUT_EMAIL_ID)
		while (count < LIMIT) {
			if (getNumberOfOpenedWindow() == 2) return true
			if (WebUI.verifyElementPresent(inputEmailObject, 2, FailureHandling.OPTIONAL)) return false
			count++
		}
		return getNumberOfOpenedWindow() == 2
	}

	private boolean switchToLoginWindow() {
		try {
			if (verifyPopUpWindow()) {
				KeywordUtil.logInfo("Try to focus on window index ${this.windowIndex}")
				WebUI.switchToWindowIndex(this.windowIndex)
				return true
			}
			return false
		}
		catch (StepFailedException ex) {
			KeywordUtil.logInfo("Can not switch window, continue on the current!")
			return false
		}
	}

	boolean stepProcess() {
		return this.switchToLoginWindow()
	}
}