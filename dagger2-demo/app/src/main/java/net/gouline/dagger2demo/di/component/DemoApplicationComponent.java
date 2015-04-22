package net.gouline.dagger2demo.di.component;

import net.gouline.dagger2demo.DemoApplication;
import net.gouline.dagger2demo.activity.AlbumSearchActivity;
import net.gouline.dagger2demo.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Component for {@link DemoApplication}.
 * <p/>
 * This acts as pairing between the module and injection targets, each of which
 * has to have a corresponding inject method in this component.
 * <p/>
 * Created by mgouline on 23/04/15.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface DemoApplicationComponent {
    void inject(DemoApplication application);

    void inject(AlbumSearchActivity activity);
}
