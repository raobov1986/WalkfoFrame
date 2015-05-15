package com.raoul.walkfoframe.async;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.raoul.walkfoframe.model.WOFCouponCat;
import com.raoul.walkfoframe.model.WOFCoupons;
import com.raoul.walkfoframe.web.DynamoDBManager;

import java.util.List;

public class GetCoupons extends AsyncTask<Void, Void, Void> {
	
	public interface OnGetCouponsFinished {
		void onCouponsDownloaded(List<WOFCoupons> coupons, List<WOFCouponCat> categories);
		void onCouponsDownloadError();
	}
	
	private Context context;
	private ProgressDialog dialog;
	private List<WOFCoupons> coupons;
	private List<WOFCouponCat> categories;
	private OnGetCouponsFinished listener;
	
	public GetCoupons(Context context, OnGetCouponsFinished listener) {
		this.context = context;
		this.listener = listener;
		this.coupons = null;
		this.categories = null;
	}
	
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		this.dialog = new ProgressDialog(this.context);
		this.dialog.setCancelable(false);
		this.dialog.setMessage("Getting coupons, please wait...");
		this.dialog.show();
	}

	@Override
	protected Void doInBackground(Void... params) {
		this.coupons = DynamoDBManager.GetWofCoupons();
		this.categories = DynamoDBManager.GetWofCouponsCategories();
		return null;
	}

	@Override
	protected void onPostExecute(Void result) {
		super.onPostExecute(result);
		if (this.dialog != null) {
			this.dialog.dismiss();
			this.dialog = null;
		}
		
		this.context = null;
		
		if (this.listener == null) return;
		
		if (this.coupons != null && this.categories != null) {
			this.listener.onCouponsDownloaded(this.coupons, this.categories);
			return;
		} 
		
		this.listener.onCouponsDownloadError();
	}
}