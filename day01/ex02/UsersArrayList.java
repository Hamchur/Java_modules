public class UsersArrayList implements UsersList {
    private User[] dataUser = new User[10];
    private int countUser = 0;

    @Override
    public void add(User newUser) {
        if (countUser >= dataUser.length) {
            User[] temp = new User[dataUser.length * 2];
            for (int i = 0; i < dataUser.length; i++) {
                temp[i] = dataUser[i];
            }
            dataUser = temp;
        }
        dataUser[countUser++] = newUser;
    }

    @Override
    public User findId(int idUser) {
        for (int i = 0; i < countUser; i++) {
            if (idUser == dataUser[i].getId()) {
                System.out.print("Found by Id: ");
                return dataUser[i];
            }
        }
        throw new UserNotFoundException();
    }

    @Override
    public User findIndex(int indexUser) {
        if (indexUser > countUser) {
            throw new UserNotFoundException();
        }
        System.out.print("\nFound by Index: ");
        return dataUser[indexUser];
    }

    @Override
    public int getAmount() {
        System.out.print("\nNumber of users = ");
        return countUser;
    }


}