package lesson4.homework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class HwTriangleTest {

    HwTriangle hwTriangle=new HwTriangle();
    private static Logger logger= LoggerFactory.getLogger(HwTriangle.class);

    @BeforeAll
    static void beforeAll() {
        logger.info("Выполнится перед всем тестовым набором.");
    }

    @BeforeEach
    void setUp() {
        logger.info("Выполнится перед каждым тестом."+"\n");
    }


    @Test
    void testHwTrianglePositiv() {
        System.out.println("Выполняем тест с положительными числами."+"\n");
        boolean result = hwTriangle.triangleArea(3, 4, 5);
        System.out.println("Площадь треугольника со значениями" + " (int a, int b, int c) " + "составляет: " + result +"\n");
        Assertions.assertTrue(result);
    }

    @Test
    void testHwTriangleWithZero() {
        System.out.println("Выполняем тест с нулевым числом."+"\n");
        boolean result = hwTriangle.triangleArea(3, 4, 0);
        Assertions.assertTrue(result);
    }

    @Test
    void testHwTriangleWithNegativNumber() {
        System.out.println("Выполняем тест с отрицательным числом."+"\n");
        boolean result = hwTriangle.triangleArea(3, 4, -5);
        Assertions.assertTrue(result);
    }


    @AfterEach
    void tearDown() {
        logger.debug("Выполнится после каждого теста. Тест закончился.");
        System.out.println("Выполнится после каждого теста. Тест закончился.");
    }


    @AfterAll
    static void afterAll() {
        logger.debug("Выполнится после всех тестовых наборов. Тестовый набор закончился.");
        System.out.println("Выполнится после всех тестовых наборов. Тестовый набор закончился.");
    }

}
