package io.github.a0gajun.esareader.presentation;

import android.app.Application;

import com.jakewharton.threetenabp.AndroidThreeTen;
import com.squareup.leakcanary.LeakCanary;

import io.github.a0gajun.esareader.BuildConfig;
import io.github.a0gajun.esareader.presentation.di.component.ApplicationComponent;
import io.github.a0gajun.esareader.presentation.di.component.DaggerApplicationComponent;
import io.github.a0gajun.esareader.presentation.di.module.ApplicationModule;
import io.github.a0gajun.esareader.presentation.di.module.NetModule;
import timber.log.Timber;

/**
 * Created by Junya on 1/6/17.
 */

public class AndroidApplication extends Application {
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeTimber();
        this.initializeInjector();
        this.initializeLeakDetection();
        AndroidThreeTen.init(this);
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .netModule(new NetModule(BuildConfig.ESA_END_POINT))
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

    private void initializeTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    private void initializeLeakDetection() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this);
        }
    }
}
