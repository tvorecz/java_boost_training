package edu.dzmtr.zrch.java.core.collections.case1;

import static org.junit.Assert.assertEquals;

import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

import org.junit.Test;

/**
 * @author Dzmitry_Zorych
 */
public class SetIterationTest {

    @Test
    public void testRemovingFromSetWhileIterating() {
        Set<String> uniqueStrings = new HashSet<>();

        uniqueStrings.add("one");
        uniqueStrings.add("two");
        uniqueStrings.add("three");
        uniqueStrings.add("five");

        Iterator<String> stringIterator = uniqueStrings.iterator();

        while (stringIterator.hasNext()) {
            stringIterator.next();
            stringIterator.remove();
        }

        assertEquals(0, uniqueStrings.size());
    }

    @Test(expected = IllegalStateException.class)
    public void testMultipleRemovingFromSetWhileIterating() {
        Set<String> uniqueStrings = new HashSet<>();

        uniqueStrings.add("one");
        uniqueStrings.add("two");
        uniqueStrings.add("three");
        uniqueStrings.add("five");

        Iterator<String> stringIterator = uniqueStrings.iterator();

        while (stringIterator.hasNext()) {
            stringIterator.next();
            stringIterator.remove();
            stringIterator.remove(); //throws exception
        }
    }

    @Test
    public void testChangingObjectsInTheSetWhileIterating() {
        Set<Participant> participants = new HashSet<>();

        participants.add(new Participant("Ihor", 21));
        participants.add(new Participant("Dima", 18));
        participants.add(new Participant("Maria", 20));
        participants.add(new Participant("Tanya", 17));
        participants.add(new Participant("Mike", 22));

        Iterator<Participant> participantIterator = participants.iterator();

        while (participantIterator.hasNext()) {
            Participant next = participantIterator.next();
            next.setAge(next.getAge() + 1);
        }

        assertEquals(5, participants.size());
    }

    @Test(expected = ConcurrentModificationException.class)
    public void testAddingObjectsToTheSetWhileIterating() {
        Set<Participant> participants = new HashSet<>();

        participants.add(new Participant("Ihor", 21));
        participants.add(new Participant("Dima", 18));
        participants.add(new Participant("Maria", 20));
        participants.add(new Participant("Tanya", 17));
        participants.add(new Participant("Mike", 22));

        Iterator<Participant> participantIterator = participants.iterator();
        int counter = 0;

        while (participantIterator.hasNext()) {
            participantIterator.next();
            if (counter == 3) {
                participants.add(new Participant("Tom", 19)); //throws ConcurrentModificationException
            }
            counter++;
        }
    }

    @Test
    public void testAddingObjectsToTheConcurrentSetWhileIterating() {
        Set<Participant> participants = new ConcurrentSkipListSet<>();

        participants.add(new Participant("Ihor", 21));
        participants.add(new Participant("Dima", 18));
        participants.add(new Participant("Maria", 20));
        participants.add(new Participant("Tanya", 17));
        participants.add(new Participant("Mike", 22));

        Iterator<Participant> participantIterator = participants.iterator();
        int counter = 0;

        while (participantIterator.hasNext()) {
            participantIterator.next();
            if (counter == 3) {
                participants.add(new Participant("Tom", 19));
            }
            counter++;
        }

        assertEquals(6, participants.size());
        assertEquals(5, counter);
    }

    @Test
    public void shouldHandleAnotherThreadRemovingObjectsWhileIterating() throws InterruptedException {
        Set<Participant> participants = new ConcurrentSkipListSet<>();

        participants.add(new Participant("Ihor", 21));
        participants.add(new Participant("Dima", 18));
        participants.add(new Participant("Maria", 20));
        participants.add(new Participant("Tanya", 17));
        participants.add(new Participant("Mike", 22));

        Thread remover = new Thread(new Runnable() {
            @Override
            public void run() {
                participants.remove(new Participant("Maria", 20));
                System.out.println("Participant(\"Maria\", 20) is deleted by another thread");
            }
        });

        Iterator<Participant> participantIterator = participants.iterator();
        int counter = 0;

        while (participantIterator.hasNext()) {
            participantIterator.next();
            if (counter == 2) {
                remover.run();
                Thread.sleep(5000);
                participantIterator.remove();
                System.out.println("Participant(\"Maria\", 20) is removed by current thread iterator");
            }
            counter++;
        }

        assertEquals(4, participants.size());
        assertEquals(5, counter);
    }
}