# Создание/Настройка профиля 
1.	пользователь вводит общую информацию:
1.1.	пользователь вводит имя
1.2.	пользователь вводит электронную почту, на которую будут высылаться exсel и pdf файлы со статистикой
1.3.	пользователь вводит возраст
1.4.	пользователь вводит свои параметры (вес, рост, хронические заболевания(если имеются)выбираются из выпадающего списка)
2.	приложение предлагает пользователю список критериев, по которым будет вестись статистика(уровень сахара в крови, артериальное давление, уровень холестерина в крови, изменение веса тела, острота зрения, физическая активность пользователя, наличие вредных привычек )
2.1.	пользователь выбирает один или несколько критериев критерий
2.2.	возле каждого критерия приложение высвечивает пояснительную подсказку с описанием каким образом будут вестись наблюдения (пр. показатель сахара в крови: вы должны будете заносить в приложение информацию о каждом приеме пищи; пр. давление: вам следует ежедневно заносить информацию о вашем кровяном давлении и т. д.)
2.3.	пользователь завершает выбор критериев
2.4.	приложение знаком пользователя с интерфейсом, расположением функций
3.	Приложение предлагает пользователю ввести информацию о питание для составления плана. апускается сценарий  - План питания
4.	Запускается сценарий 2 - Чат/общение с ботом 

Чат/общение с ботом 
1.	бот отправляет приветственное сообщение с основными положениями своего функционала и желательным форматом ввода информации, предлагает возможные сокращения для определенных команд
2.	пользователь вручную или с помощью кнопок-подсказок сверху от клавиатуры вводит нужные данные
2.1.	пользователь вводит медицинские показатели
2.2.	приложение дает ответ основываясь на отношении введённых показателей с индивидуально рассчитанной нормой
2.3.	пользователь вводит событие
2.4.	приложение помещает событие в календарь событий и сообщает, что напомнит о событии накануне. Запускается сценарий 3 - Календарь
3.	при введение пользователем данных не возможных для восприятия программой (неправильный формат ввода) приложение сообщает о проблеме пользователю и просит попробовать еще раз.

расчет с/е
1.	при внеплановом приеме пищи для пользователь вводит в чат продукт/блюдо и примерное количество
2.	приложение считает необходимую лозу инсулина и оправляет пользователю сообщение с указанием 


Календарь:
1.	пользователь оправляет в чат сообщение со словом "календарь"
2.	приложение открывает окно со встроенным календарем
3.	На календаре даты с намеченными событиями выделяются зеленым цветом
4.	пользователь нажимает на выделенную дату
5.	приложение показывает одно или несколько событий, запланированных на эту дату и  комментарии к ним; или спрашивает пользователя о желании удалить событие
6.	если комментарий существующему событию отсутствует приложение предлагает добавить комментарий
7.	если пользователь выбирает невыделенную дату приложение предлагает ему создать событие
8.	после создания события пользователю предлагается выбрать частоту отправки уведомлений о нем. Запускается сценарий 4 - Напоминания/уведомления.

Напоминания/уведомления
1.	в чате приложение отправляет сообщение о том, что через день/неделю/месяц/год произойдёт какое-то событие
1.1.	если пользователь больше не хочет получать сообщения по этому поводу, он может остановить их отправку как на определенный период времени, так и навсегда, нажав на знак креста в углу сообщения с напоминанием.
1.2.	если пользователь хочет знать больше информации, то при отправке в чат сообщения "больше информации" приложение откроет окно с календарем - Запускается сценарий 3 - Календарь
2.	приложение оправляет напоминание о приёме пищи, ответом на которое ожидается сообщение о продуктах/блюдах, съеденных пользователем
2.1.	если ответа от пользователя нет в течение более 30 минут приложение повторно отправляет уведомление
2.2.	если продукт введенный пользователем относится к числу нежелаемых для установленного рациона приложение оправляет в чат сообщение об этом

Статистика
1.	пользователь оправляет в чат сообщение со словом "статистика"
2.	в появившемся окне, приложение уточняет промежуток времени и критерии, по которым пользователь желает провести статистику
3.	если пользователь ввел даты, в которые получение информации невозможно, приложение сообщает об ошибке и заново открывает окно ввода
4.	после получения корректной информации, приложение открывает экран со статисткой (схемами изменения медицинских показателей с течение времени), внизу которого находятся кнопки экспорта, позволяющие пользователю получить информацию как в виде таблиц excel, так и pdf версии представленных выше схем.
5.	приложение высылает письмо с exсel и pdf файлами статистики на электронную почту пользователя
6.	приложение дает оценку прогресса пользователя по запрашиваемой статистике и с ее учетом предлагает скорректировать план питания. Запускается сценарий  - Составление плана питания 

Составление плана питания
1.	при первом входе в приложение или после запроса статистики оно  запрашивает/предлагает ввести изменения в дополнительную информацию о питании пользователя
2.	 на основе введенных пользователем данных, меняет базовый рацион в плане питания пользователя и предлагает ознакомиться с ним.
3.	пользователь может вручную менять пункты плана, после чего приложение ищет введенный продукт в своей базе, чтобы учти его пищевую ценность.
3.1.	если сведения о продукте отсутствуют, приложение предлагает пользователю ввести нужные значения
3.2.	если пищевая ценность введенного продукта значительно разнится с нормой, приложение сообщает об этом и предлагает варианты замены

