package mpeinc.id.aplikasiapijakarta_datapuskesmas.network;

import mpeinc.id.aplikasiapijakarta_datapuskesmas.constant.Constant;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InitRetrofitPuskesmas {
    public static Retrofit setInit() {
        return new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiServices getInstance() {
        return setInit().create(ApiServices.class);
    }
}
