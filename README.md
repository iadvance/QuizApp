# Quiz
### Quiz - игра-викторина, разработанная на языке Java для мобильных устройств под управлением Android
### Версия Android: 6.0 Marshmallow (API 23) и младше
### IDE: Android Studio
## Принцип игры:
# Главное меню:
"Начать" - Переход в меню выбора уровня;<br>
"Настройки" - Вызов измененного диалогового окна, с функциями сброса прогресса и разблокировки всех уровней;<br>
"Выход" - Выход из приложения. При нажатии на кнопку "Выход" или на системную кнопку "Назад" уведомлением Toast запрашивает подтверждение выхода из приложения и если в течении 2 секунды действие было подтверждено повторным нажатием, приложение закрывается;<br>
# Выбор уровня
Представляет собой меню для выбора уровня. Есть кнопка "Назад" для возврата в главное меню.<br>
Иконки доступных уровней пронумерованы. Если уровень еще закрыт отображается иконка замка: 🔒<br>
# Уровень (игровой процесс)
### Цель игры:
Пройти 10 интересных уровней с разнообразными вопросами
### Цель уровня: 
Ответить на 10 случайно генерируемых вопросов, по конкретной теме.<br><br>
Для игры доступны 10 уровней, где игроку предстоит выбрать правильный ответ в соответствии с заданием.<br>
При прохождении уровня открывается следующий.<br>
При выборе уровня игроку высвечивается диалоговое окно с темой уровня.<br>
При прохождении уровня игроку так же высвечивается диалоговое окно в котором предоставлен случайный (из списка) интересный факт по теме уровня, а так же кнопки перехода на следующий уровень или меню выбора уровней.<br>

### Прочее
- Сохранение прогресса выполнено через SharedPreferences, так как он предоставляет простой и гибкий встроеный способ сохранения и извлечения пользовательских настроек и других маленьких объемов данных. <br>
- Изменены диалоговые окна для сохранения общего дизайна приложения.<br>
- Реализованы анимации через код, прописанные в ресурсах в виде .xml файлов.<br>
- Реализованы звуки при выполнении некоторых действий (Нажатия на кнопки, выбор верного или не верного ответов, завершение уровня, нажатие на заблокированные иконки уровней)