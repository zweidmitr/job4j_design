package ru.job4j.ood.isp;

public class AlarmExample {
    class FitnessBracelet implements AlarmClock {
        @Override
        public void sound() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void vibration() {
            /*
               реализация
             */
        }

        @Override
        public void turnLight() {
            throw new UnsupportedOperationException();
        }
    }

    class Telephone implements AlarmClock {
        @Override
        public void sound() {
            /*
               реализация
             */
        }

        @Override
        public void vibration() {
            /*
               реализация
             */
        }

        @Override
        public void turnLight() {
            throw new UnsupportedOperationException();

        }
    }

    class Computer implements AlarmClock {
        @Override
        public void sound() {
            /*
               реализация
             */
        }

        @Override
        public void vibration() {
            /*
               реализация
             */
        }

        @Override
        public void turnLight() {
            /*
               реализация
             */
        }
    }
}
