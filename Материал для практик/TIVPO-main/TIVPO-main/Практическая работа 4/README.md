<h1>Практическая работа 4</h1>
<h2>Участники команды</h2>
<p>Состав команды CyberAliance: </p>
<ul>
  <li>Золотухин С.А.</li>
  <li>Коротыч Г.Д.</li>
  <li>Шелюхин В.П.</li>
</ul>
<h2>Функциональная спецификация десктопной программы для теста</h2>
<p>Программа "Contact Book" предназначена для ведения списка контактов.</p>
<p>Скачать ее можно <a href='https://github.com/tosvt/TIVPO/blob/main/%D0%9F%D1%80%D0%B0%D0%BA%D1%82%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%B0%D1%8F%20%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D0%B0%204/main.zip'>отсюда</a></p>

<p><img src='https://github.com/tosvt/TIVPO/blob/main/%D0%9F%D1%80%D0%B0%D0%BA%D1%82%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%B0%D1%8F%20%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D0%B0%204/imgs/mainwindow.png'></p>
<i>Главное окно программы</i>
<hr>
<p>Функции программы:</p>
<ul>
  <li>Добавление контакта</li>
  
  <li>Удаление контакта</li>
  
  <li>Поиск контакта</li>
  
  <li>Вывод контактов</li>
</ul>
<h2>Результат тестирования в ПО</h2>
<p>Тестирование производилось с помощью программы TestComplete</p>
<p>Написанный скрипт доступен по <a href='https://github.com/tosvt/TIVPO/blob/main/%D0%9F%D1%80%D0%B0%D0%BA%D1%82%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%B0%D1%8F%20%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D0%B0%204/test.py'>ссылке</a></p>
<p>Скриншот тестирование добавления контакта</p>
<p><img src='https://github.com/tosvt/TIVPO/blob/main/%D0%9F%D1%80%D0%B0%D0%BA%D1%82%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%B0%D1%8F%20%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D0%B0%204/imgs/test_addcontact.png'></p>
<p>Скриншот тестирование поиска контакта</p>
<p><img src='https://github.com/tosvt/TIVPO/blob/main/%D0%9F%D1%80%D0%B0%D0%BA%D1%82%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%B0%D1%8F%20%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D0%B0%204/imgs/test_searchcontact.png'></p>
<p>Скриншот тестирование вывода списка контактов</p>
<p><img src='https://github.com/tosvt/TIVPO/blob/main/%D0%9F%D1%80%D0%B0%D0%BA%D1%82%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%B0%D1%8F%20%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D0%B0%204/imgs/test_showlist.png'></p>
<p>Скриншот тестирование удаления контакта</p>
<p><img src='https://github.com/tosvt/TIVPO/blob/main/%D0%9F%D1%80%D0%B0%D0%BA%D1%82%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%B0%D1%8F%20%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D0%B0%204/imgs/test_deletecontact.png'></p>
<p>Скриншот тестирование добавления множества данных</p>
<p><img src='https://github.com/tosvt/TIVPO/blob/main/%D0%9F%D1%80%D0%B0%D0%BA%D1%82%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%B0%D1%8F%20%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D0%B0%204/imgs/test_bigdata.png'></p>
<p style='text-align:center'><img src="https://github.com/tosvt/TIVPO/blob/main/%D0%9F%D1%80%D0%B0%D0%BA%D1%82%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%B0%D1%8F%20%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D0%B0%204/imgs/testlogs.png"></p>
<p><i>Логи успешного тестирования</i></p>
<h2>Наименование Web-приложения и что оно из себя представляет</h2>
<p>Для тестирование было выбрано web-приложение https://ithillel.ua/. На нем можно регистрироваться и проходить курсы по программированию в различных областях. Сам сайт выглядит следующиим образом</p>
<p><img src='https://github.com/tosvt/TIVPO/blob/main/%D0%9F%D1%80%D0%B0%D0%BA%D1%82%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%B0%D1%8F%20%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D0%B0%204/imgs/web_syte.png'></p>
<h2>Результат тестирования с использованием Selenium IDE и Selenium WebDriver или аналогов</h2>
<p>В ходе тестирования, было написано четыре теста, первый проверяет на тот ли сайт мы зашли, второй - возможность зарегистрироваться на курс (дудос машина для их приемника заявок), третий - проверка блока с Курсами в Компьютерной школе Hillel и четвертый - проверка регистрации преподавателя</p>
<p><img src='https://github.com/tosvt/TIVPO/blob/main/%D0%9F%D1%80%D0%B0%D0%BA%D1%82%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%B0%D1%8F%20%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D0%B0%204/imgs/web_test1.jpg'></p>
<p align="center"><i>Скриншот выполнения первого теста</i></p>
<p><img src='https://github.com/tosvt/TIVPO/blob/main/%D0%9F%D1%80%D0%B0%D0%BA%D1%82%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%B0%D1%8F%20%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D0%B0%204/imgs/web_test2.jpg'></p>
<p align="center"><i>Скриншот выполнения второго теста</i></p>
<p><img src='https://github.com/tosvt/TIVPO/blob/main/%D0%9F%D1%80%D0%B0%D0%BA%D1%82%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%B0%D1%8F%20%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D0%B0%204/imgs/web_test3.jpg'></p>
<p align="center"><i>Скриншот выполнения третьего теста</i></p>
<p><img src='https://github.com/tosvt/TIVPO/blob/main/%D0%9F%D1%80%D0%B0%D0%BA%D1%82%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%B0%D1%8F%20%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D0%B0%204/imgs/web_test4.jpg'></p>
<p align="center"><i>Скриншот выполнения четвертого теста</i></p>

