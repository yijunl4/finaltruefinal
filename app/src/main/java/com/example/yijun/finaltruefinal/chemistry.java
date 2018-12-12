package com.example.yijun.finaltruefinal;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.view.View;
public class chemistry extends Activity {

    //what i did is to put everything and code in the activity, including questions, choices, and anwsers//
    //array is the String array of questinos, choicearray is the String array of choices. correctanwser is the char array of answer
    //youranwser will be recorded when the app is running, and at last the two char array will be compared//
    //and return the grade//
    private String[] array = {"While traveling, an airplane passenger placed a bag of potato chips in his checked luggage. When he opened the luggage, the bag had exploded and potato chips were everywhere in his luggage. Which gas law is this an example of?",
            "Consider the following compound: CH4, CH3CH3, CH3CH2Cl and CH3CH2OH, which one has the highest boiling point?",
            "To increase solubility of a gas into a liquid the most, then______.",
            "In a liquid, the energy required to increase the surface of the area by a unit amount is called___",
            "according to teh kinetic molecular theory, the pressure of a gas in a container will decrease if the _____",
            "Two moles of neon gas at 20.0 degree are heated to 350 degree while the volume is kept constant. The density of the gas____",
            "An approximation of absolute zero was made from an extrapolation of__",
            "Which of the following statements is true about Aluminum oxide: Al2O3",
            "In the current model of atom, it assumes that nearly all of an atom's mass is contained in a central nucleus, whereas most of an atom's volume is due to the space in which the atom's electron move around it. Before quantum mechanical models, the historic experiment that established this idea was",
            "Which of the following statement is false?"};
    private int questionnumber = 0;
    private String[] choicearray = {"Avogadro's Law", "Ideal Gas Law", "Charles's Law", "Boyle's Law",
            "CH4", "CH3CH3", "CH3CH2Cl", "CH3CH2OH",
            "decrease the temperature and lower the pressure",
            "increase the temperature and raise the pressure",
            "decrease the temperature and raise the pressure",
            "increase the temperature and lower the pressure",
            "dipole-dipole force",
            "surface tension",
            "hydrogen bonding",
            "viscosity",
            "number of collisions with the container wall increases",
            "number of moles of the gas increases",
            "temperature of the gas decreases",
            "volume of the container decreases",
            "decreases", "increases", "doubles", "remains the same",
            "V vs.1/T", "V vs. T", "n vs V", "P vs. 1/V",
            "Aluminum accounts for a higher mass precentage than oxygen",
            "oxygen accounts for higher mass percentage than aluminum",
            "Since aluminum has a higher average atomic mass than oxygen, it is expected to be the greater contirbutor towards the mass of the compound anywas.",
            "Since aluminum has a lower average atomic mass than aluminum, it is expected to be the lesser contirbutor towards the mass of the compound anywas.",
            "Millikan's oil drop experiment", "++Rutherford's gold foil experiment", "Thomson's cathode ray tube experiment", "Einstein's Photo-electric effect experiments",
            "An orbital can accommodate at most two electrons",
            "The spin quantum number of an electron must be either +1/2 or -1/2",
            "A 2p orbital is more penetrating than a 2S;i.e, 2p has a higher electron density near the nucleus and thus a 2p electron can penetrate into the cloud of a 1s orbital than a 2s electron can",
            "In the order of filling, the 6S orbital is filled before the 4f orbtital"};
    private char[] correctanswer = {'D','D','C','B','C','D','B','A','B','C'};
    private char[] youranswer = new char[array.length];
    private String toprinted;
    //above is the resoure used in coding, below is the items from layout//
    TextView chemquestion;
    TextView printed;
    RadioGroup choices;
    RadioButton choicea;
    RadioButton choiceb;
    RadioButton choicec;
    RadioButton choiced;
    Button next;
    TextView highest;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chemistry);
        //below is to set the group//
        MediaPlayer mp = null;
        printed = (TextView) findViewById(R.id.textView5);
        choices = (RadioGroup) findViewById(R.id.choices);
        choices.setOnCheckedChangeListener(listen);
        //below is the question and choices set//
        chemquestion = findViewById(R.id.question);
        chemquestion.setText(array[questionnumber]);
        choicea = findViewById(R.id.choicea);
        choicea.setText(choicearray[4 * questionnumber]);
        choiceb = findViewById(R.id.choiceb);
        choiceb.setText(choicearray[4 * questionnumber + 1]);
        choicec = findViewById(R.id.choicec);
        choicec.setText(choicearray[4 * questionnumber + 2]);
        choiced = findViewById(R.id.choiced);
        choiced.setText(choicearray[4 * questionnumber + 3]);
        //below is to set the next button//
        next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View V) {
                if (correctanswer[questionnumber] == youranswer[questionnumber]) {
                    playmusic(R.raw.correct);
                } else {
                    playmusic(R.raw.incorrect);
                }
                if (questionnumber >= array.length - 1) {
                    toprinted = "Your get " + getgrade() + " questions correct";
                    printed.setText(toprinted);
                    return;
                }
                questionnumber++;
                chemquestion.setText(array[questionnumber]);
                choicea.setText(choicearray[4 * questionnumber]);
                choiceb.setText(choicearray[4 * questionnumber + 1]);
                choicec.setText(choicearray[4 * questionnumber + 2]);
                choiced.setText(choicearray[4 * questionnumber + 3]);
                choices.clearCheck();

            }
        });
    }
    private RadioGroup.OnCheckedChangeListener listen=new RadioGroup.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            int id=	group.getCheckedRadioButtonId();
            switch (group.getCheckedRadioButtonId()) {
                case R.id.choicea:
                    youranswer[questionnumber] = 'A';
                    break;
                case R.id.choiceb:
                    youranswer[questionnumber] = 'B';
                    break;
                case R.id.choicec:
                    youranswer[questionnumber] = 'C';
                    break;
                case R.id.choiced:
                    youranswer[questionnumber] = 'D';
                    break;
            }
        }
    };
    public int getgrade() {
        int correct = 0;
        for (int i = 0; i < array.length; i++) {
            if (correctanswer[i] == youranswer[i]) {
                correct++;
            }
        }
        return correct;
    }
    public void playmusic(int mid) {
        mp = MediaPlayer.create(this, mid);
        mp.start();
    }
}
