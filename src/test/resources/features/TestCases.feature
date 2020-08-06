@api
Feature: MoneyMovement Test Cases


Background: 
Given Initiate the setup required

Scenario Outline: Initiate_the_cardAuth_authorize_API_with_valid_fields_and_verify_the_Expected_Result

When Initiate the Client_Credentials_API '<grant_type>' '<scope>' and '<Cmethod>' get the accessToken

Examples:
#positive_case
|grant_type|scope|Cmethod|
|client_credentials|/api|/gcb/api/clientCredentials/oauth2/token/us/gcb|


Examples:
#negitive_case
|grant_type|scope|Cmethod|
|loan_authorization|/api|/gcb/api/clientCredentials/oauth2/token/us/gcb|


Scenario Outline: Initiate_the_Password_API_with_valid_fields_and_verify_the_Expected_Result

When Initiate the Client_Credentials_API '<grant_type>' '<scope>' and '<Cmethod>' get the accessToken
And Initiate the EtoEkey_API '<Emethod>'  and get the Biz_token
And Initiate the Resource_Owner '<username>' '<password>' and '<ROmethod>' get the encrypted password

Examples:
#positive_case
|grant_type|scope|Cmethod|Emethod|username|password|ROmethod|
|client_credentials|/api|/gcb/api/clientCredentials/oauth2/token/us/gcb|/gcb/api/security/e2eKey|SandboxUser1|967c2812d7c437b1b8f5dcc887ab64eb24637c9855cc5adeae232c5ae68232802579af2dad68e94c09d3cd6ec3f974e060468150c5ad8c01f39830a723229e8507e9a23433ff273cb6084cf12e838e76e30b2cba1e23ff7be9567726e584f5f442865553df94ddda1ea035e17e3109fcfd9ea3a1d5499a184ca7b79964ca5adfeac59b566f52fb4aa0e7b35983c71b838d16d3dff61715bafde60328e9c5c7fe5ae0e5edc8187d0167206b59df38e718deef822a0499d128d1d6a8464d0871bcdc273658d3c73ebda9c3e348b6e16838942d4630d555ff3ca6569d409b674c37e6b2412e086b644844662dd36fa79acb467207855a39e203552b9f1d2b0e1600|/gcb/api/password/oauth2/token/bh/gcb|


Examples:
#negitive_case
|grant_type|scope|Cmethod|Emethod|username|password|ROmethod|
|client_credentials|/api|/gcb/api/clientCredentials/oauth2/token/us/gcb|/gcb/api/security/e2eKey|SandboxUser|967c2812d7c437b1b8f5dcc887ab64eb24637c9855cc5adeae232c5ae68232802579af2dad68e94c09d3cd6ec3f974e060468150c5ad8c01f39830a723229e8507e9a23433ff273cb6084cf12e838e76e30b2cba1e23ff7be9567726e584f5f442865553df94ddda1ea035e17e3109fcfd9ea3a1d5499a184ca7b79964ca5adfeac59b566f52fb4aa0e7b35983c71b838d16d3dff61715bafde60328e9c5c7fe5ae0e5edc8187d0167206b59df38e718deef822a0499d128d1d6a8464d0871bcdc273658d3c73ebda9c3e348b6e16838942d4630d555ff3ca6569d409b674c37e6b2412e086b644844662dd36fa79acb467207855a39e203552b9f1d2b0e1600|/gcb/api/password/oauth2/token/bh/gcb|


Scenario Outline: Initiate_the_Account_API_with_valid_fields_and_verify_the_Expected_Result

When Initiate the Client_Credentials_API '<grant_type>' '<scope>' and '<Cmethod>' get the accessToken
And Initiate the EtoEkey_API '<Emethod>'  and get the Biz_token
And Initiate the Resource_Owner '<username>' '<password>' and '<ROmethod>' get the encrypted password
Then Initiate the Accounts_API '<ACmethod>' to get all the accounts

Examples:
#positive_case
|grant_type|scope|Cmethod|Emethod|username|password|ROmethod|ACmethod|
|client_credentials|/api|/gcb/api/clientCredentials/oauth2/token/us/gcb|/gcb/api/security/e2eKey|SandboxUser1|967c2812d7c437b1b8f5dcc887ab64eb24637c9855cc5adeae232c5ae68232802579af2dad68e94c09d3cd6ec3f974e060468150c5ad8c01f39830a723229e8507e9a23433ff273cb6084cf12e838e76e30b2cba1e23ff7be9567726e584f5f442865553df94ddda1ea035e17e3109fcfd9ea3a1d5499a184ca7b79964ca5adfeac59b566f52fb4aa0e7b35983c71b838d16d3dff61715bafde60328e9c5c7fe5ae0e5edc8187d0167206b59df38e718deef822a0499d128d1d6a8464d0871bcdc273658d3c73ebda9c3e348b6e16838942d4630d555ff3ca6569d409b674c37e6b2412e086b644844662dd36fa79acb467207855a39e203552b9f1d2b0e1600|/gcb/api/password/oauth2/token/bh/gcb|/gcb/api/v1/accounts|


Scenario Outline: Initiate_the_GET_Card_API_with_valid_fields_and_verify_the_Expected_Result

When Initiate the Client_Credentials_API '<grant_type>' '<scope>' and '<Cmethod>' get the accessToken
And Initiate the EtoEkey_API '<Emethod>'  and get the Biz_token
And Initiate the Resource_Owner '<username>' '<password>' and '<ROmethod>' get the encrypted password
And Initiate the Accounts_API '<ACmethod>' to get all the accounts
Then Initiate the Cards_API '<card_method>' to get all the cards

 Examples:
|grant_type|scope|Cmethod|Emethod|username|password|ROmethod|ACmethod|card_method|
|client_credentials|/api|/gcb/api/clientCredentials/oauth2/token/us/gcb|/gcb/api/security/e2eKey|SandboxUser1|967c2812d7c437b1b8f5dcc887ab64eb24637c9855cc5adeae232c5ae68232802579af2dad68e94c09d3cd6ec3f974e060468150c5ad8c01f39830a723229e8507e9a23433ff273cb6084cf12e838e76e30b2cba1e23ff7be9567726e584f5f442865553df94ddda1ea035e17e3109fcfd9ea3a1d5499a184ca7b79964ca5adfeac59b566f52fb4aa0e7b35983c71b838d16d3dff61715bafde60328e9c5c7fe5ae0e5edc8187d0167206b59df38e718deef822a0499d128d1d6a8464d0871bcdc273658d3c73ebda9c3e348b6e16838942d4630d555ff3ca6569d409b674c37e6b2412e086b644844662dd36fa79acb467207855a39e203552b9f1d2b0e1600|/gcb/api/password/oauth2/token/bh/gcb|/gcb/api/v1/accounts|/gcb/api/v1/cards|



Scenario Outline: Initiate the GET_Transactions API with valid fields and verify the Expected Result

When Initiate the Client_Credentials_API '<grant_type>' '<scope>' and '<Cmethod>' get the accessToken
And Initiate the EtoEkey_API '<Emethod>'  and get the Biz_token
And Initiate the Resource_Owner '<username>' '<password>' and '<ROmethod>' get the encrypted password
And Initiate the Accounts_API '<ACmethod>' to get all the accounts
And Initiate the Cards_API '<card_method>' to get all the cards
Then Initiate the Transaction_Account_API '<TAmethod>' and get the accountid and transaction status

 Examples:
|grant_type|scope|Cmethod|Emethod|username|password|ROmethod|ACmethod|card_method|TAmethod|
|client_credentials|/api|/gcb/api/clientCredentials/oauth2/token/us/gcb|/gcb/api/security/e2eKey|SandboxUser1|967c2812d7c437b1b8f5dcc887ab64eb24637c9855cc5adeae232c5ae68232802579af2dad68e94c09d3cd6ec3f974e060468150c5ad8c01f39830a723229e8507e9a23433ff273cb6084cf12e838e76e30b2cba1e23ff7be9567726e584f5f442865553df94ddda1ea035e17e3109fcfd9ea3a1d5499a184ca7b79964ca5adfeac59b566f52fb4aa0e7b35983c71b838d16d3dff61715bafde60328e9c5c7fe5ae0e5edc8187d0167206b59df38e718deef822a0499d128d1d6a8464d0871bcdc273658d3c73ebda9c3e348b6e16838942d4630d555ff3ca6569d409b674c37e6b2412e086b644844662dd36fa79acb467207855a39e203552b9f1d2b0e1600|/gcb/api/password/oauth2/token/bh/gcb|/gcb/api/v1/accounts|/gcb/api/v1/cards|/gcb/api//v1/accounts/transactions|




Scenario Outline: Initiate the sourceAccounts & destination Eligibility API with valid fields and verify the Expected Result

When Initiate the Client_Credentials_API '<grant_type>' '<scope>' and '<Cmethod>' get the accessToken
And Initiate the EtoEkey_API '<Emethod>'  and get the Biz_token
And Initiate the Resource_Owner '<username>' '<password>' and '<ROmethod>' get the encrypted password
And Initiate the Accounts_API '<ACmethod>' to get all the accounts
And Initiate the Cards_API '<card_method>' to get all the cards
And Initiate the Transaction_Account_API '<TAmethod>' and get the accountid and transaction status
Then Initiate the PDT_Eligibility_API '<PA_method>' and verify the expected result

 Examples:
|grant_type|scope|Cmethod|Emethod|username|password|ROmethod|ACmethod|card_method|TAmethod|PA_method|
|client_credentials|/api|/gcb/api/clientCredentials/oauth2/token/us/gcb|/gcb/api/security/e2eKey|SandboxUser1|967c2812d7c437b1b8f5dcc887ab64eb24637c9855cc5adeae232c5ae68232802579af2dad68e94c09d3cd6ec3f974e060468150c5ad8c01f39830a723229e8507e9a23433ff273cb6084cf12e838e76e30b2cba1e23ff7be9567726e584f5f442865553df94ddda1ea035e17e3109fcfd9ea3a1d5499a184ca7b79964ca5adfeac59b566f52fb4aa0e7b35983c71b838d16d3dff61715bafde60328e9c5c7fe5ae0e5edc8187d0167206b59df38e718deef822a0499d128d1d6a8464d0871bcdc273658d3c73ebda9c3e348b6e16838942d4630d555ff3ca6569d409b674c37e6b2412e086b644844662dd36fa79acb467207855a39e203552b9f1d2b0e1600|/gcb/api/password/oauth2/token/bh/gcb|/gcb/api/v1/accounts|/gcb/api/v1/cards|/gcb/api//v1/accounts/transactions|/gcb/api//v1/accounts|





Scenario Outline: Initiate the sourceAccounts & destination Eligibility API with valid fields and verify the Expected Result

When Initiate the Client_Credentials_API '<grant_type>' '<scope>' and '<Cmethod>' get the accessToken
And Initiate the EtoEkey_API '<Emethod>'  and get the Biz_token
And Initiate the Resource_Owner '<username>' '<password>' and '<ROmethod>' get the encrypted password
And Initiate the Accounts_API '<ACmethod>' to get all the accounts
And Initiate the Cards_API '<card_method>' to get all the cards
And Initiate the Transaction_Account_API '<TAmethod>' and get the accountid and transaction status
Then Initiate the PDT_Eligibility_API '<PA_method>' and verify the expected result

 Examples:
|grant_type|scope|Cmethod|Emethod|username|password|ROmethod|ACmethod|card_method|TAmethod|PA_method|
|client_credentials|/api|/gcb/api/clientCredentials/oauth2/token/us/gcb|/gcb/api/security/e2eKey|SandboxUser1|967c2812d7c437b1b8f5dcc887ab64eb24637c9855cc5adeae232c5ae68232802579af2dad68e94c09d3cd6ec3f974e060468150c5ad8c01f39830a723229e8507e9a23433ff273cb6084cf12e838e76e30b2cba1e23ff7be9567726e584f5f442865553df94ddda1ea035e17e3109fcfd9ea3a1d5499a184ca7b79964ca5adfeac59b566f52fb4aa0e7b35983c71b838d16d3dff61715bafde60328e9c5c7fe5ae0e5edc8187d0167206b59df38e718deef822a0499d128d1d6a8464d0871bcdc273658d3c73ebda9c3e348b6e16838942d4630d555ff3ca6569d409b674c37e6b2412e086b644844662dd36fa79acb467207855a39e203552b9f1d2b0e1600|/gcb/api/password/oauth2/token/bh/gcb|/gcb/api/v1/accounts|/gcb/api/v1/cards|/gcb/api//v1/accounts/transactions|/gcb/api//v1/accounts|


Scenario Outline: Initiate the sourceAccounts & destination Eligibility API with valid fields and verify the Expected Result

When Initiate the Client_Credentials_API '<grant_type>' '<scope>' and '<Cmethod>' get the accessToken
And Initiate the EtoEkey_API '<Emethod>'  and get the Biz_token
And Initiate the Resource_Owner '<username>' '<password>' and '<ROmethod>' get the encrypted password
And Initiate the Accounts_API '<ACmethod>' to get all the accounts
And Initiate the Cards_API '<card_method>' to get all the cards
And Initiate the Transaction_Account_API '<TAmethod>' and get the accountid and transaction status
And Initiate the PDT_Eligibility_API '<PA_method>' and verify the expected result
Then Initiate the PDT-PreProcess API '<Pre_method>' with valid fields and verify the Expected Result

 Examples:
|grant_type|scope|Cmethod|Emethod|username|password|ROmethod|ACmethod|card_method|TAmethod|PA_method|Pre_method|
|client_credentials|/api|/gcb/api/clientCredentials/oauth2/token/us/gcb|/gcb/api/security/e2eKey|SandboxUser1|967c2812d7c437b1b8f5dcc887ab64eb24637c9855cc5adeae232c5ae68232802579af2dad68e94c09d3cd6ec3f974e060468150c5ad8c01f39830a723229e8507e9a23433ff273cb6084cf12e838e76e30b2cba1e23ff7be9567726e584f5f442865553df94ddda1ea035e17e3109fcfd9ea3a1d5499a184ca7b79964ca5adfeac59b566f52fb4aa0e7b35983c71b838d16d3dff61715bafde60328e9c5c7fe5ae0e5edc8187d0167206b59df38e718deef822a0499d128d1d6a8464d0871bcdc273658d3c73ebda9c3e348b6e16838942d4630d555ff3ca6569d409b674c37e6b2412e086b644844662dd36fa79acb467207855a39e203552b9f1d2b0e1600|/gcb/api/password/oauth2/token/bh/gcb|/gcb/api/v1/accounts|/gcb/api/v1/cards|/gcb/api//v1/accounts/transactions|/gcb/api//v1/accounts|/gcb/api/v1/moneyMovement/personalDomesticTransfers/preprocess|




Scenario Outline: Initiate the sourceAccounts & destination Eligibility API with valid fields and verify the Expected Result

When Initiate the Client_Credentials_API '<grant_type>' '<scope>' and '<Cmethod>' get the accessToken
And Initiate the EtoEkey_API '<Emethod>'  and get the Biz_token
And Initiate the Resource_Owner '<username>' '<password>' and '<ROmethod>' get the encrypted password
And Initiate the Accounts_API '<ACmethod>' to get all the accounts
And Initiate the Cards_API '<card_method>' to get all the cards
And Initiate the Transaction_Account_API '<TAmethod>' and get the accountid and transaction status
And Initiate the PDT_Eligibility_API '<PA_method>' and verify the expected result
And Initiate the PDT-PreProcess API '<Pre_method>' with valid fields and verify the Expected Result
Then Initiate the PDT-Confirmation API '<PDT_method>' with valid fields and verify the Expected Result

 Examples:
|grant_type|scope|Cmethod|Emethod|username|password|ROmethod|ACmethod|card_method|TAmethod|PA_method|Pre_method|PDT_method|
|client_credentials|/api|/gcb/api/clientCredentials/oauth2/token/us/gcb|/gcb/api/security/e2eKey|SandboxUser1|967c2812d7c437b1b8f5dcc887ab64eb24637c9855cc5adeae232c5ae68232802579af2dad68e94c09d3cd6ec3f974e060468150c5ad8c01f39830a723229e8507e9a23433ff273cb6084cf12e838e76e30b2cba1e23ff7be9567726e584f5f442865553df94ddda1ea035e17e3109fcfd9ea3a1d5499a184ca7b79964ca5adfeac59b566f52fb4aa0e7b35983c71b838d16d3dff61715bafde60328e9c5c7fe5ae0e5edc8187d0167206b59df38e718deef822a0499d128d1d6a8464d0871bcdc273658d3c73ebda9c3e348b6e16838942d4630d555ff3ca6569d409b674c37e6b2412e086b644844662dd36fa79acb467207855a39e203552b9f1d2b0e1600|/gcb/api/password/oauth2/token/bh/gcb|/gcb/api/v1/accounts|/gcb/api/v1/cards|/gcb/api//v1/accounts/transactions|/gcb/api//v1/accounts|/gcb/api/v1/moneyMovement/personalDomesticTransfers/preprocess|/gcb/api/v1/moneyMovement/personalDomesticTransfers|

