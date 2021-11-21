package dockerTest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class Setup_DockerGrid {

    @BeforeTest
    void startDockerGrid() throws IOException, InterruptedException {

        Runtime.getRuntime().exec("cmd /c start start_dockergrid.bat");
        Thread.sleep(30000); // just to make sure the docker started

        //I add this line to increase the firefox node on docker to increase the process
        Runtime.getRuntime().exec("cmd /c docker-compose scale firefox=3");
        Thread.sleep(5000);
    }

    @AfterTest
    void stopDockerGrid() throws IOException, InterruptedException {

        Runtime.getRuntime().exec("cmd /c start stop_dockergrid.bat");
        Thread.sleep(7000); // just to wait for docker closes

        Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
        //this will close all the command promts in progress
    }
}

