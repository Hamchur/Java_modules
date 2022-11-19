public interface UsersList {
    public void add(User user);
    public User findId(int id);
    public User findIndex(int index);
    public int getAmount();
}
