public class UsersArrayList implements UsersList {
    private User[] dataUser = new User[10];
    private int countUser = 0;

    @Override
    public void addUser(User newUser) {
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
    public User findID(int idUser) {
        for (int i = 0; i < countUser; i++) {
            if (idUser == dataUser[i].getID()) {
                System.out.print("\nFound by ID: ");
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
    public int getAmountUser() {
        System.out.print("\nNumbers of users = ");
        return countUser;
    }


}
