package giphy.dao;

import java.io.IOException;

import giphy.http.Response;
import giphy.http.Request;

public interface RequestSender {
	
	/**
     * Sends the request and returns the received response.
     * 
     * @param request
     *            the request which will be send
     * @return the received response
     * @throws IOException
     *             if an error occurred
     */
    public Response sendRequest(Request request) throws IOException;
	
}