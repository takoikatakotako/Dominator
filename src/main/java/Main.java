import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterOutputStream;

public class Main {
    static String compress = "compress";
    static String decompress = "decompress";
    static String help = "help";

    static String outputPathString = "/output";

    public static void main(String[] args) {
        String command = args[0];
        if (compress.equals(command)) {
            String sourceFileName = args[1];
            String destinationFileName = args[2];
            compress(sourceFileName, destinationFileName);
        } else if (decompress.equals(command)) {
            String sourceFileName = args[1];
            String destinationFileName = args[2];
            decompress(sourceFileName, destinationFileName);
        } else if (help.equals(command)) {
            System.out.println("compress filename.json");
            System.out.println("decompress filename.lecture");
        } else {
            System.out.println(String.format("Unknown command: %s", command));
        }
    }

    static void compress(String sourceFileName, String destinationFileName) {
        try {
            Path sourcePath = Paths.get(outputPathString + "/" + sourceFileName);
            byte[] data = Files.readAllBytes(sourcePath);

            String destinationPathString = outputPathString + "/" + destinationFileName;

            // Compress the bytes
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DeflaterOutputStream outputStream = new DeflaterOutputStream(byteArrayOutputStream);
            outputStream.write(data);
            outputStream.finish();

            try (FileOutputStream fileOutputStream = new FileOutputStream(destinationPathString)) {
                fileOutputStream.write(byteArrayOutputStream.toByteArray());
            }

            System.out.println("----------------------");
            System.out.println("Compress Completed!!");
            System.out.println(String.format("Name: %s", destinationFileName));
            System.out.println("----------------------");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void decompress(String sourceFileName, String destinationFileName) {
        try {
            Path sourcePath = Paths.get(outputPathString + "/" + sourceFileName);
            byte[] data = Files.readAllBytes(sourcePath);

            String destinationFilePathString = outputPathString + "/" + destinationFileName;

            // Decompress the bytes
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            InflaterOutputStream outputStream = new InflaterOutputStream(byteArrayOutputStream);
            outputStream.write(data);
            outputStream.finish();

            try (FileOutputStream fileOutputStream = new FileOutputStream(destinationFilePathString)) {
                fileOutputStream.write(byteArrayOutputStream.toByteArray());
            }

            System.out.println("----------------------");
            System.out.println("Decompress Completed!!");
            System.out.println(String.format("Name: %s", destinationFileName));
            System.out.println("----------------------");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
