package zomwi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

/**
 * Ejemplo de uso de la libreria Twitter4J
 * @author Daniel Alvarez
 */
public class Principal {

    public static void main(String[] args) throws TwitterException, IOException {
        Twitter twitter = new TwitterFactory().getInstance();
        twitter.setOAuthConsumer("vNs8ajvFsB2b4fifxL25Zg", "XfnEN3SnsoxSLPToxxy2T8WLPDWQg4jIXk8KnZvZoc");
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
        Status status = twitter.updateStatus("Feliz Anio nuevo a todos...");
        System.out.println("Successfully updated the status to [" + status.getText() + "].");
        System.exit(0);
    }

    private static void storeAccessToken(long id, AccessToken accessToken) {
        
    }
}
