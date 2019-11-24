package katok.core.apiDataMiner;

import static io.restassured.RestAssured.given;

public class ExchangeRateMiner {
    private static final String RESOURCE = "http://www.nbrb.by/API/ExRates/Rates/";
    private static final String PARAM_MODE = "ParamMode";
    private static final String PARAM_MODE_VALUE = "2";
    private static final String RATE_NODE = "Cur_OfficialRate";

    public static Float getExchangeRateForCurrency(String currencyCode) {

        return given().
                param(PARAM_MODE, PARAM_MODE_VALUE).
                when().
                get(RESOURCE + currencyCode).
                then().
                extract().
                path(RATE_NODE);
    }
}
