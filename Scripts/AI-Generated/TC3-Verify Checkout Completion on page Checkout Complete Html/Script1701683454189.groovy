import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'Initialize test session: Open browser and set view port'

@com.kms.katalon.core.annotation.SetUp
def setup() {
	WebUI.openBrowser('')
	WebUI.setViewPortSize(1920, 1080)	
}

'step 1: Navigate to Page checkout-complete html'

WebUI.navigateToUrl(GlobalVariable.application_domain + '/checkout-complete.html')

'step 2: Add visual checkpoint at Page checkout-complete html'

WebUI.takeFullPageScreenshotAsCheckpoint('TC3-Verify Checkout Completion on page Checkout Complete Html_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}
