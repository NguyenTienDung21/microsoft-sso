import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

'Initialize test session: Open browser and set view port'

@com.kms.katalon.core.annotation.SetUp
def setup() {
	WebUI.openBrowser('')
	WebUI.setViewPortSize(1920, 1080)	
}

'step 1: Navigate to Page checkout-complete html'

WebUI.navigateToUrl(GlobalVariable.application_domain + '/checkout-complete.html')

'step 2: Add visual checkpoint at Page checkout-complete html'

WebUI.takeFullPageScreenshotAsCheckpoint('TC3-Verify Successful Navigation to page Checkout Complete Html_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}
