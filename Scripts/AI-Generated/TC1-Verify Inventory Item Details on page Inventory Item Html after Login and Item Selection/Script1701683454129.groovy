import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import internal.GlobalVariable as GlobalVariable
import com.katalon.truetest.authentication.LoginProcess as LoginProcess

'Initialize test session: Open browser and set view port'

@com.kms.katalon.core.annotation.SetUp
def setup() {
	WebUI.openBrowser('')
	WebUI.setViewPortSize(1920, 1080)	
}

'step 1: Navigate to Page 21bb1d3e-726c-4f84-9339-authorize --> navigate to Page t'

WebUI.navigateToUrl(GlobalVariable.application_domain + '/21bb1d3e-726c-4f84-9339-51bc05929874/oauth2/v2.0/authorize')

'step 2: Login at Page t --> navigate to Page inventory html#code=0 ASsAPh27IWxyhE-TOVG8BZK'

LoginProcess.ssoLoginWithMicrosoft()

'step 3: At Page inventory html#code=0 ASsAPh27IWxyhE-TOVG8BZK click on hyperlink item 4 title link --> navigate to Page inventory-item html'

testObj = findTestObject('AI-Generated/Page_inventory_html/hyperlink_item_4_title_link')

WebUI.delay(3)

WebUI.takeScreenshot()

WebUI.verifyElementPresent(testObj, 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getUrl(), '.*/inventory.html/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(testObj)

'step 4: Add visual checkpoint at Page inventory-item html'

WebUI.takeFullPageScreenshotAsCheckpoint('TC1-Verify Inventory Item Details on page Inventory Item Html after Login and Item Selection_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}
