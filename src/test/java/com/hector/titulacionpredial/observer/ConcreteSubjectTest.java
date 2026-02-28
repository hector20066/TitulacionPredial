package com.hector.titulacionpredial.observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ConcreteSubject (Observer Pattern) Tests")
class ConcreteSubjectTest {

    @BeforeEach
    void resetSingleton() throws Exception {
        // Reset singleton instance for test isolation
        Field instanceField = ConcreteSubject.class.getDeclaredField("instance");
        instanceField.setAccessible(true);
        instanceField.set(null, null);
    }

    @Nested
    @DisplayName("Singleton Tests")
    class SingletonTests {

        @Test
        @DisplayName("getInstance debe retornar siempre la misma instancia")
        void getInstanceShouldReturnSameInstance() {
            ConcreteSubject instance1 = ConcreteSubject.getInstance();
            ConcreteSubject instance2 = ConcreteSubject.getInstance();
            assertSame(instance1, instance2);
        }

        @Test
        @DisplayName("getInstance nunca debe retornar null")
        void getInstanceShouldNeverReturnNull() {
            assertNotNull(ConcreteSubject.getInstance());
        }
    }

    @Nested
    @DisplayName("Register Tests")
    class RegisterTests {

        @Test
        @DisplayName("register debe agregar un observer exitosamente")
        void registerShouldAddObserver() {
            ConcreteSubject subject = ConcreteSubject.getInstance();
            AtomicInteger counter = new AtomicInteger(0);

            subject.register(counter::incrementAndGet);
            subject.notifyObservers();

            assertEquals(1, counter.get());
        }

        @Test
        @DisplayName("register debe permitir múltiples observers")
        void registerShouldAllowMultipleObservers() {
            ConcreteSubject subject = ConcreteSubject.getInstance();
            AtomicInteger counter = new AtomicInteger(0);

            subject.register(counter::incrementAndGet);
            subject.register(counter::incrementAndGet);
            subject.register(counter::incrementAndGet);

            subject.notifyObservers();

            assertEquals(3, counter.get());
        }
    }

    @Nested
    @DisplayName("Remove Tests")
    class RemoveTests {

        @Test
        @DisplayName("remove debe eliminar un observer del subject")
        void removeShouldRemoveObserver() {
            ConcreteSubject subject = ConcreteSubject.getInstance();
            AtomicInteger counter = new AtomicInteger(0);
            Observer observer = counter::incrementAndGet;

            subject.register(observer);
            subject.remove(observer);
            subject.notifyObservers();

            assertEquals(0, counter.get());
        }

        @Test
        @DisplayName("remove de observer no registrado no debe causar error")
        void removeUnregisteredShouldNotThrow() {
            ConcreteSubject subject = ConcreteSubject.getInstance();
            Observer observer = () -> {};

            assertDoesNotThrow(() -> subject.remove(observer));
        }
    }

    @Nested
    @DisplayName("NotifyObservers Tests")
    class NotifyTests {

        @Test
        @DisplayName("notifyObservers debe notificar a todos los observers registrados")
        void notifyObserversShouldNotifyAll() {
            ConcreteSubject subject = ConcreteSubject.getInstance();
            AtomicInteger counter1 = new AtomicInteger(0);
            AtomicInteger counter2 = new AtomicInteger(0);

            subject.register(counter1::incrementAndGet);
            subject.register(counter2::incrementAndGet);

            subject.notifyObservers();

            assertEquals(1, counter1.get());
            assertEquals(1, counter2.get());
        }

        @Test
        @DisplayName("notifyObservers sin observers no debe lanzar excepción")
        void notifyWithNoObserversShouldNotThrow() {
            ConcreteSubject subject = ConcreteSubject.getInstance();
            assertDoesNotThrow(subject::notifyObservers);
        }

        @Test
        @DisplayName("notifyObservers debe poder llamarse múltiples veces")
        void notifyObserversCanBeCalledMultipleTimes() {
            ConcreteSubject subject = ConcreteSubject.getInstance();
            AtomicInteger counter = new AtomicInteger(0);

            subject.register(counter::incrementAndGet);

            subject.notifyObservers();
            subject.notifyObservers();
            subject.notifyObservers();

            assertEquals(3, counter.get());
        }
    }

    @Nested
    @DisplayName("Interface Implementation Tests")
    class InterfaceTests {

        @Test
        @DisplayName("ConcreteSubject debe implementar Subject")
        void shouldImplementSubject() {
            ConcreteSubject subject = ConcreteSubject.getInstance();
            assertInstanceOf(Subject.class, subject);
        }
    }
}
