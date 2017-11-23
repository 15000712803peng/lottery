package com.cai.newc.net;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;



public final class ApiClient {

    private ApiClient() {}

    public static String MAIN_HOST = "http://";
    public static String URI_PREFIX_API = "/api/pub"; // 不需要加/结尾
    public static String API_Endpoint = MAIN_HOST + URI_PREFIX_API;
     static Map<String, String> headers = new HashMap<>();

    public static void setHeaders() {

    }

    public static ApiService getService() {

        if(service == null){
            OkHttpClient client = new OkHttpClient.Builder()
                    .addNetworkInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            //logs
                            Request.Builder builder = chain.request()
                                    .newBuilder();
                            return chain.proceed(builder.build());
                        }
                    })
                    .addInterceptor(new Interceptor() {

                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request.Builder builder = chain.request()
                                    .newBuilder();

                            if (headers != null && headers.size() > 0) {
                                Set<String> keys = headers.keySet();
                                for (String headerKey : keys) {
                                    builder.addHeader(headerKey,   headers.get(headerKey)).build();
                                }
                            }
                            return chain.proceed(builder.build());
                        }
                    }).build();
            Retrofit retrofit = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(MAIN_HOST)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();

            service = retrofit.create(ApiService.class);
        }

        return service;
    }

    public static ApiService service;


}