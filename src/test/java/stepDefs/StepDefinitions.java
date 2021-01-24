package stepDefs;

import io.cucumber.java.en.Given;

public class StepDefinitions {
    @Given("sentence Hello World")
    public void print_hello_world() {
        System.out.println("Hello World!");
    }

    @Given("printed {string}")
    public void print_string(String stringToPrint){
        System.out.println(stringToPrint);
    }
}
