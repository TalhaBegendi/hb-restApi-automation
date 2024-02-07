package Request;

import Store.LanguageStore;
import constant.APIConstants;
import io.restassured.response.Response;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class RequestApiService extends ApiRequestHandler {

    LanguageStore languageStore = new LanguageStore();

    public RequestApiService() {
        super(APIConstants.BASE_URL);
    }

    public void postLanguage() throws UnsupportedEncodingException {
        Map<String, Object> header = new HashMap<String, Object>() {{
            put("Content-Type", "application/json");
        }};
        Response response = postRequest(APIConstants.API_POST_SUFFIX_LANGUAGE,header,languageStore.languageStore());
    }

    public void getLanguageFileDownload() {
        Object fileCode=  dataStoreMap.getContext("fileCode");
        Map<String, Object> header = new HashMap<String, Object>() {{
            put("Accept", "application/octet-stream");
        }};
        Response response = getRequest(APIConstants.API_GET_SUFFIX_LANGUAGE + fileCode,header);
    }
}
