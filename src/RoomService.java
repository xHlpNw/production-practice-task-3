public interface RoomService<T extends Room> {
    void clean();
    void reserve();
    void free();
}
