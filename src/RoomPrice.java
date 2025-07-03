public enum RoomPrice {
    ECONOMY ("EconomyRoom", 3500),
    STANDARD ("StandardRoom", 5500),
    LUX ("LuxRoom", 9000),
    ULTRALUX ("UltraLuxRoom", 12000);

    final String title;
    final int price;
    RoomPrice(String title, int price) {
        this.title = title;
        this.price = price;
    }

    // Поиск элемента enum по title
    public static RoomPrice findByTitle(String title) {
        for (RoomPrice roomPrice : values()) {
            if (roomPrice.title.equals(title)) {
                return roomPrice;
            }
        }
        throw new IllegalArgumentException("Некорректный тип комнаты: " + title);
    }
}
