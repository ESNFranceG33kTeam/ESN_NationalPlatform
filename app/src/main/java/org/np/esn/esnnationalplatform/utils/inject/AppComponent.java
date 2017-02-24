package org.np.esn.esnnationalplatform.utils.inject;

import org.np.esn.esnnationalplatform.ESNApplication;
import org.np.esn.esnnationalplatform.adapters.AwardsAdapter;
import org.np.esn.esnnationalplatform.adapters.OCMembersAdapter;
import org.np.esn.esnnationalplatform.activities.MainActivity;
import org.np.esn.esnnationalplatform.fragments.MapFragment;
import org.np.esn.esnnationalplatform.fragments.ScheduleFragment;
import org.np.esn.esnnationalplatform.services.AppState;
import org.np.esn.esnnationalplatform.services.providers.DataProvider;
import org.np.esn.esnnationalplatform.adapters.TipsAdapter;

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

        void inject(MapFragment mapFragment);

        void inject(OCMembersAdapter ocMembersAdapter);
        void inject(TipsAdapter tipsAdapter);

        void inject(DataProvider dataProvider);

        void inject(AppState appState);

        void inject(ScheduleFragment scheduleFragment);

        void inject(AwardsAdapter awardsAdapter);
}
