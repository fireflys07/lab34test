import Character.*;
import Location.*;
import Transport.*;

public class Main {

    
    public static void main(String[] args) {
        System.out.printf("=== Жил был Ганс, младший сын в семье.%nОн ничем особо не выделялся, поэтому его выгнали из дома на его 18-ти летие.%n.%n ===%n");

        // Создание объектов

        // Ганс с случайными характеристиками
        int hansDirt = 30 + (int) (Math.random() * 80); // 30-110
        int hansYears = 5 + (int) (Math.random() * 5); // 5-10
        Gans hans = new Gans("Ганс", hansYears, hansDirt);
        Horse horse = new Horse();

        Miller miller = new Miller("Мельник", 100);
        Princess princess = new Princess("Принцесса", 10);

        Mill mill = new Mill(40);
        Barn barn = new Barn(5, (int) (Math.random() * 4)); // 0-3 жильца

        Carriage carriage = new Carriage();
        int horseCount = 2 + (int) (Math.random() * 6); // 2-7 лошадей
        for (int i = 0; i < horseCount; i++) {
            carriage.addHorse(new Horse(10 + (int) (Math.random() * 10)));
        }

        System.out.println("Созданы объекты:");
        System.out.println("- " + hans);
        System.out.println("- " + miller);
        System.out.println("- " + princess);
        System.out.println("- Мельница (мин. чистота: " + mill.getMinCleanLevel() + ")");
        System.out.println("- Амбар (вместимость: " + barn.getMaxCapacity() + ", жильцов: " + barn.getOccupants() + ")");
        System.out.println("- Карета с " + horseCount + " лошадьми\n");

        // ЭТАП 1: Ганс ищет убежище
        System.out.println("=== Ганс служил при дворе. Как кончилась его служба он пошел искать себе прибежище ===");
        boolean foundShelter = false;

        try {
            if (hans.getDirtLevel() <= 40) {
                // Ганс остается в мельнице
                mill.enter(hans);
                miller.validateAppearance(hans);
                System.out.println("Гансу позволили остаться работать в мельнице. Убежище найдено");
                foundShelter = true;
            } else if (hans.getDirtLevel() > 100) {
                throw new ExcessiveDirtException("Уровень грязи: " + hans.getDirtLevel());
            } else {
                // Ганс слишком грязный для мельницы
                throw new InvalidAppearanceException("Уровень грязи: " + hans.getDirtLevel());
            }
        } catch (ExcessiveDirtException e) {
            System.out.println("Ошибка: " + e.getMessage());
            System.out.println("-Поди прочь с глаз моих! *Ганс отправляется в Амбар");
            foundShelter = false;
        } catch (InvalidAppearanceException e) {
            System.out.println("Мельник: " + e.getMessage());
            miller.speak();
            System.out.println("-Поди прочь с глаз моих! *Ганс отправляется в Амбар");
            foundShelter = false;
        }

        // Если не нашел убежище в мельнице, отправляем в амбар
        if (!foundShelter) {
            try {
                barn.enter(hans);
                System.out.println("К сожалению не получилось найти прибежище на мельнице, Гану пришлось жить в Амбре");
                foundShelter = true;
            } catch (OvercrowdedBarnException e) {
                System.out.println("Ошибка: " + e.getMessage());
                System.out.println("Ночь в коВОРКЕ, то есть на улице");
                foundShelter = false;
            }
        }

        System.out.println();

        // ЭТАП 2: Прибытие принцессы
        System.out.println("=== Спустя три дня... ===");
        horse.sound();

        try {
            carriage.dispatch();
            System.out.println("Принцесса прибывает в золотой карете");
            princess.act();
            princess.speak();

            System.out.println("\nГанс решает представить себя Принцессе");

            try {
                hans.presentToPrincess();
                princess.recognize(hans);
            } catch (NotEnoughYearsException e) {

                System.out.println("Ошибка при представлении: " + e.getMessage());
                System.out.println("ГАНС УМЕР ОТ ХОЛОДА И ГОЛОДА");
            } catch (TooDirtyRuntimeException e) {


                System.out.println("КРИТИЧЕСКАЯ ОШИБКА: " + e.getMessage());
                System.out.println("ГАНС УМЕР ОТ ХОЛОДА И ГОЛОДА");
            }

        } catch (NotEnoughHorsesException e) {
            System.out.println("Ошибка: " + e.getMessage());
            System.out.println("Принцесса не может приехать");
            System.out.println("ГАНС УМЕР ОТ ХОЛОДА И ГОЛОДА");
        } catch (TooManyHorsesException e) {
            System.out.println("Ошибка: " + e.getMessage());
            System.out.println("Принцесса не может приехать");
            System.out.println("ГАНС УМЕР ОТ ХОЛОДА И ГОЛОДА");
        }
        System.out.println(" ");
        System.out.printf(
                "У каждой истории есть начало и конец.%n" +
                        "У каждой истории есть канва, синапсис, содержание, ключевые моменты, пролог и эпилоги.%n%n" +
                        "И нет такой книги, в которой при каждом новом прочтении не открывались бы вещи, на которые раньше не обращал внимания.%n%n" +
                        "Но у каждой книги есть своя последняя страница,%n" +
                        "перевернув которую мы ставим книгу на полку.%n" +
                        "Чтобы завтра открыть новую...%n"
        );

    }
}
