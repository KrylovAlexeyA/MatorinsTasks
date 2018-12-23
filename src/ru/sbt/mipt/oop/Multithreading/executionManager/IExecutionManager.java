package ru.sbt.mipt.oop.Multithreading.executionManager;


public interface IExecutionManager {
    IContext execute(Runnable callback, Runnable... tasks);
}
