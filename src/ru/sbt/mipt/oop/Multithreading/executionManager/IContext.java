package ru.sbt.mipt.oop.Multithreading.executionManager;

public interface IContext {
    int getCompletedTaskCount();

    int getFailedTaskCount();

    int getInterruptedTaskCount();

    void interrupt();

    boolean isFinished();
}
