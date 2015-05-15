package com.raoul.walkfoframe.utils;

import android.view.View;
import android.widget.ImageView;

public class VisivilityHelper {
	private static ImageView Arrow1;
	private static ImageView Arrow5;
	private static ImageView Arrow2;
	private static ImageView Arrow3;
	private static ImageView Arrow4;

	public static void setVisivilty(ImageView mArrow1, ImageView mArrow2,
			ImageView mArrow3, ImageView mArrow4, ImageView mArrow5,
			int position) {
		Arrow1 = mArrow1;
		Arrow2 = mArrow2;
		Arrow3 = mArrow3;
		Arrow4 = mArrow4;
		Arrow5 = mArrow5;

		switch (position) {
		case 0:
			Arrow1.setVisibility(View.VISIBLE);
			Arrow2.setVisibility(View.INVISIBLE);
			Arrow3.setVisibility(View.INVISIBLE);
			Arrow4.setVisibility(View.INVISIBLE);
			Arrow5.setVisibility(View.INVISIBLE);
			break;
		case 1:
			Arrow1.setVisibility(View.INVISIBLE);
			Arrow2.setVisibility(View.VISIBLE);
			Arrow3.setVisibility(View.INVISIBLE);
			Arrow4.setVisibility(View.INVISIBLE);
			Arrow5.setVisibility(View.INVISIBLE);
			break;
		case 2:
			Arrow1.setVisibility(View.INVISIBLE);
			Arrow2.setVisibility(View.INVISIBLE);
			Arrow3.setVisibility(View.VISIBLE);
			Arrow4.setVisibility(View.INVISIBLE);
			Arrow5.setVisibility(View.INVISIBLE);
			break;
		case 3:
			Arrow1.setVisibility(View.INVISIBLE);
			Arrow2.setVisibility(View.INVISIBLE);
			Arrow3.setVisibility(View.INVISIBLE);
			Arrow4.setVisibility(View.VISIBLE);
			Arrow5.setVisibility(View.INVISIBLE);
			break;
		case 4:
			Arrow1.setVisibility(View.INVISIBLE);
			Arrow2.setVisibility(View.INVISIBLE);
			Arrow3.setVisibility(View.INVISIBLE);
			Arrow4.setVisibility(View.INVISIBLE);
			Arrow5.setVisibility(View.VISIBLE);
			break;
		default:
			break;
		}

	}
}
