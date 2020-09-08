

package vn.chapp.nitiny.di.component;

import vn.chapp.nitiny.di.PerService;
import vn.chapp.nitiny.di.module.ServiceModule;

import dagger.Component;


@PerService
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {
}
