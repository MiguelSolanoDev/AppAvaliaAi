package com.miguelsolano.appavaliaai.api;
import java.util.List;
import com.miguelsolano.appavaliaai.model.Cidade;
import com.miguelsolano.appavaliaai.model.Estado;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
public interface IbgeService {

    @GET("estados?orderBy=nome")
    Call<List<Estado>> listarEstados();
    @GET("estados/{id}/municipios")
    Call<List<Cidade>> listarCidades(@Path("id") int estadoId);
}