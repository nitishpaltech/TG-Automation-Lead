package tests;

import org.testng.annotations.Test;

import base.BaseUtility;
import components.CompareSectionComponent;
import components.TractorSectionComponent;
import components.LeadFormComponent;
import constants.HomeTabType;
import utils.TestDataGenerator;

public class AllBrandsPageLeadTest extends BaseUtility {

	private void fillLeadForm(
			LeadFormComponent leadForm) {

		leadForm.enterName("Test QA");

		leadForm.enterMobile(
				TestDataGenerator.generateMobile()
				);

		leadForm.selectStateRandom();

		leadForm.selectDistrictRandom();

		leadForm.selectTehsilRandom();

		leadForm.submitLead(true);
	}


	/*
	 * Compare Section Lead
	 */

	    @Test
	public void verifyCompareSectionLead() {

		openPage("/tractor-brands");

		CompareSectionComponent compare =
				new CompareSectionComponent(driver);

		LeadFormComponent leadForm =
				new LeadFormComponent(driver);

		compare.clickFirstModelCheckPrice();

		fillLeadForm(leadForm);

	}


	/*
	 * Tractor Section Tabs Lead
	 */


	@Test
	public void verifyTractorTabsLead() {

		openPage("/tractor-brands");

		TractorSectionComponent section =
				new TractorSectionComponent(driver);

		LeadFormComponent leadForm =
				new LeadFormComponent(driver);


		// Popular tab

		section.selectTabFromSection("nav-popular-tab");

		section.clickFirstCardFromActiveTab();

		fillLeadForm(leadForm);


		// Latest tab

		section.selectTabFromSection("nav-latest-tab");

		section.clickFirstCardFromActiveTab();

		fillLeadForm(leadForm);


		// Upcoming tab

		section.selectTabFromSection("nav-upcoming-tab");

		section.clickFirstCardFromActiveTab();

		fillLeadForm(leadForm);

	}

}