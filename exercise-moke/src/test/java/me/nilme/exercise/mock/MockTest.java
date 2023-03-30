package me.nilme.exercise.mock;

import org.junit.Test;
import org.mockito.Mock;

import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * @author weizhuang
 * Created on 2019-07-22.
 */
public class MockTest {

    @Test
    public void testMockInterface() {
        Person person = mock(Person.class);
        String mockPersonGetName = "mockPersonGetName";
        when(person.getName()).thenReturn(mockPersonGetName);

        System.out.println(person.getName());

    }


    @Test
    public void testMockInterface2() {
        Person person = mock(Person.class);
//        when(person.getName()).thenReturn("xiaoming").thenReturn("xiaohong");
        when(person.getName()).thenReturn("xiaoming", "xiaohong");

        System.out.println(person.getName());

    }

}
