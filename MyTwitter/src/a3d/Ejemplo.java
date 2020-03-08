package a3d;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public class Ejemplo {

    public static void main(String args[]) throws Exception {
        // The factory instance is re-useable and thread safe.
        Twitter twitter = new TwitterFactory().getInstance();
        twitter.setOAuthConsumer("c6dJOwlTu6u4CaPetHmxxw", "qHMOnsAZD8Wc7FKo2VPFB1Wu1T5U5Nfr1Cc4Jwuy64");
        RequestToken requestToken = twitter.getOAuthRequestToken();
        AccessToken accessToken = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (null == accessToken) {
            System.out.println("Open the following URL and grant access to your account:");
            System.out.println(requestToken.getAuthorizationURL());
            System.out.print("Enter the PIN(if aviailable) or just hit enter.[PIN]:");
            String pin = br.readLine();
            try {
                if (pin.length() > 0) {
                    accessToken = twitter.getOAuthAccessToken(requestToken, pin);
                } else {
                    accessToken = twitter.getOAuthAccessToken();
                }
            } catch (TwitterException te) {
                if (401 == te.getStatusCode()) {
                    System.out.println("Unable to get the access token.");
                } else {
                    te.printStackTrace();
                }
            }
        }
        //persist to the accessToken for future reference.
        storeAccessToken(twitter.verifyCredentials().getId(), accessToken);
        Status status = twitter.updateStatus("Esta es una prueba de que funciona.");
        System.out.println("Successfully updated the status to [" + status.getText() + "].");
        System.exit(0);
    }

    private static void storeAccessToken(long useId, AccessToken accessToken) {
        //store accessToken.getToken()
        //store accessToken.getTokenSecret()
    }
}