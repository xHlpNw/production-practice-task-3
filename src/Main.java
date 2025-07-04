/*
Создать класс Room с следующими полями:
    ● Целочисленное, номер комнаты
    ● Целочисленное, максимальное количество человек в комнате
    ● Целочисленное, цена за ночь
    ● Логическое, забронирована ли комната
Добавить конструкторы (какие нужны для удобства создания объектов, количество человек например можно случайно генерировать).

Реализовать следующую иерархию наследования, в каждом дочернем классе только вызов родительского конструктора.
Room -> EconomyRoom, ProRoom;
ProRoom -> StandardRoom, LuxRoom;
LuxRoom -> UltraLuxRoom

Запретить создание объектов типа Room и ProRoom.

Создать интерфейс RoomService с тремя методами:
    ● clean (почистить комнату)
    ● reserve (зарезервировать комнату)
    ● free (освободить комнату)

Интерфейс должен быть параметризован обобщенным типом (дженериком) только для типа Room и его наследников.
Создать класс и имплементировать созданный интерфейс. Реализовать все методы интерфейса, реализация не важна,
единственное не забудьте при бронировании и освобождении комнаты изменять поле комнаты,
которое отвечает за то занята ли комната или нет.

Создать кастомную непроверяемую ошибку и выбрасывать её при попытке забронировать комнату,
которая уже забронирована (поле имеет значение true).

Протестируйте возможность использования сервиса для любого экземпляра комнаты.

Доп. задания:
    ● Добавить перечисление Prices и хранить в нем цены на комнаты, задавать цены на комнату с помощью перечисления.
    ● Добавить интерфейс LuxRoomService который имеет один новый метод foodDelivery (доставка еды).
        Параметризовать типом LuxRoom и его наследниками. Создать новый класс и реализовать интерфейс. Новый класс
        должен иметь реализацию всех методов интерфейса RoomService (ведь люксовые комнаты тоже комнаты и должны
        иметь базовый функционал) и также метод для доставки продуктов. Подумайте как это можно сделать (есть
        несколько вариантов). Проверьте, что нельзя в новом сервисе заказывать доставку еды из не люксовых комнат.
*/

public class Main {
    public static void main(String[] args) {
        System.out.println("Тестирование RoomService:");
        RoomService<Room> service = new InRoomService<>();
        System.out.print("EconomyRoom: ");
        Room room = new EconomyRoom(101);
        service.reserve(room);
        System.out.print("StandardRoom: ");
        service.reserve(new StandardRoom(201));
        System.out.print("LuxRoom: ");
        service.reserve(new LuxRoom(301));
        System.out.print("UltraLuxRoom: ");
        service.reserve(new UltraLuxRoom(401));

        System.out.println("\nТестирование LuxRoomService:");
        LuxRoomService<LuxRoom> luxService = new InLuxRoomService<>();
        LuxRoom luxRoom = new LuxRoom(303);
        String order = "0,5 минеральной воды без газа, цезарь с курицей";
        System.out.printf("Доставка в комнату №%d заказа '%s'\n",
                luxRoom.getNumber(), order);
        luxService.foodDelivery(luxRoom, order);
        luxService.reserve(luxRoom);
        luxService.foodDelivery(luxRoom, order);
        System.out.println("Проверка работы базового сервиса:");
        luxService.clean(luxRoom);

        System.out.println("\nПроверка исключительной ситуации:");
        try {
            service.reserve(room);
            System.out.printf("Комната №%d была успешно забронирована\n",
            room.getNumber());
        } catch (RoomAlreadyBookedException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Проверка закончена");
        }
        room.setBooked(true);

        System.out.println("\nВывод комнат:");
        System.out.println(room);
        System.out.println(new StandardRoom(202));
        System.out.println(new LuxRoom(302));
        System.out.println(new UltraLuxRoom(402));
    }
}