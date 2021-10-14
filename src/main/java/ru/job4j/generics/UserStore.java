package ru.job4j.generics;

public class UserStore implements Store<User> {

    private final Store<User> store = new MemStore<>();

    @Override
    public void add(User model) {
        store.add(model);
    }

    @Override
    public boolean replace(String id, User model) {
        store.replace(id, model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        store.delete(id);
        return true;
    }

    @Override
    public User findById(String id) {
        return store.findById(id);
    }

    public static void main(String[] args) {
        User one = new User("first");
        User two = new User("second");
        User three = new User("third");
        User four = new User("fourth");
        UserStore store = new UserStore();
        store.add(one);
        store.add(two);
        store.add(three);
        System.out.println(store.findById(two.getId()));
        System.out.println(store.delete(two.getId()));
        System.out.println(store.findById(two.getId()));
        System.out.println(store.replace("first", four));
        System.out.println("one is " + store.findById(one.getId()));

    }
}
