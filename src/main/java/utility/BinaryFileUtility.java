package utility;

import java.io.*;
import java.io.*;
import java.util.ArrayList;

public class BinaryFileUtility {


    public static <T> ArrayList<T> readObjects(String fileName) {

        ArrayList<T> objectsList = new ArrayList<>();

        if (fileName == null || fileName.isBlank()) {
            return objectsList;
        }

        File file = new File(fileName);

        if (!file.exists() || file.length() == 0) {
            return objectsList;
        }

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(file))) {

            while (true) {
                T tempObject = (T) ois.readObject();
                objectsList.add(tempObject);
            }

        } catch (EOFException e) {
            // all objects have been read


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return objectsList;
    }

    public static boolean writeObjects(String fileName, Object newObject) {
        if (fileName == null) {
            return false;
        }
        ObjectOutputStream oos = null;
        try {
            File objectFile = new File(fileName);
            FileOutputStream fosForOos = null;
            if (objectFile.exists() && objectFile.length() > 0) {
                fosForOos = new FileOutputStream(objectFile, true);
                oos = new AppendableObjectOutputStream(fosForOos);
            } else {
                fosForOos = new FileOutputStream(objectFile);
                oos = new ObjectOutputStream(fosForOos);
            }
            oos.writeObject(newObject);
            return true;
        } catch (IOException e) {
            System.out.println("Error while writing to file");
        } catch (Exception e) {
            System.out.println("Error while Write Objects");
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    System.out.println("Error while closing ObjectOutputStream");
                }
            }
        }
        return false;
    }

    public static <T> boolean overwriteObjects(String fileName, ArrayList<T> objects) {
        if (fileName == null || objects == null) {
            return false;
        }

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(fileName))) {

            for (Object object : objects) {
                oos.writeObject(object);
            }

            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
