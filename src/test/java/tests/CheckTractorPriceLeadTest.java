package tests;

import org.testng.annotations.Test;

import base.BaseUtility;

import components.HomeCompareTractorsComponent;
import components.HomeEnquireNowBannerComponent;
import components.HomeGetOfferBannerComponent;
import components.HomeHPSectionComponent;
import components.HomeMiniTractorSectionComponent;
import components.HomePriceSectionComponent;
import components.HomeTractorSectionComponent;
import components.LeadFormComponent;
import constants.HPTabType;
import constants.HomeTabType;
import constants.PopupStrategy;
import constants.PriceTabType;
import utils.TestDataGenerator;
public class CheckTractorPriceLeadTest extends BaseUtility {

	private void verifyHomeTabLead(HomeTabType tabType) {

	    HomeTractorSectionComponent section =
	            new HomeTractorSectionComponent(driver);

	    LeadFormComponent leadForm =
	            new LeadFormComponent(driver);


	    section.selectTab(tabType);

	    section.clickFirstCardCTP(tabType);

	    fillLeadForm(leadForm);

	}
	
	private void verifyPriceTabLead(PriceTabType tabType) {

	    HomePriceSectionComponent priceSection =
	            new HomePriceSectionComponent(driver);

	    LeadFormComponent leadForm =
	            new LeadFormComponent(driver);


	    priceSection.selectTab(tabType);

	    priceSection.clickFirstCardCTP(tabType);

	    fillLeadForm(leadForm);

	}
	
	private void verifyHPTabLead(HPTabType tabType) {

	    HomeHPSectionComponent hpSection =
	            new HomeHPSectionComponent(driver);

	    LeadFormComponent leadForm =
	            new LeadFormComponent(driver);


	    hpSection.selectTab(tabType);

	    hpSection.clickFirstCardCTP(tabType);

	    fillLeadForm(leadForm);

	}
	
	private void verifyEnquireNowLead() {

	    HomeEnquireNowBannerComponent banner =
	            new HomeEnquireNowBannerComponent(driver);

	    LeadFormComponent leadForm =
	            new LeadFormComponent(driver);


	    banner.clickEnquireNowCTA();

	    leadForm.enterName("Test QA");

	    leadForm.enterMobile(
	            TestDataGenerator.generateMobile()
	    );

	    leadForm.selectStateRandom();

	    leadForm.selectDistrictRandom();

	    leadForm.selectTehsilRandom();

	    leadForm.selectBrandRandom();

	    leadForm.selectModelRandomMandatory();

	    leadForm.submitLead();
	}
    
	 @Test
	public void verifyHomeSectionTabsLead() {

    verifyHomeTabLead(HomeTabType.POPULAR);

    driver.navigate().refresh();

    verifyHomeTabLead(HomeTabType.LATEST);

    driver.navigate().refresh();

    verifyHomeTabLead(HomeTabType.UPCOMING);
    }
    
    @Test

    public void verifyPriceSectionTabsLead() {

    verifyPriceTabLead(PriceTabType.UNDER_3_LAKH);

    verifyPriceTabLead(PriceTabType.THREE_TO_FIVE);

    verifyPriceTabLead(PriceTabType.FIVE_TO_SEVEN);

    verifyPriceTabLead(PriceTabType.SEVEN_TO_TEN);

    verifyPriceTabLead(PriceTabType.ABOVE_TEN);
    }
    
   @Test
   public void verifyEnquireNowBannerLead() {

    verifyEnquireNowLead();
    }
    
    @Test
    public void verifyCompareTractorSectionLead() {

        HomeCompareTractorsComponent compare =
            new HomeCompareTractorsComponent(driver);

        LeadFormComponent leadForm =
            new LeadFormComponent(driver);


        compare.clickFirstModelCheckPrice();

        fillLeadForm(leadForm);


        compare.clickSecondModelCheckPrice();

        fillLeadForm(leadForm);

    }



   @Test
   public void verifyHPSectionTabsLead() {

    verifyHPTabLead(HPTabType.UNDER_30_HP);

    verifyHPTabLead(HPTabType.HP_30_TO_50);

    verifyHPTabLead(HPTabType.HP_50_TO_70);

    verifyHPTabLead(HPTabType.HP_70_TO_100);

    verifyHPTabLead(HPTabType.ABOVE_100_HP);
    }

    private void fillLeadForm(LeadFormComponent leadForm) {

        leadForm.enterName("Test QA");

        leadForm.enterMobile(
                TestDataGenerator.generateMobile()
        );

        leadForm.selectStateRandom();
        leadForm.selectDistrictRandom();
        leadForm.selectTehsilRandom();
        leadForm.submitLead();
        
        leadForm.handleThankYouPopup(
//                PopupStrategy.CLOSE_POPUP);
//              OR
              PopupStrategy.SUBMIT_RECOMMENDED_LEAD);
//              OR
//              PopupStrategy.IGNORE_POPUP);
        

    } 
    
    @Test
    public void verifyMiniTractorSectionLead() {

        HomeMiniTractorSectionComponent miniSection =
            new HomeMiniTractorSectionComponent(driver);

        LeadFormComponent leadForm =
            new LeadFormComponent(driver);


        miniSection.clickFirstCardCTP();

        fillLeadForm(leadForm);

    }
    
    @Test
    public void verifyGetOfferBannerLead() {

        HomeGetOfferBannerComponent banner =
            new HomeGetOfferBannerComponent(driver);

        LeadFormComponent leadForm =
            new LeadFormComponent(driver);


        banner.clickGetOfferCTA();


        leadForm.enterName("Test QA");

        leadForm.enterMobile(
            TestDataGenerator.generateMobile()
        );

        leadForm.selectStateRandom();
        leadForm.selectDistrictRandom();
        leadForm.selectTehsilRandom();

        leadForm.selectBrandRandom();
        leadForm.selectModelRandomMandatory();


        leadForm.submitLead();

    }
}