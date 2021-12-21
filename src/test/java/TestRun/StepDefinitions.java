package TestRun;

import PageObjects.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StepDefinitions {

    public static final WebDriver webDriver;
    public static final MainPage mainPage;
    public static final AllCoursesPage allCoursesPage;
    public static final DataScienceCoursePage dataScienceCoursePage;
    public static final QaJavaCoursePage qaJavaCoursePage;
    public static final UnityDeveloperCoursePage unityDeveloperPage;
    public static final PartnerProgramPage partnerProgramPage;

    static  {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        mainPage = new MainPage(webDriver);
        allCoursesPage = new AllCoursesPage(webDriver);
        dataScienceCoursePage = new DataScienceCoursePage(webDriver);
        qaJavaCoursePage = new QaJavaCoursePage(webDriver);
        unityDeveloperPage = new UnityDeveloperCoursePage(webDriver);
        partnerProgramPage = new PartnerProgramPage(webDriver);
    }

    @Given("стартовая cтраница школы SkillFactory")
    public void стартовая_cтраница_школы_Skillfactory() {
        mainPage.startMainPage();
    }

    @When("находимся на стартовой странице закрыть рекламу")
    public void находимся_на_стартовой_странице_закрыть_рекламу() {
        mainPage.closeAdvertising();
    }

    @Then("находимся на стартовой странице нажать на выпадающий список и выбрать раздел Все курсы")
    public void находимся_на_стартовой_странице_нажать_на_выпадающий_список_и_выбрать_раздел_Все_курсы() {
        mainPage.chooseAllCoursesCategory();
    }
    @Then("в разделе Все курсы найти заголовок {string}")
    public void в_разделе_Все_курсы_найти_заголовок(String expectedResult) {
        String actualResult = allCoursesPage.getAllCoursesHeader();
        assertEquals(expectedResult, actualResult);
    }
    @When("находимся на стартовой странице нажать на выпадающий список и выбрать раздел Data Science")
    public void находимся_на_стартовой_странице_нажать_на_выпадающий_список_и_выбрать_раздел_data_science() {
        mainPage.chooseDataScienceCategory();
    }

    @Then("в разделе выбрать курс Data Science")
    public void в_разделе_выбрать_курс_data_science() {
        allCoursesPage.chooseDataScienceCourse();
    }

    @Then("проверить переход на страницу {string}")
    public void проверить_переход_на_страницу(String expectedResult) {
        String actualResult = dataScienceCoursePage.getDataScienceCoursePageHeader();
        assertEquals(expectedResult, actualResult);
    }
    @Then("в разделе выбрать курс QA инженер на Java")
    public void в_разделе_выбрать_курс_qa_инженер_на_java() {
        allCoursesPage.chooseQAJavaAutomationCourse();
    }
    @Then("проверить переход на страницу курса по тестированию {string}")
    public void проверить_переход_на_страницу_курса_по_тестированию(String expectHeader) {
        assertEquals(expectHeader, qaJavaCoursePage.getQaJavaAutomationHeader());
    }
    @Then("в разделе выбрать курс Разаботчик игр на Unity")
    public void в_разделе_выбрать_курс_разаботчик_игр_на_unity() {
        allCoursesPage.chooseUnityDeveloperCourse();
    }
    @Then("проверить переход на страницу курса по разработке игр {string}")
    public void проверить_переход_на_страницу_курса_по_разработке_игр(String expectHeader) {
        assertEquals(expectHeader, unityDeveloperPage.getUnityDeveloperPageHeader());
    }
    @Then("в страниице курса по Data Science нажать на Программа специализации")
    public void в_страниице_курса_по_data_science_нажать_на_программа_специализации() {
        dataScienceCoursePage.clickDataScienceCourseGetProgramButton();
    }
    @Then("проверить переход в раздел заполнения формы {string}")
    public void проверить_переход_в_раздел_заполнения_формы(String expectHeader) {
        assertEquals(expectHeader, dataScienceCoursePage.getDataScienceCourseProgramFormHeader());
    }
    @Then("заполнить форму получения прораммы и убрать галочку из чек бокса")
    public void заполнить_форму_получения_прораммы_и_убрать_галочку_из_чек_бокса() {
        dataScienceCoursePage.fillFormProgram();
    }
    @Then("проверить появление ошибки о подтверждении обработки персональных данных {string}")
    public void проверить_появление_ошибки_о_подтверждении_обработки_персональных_данных (String expectMessage) {
        assertEquals(expectMessage, dataScienceCoursePage.getProgramCheckBoxErrorMessage());
    }
    @Then("без заполнения обязательных полей нажать на кнопку Отправить")
    public void без_заполнения_обязательных_полей_нажать_на_кнопку_отправить() {
        dataScienceCoursePage.clickSubmitButtonWithoutFillProgram();
    }
    @Then("проверить появление ошибки о незаполненных обязательных полях {string}")
    public void проверить_появление_ошибки_о_незаполненных_обязательных_полях(String expectMessage) {
        assertEquals(expectMessage, dataScienceCoursePage.getFormProgramEmptyFieldsErrorMessage());
    }
    @Then("отправить форму получения прораммы с некорректным email {string}")
    public void отправить_форму_получения_прораммы_с_некорректным_email(String incorrectEmail) {
        dataScienceCoursePage.inputIncorrectEmail(incorrectEmail);
    }
    @Then("проверить появление ошибки о введенном некорректном email {string}")
    public void проверить_появление_ошибки_о_введенном_некорректном_email(String expectMessage) {
        assertEquals(expectMessage, dataScienceCoursePage.getFormProgramIncorrectEmailErrorMessage());
    }
    @Then("в чекбоксе Тематика выбрать C#")
    public void в_чекбоксе_тематика_выбрать_c() {
        allCoursesPage.selectCheckBoxThemeCSharp();
    }

    @Then("в чекбоксе Длительность выбрать от 0 до 12")
    public void в_чекбоксе_длительность_выбрать_от_до() {
        allCoursesPage.selectCheckBoxDurationFrom0To12();
    }

    @Then("в выборке проверить что Длительность не более {string}")
    public void в_выборке_проверить_что_длительность_не_более(String duration) {
        for (Object elem : allCoursesPage.getListOfCourseDurations()) {
            assertEquals(duration, elem);
        }
    }
    @Then("в выборке проверить что количество найденых курсов не равно 0")
    public void в_выборке_проверить_что_количество_найденых_курсов_не_равно() {
        assertTrue(allCoursesPage.getListOfCourse().size() != 0);
    }
    @When("находимся на стартовой странице нажать в футере на ссылку Хабр")
    public void находимся_на_стартовой_странице_нажать_в_футере_на_ссылку_хабр() {
        mainPage.clickHabrLink();
    }

    @Then("удостовериться в переходе на Хабр {string}")
    public void удостовериться_в_переходе_на_Хабр(String habrLink) {
        assertEquals(habrLink, mainPage.getUrlFromNewPage());
    }

    @When("находимся на стартовой странице нажать в футере на ссылку Вконтакте")
    public void находимся_на_стартовой_странице_нажать_в_футере_на_ссылку_вконтакте() {
        mainPage.clickVKLink();
    }

    @Then("удостовериться в переходе в Вконтакте {string}")
    public void удостовериться_в_переходе_в_вконтакте(String vkLink) {
        assertEquals(vkLink, mainPage.getUrlFromNewPage());

    }

    @When("нажать на Центр карьеры")
    public void нажать_на_центр_карьеры() {
        allCoursesPage.goToCareerCenterPage();
    }
    @Then("удостовериться в переходе на страницу {string}")
    public void удостовериться_в_переходе_на_страницу(String expectCareeCenterHeader) {
        assertEquals(expectCareeCenterHeader, allCoursesPage.getCareerCenterPageHeader());
    }

    @Then("на странице курса нажать Записаться")
    public void на_странице_курса_нажать_записаться() {
        dataScienceCoursePage.clickSignUpOnCourseButton();
    }
    @Then("выбрать оптимальный тариф")
    public void выбрать_оптимальный_тариф() {
        dataScienceCoursePage.chooseOptimalTarif();
    }
    @Then("заполнить форму для записи на курс")
    public void заполнить_форму_для_записи_на_курс() {
        dataScienceCoursePage.fillFormForSignUpOnCourse();
    }
    @Then("не заполнять обязательные поля")
    public void не_заполнять_обязательные_поля() {
        dataScienceCoursePage.formSubmitClick();
    }
    @Then("проверить сообщение об ошибке {string}")
    public void проверить_сообщение_об_ошибке(String expectedErrorMessage) {
        assertEquals(expectedErrorMessage, dataScienceCoursePage.getFormErrorMessage());
    }
    @Then("в форме ввести некорректный момер телефона {string} и подтвердить отправку формы")
    public void в_форме_ввести_некорректный_момер_телефона_и_подтвердить_отправку_формы(String incorrectPhoneNumber) {
        dataScienceCoursePage.inputIncorrectPhoneNumber(incorrectPhoneNumber);
    }
    @Then("проверить сообщение об ошибке ввода некорректного номера телефона {string}")
    public void проверить_сообщение_об_ошибке_некорректного_номера_теефона(String expectedErrorMessage) {
        assertEquals(expectedErrorMessage, dataScienceCoursePage.getFormPhoneErrorMessage());
    }
    @When("находимся на стартовой ввести Email в поле новостной рассылки")
    public void находимся_на_стартовой_ввести_email_в_поле_новостной_рассылки() {
        mainPage.inputEmailForMailing();
    }
    @Then("убоать галочку с чекбокса о согласии на обработку персональных данных")
    public void убоать_галочку_с_чекбокса_о_согласии_на_обработку_персональных_данных() {
        mainPage.putAwayFromCheckBox();
    }
    @Then("нать на кнопку Подписаться")
    public void нать_на_кнопку_подписаться() {
        mainPage.clickMailingFormSubmitButton();
    }
    @Then("проверить сообщение об ошибке обработки персональных данных {string}")
    public void проверить_сообщение_об_ошибке_обработки_персональных_данных(String expectMessage) {
        assertEquals(expectMessage, mainPage.getMailingFormMessage());
    }
    @Then("проверить сообщение об ошибке пустого поля {string}")
    public void проверить_сообщение_об_ошибке_пустого_поля(String expectMessage) {
        assertEquals(expectMessage, mainPage.getMailingFormMessage());
    }
    @Then("ввести некорректный Email {string}")
    public void ввести_некорректный_email(String incorrectEmail) {
        mainPage.inputIncorrectEmailToMailing(incorrectEmail);
    }
    @Then("проверить сообщение об ошибке ввода некорректного Email {string}")
    public void проверить_сообщение_об_ошибке_ввода_некорректного_email(String expectMessage) {
        assertEquals(expectMessage, mainPage.getMailingFormMessage());
    }
    @Then("нажать на кнопку Партнерам")
    public void нажать_на_кнопку_партнерам() {
        mainPage.clickOnPartnerLink();
    }
    @Then("нажть на кнопку Присоедениться к программе")
    public void нажть_на_кнопку_присоедениться_к_программе() {
        partnerProgramPage.clicJoinToPartnerProgramButton();
    }
    @Then("проверить переход на страницу {string} в партнерской программе")
    public void проверить_переход_на_страницу_в_партнерской_программе(String string) {
        assertEquals(string, partnerProgramPage.getRegistrationPageHeader());
    }
}
