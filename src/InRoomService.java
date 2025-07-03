public class InRoomService<T extends Room> implements RoomService<T> {
    @Override
    public void free(T room) {
        if (room.isBooked()) {
            room.setBooked(false);
            System.out.printf("Комната %d освобождена.\n", room.getNumber());
        } else {
            System.out.printf("Комната %d не забронирована.\n", room.getNumber());
        }
    }

    @Override
    public void clean(T room) {
        System.out.printf("Комната %d убрана.\n", room.getNumber());
    }

    @Override
    public void reserve(T room) {
        if (!room.isBooked()) {
            room.setBooked(true);
            System.out.printf("Комната %d забронирована.\n", room.getNumber());
        } else {
            throw new RoomAlreadyBookedException(String.format(
                    "Ошибка! Комната %d уже забронирована.", room.getNumber()
            ));
        }
    }
}
