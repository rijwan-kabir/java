import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.awt.Toolkit;

class MedicineReminder {
    private String medicineName;
    private int doseAmount;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<LocalTime> reminderTimes;

    public MedicineReminder(String medicineName, int doseAmount,
            LocalDate startDate, LocalDate endDate, List<LocalTime> reminderTimes) {
        this.medicineName = medicineName;
        this.doseAmount = doseAmount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reminderTimes = reminderTimes;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public int getDoseAmount() {
        return doseAmount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public List<LocalTime> getReminderTimes() {
        return reminderTimes;
    }

    public String getDetails() {
        return medicineName + " - " + doseAmount + "mg";
    }
}

class ReminderManager {
    private List<MedicineReminder> reminders = new ArrayList<>();
    private ScheduledExecutorService scheduler;

    public ReminderManager(int poolSize) {
        this.scheduler = Executors.newScheduledThreadPool(poolSize);
    }

    public void addReminder(MedicineReminder reminder) {
        reminders.add(reminder);
        scheduleAllReminderTimes(reminder);
    }

    private void scheduleAllReminderTimes(MedicineReminder reminder) {
        for (LocalTime time : reminder.getReminderTimes()) {
            scheduleReminder(reminder, time);
        }
    }

    private void scheduleReminder(MedicineReminder reminder, LocalTime time) {
        Runnable task = () -> {
            LocalDate today = LocalDate.now();
            if (!today.isBefore(reminder.getStartDate()) && !today.isAfter(reminder.getEndDate())) {
                clearConsole();
                printReminderBox(reminder, time);
                playAlarmSound();
                JOptionPane.showMessageDialog(null,
                        "Time to take: " + reminder.getMedicineName() +
                                "\nDose: " + reminder.getDoseAmount() + "mg",
                        "Medicine Reminder",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        };

        long initialDelay = Duration.between(LocalTime.now(), time).getSeconds();
        if (initialDelay < 0)
            initialDelay += 86400; // next day

        scheduler.scheduleAtFixedRate(task, initialDelay, 86400, TimeUnit.SECONDS);
    }

    private void playAlarmSound() {
        try {
            File soundFile = new File("alarm.wav");
            if (soundFile.exists()) {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                new Thread(() -> {
                    try {
                        Thread.sleep(30000);
                        clip.stop();
                        clip.close();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            } else {
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                long endTime = System.currentTimeMillis() + 30000;
                while (System.currentTimeMillis() < endTime) {
                    toolkit.beep();
                    Thread.sleep(500);
                    toolkit.beep();
                    Thread.sleep(1500);
                }
            }
        } catch (Exception e) {
            System.out.println("❌ Could not play alarm sound: " + e.getMessage());
        }
    }

    // Clear console - works for Windows and Unix-like OS
    private void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            for (int i = 0; i < 50; i++)
                System.out.println();
        }
    }

    private void printReminderBox(MedicineReminder reminder, LocalTime time) {
        String line = "========================================";
        System.out.println(line);
        System.out.println("           MEDICINE REMINDER            ");
        System.out.println(line);
        System.out.printf("\tMedicine: %s\n", reminder.getMedicineName());
        System.out.printf("\tDose: %d mg\n", reminder.getDoseAmount());
        System.out.printf("\tTime: %s\n", time);
        System.out.printf("\tDate: %s\n", LocalDate.now());
        System.out.println(line);
        System.out.println(" Take your medicine on time! Stay healthy.");
        System.out.println(line + "\n");
    }

    public void shutdown() {
        scheduler.shutdown();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many medicines do you want to set reminders for: ");
        int count = scanner.nextInt();
        scanner.nextLine();

        ReminderManager manager = new ReminderManager(count * 5);

        for (int i = 1; i <= count; i++) {
            System.out.println("\nEnter details for Medicine " + i + ":");

            System.out.print("Medicine Name: ");
            String name = scanner.nextLine();

            System.out.print("Dose Amount (mg): ");
            int dose = scanner.nextInt();
            scanner.nextLine();

            System.out.print("How many reminder times for this medicine: ");
            int timesCount = scanner.nextInt();
            scanner.nextLine();

            List<LocalTime> reminderTimes = new ArrayList<>();
            for (int t = 1; t <= timesCount; t++) {
                System.out.print("Enter reminder time " + t + " (HH:MM 24hr): ");
                LocalTime ttime = LocalTime.parse(scanner.nextLine());
                reminderTimes.add(ttime);
            }

            System.out.print("Start Date (YYYY-MM-DD): ");
            LocalDate startDate = LocalDate.parse(scanner.nextLine());

            System.out.print("End Date (YYYY-MM-DD): ");
            LocalDate endDate = LocalDate.parse(scanner.nextLine());

            MedicineReminder reminder = new MedicineReminder(name, dose, startDate, endDate, reminderTimes);
            manager.addReminder(reminder);
        }

        System.out.println("\nAll reminders set successfully! App is running...");

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}