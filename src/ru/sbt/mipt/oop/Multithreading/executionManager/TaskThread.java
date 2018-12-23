package ru.sbt.mipt.oop.Multithreading.executionManager;

public class TaskThread extends Thread {

    private Runnable task;
    private Context context;

    public TaskThread(Runnable task, Context context) {
        this.task = task;
        this.context = context;
    }

    @Override
    public void run() {
        if (!this.isInterrupted()) {
            try {
                task.run();
                context.incrementCompletedTaskCount();
            } catch (Exception e) {
                context.incrementFailedTaskCount();
            }
        } else {
            context.incrementInterruptedTaskCount();
        }
    }
}