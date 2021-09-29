package com.example.ta_prog_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class page_4 extends AppCompatActivity {

    private Person person;
    private static final String TAG = "Page_4 Stat :";
    private TextView nom, question_1,question_2,question3,question4,question5,question6;
    private TextView result1, reponse2,reponse3,reponse4,reponse5,reponse6;
    private TextView conseil_1,conseil2,conseil3,conseil4,conseil5,conseil6;
    boolean clicked_5 = false;
    boolean clicked_6 = false;
    boolean clicked_7 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page4);
        nom = findViewById(R.id.nom);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        question_1 = findViewById(R.id.question_1);
        question_2 = findViewById(R.id.question_2);
        question3 = findViewById(R.id.question3);
        question4 = findViewById(R.id.question4);
        question5 = findViewById(R.id.question5);
        question6 = findViewById(R.id.question6);
        result1 = findViewById(R.id.result1);
        reponse2 = findViewById(R.id.reponse2);
        reponse3 = findViewById(R.id.reponse3);
        reponse4 = findViewById(R.id.reponse4);
        reponse5 = findViewById(R.id.reponse5);
        reponse6 = findViewById(R.id.reponse6);
        conseil_1 = findViewById(R.id.conseil_1);
        conseil2 = findViewById(R.id.conseil2);
        conseil3 = findViewById(R.id.conseil3);
        conseil4 = findViewById(R.id.conseil4);
        conseil5 = findViewById(R.id.conseil5);
        conseil6 = findViewById(R.id.conseil6);
        Intent intent = getIntent();
        if (intent != null) {
            Person transferredPerson = intent.getParcelableExtra("FromPage4ToPage5");
            if (transferredPerson != null) {
                this.person = transferredPerson;

            } else {
                Log.d(TAG, "No Person found after transfer from Page3");
            }
        }
        else {
            Log.d(TAG, "Error when transferring from Page3");
        }


        button5.setOnClickListener(view -> {
            clicked_5 = true;
            clicked_6 = false;
            clicked_7 = false;
            displayResults();

        });

        button6.setOnClickListener(view -> {
            clicked_6 = true;
            clicked_5 = false;
            clicked_7 = false;
            displayResults();

        });

        button7.setOnClickListener(view -> {
            clicked_7 = true;
            clicked_6 = false;
            clicked_5 = false;
            displayResults();
        });


    }

    private void processIntentData() {
        Intent intent = getIntent();
        if (intent != null) {
            Person transferredPerson3 = intent.getParcelableExtra("FromPage4ToPage5");
            if (transferredPerson3 !=null){
                this.person = transferredPerson3;
                Log.d(TAG, person.toString());
            }
            else {
                Log.d(page_4.TAG, "No Person found after transfer from Page 5 to Page4");
            }
        }
        else {
            Log.d(page_4.TAG, "Error when transferring from Page4");
        }
    }

    public void PreviousPage4(View view){
        Intent intent = new Intent(this, page_3_inter_page_4.class);
        processIntentData();
        intent.putExtra("FromPage5ToPage4", this.person);
        startActivity(intent);
    }

    public void displayResults(){
        nom.setText(person.getName());
        if (Locale.getDefault().toString().equals("FR")  || Locale.getDefault().toString().equals("fr")) {
            // do the french stuff...
            List<String> q = Arrays.asList("1 : Avez-vous un problème cardiaque ?","2 : Avez-vous un problème de cholestérol ?","3 : Êtes-vous diabétique ?","4 : Avez-vous de l'hypertension ?","5 : Antécédents cardiovasculaires ? (famille)","6 : Connaissez vous votre IMC ?", "1. Avez-vous déjà fait le point avec votre médecin traitant à propos de votre risque cardiovasculaire ?","2. Avez-vous déjà effectué un bilan cardiaque ?","3. Avez-vous déjà consulté un cardiologue ?","1. Résultat de votre IMC (à partir de votre taille et poids)","Pratiquez-vous une activité physique régulière ?");
            List<String> yes = Arrays.asList("Le conseil de notre cardiologue : Etes-vous suivi régulièrement par votre médecin traitant et votre cardiologue ? Dans tous les cas, ne prenez-pas de médicaments sans en parler à votre médecin. Proscrire l’automédication ! Et apprenez à connaître les signes d’alerte en cas d’infarctus ou d’AVC et les premiers symptômes d’insuffisance cardiaque.", "Le conseil de notre cardiologue : Le taux de mauvais cholestérol (LDL-cholestérol) dans le sang à ne pas dépasser dépend de votre risque cardiovasculaire et de vos antécédents de maladies cardiovasculaires. ", "Le conseil de notre cardiologue : Continuez votre traitement même si on sait que ce dernier peut être contraignant pour vous.. Ne lâchez pas, c'est vital","Le conseil de notre cardiologue : En France, 15 millions de personnes sont hypertendues dont 50% de personnes de plus de 65 ans. Votre traitment doit vous permettre de diminuer votre pression artérielle pour permettre à votre coeur de se relaxer :) ","Le conseil de notre cardiologue : Les maladies cardiovasculaires peuvent être héréditaires. Si vous avez, dans votre famille, des personnes qui en sont atteintes, parlez-en à votre médecin traitant.","Vous pourrez alors comparer votre IMC avec celui que nous avons calculé pour vous dans la dernière section des résultats","Le conseil de notre cardiologue : Il est important d'aborder ce sujet avec son médecin, vous avez bien fait.","Le conseil de notre cardiologue : On espère que le bilan était positif pour vous et que vous n'avez pas été dirigé vers un cardiologue pour réaliser un bilan cardiaque plus complet.","Le conseil de notre cardiologue : C'est bien d'être suivi surtout si vous avez des soucis en particuliers", "Voici votre IMC :","Le conseil de notre cardiologue : Très bien vous êtes informé","Le conseil de notre cardiologue : Notez qu'en cas de symptômes votre médecin traitant pourra vous refaire un bilan cardiaque.","Le conseil de notre cardiologue : On espère pour vous qu'il n'ya rien de grave. Les examens de cardiologies peuvent impresionner.","Le conseil de notre cardiologue : Bravo ! votre système cardio-respiratoire est en bonne santé");
            List<String> no = Arrays.asList("Le conseil de notre cardiologue : Très bien. Continuez à être suivi régulièrement par votre médécin traitant","Le conseil de notre cardiologue : ","Le taux de mauvais cholestérol (LDL-cholestérol) dans le sang à ne pas dépasser dépend de votre risque cardiovasculaire et de vos antécédents de maladies cardiovasculaires.","Le conseil de notre cardiologue : En 2019, en France plus de 4,5 millions de personnes sont diabétiques mais 1 million d’entre elles l’ignorent. Le diabète de type 2 est le plus fréquent et il est traité par des médicaments.","Le conseil de notre cardiologue : En France, 15 millions de personnes sont hypertendues dont 50% de personnes de plus de 65 ans. Or un tiers l’ignore et seulement un tiers est bien traité. La définition de l’hypertension : une pression artérielle supérieur ou égale à 140 / 90 mm Hg en consultation ou une pression supérieure ou égale à 135 / 85 mm Hg en auto-mesure. ","Le conseil de notre cardiologue : Vous n'avez donc pas de soucis du côté de l'héridité familiale. Tput va bien de ce côté pour vous","Nous l'avons calculé spécialement pour vous dans la dernière section des résultats, allez -y jeter un coup d'oeil !","Le conseil de notre cardiologue : Connaissez-vous les facteurs de risque cardiovasculaire ? si non, parlez-en avec votre médecin","Le conseil de notre cardiologue : A partir de 45-50 chez l’homme et de 50-55 ans chez la femme ou plus tôt si vous avez des symptômes (douleur thoracique, essoufflement, palpitations, malaises et pertes de connaissance), n’hésitez pas à demander à votre médecin traitant s’il faut faire un bilan cardiaque. Le bilan initial (examen clinique et ECG) sera le plus souvent réalisé par votre médecin traitant. Il vous orientera si besoin vers un cardiologue pour réaliser un bilan cardiaque plus complet.","Le conseil de notre cardiologue : L'examen n'est pas nécessaire si le bilan initial réalisé par votre médecin traitant n'a pas révélé d'anomalies", "Voici votre IMC :","Le conseil de notre cardiologue : Parlez-en avec lui lors de votre prochaine analyse de sang ou lors de votre prochain rendez-vous médical","A partir de 45-50 chez l’homme et de 50-55 ans chez la femme ou plus tôt si vous avez des symptômes (douleur thoracique, essoufflement, palpitations, malaises et pertes de connaissance), n’hésitez pas à demander à votre médecin traitant s’il faut faire un bilan cardiaque. Le bilan initial (examen clinique et ECG) sera le plus souvent réalisé par votre médecin traitant. Il vous orientera si besoin vers un cardiologue pour réaliser un bilan cardiaque plus complet.","Le conseil de notre cardiologue : ","Le conseil de notre cardiologue : en cas de dôute parlez-en à votre médecin traitant, il effectuera un bilan initial avant d'éventuellement vous dirigez vers un cardiologue","le conseil de notre cardiologiste : pour les adultes il est recommandé de pratiquer 30 minutes d'activité physique d'intensité modérée à élevée, au moins 5 jours par semaine, en évitant de rester 2 jours consécutif sans pratiquer.");
            List<String> for_boolean = Arrays.asList("Oui","Non");
            List<String> for_imc = Arrays.asList("Consultez le site de l'OMS pour plus de renseignement sur votre IMC","");
            if (clicked_5) {
                clicked_6 = false;
                clicked_7 =false;
                question_1.setText(q.get(0));
                result1.setText(person.getCardiacProblem().toString());
                if (person.getCardiacProblem().toString().equals("OUI")){
                    conseil_1.setText(yes.get(0));
                } else if (person.getCardiacProblem().toString().equals("NON")){
                    conseil_1.setText(no.get(0));
                }
                question_2.setText(q.get(1));
                reponse2.setText(person.getCholesterolProblem().toString());
                if (person.getCholesterolProblem().toString().equals("OUI")){
                    conseil2.setText(yes.get(1));
                } else if (person.getCholesterolProblem().toString().equals("NON")){
                    conseil2.setText(no.get(1));
                }
                question3.setText(q.get(2));
                reponse3.setText(person.getDiabetesProblem().toString());
                if (person.getDiabetesProblem().toString().equals("OUI")){
                    conseil3.setText(yes.get(2));
                } else if (person.getDiabetesProblem().toString().equals("NON")){
                    conseil3.setText(no.get(2));
                }
                question4.setText(q.get(3));
                reponse4.setText(person.getHypertensionProblem().toString());
                if (person.getHypertensionProblem().toString().equals("OUI")){
                    conseil4.setText(yes.get(3));
                } else if (person.getHypertensionProblem().toString().equals("NON")){
                    conseil4.setText(no.get(3));
                }
                question5.setText(q.get(4));
                reponse5.setText(person.getFamilyHeartProblem().toString());
                if (person.getFamilyHeartProblem().toString().equals("OUI")){
                    conseil5.setText(yes.get(4));
                } else if (person.getFamilyHeartProblem().toString().equals("NON")){
                    conseil5.setText(no.get(4));
                }
                question6.setText(q.get(5));
                reponse6.setText(person.getImc().toString());
                if (person.getImc().toString().equals("OUI")){
                    conseil6.setText(yes.get(5));
                } else if (person.getImc().toString().equals("NON")){
                    conseil6.setText(no.get(5));
                }
            }
            if (clicked_6) {
                clicked_5 = false;
                clicked_7 =false;
                question_1.setText(q.get(6));
                if (person.getDiscussWithDoctor()){
                    result1.setText(for_boolean.get(0));
                    conseil_1.setText(yes.get(6));
                } else if (!person.getDiscussWithDoctor()){
                    result1.setText(for_boolean.get(1));
                    conseil_1.setText(no.get(6));
                }
                question_2.setText(q.get(7));
                if (person.getCardiacCheckUp()){
                    reponse2.setText(for_boolean.get(0));
                    conseil2.setText(yes.get(7));
                } else if (!person.getCardiacCheckUp()){
                    reponse2.setText(for_boolean.get(1));
                    conseil2.setText(no.get(7));
                }
                question3.setText(q.get(8));
                reponse3.setText(person.getConsultCardiologist().toString());
                if (person.getConsultCardiologist().toString().equals("OUI")){
                    conseil3.setText(yes.get(8));
                } else if (person.getConsultCardiologist().toString().equals("NON")){
                    conseil3.setText(no.get(8));
                }
                question4.setText(" ");
                reponse4.setText(" ");
                conseil4.setText(" ");
                question5.setText(" ");
                reponse5.setText(" ");
                conseil5.setText(" ");
                question6.setText(" ");
                reponse6.setText(" ");
                conseil6.setText(" ");

            }
            if (clicked_7) {
                clicked_6 = false;
                clicked_5 =false;
                question_1.setText(q.get(9));
                int poids = person.getPoids();
                int taille = person.getTaille();

                double taille2 = taille/100.00;
                double poids2 = Double.parseDouble(String.valueOf(poids));
                double imc = poids2 / (taille2 * taille2);
                int a = (int) Math.round(imc);

                String i = String.valueOf(a);
                result1.setText(i);
                conseil_1.setText(for_imc.get(0));
                question_2.setText(q.get(10));
                reponse2.setText(person.getSport().toString());
                if (person.getSport().toString().equals("OUI")){
                    conseil2.setText(yes.get(10));
                } else if (person.getSport().toString().equals("NON")){
                    conseil2.setText(no.get(10));
                }
                question3.setText("");
                reponse3.setText(" ");
                conseil3.setText(" ");
                question4.setText(" ");
                reponse4.setText(" ");
                conseil4.setText(" ");
                question5.setText(" ");
                reponse5.setText(" ");
                conseil5.setText(" ");
                question6.setText(" ");
                reponse6.setText(" ");
                conseil6.setText(" ");
            }

        }
        else {
            // do the english stuff...
            List<String> q = Arrays.asList("1: Do you have a heart problem?","2: Do you have a cholesterol problem?","3: Do you have diabetes?","4: Do you have high blood pressure?","5: Cardiovascular history? (family)","6: Do you know your BMI ?", "1. Have you ever checked with your GP about your cardiovascular risk?", "2. Have you ever had a heart check-up?", "3. Have you ever consulted a cardiologist?", "1. Your BMI result (based on your height and weight)", "Do you practice regular physical activity?");
            List<String> yes = Arrays.asList("Our cardiologist's advice: Are you regularly monitored by your GP and your cardiologist? In any case, do not take any medication without talking to your doctor. Do not self-medicate! And learn to know the warning signs of heart attack or stroke and the first symptoms of heart failure.", "Our cardiologist's advice: The level of bad cholesterol (LDL-cholesterol) in the blood that should not be exceeded depends on your cardiovascular risk and your history of cardiovascular disease.", "Our cardiologist's advice: Continue your treatment even if we know that it can be restrictive for you. Don't give up, it's vital", "Our cardiologist's advice: In France, 15 million people have high blood pressure, 50% of whom are over 65. Your treatment must allow you to lower your blood pressure to allow your heart to relax :)", "Our cardiologist's advice: Cardiovascular diseases can be hereditary. If you have family members who suffer from it, talk to your doctor.", "You can then compare your BMI with the one we have calculated for you in the last section of the results.", "Our cardiologist's advice: It is important to discuss this subject with your doctor, you have done well.","Our cardiologist's advice: We hope that the check-up was positive for you and that you were not referred to a cardiologist for a more complete cardiac check-up.","Our cardiologist's advice: It's good to be followed up, especially if you have any particular concerns.", "Here's your BMI:", "Our cardiologist's advice: Very good, you're well informed.", "Our cardiologist's advice: Please note that if you have any symptoms, your GP can do another cardiac check-up.", "Our cardiologist's advice: We hope for your sake that there's nothing serious. The cardiology examinations can be impressive.", "Our cardiologist's advice: Bravo! your cardio-respiratory system is in good health");
            List<String> no = Arrays.asList("Our cardiologist's advice: Very good. Continue to be monitored regularly by your doctor", "Our cardiologist's advice: ", "The level of bad cholesterol (LDL-cholesterol) in the blood that should not be exceeded depends on your cardiovascular risk and your history of cardiovascular disease", "Our cardiologist's advice: In 2019, in France, more than 4.5 million people are diabetics but 1 million of them are unaware of it. Type 2 diabetes is the most common and is treated with medication.", "Our cardiologist's advice: In France, 15 million people have high blood pressure, 50% of whom are over 65. However, a third are unaware of it and only a third are properly treated. The definition of hypertension: a blood pressure greater than or equal to 140 / 90 mm Hg in consultation or a pressure greater than or equal to 135 / 85 mm Hg in self measurement. ", "Our cardiologist's advice: So you have no worries about family inheritance. We have calculated it especially for you in the last section of the results, so go and have a look at it", "Our cardiologist's advice: Do you know the cardiovascular risk factors? If not, talk to your doctor", "Our cardiologist's advice: From the age of 45-50 in men and 50-55 in women, or earlier if you have symptoms (chest pain, shortness of breath, palpitations, fainting and loss of consciousness), don't hesitate to ask your doctor if you need a cardiac check-up. The initial assessment (clinical examination and ECG) will most often be carried out by your GP. If necessary, he will refer you to a cardiologist for a more complete cardiac check-up", "Our cardiologist's advice: The examination is not necessary if the initial check-up carried out by your GP has not revealed any abnormalities", "Here is your BMI:", "Our cardiologist's advice: Talk to him when you have your next blood test or medical appointment", "From the age of 45-50 for men and 50-55 for women, or earlier if you have symptoms (chest pain, shortness of breath, palpitations, fainting and loss of consciousness), do not hesitate to ask your GP if you need a cardiac check-up. The initial assessment (clinical examination and ECG) will most often be carried out by your GP. If necessary, he will refer you to a cardiologist for a more complete cardiac check-up", "Our cardiologist's advice: ", "Our cardiologist's advice: in the event of a problem, talk to your GP, who will carry out an initial check-up before possibly referring you to a cardiologist", "Our cardiologist's advice: for adults, it is recommended that you practise 30 minutes of physical activity of moderate to high intensity, at least 5 days a week, and that you do not go two consecutive days without practising");
            List<String> for_boolean = Arrays.asList("Yes","No");
            List<String> for_imc = Arrays.asList("Visit the WHO website for more information on your BMI","");
            if (clicked_5) {
                clicked_6 = false;
                clicked_7 =false;
                question_1.setText(q.get(0));
                result1.setText(person.getCardiacProblem().toString());
                if (person.getCardiacProblem().toString().equals("OUI")){
                    conseil_1.setText(yes.get(0));
                } else if (person.getCardiacProblem().toString().equals("NON")){
                    conseil_1.setText(no.get(0));
                }
                question_2.setText(q.get(1));
                reponse2.setText(person.getCholesterolProblem().toString());
                if (person.getCholesterolProblem().toString().equals("OUI")){
                    conseil2.setText(yes.get(1));
                } else if (person.getCholesterolProblem().toString().equals("NON")){
                    conseil2.setText(no.get(1));
                }
                question3.setText(q.get(2));
                reponse3.setText(person.getDiabetesProblem().toString());
                if (person.getDiabetesProblem().toString().equals("OUI")){
                    conseil3.setText(yes.get(2));
                } else if (person.getDiabetesProblem().toString().equals("NON")){
                    conseil3.setText(no.get(2));
                }
                question4.setText(q.get(3));
                reponse4.setText(person.getHypertensionProblem().toString());
                if (person.getHypertensionProblem().toString().equals("OUI")){
                    conseil4.setText(yes.get(3));
                } else if (person.getHypertensionProblem().toString().equals("NON")){
                    conseil4.setText(no.get(3));
                }
                question5.setText(q.get(4));
                reponse5.setText(person.getFamilyHeartProblem().toString());
                if (person.getFamilyHeartProblem().toString().equals("OUI")){
                    conseil5.setText(yes.get(4));
                } else if (person.getFamilyHeartProblem().toString().equals("NON")){
                    conseil5.setText(no.get(4));
                }
                question6.setText(q.get(5));
                reponse6.setText(person.getImc().toString());
                if (person.getImc().toString().equals("OUI")){
                    conseil6.setText(yes.get(5));
                } else if (person.getImc().toString().equals("NON")){
                    conseil6.setText(no.get(5));
                }
            }
            if (clicked_6) {
                clicked_5 = false;
                clicked_7 =false;
                question_1.setText(q.get(6));
                if (person.getDiscussWithDoctor()){
                    result1.setText(for_boolean.get(0));
                    conseil_1.setText(yes.get(6));
                } else if (!person.getDiscussWithDoctor()){
                    result1.setText(for_boolean.get(1));
                    conseil_1.setText(no.get(6));
                }
                question_2.setText(q.get(7));
                if (person.getCardiacCheckUp()){
                    reponse2.setText(for_boolean.get(0));
                    conseil2.setText(yes.get(7));
                } else if (!person.getCardiacCheckUp()){
                    reponse2.setText(for_boolean.get(1));
                    conseil2.setText(no.get(7));
                }
                question3.setText(q.get(8));
                reponse3.setText(person.getConsultCardiologist().toString());
                if (person.getConsultCardiologist().toString().equals("OUI")){
                    conseil3.setText(yes.get(8));
                } else if (person.getConsultCardiologist().toString().equals("NON")){
                    conseil3.setText(no.get(8));
                }
                question4.setText(" ");
                reponse4.setText(" ");
                conseil4.setText(" ");
                question5.setText(" ");
                reponse5.setText(" ");
                conseil5.setText(" ");
                question6.setText(" ");
                reponse6.setText(" ");
                conseil6.setText(" ");

            }
            if (clicked_7) {
                clicked_5 = false;
                clicked_6 =false;
                question_1.setText(q.get(9));
                int poids = person.getPoids();
                int taille = person.getTaille();

                double taille2 = taille/100.00;
                double poids2 = Double.parseDouble(String.valueOf(poids));
                double imc = poids2 / (taille2 * taille2);
                int a = (int) Math.round(imc);

                String i = String.valueOf(a);
                result1.setText(i);
                conseil_1.setText(for_imc.get(0));
                question_2.setText(q.get(10));
                reponse2.setText(person.getSport().toString());
                if (person.getSport().toString().equals("OUI")){
                    conseil2.setText(yes.get(10));
                } else if (person.getSport().toString().equals("NON")){
                    conseil2.setText(no.get(10));
                }
                question3.setText("");
                reponse3.setText(" ");
                conseil3.setText(" ");
                question4.setText(" ");
                reponse4.setText(" ");
                conseil4.setText(" ");
                question5.setText(" ");
                reponse5.setText(" ");
                conseil5.setText(" ");
                question6.setText(" ");
                reponse6.setText(" ");
                conseil6.setText(" ");
            }

        }
    }



}