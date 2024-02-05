package Steps;

import Request.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import java.io.UnsupportedEncodingException;


public class CommonSteps {

    RequestApiService requestApiService = new RequestApiService();

    @When("Post language")
    public void postlanguage() throws UnsupportedEncodingException {
        requestApiService.postLanguage();
    }

    @And("Get language file download")
    public void getLanguageFileDownload() {
        requestApiService.getLanguageFileDownload();
    }


}
