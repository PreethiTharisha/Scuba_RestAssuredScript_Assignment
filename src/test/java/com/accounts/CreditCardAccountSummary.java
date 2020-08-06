
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
    "outstandingBalance",
    "availableCredit",
    "creditLimit",
    "minimumDueAmount",
    "paymentDueDate",
    "alternateCurrency",
    "alternateCurrencyCurrentBalance",
    "cardHolderType"
})
public class CreditCardAccountSummary {

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
    @JsonProperty("outstandingBalance")
    private Double outstandingBalance;
    @JsonProperty("availableCredit")
    private Double availableCredit;
    @JsonProperty("creditLimit")
    private Integer creditLimit;
    @JsonProperty("minimumDueAmount")
    private Integer minimumDueAmount;
    @JsonProperty("paymentDueDate")
    private String paymentDueDate;
    @JsonProperty("alternateCurrency")
    private String alternateCurrency;
    @JsonProperty("alternateCurrencyCurrentBalance")
    private Integer alternateCurrencyCurrentBalance;
    @JsonProperty("cardHolderType")
    private String cardHolderType;
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

    @JsonProperty("outstandingBalance")
    public Double getOutstandingBalance() {
        return outstandingBalance;
    }

    @JsonProperty("outstandingBalance")
    public void setOutstandingBalance(Double outstandingBalance) {
        this.outstandingBalance = outstandingBalance;
    }

    @JsonProperty("availableCredit")
    public Double getAvailableCredit() {
        return availableCredit;
    }

    @JsonProperty("availableCredit")
    public void setAvailableCredit(Double availableCredit) {
        this.availableCredit = availableCredit;
    }

    @JsonProperty("creditLimit")
    public Integer getCreditLimit() {
        return creditLimit;
    }

    @JsonProperty("creditLimit")
    public void setCreditLimit(Integer creditLimit) {
        this.creditLimit = creditLimit;
    }

    @JsonProperty("minimumDueAmount")
    public Integer getMinimumDueAmount() {
        return minimumDueAmount;
    }

    @JsonProperty("minimumDueAmount")
    public void setMinimumDueAmount(Integer minimumDueAmount) {
        this.minimumDueAmount = minimumDueAmount;
    }

    @JsonProperty("paymentDueDate")
    public String getPaymentDueDate() {
        return paymentDueDate;
    }

    @JsonProperty("paymentDueDate")
    public void setPaymentDueDate(String paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
    }

    @JsonProperty("alternateCurrency")
    public String getAlternateCurrency() {
        return alternateCurrency;
    }

    @JsonProperty("alternateCurrency")
    public void setAlternateCurrency(String alternateCurrency) {
        this.alternateCurrency = alternateCurrency;
    }

    @JsonProperty("alternateCurrencyCurrentBalance")
    public Integer getAlternateCurrencyCurrentBalance() {
        return alternateCurrencyCurrentBalance;
    }

    @JsonProperty("alternateCurrencyCurrentBalance")
    public void setAlternateCurrencyCurrentBalance(Integer alternateCurrencyCurrentBalance) {
        this.alternateCurrencyCurrentBalance = alternateCurrencyCurrentBalance;
    }

    @JsonProperty("cardHolderType")
    public String getCardHolderType() {
        return cardHolderType;
    }

    @JsonProperty("cardHolderType")
    public void setCardHolderType(String cardHolderType) {
        this.cardHolderType = cardHolderType;
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
