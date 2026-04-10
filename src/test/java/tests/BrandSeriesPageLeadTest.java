package tests;

import org.testng.annotations.Test;

import base.BaseUtility;
import components.BrandPageComponent;
import components.LeadFormComponent;
import constants.BrandCTAType;

public class BrandSeriesPageLeadTest extends BaseUtility {

    private static final String BRAND_SERIES_URL =
            "/mahindra-tractors/sp-plus";


    private void verifyBrandLead(
            String url,
            BrandCTAType type) {

        openPage(url);

        BrandPageComponent brandPage =
                new BrandPageComponent(driver);

        LeadFormComponent leadForm =
                new LeadFormComponent(driver);


        brandPage.clickFirstCardCTA(type);


        switch(type) {

            case TALK_TO_DEALER:

                fillDealerLeadForm(leadForm);
                break;

            default:

                fillLeadForm(leadForm);

        }

    }


    private void fillLeadForm(
            LeadFormComponent leadForm) {

        leadForm.enterName("Test QA");

        leadForm.enterMobile(
                utils.TestDataGenerator.generateMobile()
        );

        leadForm.selectStateRandom();
        leadForm.selectDistrictRandom();
        leadForm.selectTehsilRandom();

        leadForm.submitLead(true);

    }


    private void fillDealerLeadForm(
            LeadFormComponent leadForm) {

        leadForm.enterName("Test QA");

        leadForm.enterMobile(
                utils.TestDataGenerator.generateMobile()
        );

        leadForm.selectStateRandom();
        leadForm.selectDistrictRandom();
        leadForm.selectTehsilRandom();
        leadForm.selectModelRandomMandatory();
        leadForm.submitLead(false);

    }


    @Test
    public void verifyBrandSeriesPageCTPLead() {

        verifyBrandLead(
                BRAND_SERIES_URL,
                BrandCTAType.CHECK_TRACTOR_PRICE
        );
       

    }


    @Test
    public void verifyBrandSeriesPageEMILead() {

        verifyBrandLead(
                BRAND_SERIES_URL,
                BrandCTAType.CHECK_EMI
        );

    }


    @Test
    public void verifyBrandSeriesPageDealerLead() {

        verifyBrandLead(
                BRAND_SERIES_URL,
                BrandCTAType.TALK_TO_DEALER
        );
        

    }
    
//    @Test
    public void verifyBrandPageSellerDetailsLead() {

    	verifyBrandLead(
    			BRAND_SERIES_URL,
    			BrandCTAType.GET_SELLER_DETAILS
    			);

    }

}