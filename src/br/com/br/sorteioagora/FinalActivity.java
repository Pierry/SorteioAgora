package br.com.br.sorteioagora;

import utils.TypeFace;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.Fullscreen;
import com.googlecode.androidannotations.annotations.NoTitle;
import com.googlecode.androidannotations.annotations.UiThread;
import com.googlecode.androidannotations.annotations.ViewById;

@Fullscreen
@NoTitle
@EActivity(R.layout.fnal)
public class FinalActivity extends Activity {
	
	@ViewById
	TextView tvSorteio;
	
	@ViewById
	ImageButton btnIniciar;
	
	private int vencedor;
	private Bundle bundle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.AlterarFonte();
		
		bundle = getIntent().getExtras();
		
		vencedor = bundle.getInt("valor");
		this.SetarValor(String.valueOf(vencedor));
	}
	
	@UiThread
	public void SetarValor(String valor){
		tvSorteio.setText(valor);
	}
	
	@UiThread
	public void AlterarFonte(){
		TypeFace face = new TypeFace(this);
		tvSorteio.setTypeface(face.getFace());		
	}
	
	
	@Click
	public void btnIniciar(){
		Intent i = new Intent(this, MainActivity_.class);
		startActivity(i);
	}
}
