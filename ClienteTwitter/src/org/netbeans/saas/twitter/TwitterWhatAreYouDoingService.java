/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.netbeans.saas.twitter;

import java.io.IOException;
import org.netbeans.saas.RestConnection;
import org.netbeans.saas.RestResponse;

/**
 * TwitterWhatAreYouDoingService Service
 *
 * @author Daniel
 */

public class TwitterWhatAreYouDoingService {

    /** Creates a new instance of TwitterWhatAreYouDoingService */
    public TwitterWhatAreYouDoingService() {
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch(Throwable th) {}
    }

    /**
     *
     * @param since
     * @param sinceId
     * @param page
     * @param count
     * @param format
     * @return an instance of RestResponse
     */
    public static RestResponse getUserTimeline(String since, String sinceId, String page, String count, String format) throws IOException {
        TwitterWhatAreYouDoingServiceAuthenticator.login();
        String[][] pathParams = new String[][]{{"{format}", format}};
        String[][] queryParams = new String[][]{{"since", since}, {"since_id", sinceId}, {"page", page}, {"count", count}};
        RestConnection conn = new RestConnection("http://twitter.com/statuses/user_timeline.{format}", pathParams, queryParams);
        sleep(1000);
        return conn.get(null);
    }
}
