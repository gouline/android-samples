package net.gouline.dagger2demo.rest;

import net.gouline.dagger2demo.model.ITunesResultSet;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * iTunes service.
 * <p/>
 * Created by mgouline on 23/04/15.
 */
public interface ITunesService {
    @GET("/search")
    void search(@Query("term") String term, @Query("entity") String entity, Callback<ITunesResultSet> callback);
}
