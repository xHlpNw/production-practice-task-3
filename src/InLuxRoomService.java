public class InLuxRoomService<T extends LuxRoom> implements LuxRoomService<T>{
    private final RoomService<T> basicService = new InRoomService<>();
    @Override
    public void foodDelivery(T room, String order) {
        if (room.isBooked()) {
            System.out.printf("В %s №%d был доставлена заказ: %s\n",
                    room.getClass().getName(), room.getNumber(), order);
        } else {
            System.out.println("Ошибка! Невозможно заказать еду в незабронированную комнату");
        }
    }

    @Override
    public void free(T room) {
        basicService.free(room);
    }

    @Override
    public void reserve(T room) {
        basicService.reserve(room);
    }

    @Override
    public void clean(T room) {
        basicService.clean(room);
    }
}
