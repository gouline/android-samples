package net.gouline.dagger2demo.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Result set as returned from the iTunes API.
 * <p/>
 * Created by mgouline on 23/04/15.
 */
@SuppressWarnings("unused")
public class ITunesResultSet implements Serializable {
    @SerializedName("results")
    private List<ITunesResult> mResults;

    public List<ITunesResult> getResults() {
        return mResults;
    }

    public void setResults(List<ITunesResult> results) {
        mResults = results;
    }
}
