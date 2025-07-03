public interface LuxRoomService <T extends LuxRoom> extends RoomService<T> {
    public void foodDelivery(T room, String order);
}
