package com.api.stepDefs;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.api.service.Base_MoneyMovement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Assignment3_stepdefs {

	Base_MoneyMovement MM = new Base_MoneyMovement();
	
	
	@Given("Initiate the setup required")
	public void initiate_the_setup_required() {
	    // Write code here that turns the phrase above into concrete actions
	   MM.baseURI_setup();
	}
	
	
	@When("Initiate the Client_Credentials_API {string} {string} and {string} get the accessToken")
	public void initiate_the_Client_Credentials_API_and_get_the_accessToken(String grantType,String scope,String Cmethod) {
		try {
			MM.API_clientCredentials(grantType,scope,Cmethod);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@And("Initiate the EtoEkey_API {string}  and get the Biz_token")
	public void API_e2ekey(String Emethod) {
		MM.API_e2ekey(Emethod);
	}

	@And("Initiate the Resource_Owner {string} {string} and {string} get the encrypted password")
	public void API_ResourceOwner(String username, String password, String ROmethod) throws FileNotFoundException, IOException {
		MM.API_ResourceOwner(username,password,ROmethod);
	}
	
	@And("Initiate the Accounts_API {string} to get all the accounts")
	public void initiate_the_Accounts_API_to_get_all_the_accounts(String ACmethod) {
		MM.API_Accounts(ACmethod);
	}

	@And("Initiate the Cards_API {string} to get all the cards")
	public void initiate_the_Cards_API_to_get_all_the_cards(String card_method) {
		MM.API_Cards(card_method);
	}
	
	@And("Initiate the Transaction_Account_API {string} and get the accountid and transaction status")
	public void initiate_the_Transaction_Account_API_to_get_transactionStatus(String TAmethod) {
		MM.API_Transactions(TAmethod);
	}
	
	@And("Initiate the PDT_Eligibility_API {string} and verify the expected result")
	public void initiate_the_PDT_API_and_verify_the_expected_result(String PA_method) {
		MM.PDT_Confirmation_API(PA_method);
	}
	
	@And("Initiate the PDT-PreProcess API {string} with valid fields and verify the Expected Result")
	public void initiate_the_PDT_PreProcess_API_and_verify_the_expected_result(String Pre_method) {
		MM.PDT_Preprocess_API(Pre_method);
	}
	
	@Then("Initiate the PDT-Confirmation API {string} with valid fields and verify the Expected Result")
	public void initiate_the_PDT_Confirmation_API_and_verify_the_expected_result(String PDT_method) {
		MM.PDT_API(PDT_method);
	}
		
	}

	
	


