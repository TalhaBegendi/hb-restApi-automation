package Store;

import model.AuthorizationValue;
import model.LanguageRequest;

public class LanguageStore {
    public LanguageRequest languageStore() {
        LanguageRequest languageRequest = new LanguageRequest();
        languageRequest.setSwaggerUrl("http://petstore.swagger.io/v2/swagger.json");
        AuthorizationValue authorizationValue = new AuthorizationValue();
        authorizationValue.setValue("yourAuthToken");
        authorizationValue.setKeyName("Authorization");
        authorizationValue.setType("Bearer");
        languageRequest.setAuthorizationValue(authorizationValue);
        return languageRequest;
    }
}
