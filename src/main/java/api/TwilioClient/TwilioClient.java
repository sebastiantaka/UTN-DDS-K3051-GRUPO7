package api.TwilioClient;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import com.twilio.Twilio;
import com.twilio.exception.AuthenticationException;
import com.twilio.exception.TwilioException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class TwilioClient {
	
	private static final String ACCOUNT_SID = "AC4a0fa540e813f807a23d85241ffd20bd";
	  private static final String AUTH_TOKEN = "f7d2b10640bc3f95f2df6fd27f64b983";

	 public void sendMessage() throws AuthenticationException, TwilioException { 
	    
		 Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

	     Message message = Message.creator(
	         new PhoneNumber("+5492227447621"),
	         new PhoneNumber("+54 11 6718-8487"),
	         "a"
	     ).create();
	  }
	
	
}
