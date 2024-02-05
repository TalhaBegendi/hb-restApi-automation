package Request;

import dataStoreMapHelper.DataStoreMap;
import io.restassured.response.Response;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static io.restassured.RestAssured.post;
import static org.assertj.core.api.Assertions.assertThat;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class RequestMethods {
    String baseUrl;

    RequestSpecification httpRequest;

    public RequestMethods(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    DataStoreMap dataStoreMap = new DataStoreMap();

    public Response postRequest(String path, Map<String, Object> headers, Object body) throws UnsupportedEncodingException {
        setHttpRequest(headers, body);
        Response response = httpRequest.post(path);
        assertThat(response.statusCode()).isEqualTo(200);
        String code = response.jsonPath().getString("code");
        String encodedTest = URLEncoder.encode(code, StandardCharsets.UTF_8.toString());
        dataStoreMap.setContext("codeForFile",""+encodedTest+"");
        response.prettyPrint();
        return response;
    }

    public Response getRequest(String path, Map<String, Object> headers) {
        setHttpRequest(headers,null);
        Response response = httpRequest.get(path);
        assertThat(response.statusCode()).isEqualTo(200);
        response.prettyPrint();
        return response;
    }

    public void setHttpRequest(Map<String, Object> headers, Object body) {
        httpRequest = RestAssured.given().baseUri(baseUrl);
        if (headers != null) {
            httpRequest.headers(headers);
        }
        if (body != null) {
            httpRequest.body(body);
        }
    }
}
