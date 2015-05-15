package com.raoul.walkfoframe.utils;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

public class DialogManager {
  private static ProgressDialog pDialog;
//  ProgressHUD mProgressHUD;

  /**
   * Function to display simple Alert Dialog
   * 
   * @param context - application context
   * @param title - alert dialog title
   * @param message - alert message
   * @param status - success/failure (used to set icon) - pass null if you don't want icon
   * */
  @SuppressWarnings("deprecation")
  public void showAlertDialog(Context context, String title, String message, Boolean status) {
    AlertDialog alertDialog = new AlertDialog.Builder(context).create();
    // Setting Dialog Title
    alertDialog.setTitle(title);
    // Setting Dialog Message
    alertDialog.setMessage(message);
    if (status != null)
      // Setting alert dialog icon
      /*
       * alertDialog .setIcon((status) ? R.drawable.success : R.drawable.fail);
       */
      // Setting OK Button
      alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {}
      });
    try {
      alertDialog.show();
    } catch (Exception e) {
      // TODO: handle exception
    }
    // Showing Alert Message

  }

  public void showProcessDialog(Context context, String title) {
    try {
      /*
       * pDialog = new ProgressDialog(context); pDialog.setMessage(title);
       * pDialog.setIndeterminate(false); pDialog.setCancelable(false); pDialog.show();
       */

//      mProgressHUD = ProgressHUD.show(context, title, true, true, new OnCancelListener() {
//
//        @Override
//        public void onCancel(DialogInterface dialog) {
//          mProgressHUD.dismiss();
//
//        }
//      });
    } catch (Exception e) {
      // TODO: handle exception
    }

  }

  public void stopProcessDialog() {
    /*
     * if (pDialog != null && pDialog.isShowing()) pDialog.dismiss();
     */

//    if (mProgressHUD != null && mProgressHUD.isShowing())
//      mProgressHUD.dismiss();

  }

}
