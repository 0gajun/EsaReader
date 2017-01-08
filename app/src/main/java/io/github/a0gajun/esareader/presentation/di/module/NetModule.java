package io.github.a0gajun.esareader.presentation.di.module;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.threeten.bp.ZonedDateTime;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.github.a0gajun.esareader.BuildConfig;
import io.github.a0gajun.esareader.data.net.EsaApi;
import io.github.a0gajun.esareader.data.net.gson.ZonedDateTimeDeserializer;
import io.github.a0gajun.esareader.data.repository.PostRepositoryImpl;
import io.github.a0gajun.esareader.domain.repository.PostRepository;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/**
 * Created by Junya on 1/7/17.
 */

@Module
public class NetModule {
    private static final int CACHE_SIZE = 20 * 1024 * 1024; // 20MiB

    private static final String ESA_AUTH_TOKEN = "Bearer " + BuildConfig.ESA_ACCESS_TOKEN;

    private final String baseUrl;

    public NetModule(String baseUrl) {
        Timber.d("foobar");
        this.baseUrl = baseUrl;
    }

    @Singleton
    @Provides
    Cache provideCache(Application application) {
        return new Cache(application.getCacheDir(), CACHE_SIZE);
    }

    @Singleton
    @Provides
    Gson provideGson() {
        return new GsonBuilder()
                .registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeDeserializer())
                .create();
    }

    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient(Cache cache) {
        return new OkHttpClient.Builder()
                .cache(cache)
                .build();
    }

    @Singleton
    @Provides
    @Named("esa_okhttp_client")
    OkHttpClient provideEsaOkHttpClient(Cache cache) {
        return new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    Request request = chain.request()
                            .newBuilder()
                            .addHeader("Authorization", ESA_AUTH_TOKEN)
                            .build();
                    return chain.proceed(request);
                })
                .cache(cache)
                .build();
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
    }

    @Singleton
    @Provides
    @Named("esa_retrofit")
    Retrofit provideEsaRetrofit(Gson gson, @Named("esa_okhttp_client") OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
    }

    @Singleton
    @Provides
    EsaApi provideEsaApi(@Named("esa_retrofit") Retrofit retrofit) {
        return retrofit.create(EsaApi.class);
    }

    @Provides
    @Singleton
    PostRepository providePostRepository(PostRepositoryImpl postRepositoryImpl) {
        return postRepositoryImpl;
    }
}
