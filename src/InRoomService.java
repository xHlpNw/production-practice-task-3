public class InRoomService implements RoomService<Room> {
    @Override
    public void free(Room room) {
        room.setBooked(false);
        System.out.printf("Комната %d освобождена.", room.getNumber());
    }

    @Override
    public void clean(Room room) {
        System.out.printf("Комната %d убрана.", room.getNumber());
    }

    @Override
    public void reserve(Room room) {
        room.setBooked(true);
        System.out.printf("Комната %d забронирована.", room.getNumber());
    }
}
