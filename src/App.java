import dto.Doctor;
import dto.Patient;
import static utils.Symptoms.*;

public class App {
    public static void main(String[] args) {
        Doctor doctor = new Doctor("Михайл", "Грибоедов", 47);

        Patient p1 = new Patient("Sam", "Sung", 62);
        p1.setSymptoms(DIZZINESS, WEAKNESS, NAUSEA);

        Patient p2 = new Patient("Ирина", "Кайратовна", 55);
        p2.setSymptoms(WEAKNESS, COUGH, FEVER);

        Patient p3 = new Patient("Billy", "Joebob", 29);
        p3.setSymptoms(LACRIMATION, RUNNY_NOSE, RASH);

        Patient p4 = new Patient("Jean", "Bauyrjean", 35);
        p4.setSymptoms(COUGH, LACRIMATION, DIZZINESS);

        doctor.addPatient(p1);
        doctor.addPatient(p2);
        doctor.addPatient(p3);
        doctor.addPatient(p4);

        doctor.startWorking();
    }
}
