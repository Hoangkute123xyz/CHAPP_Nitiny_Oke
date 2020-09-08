package vn.chapp.nitiny.di.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import vn.chapp.nitiny.MainApp;
import vn.chapp.nitiny.data.DataManager;
import vn.chapp.nitiny.di.module.ApplicationModule;
import vn.chapp.nitiny.di.ApplicationContext;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MainApp app);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}
