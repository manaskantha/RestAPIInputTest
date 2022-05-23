package com.apitest.APIInputTest;

import java.util.ArrayList;
import java.util.stream.Collectors;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class ProcessIncomingRequest {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String processRequest(String text, String subText){
        if(text == null || text.isEmpty() || subText == null || subText.isEmpty())
            throw new NullPointerException();

            ArrayList<Integer> respose = getCharPositions(text, subText);
            
            String listString = respose.stream().map(Object::toString)
                    .collect(Collectors.joining(", "));
            
            return listString;
    }
    
    public ArrayList<Integer> getCharPositions(String text, String subText){
        ArrayList<Integer> results =  new ArrayList<>();
        char[] inputChars = text.toCharArray();
        int subStrLength = subText.length();
        for(int i=0; i<inputChars.length; i++){
            if(i+subStrLength > inputChars.length)
                break;
            String subStrOfInput = text.substring(i, i+subStrLength);
            if(subStrOfInput.equalsIgnoreCase(subText)){
                results.add(i);
            }
        }
        return results;
    }
}
