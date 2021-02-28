import model.Courses;
import model.QaStudent;
import model.Registration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.BaseFunc;
import pages.SuccessPage;
import pages.qaguru.HomePage;
import pages.qaguru.RegistrationPage;

import java.sql.Driver;

public class QaGuruTests {
    private final String SUCCESS_TXT = "Paldies! Reģistrācija ir veiksmīga. Tuvākajā laikā mēs sazināsimies ar jums un piedāvāsim detalizēto informāciju par kursu, laiku un norises vietu :)";
    public final String URL = "http://qaguru.lv/totest";
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private BaseFunc baseFunc = new BaseFunc();

    @Test
    public void registrationCheck() {

        LOGGER.info("This test will try to do succesfull registration");
        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openUrl(URL);

        HomePage homePage = new HomePage(baseFunc);
        RegistrationPage registrationPage = homePage.openRegistrationPage();

        QaStudent student = new QaStudent();
        student.setFirstName("AT FN");
        student.setLastName("AT FN");
        student.setEmail("ats@ats.lv");
        student.setPhone("22222222");

        Registration registration = new Registration();
        registration.setStudent(student);
        registration.setCode("CODE");
        registration.setComment("Comment here");
        registration.setCourses(Courses.QA2);

        registrationPage.fillInRegistrationForm(registration);
        registrationPage.submitForm();

        SuccessPage successPage = new SuccessPage(baseFunc);
        Assertions.assertEquals(SUCCESS_TXT, successPage.getSUCCESS_TXT(), "Problems with success msg");

    }

@AfterEach
public void closeBrowser() {
    baseFunc.closeBrowser();
}

}
