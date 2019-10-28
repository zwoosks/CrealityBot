package giphy.entity.common;

import com.google.gson.annotations.SerializedName;

public class Pagination {

	@SerializedName("total_count")
    private int totalCount;

    @SerializedName("count")
    private int count;

    @SerializedName("offset")
    private int offset;

    /**
     * Returns the total count of the response.
     * 
     * @return the total count
     */
    public int getTotalCount() {
	return totalCount;
    }

    /**
     * Sets the total count of the pagination object.
     * 
     * @param totalCount
     *            the total count
     */
    public void setTotalCount(int totalCount) {
	this.totalCount = totalCount;
    }

    /**
     * Returns the count of the response.
     * 
     * @return the count
     */
    public int getCount() {
	return count;
    }

    /**
     * Sets the count of the pagination object.
     * 
     * @param count
     *            the count
     */
    public void setCount(int count) {
	this.count = count;
    }

    /**
     * Returns the offset of the response.
     * 
     * @return the offset
     */
    public int getOffset() {
	return offset;
    }

    /**
     * Sets the offset of the pagination object.
     * 
     * @param offset
     *            the offset
     */
    public void setOffset(int offset) {
	this.offset = offset;
    }

    @Override
    public String toString() {
	return "Pagination [totalCount = " + totalCount + ", count = " + count + ", offset = " + offset + "]";
    }
	
}