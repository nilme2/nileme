package me.nilme.exercise.mock;

import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by nilme on 2020/6/8.
 */
public class MockitoTest3 {

    @Test
    public void answerTest() {
        List mockList = mock(List.class);
        when(mockList.get(anyInt())).thenAnswer(new CustomAnswer());
        assertEquals("hello world:0", mockList.get(0));
        assertEquals("hello world:999", mockList.get(999));
    }

    private class CustomAnswer implements Answer<String> {
        @Override
        public String answer(InvocationOnMock invocation) throws Throwable {
            Object[] args = invocation.getArguments();
            return "hello world:" + args[0];
        }
    }


    @Test
    public void mytest(){
        Person person = mock(Person.class);
        person.setId(1);

        PersonService personService = mock(PersonService.class);
        PersonDao personDao = mock(PersonDao.class);

        when(personDao.update(person)).thenReturn(true);

        personService.update(person);

        personDao.update(person);


    }

    class Person {
        private int id;
        private String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    interface PersonDao {
        public boolean update(Person person);
    }

    class PersonService {
        private PersonDao personDao;

        PersonService(PersonDao personDao) {
            this.personDao = personDao;
        }

        public void update(Person person) {
            person.setName(UUID.randomUUID().toString());
            personDao.update(person);
        }
    }

    @Test
    public void unstubbed_invocations(){
        //mock对象使用Answer来对未预设的调用返回默认期望值
        List mock = mock(List.class, (Answer) invocation -> 999);
        //下面的get(1)没有预设，通常情况下会返回NULL，但是使用了Answer改变了默认期望值
        assertEquals(999, mock.get(1));
        //下面的size()没有预设，通常情况下会返回0，但是使用了Answer改变了默认期望值
        assertEquals(999,mock.size());
    }

    @Test
    public void real_partial_mock(){
        //通过spy来调用真实的api
        List list = spy(new ArrayList());
        assertEquals(0,list.size());
        A a  = mock(A.class);
        //通过thenCallRealMethod来调用真实的api
        when(a.doSomething(anyInt())).thenCallRealMethod();
        assertEquals(999,a.doSomething(999));
    }


    class A{
        public int doSomething(int i){
            return i;
        }
    }
}
