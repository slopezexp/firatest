package com.demo.services.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonServiceImplTest {


    @Mock
    PersonRepository personRepository;

    @InjeckMocks
    PersonServiceImpl personServiceImpl = new PersonServiceImpl(personRepository);    


    @Test
    void getByName() {

        String name = "John";

        when(personRepository.findByName(name)).thenReturn(new Person("John", 25));

       
        List<Person> result =  personServiceImpl.getByName("John");
        
        assertEquals(1, result.size());
        assertEquals("John", result.get(0).getName());
        
        verify(personRepository).findByName(name);
        verifyNoMoreInteractions(personRepository);

    }
}
