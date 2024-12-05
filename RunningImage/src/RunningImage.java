import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class RunningImage extends JPanel {
    private BufferedImage Sun;
    private BufferedImage Earth;
    private int frameWidth = 1000; // Ширина фрейма
    private int frameHeight = 1000; // Высота фрейма
    private int radius = 350; // Радиус орбиты
    private int degreeSpeed = 1; // Скорость вращения
    private int degreeCount = 0; // Угол вращения

    public RunningImage() {
        // Загружаем изображения
        try {
            Sun = ImageIO.read(new File("C:\\Users\\New\\Downloads\\x2071053-164798629.png")); // Путь к изображения Солнца
            Earth = ImageIO.read(new File("C:\\Users\\New\\Downloads\\161044d693189f.jpg")); // Путь к изображению Земли
        } catch (IOException e) {
            System.out.println(e);
        }

        // Создаем таймер для обновления позиции логотипа
        Timer timer = new Timer(30, e -> moveSolarSystem());
        timer.start();
    }

    private int xSunPosition = 372; // Позиция Солнца по X
    private int ySunPosition = 372; // Позиция Солнца по Y

    protected void moveSolarSystem() {
        degreeCount += degreeSpeed; // Увеличиваем угол вращения

        if (degreeCount >= 360) {
            degreeCount = 0; // Сбрасываем угол если он достиг 360
        }

        // Вычисляем координаты Земли относительно Солнца
        double xEarthPosition = xSunPosition + 64 + radius * Math.cos(Math.toRadians(degreeCount));
        double yEarthPosition = ySunPosition + 64 + radius * Math.sin(Math.toRadians(degreeCount));

        // Устанавливаем новых координаты и перерисовываем
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Рисуем Солнце
        if (Sun != null) {
            g.drawImage(Sun, xSunPosition, ySunPosition, (ImageObserver) null);
        }

        // Рисуем Землю
        double xEarthPosition = xSunPosition + 64 + radius * Math.cos(Math.toRadians(degreeCount));
        double yEarthPosition = ySunPosition + 64 + radius * Math.sin(Math.toRadians(degreeCount));

        if (Earth != null) {
            g.drawImage(Earth, (int) xEarthPosition, (int) yEarthPosition, (ImageObserver) null);
        }
    }
}
// Генерируем случайную скорости в диапазоне от 1 до 10
//ySpeed = (int) (Math.random() * 10 + 1);
