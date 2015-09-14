package android.cp.ay.com.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

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


}
