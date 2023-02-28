package practice.hospital;

import java.util.Arrays;

public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {
        final float min = 32.0f;
        final float max = 40.0f;
        float[] patientsTemp = new float[patientsCount];
        for (int i = 0; i < patientsCount; i++){
            patientsTemp[i] = (float) (min + Math.random() * (max - min));
        }
        return patientsTemp;
    }

    public static String getReport(float[] temperatureData) {
        StringBuilder stringBuilder = new StringBuilder();
       int countHealthyPatients = 1;
       double sum = 0;
       double sumMiddle;
       for (float temper : temperatureData) {
           String formatTemper = String.format("%.1f", temper);
           stringBuilder.append(formatTemper).append(" ");
           if (temper >= 36.2 && temper <= 36.9) {
               countHealthyPatients++;
           }
           sum = sum + temper;
       }
       sumMiddle = sum / temperatureData.length;
       String formatMiddle = String.format("%.2f", sumMiddle);

        return "Температуры пациентов: " + stringBuilder.toString().trim() +
        "\nСредняя температура: " + formatMiddle +
        "\nКоличество здоровых: " + countHealthyPatients;
    }
}
