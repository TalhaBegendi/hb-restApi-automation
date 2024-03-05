package Request;

import constant.APIConstants;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import static Store.LanguageStore.languageStore;
import static utils.helper.Helpers.convertToUTF8;

public class RequestApiService extends ApiRequestHandler {

    public RequestApiService() {
        super(APIConstants.BASE_URL);
    }

    public void postLanguage(String getResponse,String setResponse) throws UnsupportedEncodingException {
        Map<String, Object> header = new HashMap<String, Object>() {{
            put("Content-Type", "application/json");
        }};
        response = postRequest(APIConstants.API_POST_SUFFIX_LANGUAGE,header,languageStore());
        convertToUTF8(getResponse,setResponse);
    }


    public void getLanguageFileDownload(String usingSetResponse) {
        Object fileValue=  dataStoreMap.getContext(""+usingSetResponse+"");
        Map<String, Object> header = new HashMap<String, Object>() {{
            put("Accept", "application/octet-stream");
        }};
        response = getRequest(APIConstants.API_GET_SUFFIX_LANGUAGE + fileValue,header);
    }
}
