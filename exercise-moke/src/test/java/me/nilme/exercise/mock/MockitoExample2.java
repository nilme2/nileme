package me.nilme.exercise.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MockitoExample2 {
    @Mock
    private List mockList;

//    public MockitoExample2() {
//        MockitoAnnotations.initMocks(this);
//    }

    @Test
    public void shorthand() {
        mockList.add(1);
        verify(mockList).add(1);
    }
}