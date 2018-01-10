package pluralSight.generics.wildcards.bounded;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class PersonLoader {
    private final RandomAccessFile file;

    public PersonLoader(final File file) throws FileNotFoundException {
        this.file = new RandomAccessFile(file, "rw");
    }

    public Person load() throws ClassNotFoundException {
        try {
            /**here is the code for loading our person objects back up again.
             * We've got that file and we read a UTF eight string, that's the class name,
             * and we read a UTF eight string that's the person name.
             * Then we read the person's age out as an integer.
             * Now, we read out the class name because we might have person, which we've serialized,
             * or we might have a partner that we've serialized,
             * or we might have an employee that we've serialized.
             * We use this Class.forName method to instantiate a class object
             * that lets us build the person instance itself here.
             * */
            final String className = file.readUTF();
            final String personName = file.readUTF();
            final int age = file.readInt();

            final Class<?> personClass = Class.forName(className);
            final Constructor<?> constructor = personClass.getConstructor(String.class, int.class);
            return (Person) constructor.newInstance(personName, age);
        } catch (IOException e) {
            return null;
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void loadAll(final List<? super Person> people) throws ClassNotFoundException {
        Person person;

        while ((person = load()) != null) {
            people.add(person);
        }
    }
}
