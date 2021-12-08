import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
public class ThreadMonitor {
   // MST.MinThread[] threads;
    List<MinThread> threads = new ArrayList<>();

    java.util.Timer timer = new Timer("Thread Manager Timer");

    public ThreadMonitor(List<MinThread> threads) {
        this.threads = threads;
    }

    public void startDisplaying(JTextArea area, int updateTime) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                StringBuilder str = new StringBuilder();
                for (var thread : threads) {
                    str.append("THREAD #").append(thread.getId());
                    str.append("\nName: ").append(thread.getName());
                    str.append("\nState: ").append(thread.getState());
                    str.append("\nPriority: ").append(thread.getPriority());
                    str.append("\nIs Alive? ").append(thread.isAlive());
                    str.append("\n");
                }
                str.append("---------------------\n");
                area.setText(area.getText() + str.toString());
            }
        };
        timer.schedule(task, 0, updateTime);
    }
    public void stopDisplaying() {
        timer.cancel();
    }
}