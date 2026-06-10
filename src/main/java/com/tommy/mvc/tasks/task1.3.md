Як саме працює Model і для чого він потрібен?
Я б пояснив так.

Уяви, що у тебе є офіціант у ресторані.

    Браузер → клієнт.
    Controller → офіціант.
    JSP (View) → кухар, який готує фінальний вигляд сторінки.
    Model → піднос, на який офіціант кладе 
    все необхідне кухарю.

Наприклад, клієнт каже:

    Покажи мені інформацію про співробітника.

Controller отримує запит і думає:

    Добре, для сторінки мені потрібні ім'я, зарплата і відділ.

Він створює або отримує об'єкт:

    Employee emp = new Employee();
    emp.setName("Tom");
    emp.setSalary(1000);

Потім кладе його на "піднос":

    model.addAttribute("employee", emp);

і каже:

    return "show-details";

JSP отримує цей "піднос" і вже знає:

    ${employee.name}
    ${employee.salary}
Навіщо це потрібно?

Без Model довелося б:

    або писати HTML прямо в Java-коді (жах 😄);
    або робити глобальні змінні;
    або використовувати HttpServletRequest напряму.

Spring каже:

    Controller готує дані.
    JSP відповідає за відображення.
    Model — це міст між ними.

Тобто Model — це:

    контейнер для даних, які Controller хоче передати 
    сторінці для відображення.

Практична вправа для тебе:

Варіант 1

У контролері:

    model.addAttribute("company", "Google");
    model.addAttribute("city", "Kyiv");

У JSP:

    Company: ${company}
    City: ${city}

Варіант 2
Передай об'єкт:

    Employee emp = new Employee();
    emp.setName("John");
    emp.setSurname("Smith");

    model.addAttribute("employee", emp);

У JSP:

    ${employee.name}
    ${employee.surname}
Найважливіше, що треба запам'ятати:

Controller не повинен малювати сторінку.

Він лише каже:

    "Ось дані, які треба показати."

*Model* — це спосіб передати ці дані у View.

Коли ти дійдеш до @ModelAttribute, стане 
ще зрозуміліше, тому що тоді Spring автоматично 
буде класти твої об'єкти в Model.

До речі, якщо б тебе запитали на співбесіді:

    Для чого потрібен Model у Spring MVC?

хороша коротка відповідь була б:

    Model використовується для передачі даних з 
    Controller у View під час обробки одного HTTP-запиту.
