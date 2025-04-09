package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_same_object_returns_correct_bool() {
	    assertEquals(true, team.equals(team));
    }

    @Test
    public void equals_diffferent_class_returns_false(){
	    assertEquals(false, team.equals(null));
    }

    @Test
    public void same_class_returns_correct_bool(){
	    team.addMember("A"); team.addMember("B"); 

	    // Same name, same members
	    Team t2;
	    t2 = new Team("test-team"); t2.addMember("A"); t2.addMember("B");
	    assertEquals(true, team.equals(t2));

	    // Same name, different members
	    t2.addMember("C");
	    assertEquals(false, team.equals(t2));

	    // Different name, same members
	    Team t3; t3 = new Team("something");
	    t3.addMember("A"); t3.addMember("B");
	    assertEquals(false, team.equals(t3));

	    // Different name, different members
	    t3.addMember("C");
	    assertEquals(false, team.equals(t3));

    }

    @Test
    public void equal_classes_returns_same_hash(){
	Team t1 = new Team();
	t1.setName("foo");
	t1.addMember("bar");
	Team t2 = new Team();
	t2.setName("foo");
	t2.addMember("bar");
	assertEquals(t1.hashCode(), t2.hashCode());

	// instantiate t as a Team object
	Team t = new Team();
	int result = t.hashCode();
	int expectedResult = 1;
	assertEquals(expectedResult, result);


    }
}
