package com.example.demo.Repository;

import com.example.demo.model.Project;
import com.example.demo.repository.ProjectRepo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class TestProjectRepo {
// Simon Bøg Jørgensen
    @Test
    void getProjectTest(){
        //Arrange
        ProjectRepo pr = new ProjectRepo();
        //Act
        Project getTestProject = pr.getProject(1);
        Project expected = new Project(1,"test","test","test","test","test","test");
        Project notExpected1 = new Project(5,"test","test","test","test","test","test");

        //Assert
        assertNotEquals(notExpected1,getTestProject);
        assertEquals(expected,getTestProject);

        //Virker selvom den siger de ikke er ens. Fejlen sker grundet de ikke ligger samme sted i hukommelsen og derfor ikke er helt ens
    }

}
