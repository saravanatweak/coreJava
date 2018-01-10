package CoreJava.JavaLang.ReflectionApi.ByPluralSight;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String args[]) throws Exception {
        String typeWithPath ="CoreJava.JavaLang.ReflectionApi.ByPluralSight.AccountWorker";
        BankAccount acct = new BankAccount("d", 100);

        /** Using arq constructor creating new instance of a type,
         * nd calling that method through new instance.
         * And no implementation of any custom interface. */
//        startWork( typeWithPath , acct);

        //using no-arq constructor
        //Using custom interface having std methods
        //startWorkWithNoArqConstrucotr( typeWithPath, acct);

        Class<?> targetType = Class.forName(typeWithPath);

        AccountWorker.customAnn an = targetType.getAnnotation(AccountWorker.customAnn.class);



    }

    static void startWork(String workerTypeName, Object workerTarget) throws
            ClassNotFoundException,            NoSuchMethodException,
            IllegalAccessException,            InvocationTargetException,
            InstantiationException {

        Class<?> workerType = Class.forName(workerTypeName); //type info of our worker class name.
        Class<?> targetType = workerTarget.getClass();      // type info of our target class name.

        // Getting the constructor which holds the given class
        // referece(workerTargetType) from the working[AccountWorker) class.
        Constructor c = workerType.getConstructor(targetType);

        //using c, call a newInstance on it, pass constructor arq which is our
        // target[given obj ref] gives us new instance of accountWorker and
        // that's inside of that worker variable.
        Object worker = c.newInstance(workerTarget);

        // we'll take type info for the worker, call getMethod, pass in the method name of
        // dowork and get the method descrioption
        Method doWork = workerType.getMethod("doWork");

        //Invoking the actual method passing the woker referce
        doWork.invoke(worker);


    }

    static void startWorkWithNoArqConstrucotr(String workerTypeName, Object workerTarget) throws
            ClassNotFoundException, IllegalAccessException, InstantiationException {

        Class<?> workerType = Class.forName(workerTypeName); //type info of our worker class name.

        // bcoz, we are using no-arq constructor no need to use constructor calling,
        // instead simply call newInstance against the type description for our Worker
        // we'll go ahead and jst cast that to the interface TaskWorker, and assign it to ref of type TaskWorker
        TaskWorker worker = (TaskWorker) workerType.newInstance();

        //Because of casting and ref to type task worker, the rest of our coding is not
        // REFLECTION based, its just regular old programming.
        worker.setTarget(workerTarget);
        worker.doWork();

        //The fist two line of this method only used reflection.
        // as we didn't necessarily  know up when we coded up program.
        // Using casting, we make it as regular programming. So we used reflection where we needed.

        //this is really kind of good strategy wn we're working with reflection.
    }

}
