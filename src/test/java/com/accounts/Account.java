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
    "savingsAccountSummary",
    "checkingAccountSummary",
    "creditCardAccountSummary"
})
public class Account {

    @JsonProperty("savingsAccountSummary")
    private SavingsAccountSummary savingsAccountSummary;
    @JsonProperty("checkingAccountSummary")
    private CheckingAccountSummary checkingAccountSummary;
    @JsonProperty("creditCardAccountSummary")
    private CreditCardAccountSummary creditCardAccountSummary;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("savingsAccountSummary")
    public SavingsAccountSummary getSavingsAccountSummary() {
        return savingsAccountSummary;
    }

    @JsonProperty("savingsAccountSummary")
    public void setSavingsAccountSummary(SavingsAccountSummary savingsAccountSummary) {
        this.savingsAccountSummary = savingsAccountSummary;
    }

    @JsonProperty("checkingAccountSummary")
    public CheckingAccountSummary getCheckingAccountSummary() {
        return checkingAccountSummary;
    }

    @JsonProperty("checkingAccountSummary")
    public void setCheckingAccountSummary(CheckingAccountSummary checkingAccountSummary) {
        this.checkingAccountSummary = checkingAccountSummary;
    }

    @JsonProperty("creditCardAccountSummary")
    public CreditCardAccountSummary getCreditCardAccountSummary() {
        return creditCardAccountSummary;
    }

    @JsonProperty("creditCardAccountSummary")
    public void setCreditCardAccountSummary(CreditCardAccountSummary creditCardAccountSummary) {
        this.creditCardAccountSummary = creditCardAccountSummary;
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
