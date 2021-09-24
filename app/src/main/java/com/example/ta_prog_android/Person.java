package com.example.ta_prog_android;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

enum Genre {
    HOMME,
    FEMME,
    NON_DEFINIS
}

enum YES_NO {
    OUI,
    NON,
    NE_SAIT_PAS,
    NON_DEFINIS
}

enum Age {
    MOINS_40_ANS,
    ENTRE_40_60_ANS,
    PLUS_60_ANS,
    NON_DEFINIS
}


public class Person implements Parcelable{
    private String name;
    private Genre genre;
    private Age age;
    public static final String DEFAULT_NAME = "UNDEFINED";
    private YES_NO cardiacProblem;
    private YES_NO cholesterolProblem;
    private YES_NO diabetesProblem;
    private YES_NO hypertensionProblem;
    private YES_NO familyHeartProblem;
    private YES_NO imc;
    private Boolean discussWithDoctor;
    private Boolean cardiacCheckUp;
    private YES_NO consultCardiologist;


    /**
     * Constructor. All members get default values
     */
    public Person() {
        this.setName(Person.DEFAULT_NAME);
        this.setGenre(Genre.NON_DEFINIS);
        this.setAge(Age.NON_DEFINIS);
        this.setCardiacProblem(YES_NO.NON_DEFINIS);
        this.setCholesterolProblem(YES_NO.NON_DEFINIS);
        this.setDiabetesProblem(YES_NO.NON_DEFINIS);
        this.setHypertensionProblem(YES_NO.NON_DEFINIS);
        this.setFamilyHeartProblem(YES_NO.NON_DEFINIS);
        this.setImc(YES_NO.NON_DEFINIS);
        this.setDiscussWithDoctor(false);
        this.setCardiacCheckUp(false);
        this.setConsultCardiologist(YES_NO.NON_DEFINIS);
    }
    /**
     * @return the description of this class as a String
     */
    @NonNull
    public String toString() {
        StringBuilder sBuilder = new StringBuilder("\t Name: " + this.getName() + "\n");
        sBuilder.append("\t Genre: ").append(this.getGenre()).append("\n");
        sBuilder.append("\t Age: ").append(this.getAge()).append("\n");
        sBuilder.append("\t Cardiac Problem: ").append(this.getCardiacProblem()).append("\n");
        sBuilder.append("\t Cholesterol Problem: ").append(this.getCholesterolProblem()).append("\n");
        sBuilder.append("\t Diabetes Problem: ").append(this.getDiabetesProblem()).append("\n");
        sBuilder.append("\t Hypertension Problem: ").append(this.getHypertensionProblem()).append("\n");
        sBuilder.append("\t Family Heart Problem: ").append(this.getFamilyHeartProblem()).append("\n");
        sBuilder.append("\t IMC: ").append(this.getImc()).append("\n");
        sBuilder.append("\t Discuss with doctor: ").append(this.getDiscussWithDoctor()).append("\n");
        sBuilder.append("\t Cardiac Checkup: ").append(this.getCardiacCheckUp()).append("\n");
        sBuilder.append("\t Consult Cardiologist: ").append(this.getConsultCardiologist()).append("\n");
        return sBuilder.toString();
    }
    /**
     * Display this instance's contents
     */
    public void print() {
        System.out.println("Person's attributes: ");
        System.out.print(this);
        System.out.println();
    }

    /*
     * Getters / Setters
     */
    public String getName() { return this.name; }

    public void setName(String aName) { this.name = aName; }

    public Genre getGenre() { return this.genre; }

    public void setGenre(Genre aGenre) { this.genre = aGenre; }

    public Age getAge() { return this.age; }

    public void setAge(Age anAge) { this.age = anAge; }

    public YES_NO getCholesterolProblem() { return this.cholesterolProblem; }

    public void setCholesterolProblem(YES_NO aCholesterolProblem) {
        this.cholesterolProblem = aCholesterolProblem;
    }

    public YES_NO getCardiacProblem() { return this.cardiacProblem; }

    public void setCardiacProblem(YES_NO aCardiacProblem) {
        this.cardiacProblem = aCardiacProblem;
    }

    public YES_NO getDiabetesProblem() { return this.diabetesProblem; }

    public void setDiabetesProblem(YES_NO aDiabetesProblem) {
        this.diabetesProblem = aDiabetesProblem;
    }

    public YES_NO getHypertensionProblem() { return this.hypertensionProblem; }

    public void setHypertensionProblem(YES_NO aHypertensionProblem) {
        this.hypertensionProblem = aHypertensionProblem;
    }

    public YES_NO getFamilyHeartProblem() { return this.familyHeartProblem; }

    public void setFamilyHeartProblem(YES_NO aFamilyHeartProblem) {
        this.familyHeartProblem = aFamilyHeartProblem;
    }

    public YES_NO getImc() { return this.imc; }

    public void setImc(YES_NO aImc) { this.imc = aImc; }

    public Boolean getDiscussWithDoctor() { return this.discussWithDoctor; }

    public void setDiscussWithDoctor(Boolean aDiscussWithDoctor) {
        this.discussWithDoctor = aDiscussWithDoctor;
    }

    public Boolean getCardiacCheckUp() { return this.cardiacCheckUp; }

    public void setCardiacCheckUp(Boolean aCardiacCheckUp) {
        this.cardiacCheckUp = aCardiacCheckUp;
    }

    public YES_NO getConsultCardiologist() { return this.consultCardiologist; }

    public void setConsultCardiologist(YES_NO aConsultCardiologist) {
        this.consultCardiologist = aConsultCardiologist;
    }


    @Override // Parcelable method
    public int describeContents() { return 0;}

    @Override // Parcelable method
    public void writeToParcel(Parcel dest, int flags) {
// Both reading and writing orderings must match (see Person(Parcel in) method)
        dest.writeString(this.getName());
        dest.writeInt(this.getGenre().ordinal());
        dest.writeInt(this.getAge().ordinal());
        dest.writeInt(this.getCardiacProblem().ordinal());
        dest.writeInt(this.getCholesterolProblem().ordinal());
        dest.writeInt(this.getDiabetesProblem().ordinal());
        dest.writeInt(this.getHypertensionProblem().ordinal());
        dest.writeInt(this.getFamilyHeartProblem().ordinal());
        dest.writeInt(this.getImc().ordinal());
        dest.writeBoolean(this.getDiscussWithDoctor());
        dest.writeBoolean(this.getCardiacCheckUp());
        dest.writeInt(this.getConsultCardiologist().ordinal());
    }
    /**
     * https://developer.android.com/reference/android/os/Parcelable#java
     */
    public static final Parcelable.Creator<Person> CREATOR
            = new Parcelable.Creator<Person>() {
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
    /**
     * https://developer.android.com/reference/android/os/Parcelable#java
     */
    private Person(Parcel in) {
// Both reading and writing orderings must match (see writeToParcel method)
        this.setName(in.readString());
        this.setGenre(Genre.values()[in.readInt()]);
        this.setAge(Age.values()[in.readInt()]);
        this.setCardiacProblem(YES_NO.values()[in.readInt()]);
        this.setCholesterolProblem(YES_NO.values()[in.readInt()]);
        this.setDiabetesProblem(YES_NO.values()[in.readInt()]);
        this.setHypertensionProblem(YES_NO.values()[in.readInt()]);
        this.setFamilyHeartProblem(YES_NO.values()[in.readInt()]);
        this.setImc(YES_NO.values()[in.readInt()]);
        this.setDiscussWithDoctor(in.readBoolean());
        this.setCardiacCheckUp(in.readBoolean());
        this.setConsultCardiologist(YES_NO.values()[in.readInt()]);
    }
}

