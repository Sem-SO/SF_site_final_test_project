Feature:Scenario: стать партнером SkillFactory

  @020 @success @regress
  Scenario: перейти на страницу Входа в систему для участия в партнерской программе
    Given стартовая cтраница школы SkillFactory
    Then нажать на кнопку Партнерам
    Then нажть на кнопку Присоедениться к программе
    Then проверить переход на страницу "Регистрация вебмастера" в партнерской программе