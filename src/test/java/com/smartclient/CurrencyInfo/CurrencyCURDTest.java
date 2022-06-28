package com.smartclient.CurrencyInfo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartclient.testbase.TestBase;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.greaterThan;




/**
 * Created by Bhavesh Patel
 */
@RunWith(SerenityRunner.class)
public class CurrencyCURDTest extends TestBase {

    static ArrayList<String> currencyList = new ArrayList<>();

    @Steps
    CurrencyAssertionSteps currencyAssertionSteps;

    @Title("Get the Currencies")
    @Test
    public void test001() throws IOException {
        Response response=currencyAssertionSteps.getAllCurrencies();
        HashMap result =new ObjectMapper().readValue(response.asString(),HashMap.class);
        currencyList.addAll(result.keySet());
        Collections.sort(currencyList);
        Assert.assertThat(currencyList, hasItems("gbp","usd"));
        Assert.assertThat(currencyList.size(),greaterThan(20));
        System.out.println(currencyList);
    }

    @Test
    public void getSingleCurrency(){
        //Iterating single currency from the list
        for(String currency:currencyList){
            Response response=currencyAssertionSteps.getSingleCurrency(currency);
            response.then().log().all();
        }
    }



}
