package com.example.final_project;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;



public class HowToApply extends Activity {
	
	 ProgressBar pb;
	    Dialog dialog;
	    int downloadedSize = 0;
	    int totalSize = 0;
	    TextView cur_val;
	    String dwnload_file_path = "http://10.53.175.43/Final_project/toufik_ahmed_emon_cv.pdf";
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.how_to_apply);

		Button b = (Button) findViewById(R.id.btnDownload);
        b.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                 showProgress(dwnload_file_path);
                     
                    new Thread(new Runnable() {
                        public void run() {
                             downloadFile();
                        }
                      }).start();
            }
        });
    }
         
    void downloadFile(){
         
        try {
            URL url = new URL(dwnload_file_path);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
 
            urlConnection.setRequestMethod("GET");
            urlConnection.setDoOutput(true);
 
            //connect
            urlConnection.connect();
 
            //set the path where we want to save the file           
            File SDCardRoot = Environment.getExternalStorageDirectory(); 
            //create a new file, to save the <span id="IL_AD2" class="IL_AD">downloaded</span> file 
            File file = new File(SDCardRoot,"downloaded_file.pdf");
  
            FileOutputStream fileOutput = new FileOutputStream(file);
 
            //Stream used for reading the data from the internet
            InputStream inputStream = urlConnection.getInputStream();
 
            //this is the total size of the file which we are downloading
            totalSize = urlConnection.getContentLength();
 
            runOnUiThread(new Runnable() {
                public void run() {
                    pb.setMax(totalSize);
                }               
            });
             
            //create a buffer...
            byte[] buffer = new byte[1024];
            int bufferLength = 0;
 
            while ( (bufferLength = inputStream.read(buffer)) > 0 ) {
                fileOutput.write(buffer, 0, bufferLength);
                downloadedSize += bufferLength;
                // update the progressbar //
                runOnUiThread(new Runnable() {
                    public void run() {
                        pb.setProgress(downloadedSize);
                        float per = ((float)downloadedSize/totalSize) * 100;
                        cur_val.setText("Downloaded " + downloadedSize + "KB / " + totalSize + "KB (" + (int)per + "%)" );
                    }
                });
            }
            //close the output stream when complete //
            fileOutput.close();
            runOnUiThread(new Runnable() {
                public void run() {
                    // pb.dismiss(); // if you want close it..
                }
            });         
         
        } catch (final MalformedURLException e) {
            showError("Error : MalformedURLException " + e);        
            e.printStackTrace();
        } catch (final IOException e) {
            showError("Error : IOException " + e);          
            e.printStackTrace();
        }
        catch (final Exception e) {
            showError("Error : Please check your internet connection " + e);
        }       
    }
     
    void showError(final String err){
        runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(HowToApply.this, err, Toast.LENGTH_LONG).show();
            }
        });
    }
     
    void showProgress(String file_path){
        dialog = new Dialog(HowToApply.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.download_progress);
        dialog.setTitle("Download Progress");
 
        TextView text = (TextView) dialog.findViewById(R.id.tv1);
        text.setText("Downloading file from ... " + file_path);
        cur_val = (TextView) dialog.findViewById(R.id.cur_pg_tv);
        cur_val.setText("Starting download...");
        dialog.show();
         
        pb = (ProgressBar)dialog.findViewById(R.id.progress_bar);
        pb.setProgress(0);
        pb.setProgressDrawable(getResources().getDrawable(R.drawable.green_progress));  
    }
}