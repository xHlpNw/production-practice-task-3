/*
Создать класс Room с следующими полями:
    ● Целочисленное, номер комнаты
    ● Целочисленное, максимальное количество человек в комнате
    ● Целочисленное, цена за ночь
    ● Логическое, забронирована ли комната
Добавить конструкторы (какие нужны для удобства создания объектов, количество человек например можно случайно генерировать).
*/

import java.util.Random;

public abstract class Room {
    private final int number;
    private int capacity;
    private int price;
    private boolean isBooked;

    public Room(int number) {
        this.number = number;
        isBooked = false;
        price = RoomPrice.findByTitle(getClass().getName()).price;
        capacity = new Random().nextInt(1, 6);
    }

    public Room(int number, int capacity, int price) {
        this.number = number;
        this.capacity = capacity;
        this.price = price;
        isBooked = false;
    }

    public int getNumber() {
        return number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price >= 0) this.price = price;
        else throw new IllegalArgumentException("Цена за сутки должна быть неотрицательной.");
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    @Override
    public String toString() {
        return String.format("%s №%d, цена за сутки: %d руб., статус: %s",
                getClass().getName(), number, price, isBooked ? "занят" : "свободен");
    }
}
