package com.smartclient.CurrencyInfo;

import com.smartclient.constants.EndPoints;
import io.restassured.response.Response;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class CurrencyAssertionSteps {

    @Step("Get all Currency details")
    public Response getAllCurrencies() {
        return SerenityRest.given().log().all().urlEncodingEnabled(false)
                .when()
                .get(EndPoints.GET_ALL_CURRENCIES);

    }
    @Step("Get currency")
    public Response getSingleCurrency(String currency) {
        return SerenityRest.given().log().all().urlEncodingEnabled(false)
                .pathParam("variableFromArray", currency)
                .when()
                .get(EndPoints.CURRENCY);
    }


}
