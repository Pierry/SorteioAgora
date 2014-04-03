package utils;

import android.content.Context;
import android.graphics.Typeface;

public class TypeFace {

	private Typeface face;
	
	public TypeFace (Context context){
		face = Typeface.createFromAsset(context.getAssets(), "robotolight.ttf");
	}
	
	public Typeface getFace(){
		return face;
	}
	
}
