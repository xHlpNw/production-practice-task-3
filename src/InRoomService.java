public class InRoomService implements RoomService<Room> {
    private Room room;

    public Room getRoom() {
        return room;
    }

    public InRoomService(Room room) {
        this.room = room;
    }
    @Override
    public void free() {
        if (room.isBooked()) {
            room.setBooked(false);
            System.out.printf("Комната %d освобождена.\n", room.getNumber());
        } else {
            System.out.printf("Комната %d не забронирована.\n", room.getNumber());
        }
    }

    @Override
    public void clean() {
        System.out.printf("Комната %d убрана.\n", room.getNumber());
    }

    @Override
    public void reserve() {
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
