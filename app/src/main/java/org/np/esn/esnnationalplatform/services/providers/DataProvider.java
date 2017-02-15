package org.np.esn.esnnationalplatform.services.providers;

import org.np.esn.esnnationalplatform.model.NationalPlatformInfo;
import org.np.esn.esnnationalplatform.services.AppState;
import org.np.esn.esnnationalplatform.utils.inject.InjectUtil;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

@Singleton
public class DataProvider {

    @Inject
    AppState appState;

    @Inject
    public DataProvider() {
        InjectUtil.component().inject(this);
    }

    private interface DataProviderInterface{
        @GET("/esnp.json")
        Call<NationalPlatformInfo> getData();
    }

    public void makeRequest() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://esnp.jeremiesamson.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DataProviderInterface dataProviderInterface = retrofit.create(DataProviderInterface.class);
        Call<NationalPlatformInfo> call = dataProviderInterface.getData();
        call.enqueue(new Callback<NationalPlatformInfo>() {
            @Override
            public void onResponse(Call<NationalPlatformInfo> call, Response<NationalPlatformInfo> response) {
                appState.setNationalPlatformInfo(response.body());
            }

            @Override
            public void onFailure(Call<NationalPlatformInfo> call, Throwable t) {
                //FIXME
            }
        });
    }
}
