package Request;

import utils.dataStoreMapHelper.DataStoreMap;
import io.restassured.response.Response;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class ApiRequestHandler {
    String apiBaseUrl;

    RequestSpecification requestSpecification;

    public static Response response;

    public static DataStoreMap dataStoreMap = new DataStoreMap();

    public ApiRequestHandler(String apiBaseUrl) {
        this.apiBaseUrl = apiBaseUrl;
    }

    public Response postRequest(String path, Map<String, Object> headers, Object body) throws UnsupportedEncodingException {
        setRequestSpecification(headers, body);
        response = requestSpecification.post(path);
        assertThat(response.statusCode()).isEqualTo(200);
        response.prettyPrint();
        return response;
    }

    public Response getRequest(String path, Map<String, Object> headers) {
        setRequestSpecification(headers, null);
        response = requestSpecification.get(path);
        assertThat(response.statusCode()).isEqualTo(200);
        response.prettyPrint();
        return response;
    }

    public void setRequestSpecification(Map<String, Object> headers, Object body) {
        requestSpecification = RestAssured.given().baseUri(apiBaseUrl);
        if (headers != null) {
            requestSpecification.headers(headers);
        }
        if (body != null) {
            requestSpecification.body(body);
        }
    }
}
