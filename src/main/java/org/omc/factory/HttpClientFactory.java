package org.omc.factory;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by ocortez on 11/26/2015.
 */
@Component
public class HttpClientFactory {

    public static final String APPLICATION_JSON_UTF8 = "product/json; charset=utf-8";
    private static final int HTTP_CLIENT_CONFIG_TIMEOUT = 60000;

    public CloseableHttpClient createHttpClient(){
        return this.createHttpClient(HTTP_CLIENT_CONFIG_TIMEOUT);
    }

    private CloseableHttpClient createHttpClient(int httpClientTimeout) {
        RequestConfig.Builder requestBuilder = RequestConfig.custom();
        requestBuilder = requestBuilder.setConnectTimeout(httpClientTimeout);
        requestBuilder = requestBuilder.setSocketTimeout(httpClientTimeout);
        requestBuilder = requestBuilder.setConnectionRequestTimeout(httpClientTimeout);
        return HttpClientBuilder.create().disableContentCompression().setDefaultRequestConfig(requestBuilder.build()).build();
    }

    public static int getHttpClientConfigTimeout() {
        return HTTP_CLIENT_CONFIG_TIMEOUT;
    }

    public static String getApplicationJsonUtf8() {
        return APPLICATION_JSON_UTF8;
    }
}
