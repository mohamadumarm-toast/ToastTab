using Microsoft.AspNetCore.Mvc;
using MyApp.Models;
namespace MyApp.Controllers
{
    public class LoginController : Controller
    {
        [HttpGet]
        public IActionResult Index()
        {
            return View();
        }

        [HttpPost]
        public IActionResult Login(string username, string password)
        {
            var key = new User(username, password);
            var userRepo = new List<User>
            {
                new User("john","password123"),
                new User("mdUmar", "Toast@1234")
            };
            if(userRepo.Any(u => u.Username == key.Username && u.Password == key.Password)) { 
                return View("LoginSuccess");
            }
            else
            {
                ViewBag.ErrorMessage = "Please enter a valid username and password.";
                Console.WriteLine("Error");
                return View("Index");
            }
            
        }
    }
}

