package dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Patient extends Person {
    private List<String> symptoms = new ArrayList<>();
    private Diagnosis diagnosis;

    public Patient(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    public List<String> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String... symptoms) {
        this.symptoms = Arrays.asList(symptoms);
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }
}
