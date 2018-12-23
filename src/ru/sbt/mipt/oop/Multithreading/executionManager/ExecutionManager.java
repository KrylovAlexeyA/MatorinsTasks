package ru.sbt.mipt.oop.Multithreading.executionManager;

public class ExecutionManager implements IExecutionManager {
/*
    *Метод execute принимает массив тасков, это задания которые ExecutionManager должен выполнять параллельно
    (в вашей реализации пусть будет в своем пуле потоков).
    *После завершения всех тасков должен выполниться callback (ровно 1 раз).

    *Метод execute – это неблокирующий метод, который сразу возвращает объект Context.
*/

    @Override
    public Context execute(Runnable callback, Runnable... tasks) {
        Context context = new Context();
        for (Runnable task : tasks) {
            ExecutionManagerTest.sleep(10);
            context.addThread(runTask(task, context));
        }
        runCallBack(callback, context);
        return context;
    }

    private Thread runCallBack(Runnable callback, Context context) {
        Thread callbackThread = new CallbackThread(callback, context);
        try {
            callbackThread.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return callbackThread;
    }

    private Thread runTask(Runnable task, Context context) {
        Thread taskThread = new TaskThread(task, context);
        try {
            taskThread.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return taskThread;
    }
}
