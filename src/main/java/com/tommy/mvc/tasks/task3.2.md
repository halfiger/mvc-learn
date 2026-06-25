# 1. Про @RequestParam

    @RequestParam("employeeName")

означає:

    Spring, знайди параметр із назвою employeeName
    у запиті і передай його сюди.

Тому якщо у формі:

    <input type="text" name="userName">

а в контролері:

    @RequestParam("employeeName")

то Spring не знайде потрібний параметр і видасть помилку:

    Required String parameter 'employeeName' is not present

# 2. Про @ModelAttribute

Тут ти теж правильно зрозумів основну ідею:

Ми передаємо в Model порожній об'єкт:

    model.addAttribute("employee", new Employee());

і форма прив'язується до нього:

    <form:form modelAttribute="employee">

Але є одна дуже важлива деталь, яку треба зрозуміти:
# Spring НЕ використовує цей самий об'єкт повторно.

Відбувається приблизно так:

# GET /askDetails
    model.addAttribute("employee", new Employee());

↓

# JSP отримує порожній Employee і будує форму:

    <form:input path="name"/>
    <form:input path="surname"/>
    <form:input path="salary"/>

# Spring бачить:

    path="name"      → employee.name
    path="surname"   → employee.surname
    path="salary"    → employee.salary

і створює HTML:

    <input name="name">
    <input name="surname">
    <input name="salary">
    POST/GET /showDetails

Коли форма відправляється, браузер надсилає:

    name=Tom
    surname=Smith
    salary=5000
    email=test@gmail.com
    phoneNumber=123456

Тоді Spring робить магію:

    Employee emp = new Employee();
    
    emp.setName(...);
    emp.setSurname(...);
    emp.setSalary(...);
    emp.setEmail(...);
    emp.setPhoneNumber(...);

І передає готовий об'єкт:

    @ModelAttribute("employee") Employee emp

# Найважливіше
# Spring автоматично викликає сеттери, якщо:

Є поле:

        private String email;
Є setter:

        setEmail(...)
У формі є:

    <form:input path="email"/>

Якби ти забув setter:

    public void setEmail(String email)

то email залишився б:

    null
# Тобто різниця така:

- @RequestParam

Ти сам кажеш:

    String name
    String surname
    int salary

і сам усе збираєш.

    @ModelAttribute

Spring каже:

    Дай мені клас Employee, а я сам заповню його поля.

Тому @ModelAttribute можна уявити як:

    @RequestParam String name
    @RequestParam String surname
    @RequestParam int salary
    @RequestParam String email
    @RequestParam String phone
...

    Employee emp = new Employee();
    
    emp.setName(name);
    emp.setSurname(surname);
...

але все це робить Spring автоматично.

І я думаю, що ти вже готовий відповісти на питання:

# Чому все працює, хоча ми не написали жодного @RequestParam?

Правильна відповідь:

    Тому що Spring автоматично отримує параметри запиту,
    знаходить відповідні поля та сеттери в класі Employee,
    створює об'єкт і заповнює його через механізм data binding,
    використовуючи @ModelAttribute.

    І це одна з ключових можливостей Spring MVC.