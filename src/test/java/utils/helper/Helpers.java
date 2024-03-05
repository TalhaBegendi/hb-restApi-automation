package utils.helper;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import static Request.ApiRequestHandler.dataStoreMap;
import static Request.ApiRequestHandler.response;
public class Helpers  {

    public static void convertToUTF8(String getResponse, String setResponse) throws UnsupportedEncodingException {
        String value = response.jsonPath().getString(""+getResponse+"");
        String encodedTest = URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        dataStoreMap.setContext(""+setResponse+"",""+encodedTest+"");
    }
}
