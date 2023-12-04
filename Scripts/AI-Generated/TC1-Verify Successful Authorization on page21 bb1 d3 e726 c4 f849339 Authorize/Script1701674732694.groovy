import com.katalon.truetest.authentication.LoginProcess as LoginProcess
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

'Initialize test session: Open browser and set view port'

@com.kms.katalon.core.annotation.SetUp
def setup() {
	WebUI.openBrowser('')
	WebUI.setViewPortSize(1920, 1080)	
}

'step 1: Navigate to Page 21bb1d3e-726c-4f84-9339-authorize --> navigate to Page t'

WebUI.navigateToUrl(GlobalVariable.application_domain + '/21bb1d3e-726c-4f84-9339-51bc05929874/oauth2/v2.0/authorize')

'step 2: Login at Page t --> navigate to Page 21bb1d3e-726c-4f84-9339-authorize'

LoginProcess.ssoLoginWithMicrosoft()

'step 3: Add visual checkpoint at Page 21bb1d3e-726c-4f84-9339-authorize'

WebUI.takeFullPageScreenshotAsCheckpoint('TC1-Verify Successful Authorization on page21 bb1 d3 e726 c4 f849339 Authorize_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}
