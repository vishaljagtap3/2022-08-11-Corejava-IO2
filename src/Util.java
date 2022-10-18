
import java.io.*;
import java.util.Scanner;


public class Util {

    public static void serializationDemo() {
        Student s1 = new Student(11, 66.34f, "ABC", "Sports and Music");

        try {
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(
                            new FileOutputStream("/home/vishal/java/demos/students_data_new.bin")
                    );

            objectOutputStream.writeObject(s1);

            objectOutputStream.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void deSerializationDemo() {
        try {
            ObjectInputStream objectInputStream =
                    new ObjectInputStream(
                            new FileInputStream("/home/vishal/java/demos/students_data_new.bin")
                    );

            Student student = (Student) objectInputStream.readObject();
            System.out.println(student);
            objectInputStream.close();
        }
        catch (IOException e) {

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void deSerializationDemoOld() {
        try {
            DataInputStream din = new DataInputStream(
                    new FileInputStream("/home/vishal/java/demos/students_data.bin")
            );

            Student student = new Student(
                    din.readInt(),
                    din.readFloat(),
                    din.readUTF(),
                    din.readUTF()
            );
            System.out.println(student);

            din.close();
        } catch (IOException e) {
        }
    }


    public static void serializationDemoOld() {

        Student s1 = new Student(11, 66.34f, "ABC", "Sports and Music");
        try {
            DataOutputStream dout = new DataOutputStream(
                    new FileOutputStream("/home/vishal/java/demos/students_data.bin")
            );
            dout.writeInt(s1.getRoll());
            dout.writeFloat(s1.getMarks());
            dout.writeUTF(s1.getName());
            dout.writeUTF(s1.getHobbies());
            dout.close();

        } catch (IOException e) {
        }
    }


    public static void scannerDemo() {
        Scanner scanner = new Scanner(System.in);
        int roll = scanner.nextInt(8);
        float marks = scanner.nextFloat();
        scanner.nextLine();
        String name = scanner.nextLine();

        System.out.println(roll + " " + marks + " " + name);
    }

    public static void systemIO() {
        byte[] data = new byte[1024 * 1];
        try {

            System.out.println("Enter roll: ");
            int count = System.in.read(data);
            String numStr = new String(data, 0, count);
            int roll = Integer.parseInt(
                    numStr.substring(0, numStr.length() - 1)
            );
            System.out.println("roll = " + roll);

            System.out.println("Enter marks: ");
            count = System.in.read(data);
            numStr = new String(data, 0, count);
            float marks = Float.parseFloat(
                    numStr.substring(0, numStr.length() - 1)
            );
            System.out.println("marks = " + marks);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void dataIODemo() {
        try {

            FileOutputStream fout = new FileOutputStream("/home/vishal/java/demos/mydata.txt");
            DataOutputStream dout = new DataOutputStream(fout);
            dout.writeInt(1234);
            dout.writeChar('A');
            dout.writeDouble(12.122);
            dout.writeUTF("BitCode");
            dout.close();

            DataInputStream din = new DataInputStream(new FileInputStream("/home/vishal/java/demos/mydata.txt"));

            int i = din.readInt();
            char ch = din.readChar();
            double d = din.readDouble();
            String str = din.readUTF();

            System.out.println(i + " " + ch + " " + d + " " + str);

            din.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void printStreamDemo() {
        try {
            PrintStream ps = new PrintStream(
                    new FileOutputStream("/home/vishal/java/demos/myfile_new.txt")
            );
            ps.println("This is line 1 \n");
            ps.print("A");
            ps.print(1234);

            ps.close();
        } catch (IOException e) {
        }
    }

    public static void fileOutputStreamDemo() {
        try {
            FileInputStream fin = new FileInputStream("/home/vishal/java/demos/sample_video_1.mp4");
            BufferedInputStream bin = new BufferedInputStream(fin);

            FileOutputStream fout = new FileOutputStream("/home/vishal/java/demos/sample_video_2.mp4");
            BufferedOutputStream bout = new BufferedOutputStream(fout);

            long startTime = System.currentTimeMillis();
            int count = 0;
            byte[] arr = new byte[8 * 1024];
            while ((count = bin.read(arr)) != -1) {
                bout.write(arr, 0, count);
            }

            System.out.println("Time : " + (System.currentTimeMillis() - startTime));

            bout.close();
            bin.close();
        } catch (IOException e) {
        }

    }

    public static void sequenceInputStreamDemo() {
        try {
            ByteArrayInputStream bin = new ByteArrayInputStream("this is demo".getBytes());
            FileInputStream fin = new FileInputStream("/home/vishal/java/demos/small_file.txt");
            SequenceInputStream sin = new SequenceInputStream(bin, fin);

            int ch;
            while ((ch = sin.read()) != -1) {
                System.out.print((char) ch);
            }
            sin.close();
        } catch (IOException e) {
        }

    }

    public static void bufferedInputStreamDemo() {
        try {
            FileInputStream fin = new FileInputStream("/home/vishal/java/demos/bigfile.txt");
            BufferedInputStream bin = new BufferedInputStream(fin, 32 * 1024);

            long startTime = System.currentTimeMillis();

            int count = 0;
            byte[] arr = new byte[1024 * 8];
            while ((count = bin.read(arr)) != -1) {

            }

            System.out.println("Time taken: " + (System.currentTimeMillis() - startTime));
            bin.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void pushbackInputStreamDemo() {
        try {
            ByteArrayInputStream bin = new ByteArrayInputStream(
                    "this is demo".getBytes()
            );
            PushbackInputStream pin = new PushbackInputStream(bin);

            int ch;
            ch = pin.read();
            System.out.println((char) ch);
            ch = pin.read();
            System.out.println((char) ch);
            pin.unread(ch);
            ch = pin.read();
            System.out.println((char) ch);

            pin.close();
        } catch (IOException e) {
        }
    }

    public static void byteArrayInputStreamDemo() {
        try {
            byte[] data = "BitCode is the Best!".getBytes();
            //ByteArrayInputStream bin = new ByteArrayInputStream(data);
            ByteArrayInputStream bin = new ByteArrayInputStream(data, 0, 10);

            int ch;
            while ((ch = bin.read()) != -1) {
                System.out.print((char) ch);
            }
            System.out.println();
            bin.close();
        } catch (IOException e) {
        }
    }

    public static void readFromFile1(String path) {

        try {
            FileInputStream fin = new FileInputStream(new File(path));
            long startTime = System.currentTimeMillis();

            /*int ch;
            while( (ch = fin.read()) != -1) {
            }*/
            int count = 0;
            byte[] arr = new byte[1024 * 8];
            /*while( (count = fin.read(arr)) != -1) {

            }*/
            while ((count = fin.read(arr, 0, 1024 * 8)) != -1) {

            }

            System.out.println("Time taken: " + (System.currentTimeMillis() - startTime));
            fin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /*public static void readFromFile1(String path) {
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //way 1
        int ch;

        try {
            System.out.println("Available: " + fin.available() );
            System.out.println("mark supported : " + fin.markSupported());
            while ((ch = fin.read()) != -1) {
                System.out.print((char)ch);
                fin.skip(1);
            }
            System.out.println("Available: " + fin.available() );

            fin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }*/

}
