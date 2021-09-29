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
                question_1.setText(q.get(6));
                if (person.getDiscussWithDoctor()){
                    result1.setText(for_boolean.get(1));
                    conseil_1.setText(yes.get(6));
                } else if (!person.getDiscussWithDoctor()){
                    conseil_1.setText(no.get(6));
                }
                question_2.setText(q.get(7));
                if (person.getCardiacCheckUp()){
                    reponse2.setText(for_boolean.get(0));
                    conseil2.setText(yes.get(7));
                } else if (!person.getCardiacCheckUp()){
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
            List<String> q = Arrays.asList("1 : Avez-vous un problème cardiaque ?","2 : Avez-vous un problème de cholestérol ?","3 : Êtes-vous diabétique ?","4 : Avez-vous de l'hypertension ?","5 : Antécédents cardiovasculaires ? (famille)","6 : Connaissez vous votre IMC ?", "1. Avez-vous déjà fait le point avec votre médecin traitant à propos de votre risque cardiovasculaire ?","2. Avez-vous déjà effectué un bilan cardiaque ?","3. Avez-vous déjà consulté un cardiologue ?","1. Résultat de votre IMC (à partir de votre taille et poids)","Pratiquez-vous une activité physique régulière ?");
            List<String> yes = Arrays.asList("Le conseil de notre cardiologue : Etes-vous suivi régulièrement par votre médecin traitant et votre cardiologue ? Dans tous les cas, ne prenez-pas de médicaments sans en parler à votre médecin. Proscrire l’automédication ! Et apprenez à connaître les signes d’alerte en cas d’infarctus ou d’AVC et les premiers symptômes d’insuffisance cardiaque.", "Le conseil de notre cardiologue : Le taux de mauvais cholestérol (LDL-cholestérol) dans le sang à ne pas dépasser dépend de votre risque cardiovasculaire et de vos antécédents de maladies cardiovasculaires. ", "Le conseil de notre cardiologue : Continuez votre traitement même si on sait que ce dernier peut être contraignant pour vous.. Ne lâchez pas, c'est vital","Le conseil de notre cardiologue : En France, 15 millions de personnes sont hypertendues dont 50% de personnes de plus de 65 ans. Votre traitment doit vous permettre de diminuer votre pression artérielle pour permettre à votre coeur de se relaxer :) ","Le conseil de notre cardiologue : Les maladies cardiovasculaires peuvent être héréditaires. Si vous avez, dans votre famille, des personnes qui en sont atteintes, parlez-en à votre médecin traitant.","Vous pourrez alors comparer votre IMC avec celui que nous avons calculé pour vous dans la dernière section des résultats","Le conseil de notre cardiologue : Il est important d'aborder ce sujet avec son médecin, vous avez bien fait.","Le conseil de notre cardiologue : On espère que le bilan était positif pour vous et que vous n'avez pas été dirigé vers un cardiologue pour réaliser un bilan cardiaque plus complet.","Le conseil de notre cardiologue : C'est bien d'être suivi surtout si vous avez des soucis en particuliers", "Voici votre IMC :","Le conseil de notre cardiologue : Très bien vous êtes informé","Le conseil de notre cardiologue : Notez qu'en cas de symptômes votre médecin traitant pourra vous refaire un bilan cardiaque.","Le conseil de notre cardiologue : On espère pour vous qu'il n'ya rien de grave. Les examens de cardiologies peuvent impresionner.","Le conseil de notre cardiologue : Bravo ! votre système cardio-respiratoire est en bonne santé");
            List<String> no = Arrays.asList("Le conseil de notre cardiologue : Très bien. Continuez à être suivi régulièrement par votre médécin traitant","Le conseil de notre cardiologue : ","Le taux de mauvais cholestérol (LDL-cholestérol) dans le sang à ne pas dépasser dépend de votre risque cardiovasculaire et de vos antécédents de maladies cardiovasculaires.","Le conseil de notre cardiologue : En 2019, en France plus de 4,5 millions de personnes sont diabétiques mais 1 million d’entre elles l’ignorent. Le diabète de type 2 est le plus fréquent et il est traité par des médicaments.","Le conseil de notre cardiologue : En France, 15 millions de personnes sont hypertendues dont 50% de personnes de plus de 65 ans. Or un tiers l’ignore et seulement un tiers est bien traité. La définition de l’hypertension : une pression artérielle supérieur ou égale à 140 / 90 mm Hg en consultation ou une pression supérieure ou égale à 135 / 85 mm Hg en auto-mesure. ","Le conseil de notre cardiologue : Vous n'avez donc pas de soucis du côté de l'héridité familiale. Tput va bien de ce côté pour vous","Nous l'avons calculé spécialement pour vous dans la dernière section des résultats, allez -y jeter un coup d'oeil !","Le conseil de notre cardiologue : Connaissez-vous les facteurs de risque cardiovasculaire ? si non, parlez-en avec votre médecin","Le conseil de notre cardiologue : A partir de 45-50 chez l’homme et de 50-55 ans chez la femme ou plus tôt si vous avez des symptômes (douleur thoracique, essoufflement, palpitations, malaises et pertes de connaissance), n’hésitez pas à demander à votre médecin traitant s’il faut faire un bilan cardiaque. Le bilan initial (examen clinique et ECG) sera le plus souvent réalisé par votre médecin traitant. Il vous orientera si besoin vers un cardiologue pour réaliser un bilan cardiaque plus complet.","Le conseil de notre cardiologue : L'examen n'est pas nécessaire si le bilan initial réalisé par votre médecin traitant n'a pas révélé d'anomalies", "Voici votre IMC :","Le conseil de notre cardiologue : Parlez-en avec lui lors de votre prochaine analyse de sang ou lors de votre prochain rendez-vous médical","A partir de 45-50 chez l’homme et de 50-55 ans chez la femme ou plus tôt si vous avez des symptômes (douleur thoracique, essoufflement, palpitations, malaises et pertes de connaissance), n’hésitez pas à demander à votre médecin traitant s’il faut faire un bilan cardiaque. Le bilan initial (examen clinique et ECG) sera le plus souvent réalisé par votre médecin traitant. Il vous orientera si besoin vers un cardiologue pour réaliser un bilan cardiaque plus complet.","Le conseil de notre cardiologue : ","Le conseil de notre cardiologue : en cas de dôute parlez-en à votre médecin traitant, il effectuera un bilan initial avant d'éventuellement vous dirigez vers un cardiologue","le conseil de notre cardiologiste : pour les adultes il est recommandé de pratiquer 30 minutes d'activité physique d'intensité modérée à élevée, au moins 5 jours par semaine, en évitant de rester 2 jours consécutif sans pratiquer.");
            List<String> for_boolean = Arrays.asList("Oui","Non");
            List<String> for_imc = Arrays.asList("Consultez le site de l'OMS pour plus de renseignement sur votre IMC","");
            if (clicked_5) {
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
                question_1.setText(q.get(6));
                if (person.getDiscussWithDoctor()){
                    result1.setText(for_boolean.get(1));
                    conseil_1.setText(yes.get(6));
                } else if (!person.getDiscussWithDoctor()){
                    conseil_1.setText(no.get(6));
                }
                question_2.setText(q.get(7));
                if (person.getCardiacCheckUp()){
                    reponse2.setText(for_boolean.get(0));
                    conseil2.setText(yes.get(7));
                } else if (!person.getCardiacCheckUp()){
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