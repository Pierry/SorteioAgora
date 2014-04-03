package br.com.br.sorteioagora;

import java.util.Random;

import utils.TypeFace;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.googlecode.androidannotations.annotations.Background;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.Fullscreen;
import com.googlecode.androidannotations.annotations.NoTitle;
import com.googlecode.androidannotations.annotations.UiThread;
import com.googlecode.androidannotations.annotations.ViewById;

@Fullscreen
@NoTitle
@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {

	@ViewById
	EditText etSorteio;
	
	@ViewById
	TextView tvSorteio;
	
	@ViewById
	ImageButton btnIniciar;
	
	private int vencedor;
	private Intent finals;
	private Bundle bundle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.AlterarFonte();
		
		finals = new Intent(this, FinalActivity_.class);
		bundle = new Bundle();
	}


	@Background
	public void Sleep(ProgressDialog dialog){		
		try {
			Thread.sleep(1000);			
			
			if (etSorteio.getText().toString().equals("")){
				vencedor = 100;	
			} else {
				vencedor = Integer.valueOf(etSorteio.getText().toString());
			}
			
			Random randon = new Random();
						
			vencedor = randon.nextInt(vencedor - 0 + 1) + 0; 
			
			dialog.dismiss();
			IniciaraActivity();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			dialog.dismiss();
		}
	}
	
	@UiThread
	public void IniciaraActivity(){
		bundle.putInt("valor", vencedor);
		finals.putExtras(bundle);
		startActivity(finals);
	}
	
	@UiThread
	public void AlterarFonte(){
		TypeFace face = new TypeFace(this);
		tvSorteio.setTypeface(face.getFace());
		etSorteio.setTypeface(face.getFace());
	}
	
	
	@Click
	public void btnIniciar(){
		ProgressDialog dialog = ProgressDialog.show(this, "", "Carreganndo...");
		dialog.setCancelable(true);		
		this.Sleep(dialog);
	}
}
