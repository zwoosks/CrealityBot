package giphy.entity.search;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import giphy.entity.common.Meta;
import giphy.entity.common.Pagination;
import giphy.entity.giphy.GiphyData;

public class SearchFeed {
	
	@SerializedName("data")
    private List<GiphyData> dataList;

    @SerializedName("meta")
    private Meta meta;

    @SerializedName("pagination")
    private Pagination pagination;

    /**
     * Returns the data list.
     * 
     * <p>
     * "data": [ ... ],
     * 
     * @return the data list
     */
    public List<GiphyData> getDataList() {
	return dataList;
    }

    /**
     * Sets the data list.
     * 
     * @param dataList
     *            the data list
     */
    public void setDataList(List<GiphyData> dataList) {
	this.dataList = dataList;
    }

    /**
     * Returns the meta information object.
     * 
     * <p>
     * "meta": { ... },
     * 
     * @return the meta information object
     */
    public Meta getMeta() {
	return meta;
    }

    /**
     * Sets the meta object.
     * 
     * @param meta
     *            the meta object
     */
    public void setMeta(Meta meta) {
	this.meta = meta;
    }

    /**
     * Returns the pagination object.
     * 
     * <p>
     * "pagination": { ... }
     * 
     * @return the pagination object
     */
    public Pagination getPagination() {
	return pagination;
    }

    /**
     * Sets the pagination object.
     * 
     * @param pagination
     *            the pagination object
     */
    public void setPagination(Pagination pagination) {
	this.pagination = pagination;
    }

    @Override
    public String toString() {
	String outputString = "SearchFeed [";
	for (GiphyData data : dataList) {
	    outputString += "\n  " + data;
	}
	outputString += "\n  " + meta + "\n  " + pagination + "\n]";
	return outputString;
    }
	
}