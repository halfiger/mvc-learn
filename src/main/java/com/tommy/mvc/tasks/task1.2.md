Ти питаєш про це:

    @RequestMapping("/")
    public String showFirstView(Model model) {

    model.addAttribute("message",
            "Welcome to Employee Portal");

    return "first-view";
    }

і в JSP:

    ${message}
Що тут відбувається?
1. Користувач відкриває сторінку

У браузері:

    http://localhost:8080/mvc/employee/

↓

2. DispatcherServlet знаходить контролер

       @RequestMapping("/")
       public String showFirstView(Model model)

і викликає цей метод.

↓

3. Створюється об'єкт Model

Spring автоматично створює:

    Model model

Тобі не потрібно його створювати через new.

↓

4. Ми кладемо дані в Model

       model.addAttribute("message",
       "Welcome to Employee Portal");

Це майже те саме, що:

    Map<String, Object> map = new HashMap<>();
    map.put("message",
    "Welcome to Employee Portal");

Тільки це спеціальний контейнер Spring.

У пам'яті зараз є:

    Ключ	    Значення
    message	    Welcome to Employee Portal

↓

5. Повертається View

        return "first-view";

ViewResolver знаходить:

    WEB-INF/view/first-view.jsp

↓

6. JSP отримує Model

У JSP можна написати:

    ${message}

EL (Expression Language) каже:

    "Покажи мені значення атрибута message."

І JSP виведе:

    Welcome to Employee Portal
Де воно зберігається?

Тільки під час цього HTTP-запиту.

# Запит → Controller → Model → JSP → Відповідь

Після того, як сторінка відправлена браузеру:
❌ Дані зникають.

Якщо оновити сторінку?
Контролер виконається знову:

    model.addAttribute(...)

і повідомлення створиться ще раз.

Це не база даних

Це НЕ:

INSERT INTO messages ...

НЕ файл.

НЕ Session.

Це просто тимчасові дані для передачі:

#   Controller → View

Приклад з Employee

    Employee emp = new Employee();
    emp.setName("Tom");
    
    model.addAttribute("employee", emp);

JSP:

    Name: ${employee.name}

Spring фактично робить:

    employee -> Employee object
    
    employee.name -> Tom

і на сторінці буде:

    Name: Tom

Запам'ятай правило:

    Де?	            Для чого?
    Model	        Передати дані з Controller у View
    Session	        Зберігати між кількома запитами
    Database	    Постійне зберігання
    RequestParam	Отримати дані від користувача

Отже відповідь на твоє питання:

    Ми записуємо значення в Model у контролері, 
    Spring тимчасово зберігає їх для цього запиту 
    і передає JSP, де ми можемо вивести їх через ${...}.

Це один із найважливіших механізмів у Spring MVC.

# Browser → DispatcherServlet → Controller → Model 
# → ViewResolver → JSP → Browser
