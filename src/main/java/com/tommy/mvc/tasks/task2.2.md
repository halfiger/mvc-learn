Якщо ти вже зробив і воно працює — це чудово. 
Тоді зараз саме час зрозуміти що насправді відбувається, 
а не просто запам'ятати синтаксис.

Ось що важливо знати про @RequestParam.

# 1. Звідки береться значення?

У тебе є форма:

    <form action="showGreeting" method="GET">
        <input type="text" name="employeeName">
        <input type="submit" value="Say Hello">
    </form>

Користувач вводить:

    Tommy   

Браузер формує URL:

    showGreeting?employeeName=Tommy

або повністю:

http://localhost:8080/mvc/employee/showGreeting?employeeName=Tommy

Саме браузер створює цей параметр.

Spring його не вигадує.

# 2. Що робить @RequestParam?

Приклад:

    @RequestMapping("/showGreeting")
    public String showGreeting(
    @RequestParam("employeeName") String name,
    Model model) {

    ...
}

Spring каже:

    "Знайди параметр employeeName у HTTP-запиті і поклади 
    його в змінну name."

Фактично це аналог:

    String name = request.getParameter("employeeName");

Тобто @RequestParam — це зручна обгортка над Servlet API.

# 3. Назви повинні співпадати

Форма:

    <input type="text" name="employeeName">

Контролер:

    @RequestParam("employeeName")

Працює ✅
Якщо:

    <input type="text" name="name">

а в контролері:

    @RequestParam("employeeName")

то Spring скаже:

    Required String parameter 'employeeName' is not present

бо параметра з таким ім'ям немає.

# 4. Можна не писати ім'я

Якщо назви однакові:

    @RequestMapping("/showGreeting")
    public String showGreeting(
    @RequestParam String employeeName,
    Model model) {

Spring автоматично зрозуміє:

    employeeName

але я рекомендую поки писати явно:

    @RequestParam("employeeName")

Так зрозуміліше.

# 5. Параметр може бути необов'язковим

Зараз:

    @RequestParam("employeeName")

обов'язковий.

Якщо перейти:

    /showGreeting

буде помилка.

Можна зробити:

    @RequestParam(
    value = "employeeName",
    required = false)
    String name

або:

    @RequestParam(
    value = "employeeName",
    defaultValue = "Guest")
    String name

Тоді:

    /showGreeting

дасть:

    Hello Guest

# 6. GET і POST

Ти зараз використовував:

    method="GET"

тобто:

    /showGreeting?employeeName=Tommy

дані видно в URL.

Пізніше буде:

    method="POST"

і дані підуть у body запиту.

    @RequestParam працює в обох випадках.

# 7. Найважливіше

Різниця між тим, що ти вже вивчив:

    Model
    Controller → JSP

-Передає дані від сервера до сторінки.

    @RequestParam
    Browser → Controller

-Передає дані від користувача до сервера.

Оце дуже важлива схема:

    Browser
    ↓
    @RequestParam
    ↓
    Controller
    ↓
    Model
    ↓
    JSP
    ↓
    Browser

І остання цікава деталь.

Пізніше ти перейдеш до:

    @ModelAttribute Employee employee

І це буде означати:

    Spring автоматично збере всі RequestParam і 
    створить об'єкт Employee.

Тобто:

    @RequestParam → окремі поля
    @ModelAttribute → цілий об'єкт

Тому те, що ти зараз вивчаєш — це фундамент для наступної теми.

Показуй тепер своє рішення. Подивимося, чи все зроблено 
правильно і чи немає дрібних покращень.