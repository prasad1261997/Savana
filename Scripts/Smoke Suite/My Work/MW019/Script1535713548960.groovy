import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

//Login Into Application
CustomKeywords.'actions.Common.login'()

//Click on My Work link from left menu
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

//Expand LinQ process
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/icon_Expand_LinQ Process'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

//Select LinQ Activity C
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/a_LinQ Activity C'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_LinQ Activity C'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

//Select Show Assigned only checkbox
WebUI.check(findTestObject('Page_nGage_Dashboard/My_Work/chexkbox_ShowAssignedOnly'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

//Verify Record is displayed in the grid
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/My_Work/table_Record_One_DocIDColumn'), GlobalVariable.MW018_DocID)

//Select Checkbox against document in table
WebUI.check(findTestObject('Page_nGage_Dashboard/My_Work/table_RecoedOne_Checkbox'))

//Perform Mouser over on Action button
WebUI.mouseOver(findTestObject('Page_nGage_Dashboard/My_Work/span_Actions Button'))

//Select action "UnAssign work items"
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/action_UnAssignWorkItems'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/action_UnAssignWorkItems'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

//Verify Success message
WebUI.verifyElementPresent(findTestObject('Page_nGage_Dashboard/My_Work/processingGrid_SuccessMessage'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/My_Work/processingGrid_SuccessMessage'), 'Work item(s) unassigned successfully')

//Close popup dialog
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/btn_processingGrid_Close'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)