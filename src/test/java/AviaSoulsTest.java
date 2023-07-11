import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

class AviaSoulsTest {


    @Test
    void compareToTest() {
        AviaSouls client = new AviaSouls();
        Ticket ticket1 = new Ticket("Шереметьево",
                "Шарм-эль-шейх", 40000, 6, 5);
        Ticket ticket2 = new Ticket("Шереметьево",
                "Шарм-эль-шейх", 20000, 8, 7);
        Ticket ticket3 = new Ticket("Шереметьево",
                "Шарм-эль-шейх", 100000, 2, 1);
        Ticket ticket4 = new Ticket("Шереметьево",
                "Шарм-эль-шейх", 60000, 4, 3);
        Ticket ticket5 = new Ticket("Шереметьево",
                "Мадрид", 80000, 4, 3);
        //добавляем био=леты в массив типа AviaSouls
        client.add(ticket1);
        client.add(ticket2);
        client.add(ticket3);
        client.add(ticket4);
        client.add(ticket5);
        //Создаем переменные ожидаемого результата
        //Переменная для выдачи массива каким он есть
        Ticket[] expected1 = {ticket1, ticket2, ticket3, ticket4, ticket5};
        //Переменная для выдачи массива в порядке цены
        Ticket[] expected2 = {ticket2, ticket1, ticket4, ticket3};
        //Переменная для выдачи массива в порядке времени полета
        Ticket[] expected3 = {ticket3, ticket4, ticket1, ticket2};
        //Переменная для выдачи массива на запрос, на который есть один билет
        Ticket[] expected4 = {ticket5};
        //Переменная для выдачи массива на запрос, на который нет билетов
        Ticket[] expected5 = {};

        //Создес компаратор определяющий по времени полета
        TicketTimeComparator compare = new TicketTimeComparator();

        //проверка на выдачу массива как такового
        Assertions.assertArrayEquals(expected1, client.findAll());

        //проверка на сортировку по цене
        Assertions.assertArrayEquals(expected2, client.searchAndSortBy("Шереметьево", "Шарм-эль-шейх", Ticket::compareTo));
        //проверка на сортировку по времени перелёта
        Assertions.assertArrayEquals(expected3, client.searchAndSortBy("Шереметьево", "Шарм-эль-шейх", compare));
        //проверка на массив с одной переменной
        Assertions.assertArrayEquals(expected4, client.search("Шереметьево", "Мадрид"));
        Assertions.assertArrayEquals(expected4, client.searchAndSortBy("Шереметьево", "Мадрид", compare));
        Assertions.assertArrayEquals(expected4, client.searchAndSortBy("Шереметьево", "Мадрид", Ticket::compareTo));
        //проверка на массив с пустым содержимым
        Assertions.assertArrayEquals(expected5, client.search("Шереметьево", "Париж"));
        Assertions.assertArrayEquals(expected5, client.searchAndSortBy("Шереметьево", "Париж", compare));
        Assertions.assertArrayEquals(expected5, client.searchAndSortBy("Шереметьево", "Париж", Ticket::compareTo));
    }
}