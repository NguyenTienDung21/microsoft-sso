package com.katalon.truetest.authentication

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil

import org.apache.commons.codec.binary.Base32
import org.apache.commons.codec.binary.Hex
import de.taimos.totp.TOTP as TOTP

class ExecutionUtil {
	private ExecutionUtil() {}

	static String getTwoFactorCode(String secret) {
		def base32 = new Base32()
		def bytes = base32.decode(secret.toUpperCase())
		def hexKey = Hex.encodeHexString(bytes)
		return TOTP.getOTP(hexKey)
	}

	private static boolean tryToInput(TestObject object, String value) {
		try {
			KeywordUtil.logInfo("Try to find and set text on: " + object.getObjectId())
			WebUI.setText(object, value)
			return true
		}
		catch (StepFailedException ex) {
			KeywordUtil.logInfo("Can not perform set text action, execution failed")
			return false
		}
	}

	private static boolean tryToClick(TestObject object) {
		try {
			KeywordUtil.logInfo("Try to find and click on: " + object.getObjectId())
			WebUI.enhancedClick(object)
			return true
		}
		catch (StepFailedException ex) {
			KeywordUtil.logInfo("Can not perform click action, execution failed")
			return false
		}
	}
}