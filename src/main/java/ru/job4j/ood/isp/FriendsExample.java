package ru.job4j.ood.isp;

public class FriendsExample {
    class He implements Friendship {
        @Override
        public void trust() {

        }

        @Override
        public void interest() {

        }

        @Override
        public void time() {

        }

        @Override
        public void laugh() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void money() {
            throw new UnsupportedOperationException();
        }
    }

    class She implements Friendship {
        @Override
        public void trust() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void interest() {

        }

        @Override
        public void time() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void laugh() {

        }

        @Override
        public void money() {

        }
    }
}
