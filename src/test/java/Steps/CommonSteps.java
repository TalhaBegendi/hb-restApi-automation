package Steps;

import Request.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;


public class CommonSteps {

    RequestApiService requestApiService = new RequestApiService();

    @When("Post language")
    public void postlanguage() throws UnsupportedEncodingException {
        requestApiService.postlanguage();
    }

    @And("Get file")
    public void getFile() {
        requestApiService.getFile();
    }


}
