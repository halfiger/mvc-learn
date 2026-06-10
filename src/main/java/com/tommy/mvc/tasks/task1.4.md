Розберемо коротке рев'ю.

1. Model використав правильно ✅
   @RequestMapping("/")
   public String showFirstView(Model model) {

   model.addAttribute("message", 
                "Welcome to Employee Portal");
   return "first-view";
   }

Ти:

отримав Model від Spring;
поклав туди дані;
JSP їх відобразив.

Це і є основне призначення Model.

2. @RequestMapping на класі ✅
   @Controller
   @RequestMapping("/employee")
   public class MyController {

Дуже добре.

Тепер усі URL:

Було:

/mvc/data/...

Стало:

/mvc/employee/...

Тобто:

@RequestMapping("/info")

означає:

/mvc/employee/info

Це правильне використання.

3. Нова сторінка company-info.jsp ✅
   @RequestMapping("/info")
   public String showInfo() {
   return "company-info";
   }

Працює через:

/mvc/employee/info

ViewResolver знаходить:

/WEB-INF/view/company-info.jsp

Все правильно.

4. Посилання
   <a href="askDetails">Add employee</a>

Працює, але є нюанс.

Краще писати:

<a href="${pageContext.request.contextPath}/
employee/askDetails">
    Add employee
</a>
Чому?

Якщо завтра проект буде:

localhost:8080/mycompany

замість

localhost:8080/mvc

то абсолютне посилання все одно працюватиме.

5. Маленька помилка в JSP

У тебе:

<!DOCTYPE>

краще:

<!DOCTYPE html>

тобто:

<!DOCTYPE html>
<html>
...
</html>
Головне питання

Тепер скажи своїми словами:

Що робить цей код?
model.addAttribute("message", "Welcome to 
Employee Portal");

Якщо можеш пояснити одним-двома реченнями — 
значить тему ти зрозумів.

Наступний крок

Я б зараз перейшов до наступної теми з лекцій:

Завдання №2 — @RequestParam

Мета:

навчитися отримувати дані безпосередньо з URL.

Наприклад:

localhost:8080/mvc/employee/greet?name=Tommy

і показувати:

Hello Tommy

Тут ти зрозумієш:

звідки беруться дані від користувача;
як Controller отримує параметри;
чим @RequestParam відрізняється від Model.

Після цього форми (<form>) стануть абсолютно зрозумілими.