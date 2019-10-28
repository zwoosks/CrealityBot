package giphy.entity.search;

import com.google.gson.annotations.SerializedName;

import giphy.entity.common.Meta;
import giphy.entity.giphy.GiphyRandom;

public class SearchRandom {
	
	@SerializedName("data")
    private GiphyRandom data;

    @SerializedName("meta")
    private Meta meta;

    /**
     * Returns the data.
     * 
     * <p>
     * "data": { ... }
     * 
     * @return The data.
     */
    public GiphyRandom getData() {
	return data;
    }

    /**
     * Sets the data.
     * 
     * @param data
     *            the data
     */
    public void setData(GiphyRandom data) {
	this.data = data;
    }

    /**
     * Returns the meta data.
     * 
     * <p>
     * "meta": { ... }
     * 
     * @return the meta data.
     */
    public Meta getMeta() {
	return meta;
    }

    /**
     * Sets the meta data.
     * 
     * @param meta
     *            the meta data
     */
    public void setMeta(Meta meta) {
	this.meta = meta;
    }

    @Override
    public String toString() {
	String outputString = "SearchRandom [";
	outputString += "\n  " + data;
	outputString += "\n  " + meta + "\n]";
	return outputString;
    }
	
}