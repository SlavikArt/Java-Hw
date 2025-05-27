package Task_3;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

public class Task_3 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scn = new Scanner(System.in);
        System.out.print("Введіть шлях до існуючої директорії: ");
        String sourceDir = scn.nextLine();
        System.out.print("Введіть шлях до нової директорії: ");
        String destDir = scn.nextLine();

        AtomicLong fileCount = new AtomicLong(0);
        AtomicLong totalSize = new AtomicLong(0);

        Thread copyThread = new Thread(() -> {
            try {
                copyDirectory(Paths.get(sourceDir), Paths.get(destDir), fileCount, totalSize);
            } catch (IOException e) {
                System.out.println("Помилка при копіюванні директорії: " + e.getMessage());
            }
        });

        copyThread.start();
        copyThread.join();

        System.out.println("Кількість скопійованих файлів: " + fileCount.get());
        System.out.println("Загальний обсяг скопійованих даних: " + totalSize.get() + " байт");
    }

    private static void copyDirectory(Path source, Path target, AtomicLong fileCount, AtomicLong totalSize) throws IOException {
        Files.walkFileTree(source, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                Path targetDir = target.resolve(source.relativize(dir));
                Files.createDirectories(targetDir);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Path targetFile = target.resolve(source.relativize(file));
                Files.copy(file, targetFile);
                fileCount.incrementAndGet();
                totalSize.addAndGet(attrs.size());
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
