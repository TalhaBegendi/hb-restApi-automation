package Request;

import Store.LanguageStore;
import constant.APIConstants;
import io.restassured.response.Response;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class RequestApiService extends RequestMethods {

    LanguageStore postStore = new LanguageStore();

    public RequestApiService() {
        super(APIConstants.SwaggerAPI.BASE_URL);
    }

    public void postlanguage() throws UnsupportedEncodingException {
        Map<String, Object> header = new HashMap<String, Object>() {{
            put("Content-Type", "application/json");
        }};
        Response response = postRequest(APIConstants.SwaggerAPI.API_POST_SUFFIX_LANGUAGE,header,postStore.languageStore());
    }

    public void getFile() {
        Object codeForFile=  dataStoreMap.getContext("codeForFile");
        Map<String, Object> header = new HashMap<String, Object>() {{
            put("Accept", "application/octet-stream");
        }};
        Response response = getRequest(APIConstants.SwaggerAPI.API_GET_SUFFIX_LANGUAGE + codeForFile,header);
    }
}
