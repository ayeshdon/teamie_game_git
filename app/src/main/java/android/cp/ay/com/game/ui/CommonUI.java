package android.cp.ay.com.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.cp.ay.com.game.R;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by ayesh on 9/10/15.
 */
public class CommonUI {

    private static CommonUI instace;


    public static CommonUI getInstace() {

        if (instace == null) {
            instace = new CommonUI();
        }

        return instace;
    }


    public void showAlert(String title, String msg, Context context) throws Exception {
        try {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    context);

            alertDialogBuilder.setTitle(title);


            alertDialogBuilder
                    .setMessage(msg)
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alertDialog = alertDialogBuilder.create();

            alertDialog.show();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }




//    public void setCommonActionBar(ActionBar customActionBar,Context context,boolean isHomeNavEnable,
//                                   boolean isShowHeaderImg,String title,boolean isHomeUp) throws Exception {
//        try {
//
//            customActionBar.setDisplayHomeAsUpEnabled(false);
//            customActionBar.setDisplayShowCustomEnabled(true);
//            customActionBar.setDisplayUseLogoEnabled(true);
//            customActionBar.setDisplayShowTitleEnabled(true);
//
//            if (isHomeNavEnable) {
//
//                if (isHomeUp) {
//
//                    customActionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM |
//                            ActionBar.DISPLAY_HOME_AS_UP|ActionBar.DISPLAY_SHOW_HOME);
//
//
//                }else{
//                    customActionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM |
//                            ActionBar.DISPLAY_SHOW_HOME);
//                }
//            }else{
//                customActionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM );
//            }
//
//
//            customActionBar.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.actionbar));
//
//
//
//            LayoutInflater inflator = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            View v = inflator.inflate(R.layout.actionbar_layout, null);
//
//            TextView actionBarTextView  = (TextView)  v.findViewById(R.id.actionBarTextView);
//
//
//
//
//            actionBarTextView.setText(title);
//
//
//
//
//
//            customActionBar.setCustomView(v);
//
//        } catch (Exception e) {
//            throw e;
//        }
//    }

}
