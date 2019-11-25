package mpeinc.id.aplikasiapijakarta_datapuskesmas.network;

import mpeinc.id.aplikasiapijakarta_datapuskesmas.models.ResponseDataPuskesmas;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ApiServices {

    @GET("puskesmas")
    Call<ResponseDataPuskesmas> datapuskesman(
            @Header("Authorization") String auth_token
    );
}
