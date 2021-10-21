package me.itskekoff.bettercraft.installer;

import java.io.*;
import java.net.URL;
import java.nio.file.*;
import java.nio.file.Files;
import java.util.zip.ZipEntry;
import java.util.List;
import java.util.zip.ZipInputStream;
import java.net.URI;
import java.nio.file.Paths;

import java.util.concurrent.TimeUnit;
/* Ссылки на закачку:
* https://drive.google.com/u/0/uc?id=1ps0VEMmAMBKXvGBgxMe9v-Xclt2vJsI6&export=download - bettercraft        *
*  https://getfile.dokpub.com/yandex/get/https://disk.yandex.ru/d/xCUM2TeyqODNoQ - jdk   *
* */
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("------------------------------------------");
        System.out.println("Инициализая | By itskekoff...");
        System.out.println("");
        System.out.println("Создание файлов и директорий 0/3");
        System.out.println("------------------------------------------");

        TimeUnit.SECONDS.sleep(1);
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("------------------------------------------");
        System.out.println("Установка & Настройка...");
        System.out.println("");
        System.out.println("Создание директории ./data 1/2");
        System.out.println("------------------------------------------");
        File file = new File("./data");
        file.mkdirs();
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("------------------------------------------");
        System.out.println("Установка & Настройка...");
        System.out.println("");
        System.out.println("Создание файла ddosmsg.txt в data 2/2");
        System.out.println("------------------------------------------");

        TimeUnit.SECONDS.sleep(1);

        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("------------------------------------------");
        System.out.println("Установка & Настройка...");
        System.out.println("");
        System.out.println("Создание run.bat");
        System.out.println("------------------------------------------");
        final File fileee = new File("run.bat");
        fileee.createNewFile();
        PrintWriter writeer = new PrintWriter(fileee, "UTF-8");
        writeer.println("@echo off");
        writeer.println("\".jdk\\bin\\java\" -Dfile.encoding=UTF-8 -jar BetterCraft.jar");
        writeer.println("pause");
        writeer.close();
        TimeUnit.SECONDS.sleep(1);
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("------------------------------------------");
        System.out.println("Установка & Настройка...");
        System.out.println("");
        System.out.println("Скачивание BetterCraft 1/3");
        System.out.println("------------------------------------------");
        InputStream inputStream = new URL("https://drive.google.com/u/0/uc?id=1LwN29poMxbKDjiPUEWsqnUQTmae9Tm7z&export=download").openStream();
        Files.copy(inputStream, Paths.get("./BetterCraft.jar"), StandardCopyOption.REPLACE_EXISTING);
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("------------------------------------------");
        System.out.println("Установка & Настройка...");
        System.out.println("");
        System.out.println("Скачивание .jdk & разархивация .jdk 2/3");
        System.out.println("------------------------------------------");
        String sourceUrl = "https://getfile.dokpub.com/yandex/get/https://disk.yandex.ru/d/xCUM2TeyqODNoQ";
        String targetFilename = "jdk.zip";

        long bytesDownloaded = download(sourceUrl, targetFilename);

        System.out.println(String.format("Скачано %d байт", bytesDownloaded, sourceUrl, targetFilename));
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("------------------------------------------");
        System.out.println("Установка & Настройка...");
        System.out.println("");
        System.out.println("Скачивание msgddos.yml (файл конфигурации)");
        System.out.println("------------------------------------------");
        // https://drive.google.com/u/0/uc?id=1qPeEHxE2NY-PruJGe6BaGGRC8frjeboi&export=download
        String sourceUrrl = "https://drive.google.com/u/0/uc?id=1qPeEHxE2NY-PruJGe6BaGGRC8frjeboi&export=download";
        String targetFileename = "./data/msgddos.yml";
        long bytesDownloadeed = download(sourceUrrl, targetFileename);
        System.out.println(String.format("Скачано %d байт", bytesDownloadeed, sourceUrrl, targetFileename));
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        new ProcessBuilder("cmd", "/c", "powershell -Command \"Expand-Archive -Path jdk.zip -DestinationPath ./\".").inheritIO().start().waitFor();
        new ProcessBuilder("cmd", "/c", "del \"jdk.zip\"").inheritIO().start().waitFor();
        
    }


    static long download(String url, String fileName) throws IOException {

        try (InputStream in = URI.create(url).toURL().openStream()) {
            return Files.copy(in, Paths.get(fileName));

        }

    }
}
