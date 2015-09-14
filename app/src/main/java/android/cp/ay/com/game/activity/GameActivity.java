package android.cp.ay.com.game.activity;

import android.app.Dialog;
import android.content.Intent;
import android.cp.ay.com.game.MainApplication;
import android.cp.ay.com.game.enumclass.GameLevel;
import android.cp.ay.com.game.listener.WordClickListener;
import android.cp.ay.com.game.adapter.AnswerListAdapter;
import android.cp.ay.com.game.bean.ParagraphBean;
import android.cp.ay.com.game.R;
import android.cp.ay.com.game.bean.ScoreBean;
import android.cp.ay.com.game.bean.WordBean;
import android.cp.ay.com.game.db.table.ScoresTable;
import android.cp.ay.com.game.utils.Constant;
import android.cp.ay.com.game.utils.IndexedClickableSpan;
import android.cp.ay.com.game.utils.Utils;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

import java.util.ArrayList;


public class GameActivity extends AppCompatActivity implements WordClickListener, View.OnClickListener {


    private TextView text01TextView,text02TextView,text03TextView,text04TextView,text05TextView,
            text06TextView,text07TextView,text08TextView,text09TextView,text10TextView;
    private ArrayList<ParagraphBean>  paragraphList;
    private WordBean[] wordList;
    private Button submitButton;

    private TextView text01AnwserTextView,text02AnwserTextView,text03AnwserTextView,text04AnwserTextView,
            text05AnwserTextView,text06AnwserTextView,text07AnwserTextView,text08AnwserTextView,
            text09AnwserTextView,text10AnwserTextView;

    private MainApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {

            paragraphList = new ArrayList<ParagraphBean>();
            wordList = new WordBean[10];

            application = (MainApplication) getApplication();

            overridePendingTransition(R.anim.animation_enter,
                    R.anim.animation_leave);




            setContentView(R.layout.activity_game);

            UIInitialize();

            paragraphProcess();



            wordProcessLogic();


        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, getResources().getString(R.string.exception), Toast.LENGTH_LONG).show();
            callBack();
        }
    }

    /*
    process of paragraph text to sentences
     */
    private void paragraphProcess()  throws Exception {
        try {



            String[]sentenceHolder = application.SELECTED_PARAGRAPH.split("\\.");

            for (int i = 0; i < 10; i++) {

                ParagraphBean dataBean = new ParagraphBean();
                dataBean.setText(sentenceHolder[i]);
                paragraphList.add(dataBean);
            }


//            Toast.makeText(this,"list size : "+paragraphList.size(),Toast.LENGTH_LONG).show();

        }catch (Exception e){
            throw  e;
        }
    }

    /**
     * word process method
     * @throws Exception
     */
    private void wordProcessLogic() throws Exception {
        try {



            for (int i = 0; i <paragraphList.size() ; i++) {

                SpannableStringBuilder ssb = new SpannableStringBuilder();

                String textVal = paragraphList.get(i).getText();

                String textHolder[] = textVal.split(" ");

                int wordLength = 0;
                int wordPos = 0;

                wordPos    =  getWordPos(textHolder, application.GAME_LEVEL.getWordCount());
                wordLength =  textHolder[wordPos].length();



                WordBean wordBean = new WordBean();
                wordBean.setCorrectPos(i);
                wordBean.setWord(textHolder[wordPos]);

                paragraphList.get(i).setWordBean(wordBean);

                int aswIndex = getAnswerListPos();

                wordList[aswIndex] = wordBean;

                textHolder[wordPos] = i+"@"+wordPos+"@ ______________ ";

                int firstLength = 0 ;

                if (wordPos > 9){
                    wordLength = 15;
                }else if(wordPos > 99){
                    wordLength = 16;
                }else{
                    wordLength = 17;
                }

                StringBuilder printString = new StringBuilder();



                for (int j = 0; j < textHolder.length; j++) {

                    if (j == wordPos){

                        firstLength =   ssb.length();

                        printString.append(textHolder[j]+" ");
                        ssb.append(textHolder[j].split("@")[2]+" ");

                    }else{

                        printString.append(textHolder[j]+" ");
                        ssb.append(textHolder[j]+" ");

                    }

                }

                String tt = printString.toString();


                int endPos = (firstLength + wordLength);


                ssb.setSpan(new IndexedClickableSpan(firstLength, endPos, this, tt, this),
                        firstLength, endPos, Spanned.SPAN_POINT_MARK);

                updateSentenceUI(ssb,i);



            }


        } catch (Exception e) {
            throw e;
        }
    }

    /*
    update ui according to sentences
     */
    private void updateSentenceUI(SpannableStringBuilder ssb,int place)throws Exception{
        try {

            switch (place){
                case 0:
                    text01TextView.setText(ssb);
                    text01TextView.setMovementMethod(LinkMovementMethod.getInstance());
                    text01TextView.setHighlightColor(Color.TRANSPARENT);

                    break;

                case 1:

                    text02TextView.setText(ssb);
                    text02TextView.setMovementMethod(LinkMovementMethod.getInstance());
                    text02TextView.setHighlightColor(Color.TRANSPARENT);

                    break;

                case 2:

                    text03TextView.setText(ssb);
                    text03TextView.setMovementMethod(LinkMovementMethod.getInstance());
                    text03TextView.setHighlightColor(Color.TRANSPARENT);

                    break;

                case 3:

                    text04TextView.setText(ssb);
                    text04TextView.setMovementMethod(LinkMovementMethod.getInstance());
                    text04TextView.setHighlightColor(Color.TRANSPARENT);

                    break;

                case 4:

                    text05TextView.setText(ssb);
                    text05TextView.setMovementMethod(LinkMovementMethod.getInstance());
                    text05TextView.setHighlightColor(Color.TRANSPARENT);

                    break;

                case 5:

                    text06TextView.setText(ssb);
                    text06TextView.setMovementMethod(LinkMovementMethod.getInstance());
                    text06TextView.setHighlightColor(Color.TRANSPARENT);

                    break;

                case 6:

                    text07TextView.setText(ssb);
                    text07TextView.setMovementMethod(LinkMovementMethod.getInstance());
                    text07TextView.setHighlightColor(Color.TRANSPARENT);

                    break;

                case 7:

                    text08TextView.setText(ssb);
                    text08TextView.setMovementMethod(LinkMovementMethod.getInstance());
                    text08TextView.setHighlightColor(Color.TRANSPARENT);

                    break;

                case 8:

                    text09TextView.setText(ssb);
                    text09TextView.setMovementMethod(LinkMovementMethod.getInstance());
                    text09TextView.setHighlightColor(Color.TRANSPARENT);

                    break;

                case 9:

                    text10TextView.setText(ssb);
                    text10TextView.setMovementMethod(LinkMovementMethod.getInstance());
                    text10TextView.setHighlightColor(Color.TRANSPARENT);

                    break;


            }





        }catch (Exception e){
            throw  e;
        }
    }

    private int getAnswerListPos() throws Exception{
        try {

            int ran = Utils.getRandomNumber();

            if (ran < 0){
                ran = ran* -1;
            }

            int index = ran%10;


            if (wordList[index] != null ){
                return getAnswerListPos();
            }else{
                return index;
            }

        }catch (Exception e){
            throw e;
        }
    }

    /**
     * get random value for remove word
     * @return int word place
     * @throws Exception
     */
    private int getWordPos(String textArray[],int minCount) throws Exception {
        try {

            int ran = Utils.getRandomNumber();

            if (ran < 0){
                ran = ran* -1;
            }

            int returnVal = ran % (textArray.length);

            if (textArray[returnVal].length() < minCount){

                return getWordPos(textArray, minCount);

            }else{

                return returnVal;

            }


        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Initialize UI Component
     * @throws Exception
     */
    private void UIInitialize() throws Exception {
        try {

            text01TextView = (TextView) findViewById(R.id.text01TextView);
            text02TextView = (TextView) findViewById(R.id.text02TextView);
            text03TextView = (TextView) findViewById(R.id.text03TextView);
            text04TextView = (TextView) findViewById(R.id.text04TextView);
            text05TextView = (TextView) findViewById(R.id.text05TextView);
            text06TextView = (TextView) findViewById(R.id.text06TextView);
            text07TextView = (TextView) findViewById(R.id.text07TextView);
            text08TextView = (TextView) findViewById(R.id.text08TextView);
            text09TextView = (TextView) findViewById(R.id.text09TextView);
            text10TextView = (TextView) findViewById(R.id.text10TextView);




            text01AnwserTextView = (TextView) findViewById(R.id.text01AnwserTextView);
            text02AnwserTextView = (TextView) findViewById(R.id.text02AnwserTextView);
            text03AnwserTextView = (TextView) findViewById(R.id.text03AnwserTextView);
            text04AnwserTextView = (TextView) findViewById(R.id.text04AnwserTextView);
            text05AnwserTextView = (TextView) findViewById(R.id.text05AnwserTextView);
            text06AnwserTextView = (TextView) findViewById(R.id.text06AnwserTextView);
            text07AnwserTextView = (TextView) findViewById(R.id.text07AnwserTextView);
            text08AnwserTextView = (TextView) findViewById(R.id.text08AnwserTextView);
            text09AnwserTextView = (TextView) findViewById(R.id.text09AnwserTextView);
            text10AnwserTextView = (TextView) findViewById(R.id.text10AnwserTextView);


            submitButton  =  (Button)findViewById(R.id.submitButton);

            submitButton.setOnClickListener(this);



        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * general back action
     */
    private void callBack() {
        finish();
    }

    @Override
    public void onBackPressed() {
        callBack();
    }


    @Override
    public void onWordClick(String word) {

        try {

            String num[] = word.split("@");

            int pos = Integer.parseInt(num[0]);
            int wordNewpos = Integer.parseInt(num[1]);



            showWordDialog(pos,wordNewpos);

        }catch (Exception e){
            e.printStackTrace();
            callBack();
        }



    }

    private void showWordDialog(final int pos,final int wordNewPos) {

        try {

            final Dialog dialog = new Dialog(this,R.style.Dialog_No_Border);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.view_word_select_dialog);


            String test = "";

            ListView answerListView = (ListView) dialog.findViewById(R.id.answerListView);

            AnswerListAdapter adapter = new AnswerListAdapter(this,wordList);
            answerListView.setAdapter(adapter);

            answerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                    paragraphList.get(pos).getWordBean().setAnswerPos(wordList[i].getCorrectPos());


                    if (pos == 0){

                        text01AnwserTextView.setText(wordList[i].getWord());

                    }else if (pos == 1){

                        text02AnwserTextView.setText(wordList[i].getWord());

                    }else if (pos == 2){

                        text03AnwserTextView.setText(wordList[i].getWord());

                    }else if (pos == 3){

                        text04AnwserTextView.setText(wordList[i].getWord());

                    }else if (pos == 4){

                        text05AnwserTextView.setText(wordList[i].getWord());

                    }else if (pos == 5){

                        text06AnwserTextView.setText(wordList[i].getWord());


                    }else if (pos == 6){

                        text07AnwserTextView.setText(wordList[i].getWord());


                    }else if (pos == 7){

                        text08AnwserTextView.setText(wordList[i].getWord());


                    }else if (pos == 8){

                        text09AnwserTextView.setText(wordList[i].getWord());


                    }else if (pos == 9){

                        text10AnwserTextView.setText(wordList[i].getWord());

                    }

                    dialog.dismiss();
                }

            });

            Button closeButton = (Button) dialog.findViewById(R.id.closeButton);
            closeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    dialog.dismiss();
                }
            });

            dialog.show();



        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        try {
            switch (view.getId()){

                case R.id.submitButton :

                    int score = 0;

                    if (application.GAME_LEVEL == GameLevel.LEVEL_02){

                        score = score + application.GENRAL_SCORE;

                    }

                    for (int i = 0; i < paragraphList.size(); i++) {

                        ParagraphBean bean = paragraphList.get(i);
                        WordBean wordBean = bean.getWordBean();



                        if (wordBean.getCorrectPos() == wordBean.getAnswerPos()){

                            score ++;

                        }else{

                            boolean isSameAnswerExist = false;

                            for (int j = 0; j <wordList.length ; j++) {

                                WordBean tempBean = wordList[j];


                                if (wordBean.getCorrectPos() != tempBean.getCorrectPos())   {

                                    if (wordBean.getWord().equals(tempBean.getWord())){

                                        if (tempBean.getCorrectPos() == wordBean.getAnswerPos()){
                                            isSameAnswerExist = true;
                                        }
                                    }

                                }
                            }

                            if (isSameAnswerExist){
                                score ++;
                            }
                        }


                    }

                    Toast.makeText(this,  "SCORE : "+score, Toast.LENGTH_SHORT).show();

                    ScoresTable scoresTable = new ScoresTable(this);
                    int currentHighScore = scoresTable.getTopScore();


                    if (currentHighScore <= score){
                        showHighScoreAlert(score);
                    }else{
                        showResultAlert("",score,false);
                    }





                    break;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }





    public void showResultAlert(String title, final int score,boolean isHighScore) throws Exception {
        try {
            final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    this);


            LayoutInflater inflater = this.getLayoutInflater();
            View dialogView = inflater.inflate(R.layout.view_show_result, null);
            alertDialogBuilder.setView(dialogView);

            final AlertDialog alertDialog = alertDialogBuilder.create();


            alertDialog.show();


            Button resultCancelButton = (Button)dialogView.findViewById(R.id.resultCancelButton);
            resultCancelButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    application.GAME_LEVEL = GameLevel.LEVEL_01;
                    application.GENRAL_SCORE = 0;

                    alertDialog.dismiss();

                    GameActivity.this.finish();
                }
            });



            Button tryAgainButton = (Button)dialogView.findViewById(R.id.tryAgainButton);
            tryAgainButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    application.GAME_LEVEL = GameLevel.LEVEL_01;
                    application.GENRAL_SCORE = 0;

                    alertDialog.dismiss();

                    Intent callTryAgain = new Intent(GameActivity.this,GameInitActivity.class);
                    startActivity(callTryAgain);
                    GameActivity.this.finish();


                }
            });




            Button netLevelButton = (Button) dialogView.findViewById(R.id.netLevelButton);

            if (application.GAME_LEVEL == GameLevel.LEVEL_02){

                netLevelButton.setVisibility(View.GONE);
                tryAgainButton.setVisibility(View.GONE);
                resultCancelButton.setText(getResources().getString(R.string.finish));

            }else{

                netLevelButton.setVisibility(View.VISIBLE);
                tryAgainButton.setVisibility(View.VISIBLE);
                resultCancelButton.setText(getResources().getString(R.string.cancel));

            }

            netLevelButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    application.GAME_LEVEL = GameLevel.LEVEL_02;
                    application.GENRAL_SCORE = score;

                    alertDialog.dismiss();

                    Intent callTryAgain = new Intent(GameActivity.this,GameInitActivity.class);
                    startActivity(callTryAgain);
                    GameActivity.this.finish();


                }
            });



            TextView scoreTextView = (TextView) dialogView.findViewById(R.id.scoreTextView);
            scoreTextView.setText(String.valueOf(score));



            Shimmer shimmer = new Shimmer();

            ShimmerTextView highScoreTextView = (ShimmerTextView) dialogView.findViewById(R.id.highScoreTextView);
            shimmer.start(highScoreTextView);

            if (isHighScore){
                highScoreTextView.setVisibility(View.VISIBLE);
            }else{
                highScoreTextView.setVisibility(View.GONE);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }






    public void showHighScoreAlert(final int score) throws Exception {
        try {
            final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    this);


            LayoutInflater inflater = this.getLayoutInflater();
            View dialogView = inflater.inflate(R.layout.view_high_score, null);
            alertDialogBuilder.setView(dialogView);

            final AlertDialog alertDialog = alertDialogBuilder.create();


            alertDialog.show();

            final EditText highScoreNameEditText = (EditText) dialogView.findViewById(R.id.highScoreNameEditText);

            Button highSocreOkButton = (Button) dialogView.findViewById(R.id.highSocreOkButton);
            highSocreOkButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    try {
                        String name = highScoreNameEditText.getText().toString();

                        if (name.isEmpty()) {

                            Toast.makeText(GameActivity.this, getResources().getString(R.string.name_empty),
                                    Toast.LENGTH_LONG).show();

                        } else {

                            ScoreBean bean = new ScoreBean();

                            bean.setLevel(application.GAME_LEVEL.getIndex());
                            bean.setScore(score);
                            bean.setName(name);

                            ScoresTable table = new ScoresTable(GameActivity.this);
                            table.insertContact(bean);

                            alertDialog.cancel();

                            showResultAlert("", score, true);


                        }


                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });




            TextView scorebTextView = (TextView) dialogView.findViewById(R.id.scorebTextView);
            scorebTextView.setText(String.valueOf(score));


            Animation textAni = AnimationUtils.loadAnimation(this, R.anim.text_animation);


            TextView highScorebTextView = (TextView) findViewById(R.id.highScorebTextView);

            highScorebTextView.startAnimation(textAni);




        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
            throw e;
        }
    }
}
