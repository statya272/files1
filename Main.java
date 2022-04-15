import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        String mainLocation = "D:\\Games";
        StringBuilder log = new StringBuilder();

        //Создание директорий src, res, savegames, temp в папке Games.
        File dirSrc = new File(mainLocation, "src");
        log.append(msgToLog(dirSrc, dirSrc.mkdir()));
        File dirRes = new File(mainLocation, "res");
        log.append(msgToLog(dirRes, dirRes.mkdir()));
        File dirSavegames = new File(mainLocation, "savegames");
        log.append(msgToLog(dirSavegames, dirSavegames.mkdir()));
        File dirTemp = new File(mainLocation, "temp");
        log.append(msgToLog(dirTemp, dirTemp.mkdir()));

        //Создание директорий main, test в папке src.
        File dirMain = new File(dirSrc, "main");
        log.append(msgToLog(dirMain, dirMain.mkdir()));
        File dirTest = new File(dirSrc, "test");
        log.append(msgToLog(dirTest, dirTest.mkdir()));

        //Создание файлов Main.java, Utils.java в папке main.
        File fileMain = new File(dirMain, "Main.java");
        try {
            log.append(msgToLog(fileMain, fileMain.createNewFile()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        File dirUtils = new File(dirMain, "Utils.java");
        try {
            log.append(msgToLog(dirUtils, dirUtils.createNewFile()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //Создание директорий drawables, vectors, icons в папке res .
        File dirDrawables = new File(dirRes, "drawables");
        log.append(msgToLog(dirDrawables, dirDrawables.mkdir()));
        File dirVectors = new File(dirRes, "vectors");
        log.append(msgToLog(dirVectors, dirVectors.mkdir()));
        File dirIcons = new File(dirRes, "icons");
        log.append(msgToLog(dirIcons, dirIcons.mkdir()));

        //Создание файлов temp.txt в папке temp.
        File fileTemp = new File(dirTemp, "temp.txt");
        try {
            log.append(msgToLog(fileTemp, fileTemp.createNewFile()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //Сохранение лога в файл
        try (FileWriter writer = new FileWriter(fileTemp, false)) {
            writer.write(log.toString());
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String msgToLog(File file, boolean isCreated) {
        if (isCreated) {
            if (file.isDirectory()) {
                return "Директория " + file.getAbsolutePath() + " создана" + "\n";
            } else {
                return "Файл " + file.getAbsolutePath() + " создан" + "\n";
            }
        } else {
            if (file.isDirectory()) {
                return "Директория " + file.getAbsolutePath() + " не создана" + "\n";
            } else {
                return "Файл " + file.getAbsolutePath() + " не создан" + "\n";
            }
        }
    }
}
