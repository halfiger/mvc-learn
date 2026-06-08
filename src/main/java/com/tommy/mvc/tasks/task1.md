Блок 1. Повторення бази Spring MVC
Теми:

    Introduction to Spring MVC Application Configuration
    First Spring MVC application
    Using data in View
    Model Component
    @RequestParam
    @RequestMapping для Controller class

----------------------------------------------
Практичне завдання №1
Мета Переробити поточний проєкт у невеликий
портал співробітників.

Крок 1
У first-view.jsp замість:
<h2> hello </h2>

зроби:
<h2> Employee Portal</h2>

і додай посилання:
<a href="askDetails">Add employee</a>

Крок 2

У контролері:

@RequestMapping("/")
public String showFirstView() {
return "first-view";
}

додай у Model повідомлення.

Очікування:

На сторінці має відображатися:

Welcome to Employee Portal
Підказка

Тобі знадобиться:
Model model

і:
model.addAttribute(...)

Крок 3
У first-view.jsp виведи повідомлення через:
${...}

Крок 4
Створи новий URL:
localhost:8080/mvc/data/info
який повертає сторінку:
Company Information

Підказка
У контролері додати:
@RequestMapping("/info")
і створити новий JSP.

Крок 5
Зроби так, щоб всі URL контролера починалися з:
/employee
тобто:
Було:
/mvc/data/
Стало:
/mvc/employee/

Питання для себе після виконання:
*Навіщо потрібен Model?
*Що робить @RequestMapping над класом?
*Чим відрізняється:
@RequestMapping("/")
від
@RequestMapping("/info")
*Хто повертає JSP: Tomcat чи DispatcherServlet?
Що ти потренуєш
Тема	Практика
DispatcherServlet	✓
View Resolver	✓
Model	✓
JSP EL ${}	✓
@RequestMapping	✓
Controller level mapping	✓
Не використовуй поки:
@ModelAttribute
форми
валідацію

Це буде наступний блок.

Після виконання цього завдання напиши:
що вдалося;
які були помилки;
покажи код, якщо щось не працює.

Після цього дамо Завдання №2 — @RequestParam + 
ручна обробка даних форми, як це зазвичай 
проходять у Spring MVC курсах.