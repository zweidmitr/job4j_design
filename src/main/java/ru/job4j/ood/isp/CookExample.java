package ru.job4j.ood.isp;

public class CookExample {
    class MyHome implements CookAtHome {
        @Override
        public void gasStove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void electricStove() {
            /*
               реализация
             */
        }

        @Override
        public void microwave() {
            /*
               реализация
             */
        }

        @Override
        public void lazyLunch() {
            /*
               реализация
             */
        }
    }

    class FriendHome implements CookAtHome {
        @Override
        public void gasStove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void electricStove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void microwave() {
            /*
               реализация
             */
        }

        @Override
        public void lazyLunch() {
            /*
               реализация
             */
        }
    }

    class BrotherHome implements CookAtHome {
        @Override
        public void gasStove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void electricStove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void microwave() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void lazyLunch() {
            /*
               реализация
             */
        }
    }
}
