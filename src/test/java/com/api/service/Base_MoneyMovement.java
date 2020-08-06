package com.api.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.entity.ContentType;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.accounts.*;
import com.jayway.jsonpath.DocumentContext;
import com.source.destination.accounts.DestinationSourceAcctCombination;
import com.source.destination.accounts.Sourceanddesinationaccount;

import PropertyFile.PropertyFile;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;



public class Base_MoneyMovement {
	String authorization_64;
	String client_id;
	String client_secret;
	String access_token;
	String BizToken;
	String Authorization_new;
	String access_token_new;
	 String controlFlowID;
	String excelFilePath="src\\main\\java\\data1\\assign3Data.xlsx";
	
@BeforeTest
public void baseURI_setup() {
	RestAssured.baseURI=PropertyFile.getValue("MM_baseURI");
	authorization_64 = PropertyFile.getValue("MM_authorization_64");
	client_id= PropertyFile.getValue("MM_client_id");
	client_secret = PropertyFile.getValue("MM_client_secret");
	
}

@Test
public void API_clientCredentials(String grantType,String scope,String Cmethod) throws FileNotFoundException, IOException {
	
    String payload = "grant_type="+grantType+"&scope="+scope;

    RequestSpecBuilder builder = new RequestSpecBuilder(); 
    builder.addHeader("Content-Type", "application/x-www-form-urlencoded");
    builder.addHeader("Authorization", authorization_64);
    builder.addHeader("uuid", UUID.randomUUID().toString());
    builder.addHeader("Accept", ContentType.APPLICATION_JSON.getMimeType());
    
    RequestSpecification request1 = builder.build();

    Response res=given().spec(request1)
            .when()
            .with()
            .body(payload)
            .post(Cmethod);
    
   System.out.println(res.statusCode());

   access_token = res
            .then().extract().path("access_token");    
    
    System.out.println("The access token is >>>>>>" + access_token);

    if(res.statusCode()==200) {
    	
    	Assert.assertEquals(200, res.statusCode());
    }
    else {
    	
    	Assert.assertEquals(400, res.statusCode());
    }
     
     
     System.out.println("End of API >>>>   API_clientCredentials");
}

@Test
public void API_e2ekey(String Emethod) {
	
	 System.out.println("Start of the API >>> API_e2ekey");
	 
     String Authorization = "Bearer" + " " + access_token;
     
     System.out.println("Authorization------- "+Authorization);
        
     RequestSpecBuilder builder = new RequestSpecBuilder(); 
     builder.addHeader("accept", "application/json");
     builder.addHeader("Authorization", Authorization);
     builder.addHeader("client_id", client_id);
     builder.addHeader("client_secret", client_secret);
     builder.addHeader("uuid", UUID.randomUUID().toString());
     builder.addHeader("Content-Type", ContentType.APPLICATION_JSON.getMimeType());
     builder.addHeader("countryCode", "PL");
     builder.addHeader("businessCode", "GCB");
     builder.addHeader("channelId", "SSA");
     
     RequestSpecification request1 = builder.build();

     Response res=given().spec(request1)
             .when()
             .with()
             .get(Emethod);

     System.out.println(res.statusCode());

      BizToken =  res.header("bizToken").toString();
      
      System.out.println(BizToken + "BizToken is given");
      
      System.out.println(res.body().prettyPrint());
      
     System.out.println("End of API >>>> API_e2ekey");
	
}

@Test
public void API_ResourceOwner(String uName, String pass,String ROmethod) throws FileNotFoundException, IOException {
	
	System.out.println("Start of the API >>> API_ResourceOwner");
	
	RequestSpecification request = RestAssured.given();
   
    String payload = "grant_type=password&scope=/api&username="+uName+"&password="+pass;
    
    RequestSpecBuilder builder = new RequestSpecBuilder(); // Demonstration for RequestSpecBuilder
    builder.addHeader("Content-Type", "application/x-www-form-urlencoded");
    builder.addHeader("Authorization", authorization_64);
    builder.addHeader("uuid", UUID.randomUUID().toString());
    builder.addHeader("Accept", "application/json");
    builder.addHeader("BizToken", BizToken);
    
    RequestSpecification request1 = builder.build();

    Response res=given().spec(request1)
            .when()
            .with()
            .body(payload)
            .post(ROmethod);
           

    System.out.println(res.statusCode());
    
     access_token_new = res
             .then().extract().path("access_token");

     Authorization_new = "Bearer "+access_token_new;
     
     System.out.println("Authorization_new" +Authorization_new);
     
     System.out.println(res.body().prettyPrint());

    System.out.println("End of the API >>>  API_ResourceOwner");
	
}

@Test
public void API_Accounts(String ACmethod) {
	
	System.out.println("Start of the API >>>  API_Accounts");
	 
	 RequestSpecBuilder builder = new RequestSpecBuilder(); // Demonstration for RequestSpecBuilder
	    builder.addHeader("accept", "application/json");
	    builder.addHeader("Authorization",Authorization_new);
	    builder.addHeader("uuid", UUID.randomUUID().toString());
	    builder.addHeader("client_id", client_id);
	    
	    RequestSpecification request1 = builder.build();

	    Response res=given().spec(request1)
	            .when()
	            .with()
	            .get(ACmethod);
	           

	    System.out.println(res.statusCode());

    System.out.println(res.body().prettyPrint());
    
    System.out.println("End of the API >>>  API_Accounts");

 }

public void API_Cards(String card_method) {
	

	System.out.println("Start of the API >>>  /gcb/api//v1/cards");
	
	RequestSpecification request= RestAssured.given();
	
	Response response = request
	.when()
	.header("Authorization",Authorization_new)
	.accept("application/json")
	.header("uuid",UUID.randomUUID().toString())
	.header("client_id",client_id)
	.queryParam("cardFunction", "ALL")
	.with()
	.get(card_method);
	
	
	 /*RequestSpecBuilder builder = new RequestSpecBuilder(); // Demonstration for RequestSpecBuilder
	    builder.addHeader("accept", "application/json");
	    builder.addHeader("Authorization",Authorization_new);
	    builder.addHeader("uuid", UUID.randomUUID().toString());
	    builder.addHeader("client_id", client_id);
	    builder.addHeader("BizToken", BizToken);
	    
	    RequestSpecification request1 = builder.build();

	    Response res=given().spec(request1)
	            .when()
	            .with()
	            .get(card_method);*/
	
	System.out.println(response.statusCode());
	
	System.out.println(response.body().prettyPrint());
	
	System.out.println("End of the API >>>  API_Cards");
	


}


public void API_Transactions(String s) {
	
    System.out.println("Start of the API >>>  /gcb/api//v1/accounts");

    RequestSpecification request = RestAssured.given();

    Response response = request
            .when()
            .header("Authorization", Authorization_new)
            .accept("application/json")
            .header("uuid", UUID.randomUUID().toString())
            .header("client_id", client_id)
            .with()
            .get("/gcb/api/v1/accounts");
    
	  AccountGroupSummaryList accountGroupSummaryList = response.getBody().as(AccountGroupSummaryList.class);


      for(int accountGroupSummaryListIndex = 0; accountGroupSummaryListIndex < accountGroupSummaryList.getAccountGroupSummary().size(); accountGroupSummaryListIndex++)
          {
              AccountGroupSummary accountGroupSummary = accountGroupSummaryList.getAccountGroupSummary().get(accountGroupSummaryListIndex);
              for(int accountIndex = 0; accountIndex < accountGroupSummary.getAccounts().size(); accountIndex++)
              {
                  String accountId1 = null;
                  try {
                      accountId1 = accountGroupSummary.getAccounts().get(accountIndex).getSavingsAccountSummary().getAccountId();
                      System.out.println(accountGroupSummary.getAccounts().get(accountIndex).getSavingsAccountSummary().getAccountId());
                  }catch(Exception e){
                  }
	
     System.out.println("Start of the API >>> /gcb/api//v1/accounts/"+accountId1+"/transactions");
     
     System.out.println(response.statusCode());
     System.out.println(response.body().prettyPrint());
     System.out.println("End of the API >>>  /gcb/api//v1/accounts/"+accountId1+"/transactions");
              
              }
          }
}

@Test
    public void PDT_Confirmation_API(String PA_method) {
	
    System.out.println("Start of the API >>>  PDT_Confirmation_API");

    RequestSpecification request = RestAssured.given();

    Response response = request
            .when()
            .header("Authorization", Authorization_new)
            .accept("application/json")
            .header("uuid", UUID.randomUUID().toString())
            .header("client_id", client_id)
            .with()
            .get(PA_method);

    System.out.println("Start of the API >>>  /gcb/api/v1/cards?cardFunction=ALL");
    request = RestAssured.given();
    response = request
            .when()
            .header("Authorization",Authorization_new)
            .accept("application/json")
            .header("uuid",UUID.randomUUID().toString())
            .header("Client_id",client_id)
            .with()
            .get("/gcb/api/v1/cards?cardFunction=ALL");

    System.out.println(response.statusCode());
    System.out.println(response.body().prettyPrint());
    System.out.println("End of the API >>>  /gcb/api/v1/cards?cardFunction=ALL");


    String accountId="809433290433946686651706662332f634a375573535370634d706a6574315a2b534565795270615a3533664d";
    
    System.out.println("Start of the API >>> /gcb/api//v1/accounts/"+accountId+"/transactions?transactionStatus=POSTED");
    
    request = RestAssured.given();
    response = request
            .when()
            .header("Authorization",Authorization_new)
            .accept("application/json")
            .header("uuid",UUID.randomUUID().toString())
            .header("Client_id",client_id)
            .with()
            .get("/gcb/api//v1/accounts/"+accountId+"/transactions?transactionStatus=POSTED");

    System.out.println(response.statusCode());
    System.out.println(response.body().prettyPrint());
    
    System.out.println("End of the API >>>  /gcb/api//v1/accounts/"+accountId+"/transactions?transactionStatus=POSTED");
    

    System.out.println("Start of the API >>>   /gcb/api/v1/moneyMovement/personalDomesticTransfers/destinationAccounts/sourceAccounts");
    
    request = RestAssured.given();
    response = request
            .when()
            .header("Authorization",Authorization_new)
            .accept("application/json")
            .header("uuid",UUID.randomUUID().toString())
            .header("Client_id",client_id)
            .with()
            .get("/gcb/api/v1/moneyMovement/personalDomesticTransfers/destinationAccounts/sourceAccounts");
    
   
    System.out.println(response.statusCode());
    System.out.println(response.body().prettyPrint());
    
    Sourceanddesinationaccount Sourceanddestinationaccount = response.getBody().as(Sourceanddesinationaccount.class);

    String desitnationaccountid = Sourceanddestinationaccount.getDestinationSourceAcctCombinations().get(0).getDestinationAccountId();
    System.out.println("Destination account ID: " + desitnationaccountid);
    String sourceaccountId =Sourceanddestinationaccount.getDestinationSourceAcctCombinations().get(0).getSourceAccountIds().get(0).getSourceAccountId();
    System.out.println("Source account ID: " + sourceaccountId);
    
   for(int Index = 0; Index < Sourceanddestinationaccount.getDestinationSourceAcctCombinations().size(); Index++)
        {
    	   DestinationSourceAcctCombination DestinationSourceAcctCombinations = Sourceanddestinationaccount.getDestinationSourceAcctCombinations().get(Index) ;
              
              String desitaccount = null;
              
                try {
                	desitaccount = DestinationSourceAcctCombinations.getDestinationAccountId();
                    System.out.println("Destination account ID : " + desitaccount);
                   
                }catch(Exception e){
                }
                
             for (int sosurceaccountindex = 0 ; sosurceaccountindex<DestinationSourceAcctCombinations.getSourceAccountIds().size();sosurceaccountindex++)
                
                {
                	String sourceacc = null;
                	try {
                		sourceacc = DestinationSourceAcctCombinations.getSourceAccountIds().get(sosurceaccountindex).getSourceAccountId();
                        System.out.println("Source account ID : " + sourceacc);

                	}catch(Exception e){
                  }
            } 
     }
   
   
    JSONObject payload = new JSONObject();
    payload.put("sourceAccountId",sourceaccountId); 
    payload.put("transactionAmount","10");
    payload.put("transferCurrencyIndicator","SOURCE_ACCOUNT_CURRENCY");
    payload.put("destinationAccountId",desitnationaccountid);
    payload.put("chargeBearer","BENEFICIARY");
    payload.put("fxDealReferenceNumber","123456");
    payload.put("remarks","1");

    System.out.println("Start of the API >>>  /gcb/api/v1/moneyMovement/personalDomesticTransfers/preprocess");
    
    request = RestAssured.given();
    response = request
            .when()
            .header("Authorization",Authorization_new)
            .accept("application/json")
            .contentType(ContentType.APPLICATION_JSON.getMimeType())
            .header("uuid",UUID.randomUUID().toString())
            .header("Client_id",client_id)
            .with()
            .body(payload.toString())
            .post("/gcb/api/v1/moneyMovement/personalDomesticTransfers/preprocess");

    System.out.println(response.statusCode());
    ResponseBody body2 = response.body();
    DocumentContext jsonContext2 = com.jayway.jsonpath.JsonPath.parse(body2.print());
    String controlFlowID = jsonContext2.read("$.controlFlowId");
    
    System.out.println("End of the API >>>  /gcb/api/v1/moneyMovement/personalDomesticTransfers/preprocess");
    

    System.out.println("Start of the API >>> /gcb/api/v1/moneyMovement/personalDomesticTransfers");
    
    String payload_ControlFlowID="{\n" +
            "  \"controlFlowId\": \""+controlFlowID+"\"\n" +
            "}";
    request = RestAssured.given();
    response = request
            .when()
            .header("Authorization",Authorization_new)
            .accept("application/json")
            .contentType(ContentType.APPLICATION_JSON.getMimeType())
            .header("uuid",UUID.randomUUID().toString())
            .header("Client_id",client_id)
            .with()
            .body(payload_ControlFlowID)
            .post("/gcb/api/v1/moneyMovement/personalDomesticTransfers");

    System.out.println(response.statusCode());
    System.out.println(response.body().prettyPrint());
    
    System.out.println("End of the API >>>  /gcb/api/v1/moneyMovement/personalDomesticTransfers");
    
}

@Test
public void PDT_Preprocess_API(String Pre_method) {
	
 
    System.out.println("Start of the API >>>  /gcb/api/v1/moneyMovement/personalDomesticTransfers/preprocess");
    
    RequestSpecification request = RestAssured.given();
    
    JSONObject customerDetailsPayload = new JSONObject();
    customerDetailsPayload.put("sourceAccountId","76664e6467792f4e53784f4645714f6a6f4f6d53443053582b6359305142594a444e63714b7365536c6c877d");
    customerDetailsPayload.put("transactionAmount","400");
    customerDetailsPayload.put("transferCurrencyIndicator","SOURCE_ACCOUNT_CURRENCY");
    customerDetailsPayload.put("destinationAccountId","90007745333946686651706662332f634a375574544020634d706a6574315a2b534565795270615a3533513d");
    customerDetailsPayload.put("chargeBearer","BENEFICIARY");
    customerDetailsPayload.put("fxDealReferenceNumber","123456");
    customerDetailsPayload.put("remarks","1");
    
    
    Response response = request
    .when()
    .header("Authorization",Authorization_new)
    .accept("application/json")
    .contentType(ContentType.APPLICATION_JSON.getMimeType())
    .header("uuid",UUID.randomUUID().toString())
    .header("Client_id",client_id)
    .with()
    .body(customerDetailsPayload.toString())
    .post(Pre_method);
    
    System.out.println(response.statusCode());
    System.out.println(response.body().prettyPrint());
    
    ResponseBody body2 = response.body();
    DocumentContext jsonContext2 = com.jayway.jsonpath.JsonPath.parse(body2.print());
    controlFlowID = jsonContext2.read("$.controlFlowId");
    
    System.out.println("End of the API >>>  /gcb/api/v1/moneyMovement/personalDomesticTransfers/preprocess");
   
 }
public void PDT_API(String PDT_method) {
	
	 System.out.println("Start of the API >>> /gcb/api/v1/moneyMovement/personalDomesticTransfers");
	 
     String payload_ControlFlowID="{\n" + 
     		"  \"controlFlowId\": \""+controlFlowID+"\"\n" + 
     		"}";
     
     RequestSpecification request = RestAssured.given();
     Response response = request
     .when()
     .header("Authorization",Authorization_new)
     .accept("application/json")
     .contentType(ContentType.APPLICATION_JSON.getMimeType())
     .header("uuid",UUID.randomUUID().toString())
     .header("Client_id",client_id)
     .with()
     .body(payload_ControlFlowID)
     .post(PDT_method);
     
     System.out.println(response.statusCode());
     System.out.println(response.body().prettyPrint());
     
     System.out.println("End of the API >>>  /gcb/api/v1/moneyMovement/personalDomesticTransfers");
}

}

