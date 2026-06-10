Model використовується для передачі даних 
із Controller у View (JSP) під час обробки 
одного HTTP-запиту.

# Завдання №2 — @RequestParam
# Мета Навчитися отримувати дані від 
# користувача через URL-параметри.

Що треба реалізувати 
Створи сторінку:

    localhost:8080/mvc/employee/askName

де буде проста HTML форма:

    Введіть ім'я: [________]
    
    [Привітатися]

# Крок 1

У контролері створи метод:

    @RequestMapping("/askName")
    public String askName() {
    return "ask-name";
    }

# Крок 2

Створи JSP:

    ask-name.jsp

У ньому зроби звичайну HTML-форму (не <form:form>):

        <form action="showGreeting" method="GET">
        <input type="text" name="employeeName">
        <input type="submit" value="Say Hello">
        </form>

# Крок 3

Створи новий метод у контролері.

Він повинен обробляти:

        /showGreeting

та отримувати ім'я через @RequestParam.

Підказка:

    @RequestMapping("/showGreeting")
    public String ...

# Крок 4

Отримай значення параметра:

    employeeName

за допомогою:

    @RequestParam(...)
# Крок 5

Створи повідомлення:

    Hello, ІМ'Я!

Наприклад:

    Hello, Tommy!

# Крок 6

Передай це повідомлення у JSP через Model.

# Крок 7

Створи сторінку:

    show-greeting.jsp

і виведи повідомлення через:

    ${...}
Очікуваний результат

Користувач відкриває:

    localhost:8080/mvc/employee/askName

Вводить:

    Tommy

Після натискання кнопки переходить на:

localhost:8080/mvc/employee/showGreeting?employeeName=Tommy

і бачить:

    Hello, Tommy!
Питання після виконання
Чим @RequestParam відрізняється від Model?
Хто надсилає дані в @RequestParam — браузер чи Spring?
Чому параметр називається саме:
name="employeeName"

і що буде, якщо назви не співпадатимуть?

Спробуй зробити самостійно. Якщо щось не запрацює — показуй код 
і будемо розбиратися. Це дуже важлива тема перед переходом 
до @ModelAttribute і Spring форм.