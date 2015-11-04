package com.example.final_project;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.util.Log;

/**
 * Created by tahseen0amin on 16/02/2014.
 */
public class ApiConnector {

	public Boolean uploadImageToserver(List<NameValuePair> params) {

		// URL for getting all customers
		String url = "http://192.168.0.103/final_project/insert_data.php";

		HttpEntity httpEntity = null;

		try {

			DefaultHttpClient httpClient = new DefaultHttpClient(); // Default
																	// HttpClient

			HttpPost httpPost = new HttpPost(url);
			httpPost.setEntity(new UrlEncodedFormEntity(params));

			HttpResponse httpResponse = httpClient.execute(httpPost);

			httpEntity = httpResponse.getEntity();
			String entityResponse = EntityUtils.toString(httpEntity);

			Log.e("Entity Response  : ", entityResponse);
			return true;

		} catch (ClientProtocolException e) {

			// Signals error in http protocol
			e.printStackTrace();

			// Log Errors Her

		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}
