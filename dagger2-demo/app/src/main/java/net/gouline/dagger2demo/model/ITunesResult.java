package net.gouline.dagger2demo.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Single iTunes result contained in {@link ITunesResultSet}.
 * <p/>
 * Created by mgouline on 23/04/15.
 */
@SuppressWarnings("unused")
public class ITunesResult implements Serializable {
    @SerializedName("collectionName")
    private String mCollectionName;

    public String getCollectionName() {
        return mCollectionName;
    }

    public void setCollectionName(String collectionName) {
        mCollectionName = collectionName;
    }

    @Override
    public String toString() {
        return mCollectionName;
    }
}
