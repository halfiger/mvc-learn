Чудово! 👍 Це саме те, що треба було зробити. 
І головне — ти вже починаєш експериментувати сам
(/info, Employee emp, різні атрибути в Model), 
а це означає, що матеріал починає засвоюватися.

Давай зробимо невелике рев'ю.

1. @RequestParam використав правильно ✅
   @RequestMapping("/showGreeting")
   public String showGreeting(
   @RequestParam("employeeName") String name,
   Model model) {

   model.addAttribute("greetingName", name);
   return "show-greeting";
   }

Тут усе правильно:

Браузер надсилає:
showGreeting?employeeName=kaka
Spring читає:
employeeName = kaka
Поміщає в:
String name
Controller кладе в Model:
model.addAttribute("greetingName", name);
JSP показує:
${greetingName}

2. Дуже важливий момент

        Ти зараз пройшов повний цикл:
        
        Browser
        ↓
        HTML Form
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

Це буквально основа Spring MVC.


4. Важливе питання для перевірки розуміння

Якщо змінити:

<input type="text" name="employeeName">

на

<input type="text" name="userName">

а контролер залишити:

@RequestParam("employeeName")

що станеться?

Якщо можеш відповісти — тему зрозумів.