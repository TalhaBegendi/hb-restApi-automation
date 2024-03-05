package Steps;

import Request.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import java.io.UnsupportedEncodingException;

public class CommonSteps {

    RequestApiService requestApiService = new RequestApiService();

    @When("Post language after get field from response {} and set field to variable {}")
    public void postlanguage(String getResponse,String setResponse) throws UnsupportedEncodingException {
        requestApiService.postLanguage(getResponse,setResponse);
    }

    @And("Get language file download before variable set reponse {}")
    public void getLanguageFileDownload(String usingSetResponse) {
        requestApiService.getLanguageFileDownload(usingSetResponse);
    }


}
