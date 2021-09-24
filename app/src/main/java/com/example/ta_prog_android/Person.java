package com.example.ta_prog_android;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

enum Genre {
    MAN,
    WOMAN,
    UNDEFINED
}

enum IMC {
    YES,
    NO,
    OTHER,
    UNDEFINED
}

enum Age {
    MOINS_40_ANS,
    ENTRE_40_60_ANS,
    PLUS_60_ANS,
    UNDEFINED
}

public class Person implements Parcelable{
    private String name;
    private Genre genre;
    private Age age;
    public static final String DEFAULT_NAME = "UNDEFINED";
    private Boolean cardiacProblem;
    private Boolean cholesterolProblem;
    private Boolean diabetesProblem;
    private Boolean hypertensionProblem;
    private Boolean familyHeartProblem;
    private IMC imc;
    private Boolean discussWithDoctor;
    private Boolean cardiacCheckUp;
    private Boolean consultCardiologist;


    /**
     * Constructor. All members get default values
     */
    public Person() {
        this.setName(Person.DEFAULT_NAME);
        this.setGenre(Genre.UNDEFINED);
        this.setAge(Age.UNDEFINED);
        this.setCardiacProblem(false);
        this.setCholesterolProblem(false);
        this.setDiabetesProblem(false);
        this.setHypertensionProblem(false);
        this.setFamilyHeartProblem(false);
        this.setImc(IMC.UNDEFINED);
        this.setDiscussWithDoctor(false);
        this.setCardiacCheckUp(false);
        this.setConsultCardiologist(false);
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

    public Boolean getCholesterolProblem() { return this.cholesterolProblem; }

    public void setCholesterolProblem(Boolean aCholesterolProblem) {
        this.cholesterolProblem = aCholesterolProblem;
    }

    public Boolean getCardiacProblem() { return this.cardiacProblem; }

    public void setCardiacProblem(Boolean aCardiacProblem) {
        this.cardiacProblem = aCardiacProblem;
    }

    public Boolean getDiabetesProblem() { return this.diabetesProblem; }

    public void setDiabetesProblem(Boolean aDiabetesProblem) {
        this.diabetesProblem = aDiabetesProblem;
    }

    public Boolean getHypertensionProblem() { return this.hypertensionProblem; }

    public void setHypertensionProblem(Boolean aHypertensionProblem) {
        this.hypertensionProblem = aHypertensionProblem;
    }

    public Boolean getFamilyHeartProblem() { return this.familyHeartProblem; }

    public void setFamilyHeartProblem(Boolean aFamilyHeartProblem) {
        this.familyHeartProblem = aFamilyHeartProblem;
    }

    public IMC getImc() { return this.imc; }

    public void setImc(IMC aImc) { this.imc = aImc; }

    public Boolean getDiscussWithDoctor() { return this.discussWithDoctor; }

    public void setDiscussWithDoctor(Boolean aDiscussWithDoctor) {
        this.discussWithDoctor = aDiscussWithDoctor;
    }

    public Boolean getCardiacCheckUp() { return this.cardiacCheckUp; }

    public void setCardiacCheckUp(Boolean aCardiacCheckUp) {
        this.cardiacCheckUp = aCardiacCheckUp;
    }

    public Boolean getConsultCardiologist() { return this.consultCardiologist; }

    public void setConsultCardiologist(Boolean aConsultCardiologist) {
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
        dest.writeBoolean(this.getCardiacProblem());
        dest.writeBoolean(this.getCholesterolProblem());
        dest.writeBoolean(this.getDiabetesProblem());
        dest.writeBoolean(this.getHypertensionProblem());
        dest.writeBoolean(this.getFamilyHeartProblem());
        dest.writeInt(this.getImc().ordinal());
        dest.writeBoolean(this.getDiscussWithDoctor());
        dest.writeBoolean(this.getCardiacCheckUp());
        dest.writeBoolean(this.getConsultCardiologist());
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
        this.setCardiacProblem(in.readBoolean());
        this.setCholesterolProblem(in.readBoolean());
        this.setDiabetesProblem(in.readBoolean());
        this.setHypertensionProblem(in.readBoolean());
        this.setFamilyHeartProblem(in.readBoolean());
        this.setImc(IMC.values()[in.readInt()]);
        this.setDiscussWithDoctor(in.readBoolean());
        this.setCardiacCheckUp(in.readBoolean());
        this.setConsultCardiologist(in.readBoolean());
    }
}

