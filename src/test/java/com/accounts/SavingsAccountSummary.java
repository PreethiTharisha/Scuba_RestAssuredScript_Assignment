package com.accounts;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "productName",
    "productCode",
    "displayAccountNumber",
    "accountId",
    "currencyCode",
    "accountClassification",
    "accountStatus",
    "currentBalance",
    "availableBalance"
})
public class SavingsAccountSummary {

    @JsonProperty("productName")
    private String productName;
    @JsonProperty("productCode")
    private String productCode;
    @JsonProperty("displayAccountNumber")
    private String displayAccountNumber;
    @JsonProperty("accountId")
    private String accountId;
    @JsonProperty("currencyCode")
    private String currencyCode;
    @JsonProperty("accountClassification")
    private String accountClassification;
    @JsonProperty("accountStatus")
    private String accountStatus;
    @JsonProperty("currentBalance")
    private Double currentBalance;
    @JsonProperty("availableBalance")
    private Double availableBalance;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("productName")
    public String getProductName() {
        return productName;
    }

    @JsonProperty("productName")
    public void setProductName(String productName) {
        this.productName = productName;
    }

    @JsonProperty("productCode")
    public String getProductCode() {
        return productCode;
    }

    @JsonProperty("productCode")
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @JsonProperty("displayAccountNumber")
    public String getDisplayAccountNumber() {
        return displayAccountNumber;
    }

    @JsonProperty("displayAccountNumber")
    public void setDisplayAccountNumber(String displayAccountNumber) {
        this.displayAccountNumber = displayAccountNumber;
    }

    @JsonProperty("accountId")
    public String getAccountId() {
        return accountId;
    }

    @JsonProperty("accountId")
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @JsonProperty("currencyCode")
    public String getCurrencyCode() {
        return currencyCode;
    }

    @JsonProperty("currencyCode")
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @JsonProperty("accountClassification")
    public String getAccountClassification() {
        return accountClassification;
    }

    @JsonProperty("accountClassification")
    public void setAccountClassification(String accountClassification) {
        this.accountClassification = accountClassification;
    }

    @JsonProperty("accountStatus")
    public String getAccountStatus() {
        return accountStatus;
    }

    @JsonProperty("accountStatus")
    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    @JsonProperty("currentBalance")
    public Double getCurrentBalance() {
        return currentBalance;
    }

    @JsonProperty("currentBalance")
    public void setCurrentBalance(Double currentBalance) {
        this.currentBalance = currentBalance;
    }

    @JsonProperty("availableBalance")
    public Double getAvailableBalance() {
        return availableBalance;
    }

    @JsonProperty("availableBalance")
    public void setAvailableBalance(Double availableBalance) {
        this.availableBalance = availableBalance;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
