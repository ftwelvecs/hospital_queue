package dto;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

import static utils.Symptoms.*;

public class Doctor extends Person {
    private Queue<Patient> patientQueue = new ArrayDeque<>();

    private List<String> covidSymptoms = Arrays.asList(COUGH, FEVER, WEAKNESS);
    private List<String> poisoningSymptoms = Arrays.asList(DIZZINESS, NAUSEA, WEAKNESS);
    private List<String> allergySymptoms = Arrays.asList(RASH, RUNNY_NOSE, LACRIMATION);

    public Doctor(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    public void addPatient(Patient patient) {
        patientQueue.add(patient);
    }

    public void startWorking() {
        while (!patientQueue.isEmpty()) {
            Patient patient = patientQueue.poll();
            System.out.println("Начинаю осматривать пациента: " + patient.getFirstName() + " " + patient.getLastName());
            Diagnosis diagnosis = diagnosing(patient.getSymptoms());
            patient.setDiagnosis(diagnosis);
            System.out.println("У вас " + diagnosis.getName() + ", лечение: " + diagnosis.getTreatment());
            if (!patientQueue.isEmpty()) System.out.println("Следующий...\n");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\nОсмотр завершен, кварцевание! Кабинет закрыт");
    }

    private Diagnosis diagnosing(List<String> symptoms) {
        Diagnosis diagnosis;

        if (isItCovid(symptoms))
            diagnosis = new Diagnosis("короновирус", "необходимо срочно вакцинировать");
        else if (isItPoisoning(symptoms))
            diagnosis = new Diagnosis("отравление", "нужно промыть желудок");
        else if (isItAllergy(symptoms))
            diagnosis = new Diagnosis("аллергия", "пейте противоаллергенные таблетки");
        else
            diagnosis = new Diagnosis("неизвестная болезнь", "используйте подорожник");

        return diagnosis;
    }

    private boolean isItCovid(List<String> symptoms) {
        for (String symptom : symptoms) {
            if (!covidSymptoms.contains(symptom))
                return false;
        }
        return true;
    }

    private boolean isItPoisoning(List<String> symptoms) {
        for (String symptom : symptoms) {
            if (!poisoningSymptoms.contains(symptom))
                return false;
        }
        return true;
    }

    private boolean isItAllergy(List<String> symptoms) {
        for (String symptom : symptoms) {
            if (!allergySymptoms.contains(symptom))
                return false;
        }
        return true;
    }
}
