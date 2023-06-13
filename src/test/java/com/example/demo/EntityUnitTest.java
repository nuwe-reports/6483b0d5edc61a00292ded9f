package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import com.example.demo.entities.*;
import org.junit.jupiter.api.BeforeEach;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@TestInstance(Lifecycle.PER_CLASS)
class EntityUnitTest {

    @Autowired
    private TestEntityManager entityManager;

    private Doctor d1;

    private Patient p1;

    private Room r1;

    private Appointment a1;
    private Appointment a2;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
    
    @BeforeEach
    void loadData(){
        d1 = new Doctor ("Perla", "Amalia", 24, "p.amalia@hospital.accwe");
        
        p1= new Patient("Jose Luis", "Olaya", 37, "j.olaya@email.com");
        
        r1 = new Room("Dermatology");
        
        LocalDateTime startsAt= LocalDateTime.parse("19:30 24/04/2023", formatter);
        LocalDateTime finishesAt = LocalDateTime.parse("20:30 24/04/2023", formatter);
        a1 = new Appointment(p1, d1, r1, startsAt, finishesAt);
        
        startsAt= LocalDateTime.parse("19:30 20/04/2023", formatter);
        finishesAt = LocalDateTime.parse("20:30 20/04/2023", formatter);
        
        a2 = new Appointment(p1, d1, r1, startsAt, finishesAt);
    }
    
    @Test
    void shouldGetDoctor(){
        assertThat(d1.getFirstName()).isEqualTo("Perla");
        assertThat(d1.getLastName()).isEqualTo("Amalia");
        assertThat(d1.getAge()).isEqualTo(24);
        assertThat(d1.getEmail()).isEqualTo("p.amalia@hospital.accwe");
    }

    @Test
    void shouldSetDoctor(){
        d1.setFirstName("Rodrigo");
        d1.setLastName("Quesada");
        d1.setAge(33);
        d1.setEmail("rquesada@hospital.accwe");
        assertThat(d1.getFirstName()).isEqualTo("Rodrigo");
        assertThat(d1.getLastName()).isEqualTo("Quesada");
        assertThat(d1.getAge()).isEqualTo(33);
        assertThat(d1.getEmail()).isEqualTo("rquesada@hospital.accwe");
    }
    
    
    @Test
    void shouldGetPatient(){
        assertThat(p1.getFirstName()).isEqualTo("Jose Luis");
        assertThat(p1.getLastName()).isEqualTo("Olaya");
        assertThat(p1.getAge()).isEqualTo(37);
        assertThat(p1.getEmail()).isEqualTo("j.olaya@email.com");
    }

    @Test
    void shouldSetPatient(){
        p1.setFirstName("Raul");
        p1.setLastName("Funes");
        p1.setAge(23);
        p1.setEmail("raulsergiofunes@gmail.com");
        assertThat(p1.getFirstName()).isEqualTo("Raul");
        assertThat(p1.getLastName()).isEqualTo("Funes");
        assertThat(p1.getAge()).isEqualTo(23);
        assertThat(p1.getEmail()).isEqualTo("raulsergiofunes@gmail.com");
    }
    
    
    @Test
    void shouldGetRoom(){
        assertThat(r1.getRoomName()).isEqualTo("Dermatology");
    }

        @Test
    void shouldGetAppointment(){
        LocalDateTime startsAt= LocalDateTime.parse("19:30 24/04/2023", formatter);
        LocalDateTime finishesAt = LocalDateTime.parse("20:30 24/04/2023", formatter);
        
        assertThat(a1.getDoctor()).isEqualTo(d1);
        assertThat(a1.getPatient()).isEqualTo(p1);
        assertThat(a1.getRoom()).isEqualTo(r1);
        assertThat(a1.getStartsAt()).isEqualTo(startsAt);
        assertThat(a1.getFinishesAt()).isEqualTo(finishesAt);
    }

    @Test
    void shouldSetAppointment(){
        Doctor d2 = new Doctor("Rodrigo", "Quesada", 33, "rquesada@hospital.accwe");
        a1.setDoctor(d2);
        Patient p2 = new Patient("Raul", "Funes", 23, "raulsergiofunes@gmail.com");
        a1.setPatient(p2);
        Room r2 = new Room("Odontology");
        a1.setRoom(r2);
        LocalDateTime startsAt= LocalDateTime.parse("19:30 20/04/2023", formatter);
        a1.setStartsAt(startsAt);
        LocalDateTime finishesAt = LocalDateTime.parse("20:30 20/04/2023", formatter);
        a1.setFinishesAt(finishesAt);
        
        assertThat(a1.getDoctor()).isEqualTo(d2);
        assertThat(a1.getPatient()).isEqualTo(p2);
        assertThat(a1.getRoom()).isEqualTo(r2);
        assertThat(a1.getStartsAt()).isEqualTo(startsAt);
        assertThat(a1.getFinishesAt()).isEqualTo(finishesAt);
    }
    
    
    @Test
    void shouldOverlapCase1(){
        LocalDateTime startsAt= LocalDateTime.parse("19:30 24/04/2023", formatter);
        LocalDateTime finishesAt = LocalDateTime.parse("21:00 24/04/2023", formatter);
        Appointment a_case1 = new Appointment(p1, d1, r1, startsAt, finishesAt);
        assertThat(a1.overlaps(a_case1)).isTrue();
    }
    
    @Test
    void shouldOverlapCase2(){
        LocalDateTime startsAt= LocalDateTime.parse("18:30 24/04/2023", formatter);
        LocalDateTime finishesAt = LocalDateTime.parse("20:30 24/04/2023", formatter);
        Appointment a_case1 = new Appointment(p1, d1, r1, startsAt, finishesAt);
        assertThat(a1.overlaps(a_case1)).isTrue();
    }
    
    @Test
    void shouldOverlapCase3(){
        LocalDateTime startsAt= LocalDateTime.parse("18:30 24/04/2023", formatter);
        LocalDateTime finishesAt = LocalDateTime.parse("20:00 24/04/2023", formatter);
        Appointment a_case1 = new Appointment(p1, d1, r1, startsAt, finishesAt);
        assertThat(a1.overlaps(a_case1)).isTrue();
    }
    
    @Test
    void shouldOverlapCase4(){
        LocalDateTime startsAt= LocalDateTime.parse("19:30 24/04/2023", formatter);
        LocalDateTime finishesAt = LocalDateTime.parse("20:00 24/04/2023", formatter);
        Appointment a_case1 = new Appointment(p1, d1, r1, startsAt, finishesAt);
        assertThat(a1.overlaps(a_case1)).isTrue();
    }
    
    @Test
    void shouldNotOverlap(){
        assertThat(a1.overlaps(a2)).isFalse();
    }    /** TODO
     * Implement tests for each Entity class: Doctor, Patient, Room and Appointment.
     * Make sure you are as exhaustive as possible. Coverage is checked ;)
     */
    
}
