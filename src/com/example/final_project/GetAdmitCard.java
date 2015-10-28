package com.example.final_project;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GetAdmitCard extends Activity {

	Button b;
	EditText edtMobileNumber, edtPinNumber;
	TextView tv;
	HttpPost httppost;
	StringBuffer buffer;
	HttpResponse response;
	HttpClient httpclient;
	List<NameValuePair> nameValuePairs;
	ProgressDialog dialog = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.get_admit_card);
		b = (Button) findViewById(R.id.button1);
		edtMobileNumber = (EditText) findViewById(R.id.edtMobileNumber);
		edtPinNumber = (EditText) findViewById(R.id.edtPinNumber);
		tv = (TextView) findViewById(R.id.tv);

		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog = ProgressDialog.show(GetAdmitCard.this, "",
						"Validating user...", true);
				new Thread(new Runnable() {
					public void run() {
						login();
					}
				}).start();
			}
		});
	}

	void login() {
		try {

			httpclient = new DefaultHttpClient();
			httppost = new HttpPost(
					"http://10.54.145.82/Final_project/login.php"); // make sure
																	// the url
																	// is
																	// correct.
			// add your data
			nameValuePairs = new ArrayList<NameValuePair>(2);
			// Always use the same variable name for posting i.e the android
			// side variable name and php side variable name should be similar,
			nameValuePairs.add(new BasicNameValuePair("payment_id",
					edtMobileNumber.getText().toString())); // $Edittext_value
																	// =
																	// $_POST['Edittext_value'];
			nameValuePairs.add(new BasicNameValuePair("payment_pin", edtPinNumber
					.getText().toString()));
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			// Execute HTTP Post Request
			response = httpclient.execute(httppost);

			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			final String response = httpclient.execute(httppost,
					responseHandler);
			System.out.println("Response : " + response);
			runOnUiThread(new Runnable() {
				public void run() {
					tv.setText("Response from PHP : " + response);
					dialog.dismiss();
				}
			});

			if (response.equalsIgnoreCase("User Found")) {
				runOnUiThread(new Runnable() {
					public void run() {
						Toast.makeText(GetAdmitCard.this, "Login Success",
								Toast.LENGTH_SHORT).show();
					}
				});

				startActivity(new Intent(GetAdmitCard.this,
						AdmitCardClass.class));
			} else {
				showAlert();
			}

		} catch (Exception e) {
			dialog.dismiss();
			System.out.println("Exception : " + e.getMessage());
		}
	}

	public void showAlert() {
		GetAdmitCard.this.runOnUiThread(new Runnable() {
			public void run() {
				AlertDialog.Builder builder = new AlertDialog.Builder(
						GetAdmitCard.this);
				builder.setTitle("Login Error.");
				builder.setMessage("User not Found.")
						.setCancelable(false)
						.setPositiveButton("OK",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int id) {
									}
								});
				AlertDialog alert = builder.create();
				alert.show();
			}
		});
	}
}