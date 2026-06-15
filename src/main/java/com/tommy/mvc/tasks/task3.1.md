Наступне завдання
--
Ти вже маєш:

    <form:form modelAttribute="employee">

і:

    @ModelAttribute("employee") Employee emp

Але зараз ти ще не до кінця розумієш як саме це працює.
Тому нове завдання:

# Завдання №3

Додай в Employee:

    private String email;
    private String phoneNumber;

Потім:
Додай поля у форму:

    <form:input path="email"/>
    <form:input path="phoneNumber"/>

НІЧОГО не змінюй тут:

    @RequestMapping("/showDetails")
    public String showDetails(
    @ModelAttribute("employee") Employee emp)

У show-details.jsp виведи:

    ${employee.email}
    ${employee.phoneNumber}

# Головне питання
Чому все працює, хоча ми не написали 
жодного @RequestParam?

Коли виконаєш це завдання, ти зрозумієш 
справжню магію Spring MVC.

І саме після цього можна буде переходити до:

    <form:select>
    <form:radiobutton>
    <form:checkbox>
    Validation (@Size, @NotBlank)

Тобто ти рухаєшся дуже правильно. 
# Наступна тема — одна з найважливіших у Spring MVC.