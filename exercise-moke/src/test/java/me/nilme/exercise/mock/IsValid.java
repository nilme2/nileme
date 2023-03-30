package me.nilme.exercise.mock;

import org.mockito.ArgumentMatcher;

import java.util.List;

class IsValid extends ArgumentMatcher<List> {
    @Override
    public boolean matches(Object o) {
        return o == new Integer(1) || o == new Integer(2) ;
    }
}