package com.katalon.truetest.authentication

import com.katalon.truetest.authentication.sso.microsoft.MicrosoftLoginProcess

class LoginProcess {

	private LoginProcess() {}

	public static void ssoLoginWithMicrosoft() {
		def microsoftLoginProcess = new MicrosoftLoginProcess()
		microsoftLoginProcess.execute()
	}
}