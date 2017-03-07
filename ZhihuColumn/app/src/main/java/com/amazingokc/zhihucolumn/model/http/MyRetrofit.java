package com.amazingokc.zhihucolumn.model.http;

import com.amazingokc.zhihucolumn.mommon.Constants;
import com.amazingokc.zhihucolumn.mommon.MyApplication;
import com.amazingokc.zhihucolumn.utils.LLog;
import com.amazingokc.zhihucolumn.utils.NetworkUtil;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by cjy on 2017/3/7.
 */

public class MyRetrofit {

    private static volatile OkHttpClient sHttpClient = null;
    private static Retrofit retrofit;
    public static final long RESPONSE_CACHE_SIZE = 1024 * 1024 * 20; // 20MB
    private static volatile HttpLoggingInterceptor loggingInterceptor = null;

    //缓存拦截器
    private static final Interceptor cacheInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request original = chain.request();
            Request request;
            if (!NetworkUtil.isNetworkAvailable(MyApplication.getApplication())) {
                //在请求头中加入：强制使用缓存，不访问网络
                request = original.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
                LLog.e("Interceptor ", " no network");
            } else {
                request = original.newBuilder()
                        .header("sdkversion", "1")
                        .method(original.method(), original.body())
                        .build();
            }

            Response response = chain.proceed(request);

            if (NetworkUtil.isNetworkAvailable(MyApplication.getApplication())) {
                //有网的时候读接口上的@Headers里的配置，你可以在这里进行统一的设置
//                String cacheControl = original.cacheControl().toString();
                // 有网络时 在响应头中加入：设置缓存超时时间0个小时
                int maxAge = 0;
                return response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .build();
            } else {
                // 无网络时，在响应头中加入：设置超时为4周
                int maxStale = 60 * 60 * 24 * 28;
                return response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();
            }
        }
    };

    private static final HttpLoggingInterceptor logIntercaptor() {
        // log用拦截器
        if (loggingInterceptor == null) {
//            synchronized (YiMianRetrofit.class) {
//                if (loggingInterceptor == null) {
            loggingInterceptor = new HttpLoggingInterceptor();

            // 开发模式记录整个body，否则只记录基本信息如返回200，http协议版本等
            if (Constants.isDebug) {
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            } else {
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            }
//                }
//            }
        }
        return loggingInterceptor;
    }

    /**
     * 每个获取 APIService 的方法都在先检测 sHttpClient 是否为空
     */
    private static void initHttpClient() {

        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        LLog.d("initHttpClient", "" + MyApplication.getApplication());
        File file = new File(MyApplication.getApplication().getCacheDir(), "ResponseCache");

        builder.cache(new Cache(file, RESPONSE_CACHE_SIZE))
                .retryOnConnectionFailure(true)//连接失败后是否重新连接
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addNetworkInterceptor(cacheInterceptor)
                .addInterceptor(cacheInterceptor)
                .addInterceptor(logIntercaptor());
        sHttpClient = builder.build();

    }

    public static Retrofit getRetrofit() {
        if (sHttpClient == null) {
            initHttpClient();
        }
        if (retrofit == null) {
            synchronized (MyRetrofit.class) {
                if (retrofit == null) {
                    //设置缓存大小
                    retrofit = new Retrofit.Builder()
                            .baseUrl(Constants.BASEURL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .client(sHttpClient)
                            .build();
                }
            }
        }
        return retrofit;
    }
}
