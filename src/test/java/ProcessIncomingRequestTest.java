import org.junit.Assert;
import org.junit.Test;

import com.apitest.APIInputTest.ProcessIncomingRequest;

import java.util.ArrayList;

public class ProcessIncomingRequestTest {

    @Test
    public void check_NullInput(){
        ProcessIncomingRequest processIncomingRequest = new ProcessIncomingRequest();
        Assert.assertThrows(NullPointerException.class, () ->  processIncomingRequest.processRequest(null, null));
    }

    @Test
    public void check_EmptyInput(){
        ProcessIncomingRequest processIncomingRequest = new ProcessIncomingRequest();
        Assert.assertThrows(NullPointerException.class, () ->  processIncomingRequest.processRequest("", ""));
    }

    @Test
    public void check_ResultSize_sameCharsIn_InputArray(){
        ProcessIncomingRequest processIncomingRequest = new ProcessIncomingRequest();
        ArrayList<Integer> results = processIncomingRequest.getCharPositions("aaaaa", "aa");

        Assert.assertEquals(4, results.size());
    }

    @Test
    public void checkValue_sameCharsIn_InputArray(){
        ProcessIncomingRequest processIncomingRequest = new ProcessIncomingRequest();
        ArrayList<Integer> results = processIncomingRequest.getCharPositions("aaaaa", "aa");

        int i=0;
        for(Integer resultPosition: results){
            Assert.assertTrue(i==resultPosition);
            i++;
        }
    }

    @Test
    public void checkValue_diffChars_MultiOccurrences_InputArray(){
        ProcessIncomingRequest processIncomingRequest = new ProcessIncomingRequest();
        ArrayList<Integer> results = processIncomingRequest.getCharPositions("abccabcdebcabf", "aa");

        int i=0;
        for(Integer resultPosition: results){
            if(i==0){
                Assert.assertTrue(i==resultPosition);
            } else{
                Assert.assertTrue(4==resultPosition);
            }
            i++;
        }
    }

    @Test
    public void checkValue_caseSensitive_InputArray(){
        ProcessIncomingRequest processIncomingRequest = new ProcessIncomingRequest();
        ArrayList<Integer> results = processIncomingRequest.getCharPositions("BXyaCdRFncDrxX", "cDR");

        int i=0;
        for(Integer resultPosition: results){
            if(i==0){
                Assert.assertTrue(4==resultPosition);
            } else{
                Assert.assertTrue(9==resultPosition);
            }
            i++;
        }
    }


}
