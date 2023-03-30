package me.nilme.exercise.mock;

import org.mockito.ArgumentMatcher;

import java.util.List;

class IsListofTwoElements extends ArgumentMatcher<List>
    {
        public boolean matches(Object list)
        {
            return((List)list).size()==2;
        }
    }