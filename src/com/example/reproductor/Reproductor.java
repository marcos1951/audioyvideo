package com.example.reproductor;

import android.support.v7.app.ActionBarActivity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;


public class Reproductor extends ActionBarActivity implements OnClickListener {

	
	Button botonReproducir, botonParar;
	Button botonReproducirVideo, botonPararVideo;
	MediaPlayer mp;
	VideoView vv;
	int bandera;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor);
    
        
        botonReproducir = (Button)findViewById(R.id.btnreproducir);
        botonParar = (Button)findViewById(R.id.btnparar);
        botonReproducir.setOnClickListener(this);
        botonParar.setOnClickListener(this);
        
        botonReproducirVideo = (Button)findViewById(R.id.btnreproducirvideo);
        botonPararVideo = (Button)findViewById(R.id.btnpararvideo);
        botonReproducirVideo.setOnClickListener(this);
        botonPararVideo.setOnClickListener(this);
    
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.reproductor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	
		switch(v.getId()){
		//audio
		case R.id.btnreproducir:
			mp = MediaPlayer.create(this, R.raw.canguro);
			mp.start();
			botonReproducir.setEnabled(false);
			botonParar.setEnabled(true);
		break;
		
		case R.id.btnparar:
			mp.stop();
			botonParar.setEnabled(false);
			botonReproducir.setEnabled(true);
			break;
			//video
		case R.id.btnreproducirvideo:
			
			Uri path = Uri.parse("android.resource://com.example.reproductor/"+ R.raw.video);

			MediaController mc = new MediaController(this);   	
			        vv.setMediaController(mc);
			        vv.setVideoURI(path);
			        vv.start();

		break;
		
		
		
		
		}
		
		
		
		
	}
}
