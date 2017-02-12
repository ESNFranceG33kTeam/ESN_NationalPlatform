package org.np.esn.esnnationalplatform.utils.inject;

import org.np.esn.esnnationalplatform.ESNApplication;
import org.np.esn.esnnationalplatform.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                AndroidModules.class
        }
)

public interface AppComponent {
        void inject(ESNApplication application);

        void inject(MainActivity mainActivity);
}
