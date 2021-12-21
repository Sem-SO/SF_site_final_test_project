# SF_site_final_test_project

Проект по автотестированию сайта https://skillfactory.ru/

В проекте описаны 20 тесткейсов:
  001) отфильтровать курсы по параметру длительности от "0 до 12" и таматики "C#"
  002) отфильтровать курсы по параметру таматики "C#"
  003) выбрать курс по Data Science
  004) выбрать курс по QA инженер на Java
  005) выбрать курс Разаботчик игр на Unity
  006) открыть форму для получения программы курса по Data Science
  007) отправить форму для получения программы курса по Data Science без согласия об обработки персональных данных
  008) отправить форму для получения программы курса по Data Science без заполнения обязательных поле
  009) отправить форму для получения программы курса по Data Science с некорректным Email   
  010) успешная запись на курс на курс Data Science
  011) незаполнены обязательные поля при записи на курс Data Science
  012) введен некорректный номер телефона при записи на курс Data Science
  013) подписаться на рассылку новостей без согласия на обработку персональных данных
  014) подписаться на рассылку новостей без ввода Email
  015) подписаться на рассылку с некорректным Email
  016) перейти в раздел Все курсы
  017) перейти в блог на Хабр
  018) перейти в блог во Вконтакте
  019) перейти в центр карьеры
  020) перейти на страницу Входа в систему для участия в партнерской программе
  
В ходе тестирования был выявлен один Баг (ткст кейс №001): вместо ожидаемого результата для всех отфильтрованных курсов "длительность прохождения 12 мес." было получено для одного из курсов "18 мес."

Для запуска тестов необходимо: 
  1) склонировать репозиторий командой git clone
  Запуск через IntelliJ IDEA:
  2) в файле RunCucumberTest для @CucumberOptions указать значение атрибута tags из @regress (запускает все тесты), @success (запускает только успешные тесты), @bug (запускает тесты с обнаруженными багами)
  3) запустить метод RunCucumberTest
  Запуск через командную строку
