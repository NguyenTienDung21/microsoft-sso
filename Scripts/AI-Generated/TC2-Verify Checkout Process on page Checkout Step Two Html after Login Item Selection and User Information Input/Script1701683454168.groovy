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

'step 3: At Page inventory html#code=0 ASsAPh27IWxyhE-TOVG8BZK click on button add to cart sauce labs backpack'

testObj = findTestObject('AI-Generated/Page_inventory_html/button_add_to_cart_sauce_labs_backpack')

WebUI.delay(3)

WebUI.takeScreenshot()

WebUI.verifyElementPresent(testObj, 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getUrl(), '.*/inventory.html/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(testObj)

'step 4: At Page inventory html#code=0 ASsAPh27IWxyhE-TOVG8BZK click on hyperlink item 4 title link --> navigate to Page inventory-item html'

testObj = findTestObject('AI-Generated/Page_inventory_html/hyperlink_item_4_title_link')

WebUI.delay(3)

WebUI.takeScreenshot()

WebUI.verifyElementPresent(testObj, 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getUrl(), '.*/inventory.html/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(testObj)

'step 5: At Page inventory-item html click on hyperlink object --> navigate to Page cart html'

testObj = findTestObject('AI-Generated/Page_inventory-item_html/hyperlink_object')

WebUI.delay(3)

WebUI.takeScreenshot()

WebUI.verifyElementPresent(testObj, 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getUrl(), '.*/inventory-item.html/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(testObj)

'step 6: At Page cart html click on hyperlink object'

testObj = findTestObject('AI-Generated/Page_cart_html/hyperlink_object')

WebUI.delay(3)

WebUI.takeScreenshot()

WebUI.verifyElementPresent(testObj, 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getUrl(), '.*/cart.html/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(testObj)

'step 7: At Page cart html click on button checkout --> navigate to Page checkout-step-one html'

testObj = findTestObject('AI-Generated/Page_cart_html/button_checkout')

WebUI.delay(3)

WebUI.takeScreenshot()

WebUI.verifyElementPresent(testObj, 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getUrl(), '.*/cart.html/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(testObj)

'step 8: At Page checkout-step-one html input on input firstname'

testObj = findTestObject('AI-Generated/Page_checkout-step-one_html/input_firstname')

WebUI.delay(3)

WebUI.takeScreenshot()

WebUI.verifyElementPresent(testObj, 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getUrl(), '.*/checkout-step-one.html/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.setText(testObj, var_1_input_firstname)

'step 9: At Page checkout-step-one html input on input lastname'

testObj = findTestObject('AI-Generated/Page_checkout-step-one_html/input_lastname')

WebUI.delay(3)

WebUI.takeScreenshot()

WebUI.verifyElementPresent(testObj, 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getUrl(), '.*/checkout-step-one.html/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.setText(testObj, var_2_input_lastname)

'step 10: At Page checkout-step-one html input on input postalcode'

testObj = findTestObject('AI-Generated/Page_checkout-step-one_html/input_postalcode')

WebUI.delay(3)

WebUI.takeScreenshot()

WebUI.verifyElementPresent(testObj, 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getUrl(), '.*/checkout-step-one.html/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.setText(testObj, var_3_input_postalcode)

'step 11: At Page checkout-step-one html click on input continue --> navigate to Page checkout-step-two html'

testObj = findTestObject('AI-Generated/Page_checkout-step-one_html/input_continue')

WebUI.delay(3)

WebUI.takeScreenshot()

WebUI.verifyElementPresent(testObj, 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getUrl(), '.*/checkout-step-one.html/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(testObj)

'step 12: Add visual checkpoint at Page checkout-step-two html'

WebUI.takeFullPageScreenshotAsCheckpoint('TC2-Verify Checkout Process on page Checkout Step Two Html after Login Item Selection and User Information Input_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}
