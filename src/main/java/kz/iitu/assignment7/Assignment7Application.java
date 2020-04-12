package kz.iitu.assignment7;
import kz.iitu.assignment7.model.*;
import kz.iitu.assignment7.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Assignment7Application {
	public static void main(String[] args) {
		SpringApplication.run(Assignment7Application.class, args);
	}
}
