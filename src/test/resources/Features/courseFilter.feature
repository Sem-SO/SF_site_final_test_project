Feature: выбор курса
  @001 @bug @regress
  Scenario: отфильтровать курсы по параметру длительности от "0 до 12" и таматики "C#"
    Given стартовая cтраница школы SkillFactory
    When находимся на стартовой странице нажать на выпадающий список и выбрать раздел Все курсы
    Then в чекбоксе Тематика выбрать C#
    Then в чекбоксе Длительность выбрать от 0 до 12
    Then в выборке проверить что Длительность не более "12 мес"

  @002 @success @regress
  Scenario: отфильтровать курсы по параметру таматики "C#"
    Given стартовая cтраница школы SkillFactory
    When находимся на стартовой странице нажать на выпадающий список и выбрать раздел Все курсы
    Then в чекбоксе Тематика выбрать C#
    Then в выборке проверить что количество найденых курсов не равно 0