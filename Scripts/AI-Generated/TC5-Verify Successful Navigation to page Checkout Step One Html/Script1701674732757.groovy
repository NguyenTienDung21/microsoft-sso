import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

'Initialize test session: Open browser and set view port'

@com.kms.katalon.core.annotation.SetUp
def setup() {
	WebUI.openBrowser('')
	WebUI.setViewPortSize(1920, 1080)	
}

'step 1: Navigate to Page checkout-step-one html'

WebUI.navigateToUrl(GlobalVariable.application_domain + '/checkout-step-one.html')

'step 2: Add visual checkpoint at Page checkout-step-one html'

WebUI.takeFullPageScreenshotAsCheckpoint('TC5-Verify Successful Navigation to page Checkout Step One Html_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}
